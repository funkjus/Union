package com.mama.union.controllers;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DAO.Person;
import com.mama.union.entity.DTO.requests.PersonRequest;
import com.mama.union.entity.DTO.responses.PersonResponse;
import com.mama.union.service.implementation.MemberDocService;
import com.mama.union.service.implementation.PersonService;
import com.mama.union.utils.validation.PersonValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Slf4j
public class PersonController extends BaseRestController {

    private final PersonValidation personValidation;
    private final PersonService service;
    private final MemberDocService memberDocService;

    @Autowired
    public PersonController(PersonValidation personValidation, PersonService service, MemberDocService memberDocService) {
        this.personValidation = personValidation;
        this.service = service;
        this.memberDocService = memberDocService;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('person:read')")
    public List<PersonResponse> all(HttpServletRequest request,
                                    @RequestParam(required = false) String fn,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "9") int size,
                                    @RequestParam(defaultValue = "id,desc") String[] sort) {
        List<PersonResponse> pr = new ArrayList<>();
        if (fn == null) {
            for (Person p : service.getAll(getPageableAndSorting(page, size, sort))) {
                pr.add(new PersonResponse(p));
            }
            log.info("user {} [ request {} {} ]", request.getUserPrincipal().getName(), request.getMethod(), request.getServletPath());
            return pr;
        }
        for (Person p : service.getByFn(fn, getPageableAndSorting(page, size, sort))) {
            pr.add(new PersonResponse(p));
        }
        log.info("user {} [ request {} {} ]", request.getUserPrincipal().getName(), request.getMethod(), request.getServletPath());
        return pr;
    }

    @GetMapping("/{person_id}")
    @PreAuthorize("hasAuthority('person:read')")
    public PersonResponse byId(@PathVariable Long person_id) {
        return new PersonResponse(service.getById(person_id));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('person:write')")
    public PersonResponse create(@Valid @RequestBody PersonRequest item) {
        Person req = item.toPerson();
        service.create(req);
        req.getMemberDoc().forEach(i -> memberDocService.create(i));
        return new PersonResponse(req);
    }

    @PostMapping("/{person_id}")
    @PreAuthorize("hasAuthority('person:write')")
    public PersonResponse update(@PathVariable Long person_id, @RequestBody PersonRequest item) {
        Person req = item.toPerson();
        req.getMemberDoc().forEach(i -> memberDocService.update(i.getId(),i));
        return new PersonResponse(service.update(person_id, req));
    }

    @DeleteMapping("/{person_id}")
    @PreAuthorize("hasAuthority('person:write')")
    public PersonResponse delete(@PathVariable Long person_id) {
        return new PersonResponse(service.delete(person_id));
    }


    @GetMapping("/{person_id}/members")
    @PreAuthorize("hasAuthority('person:read')")
    public List<MemberDoc> allMemberDoc(@PathVariable Long person_id) {
        return service.getAllMemberDoc(person_id);
    }

}
