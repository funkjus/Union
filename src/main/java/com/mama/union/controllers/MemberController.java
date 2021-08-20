package com.mama.union.controllers;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DTO.requests.MemberDocRequest;
import com.mama.union.entity.DTO.responses.MemberDocResponse;
import com.mama.union.service.implementation.MemberDocService;
import com.mama.union.service.implementation.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@Slf4j
public class MemberController {

    private final MemberDocService service;
    private final PersonService personService;

    public MemberController(MemberDocService service, PersonService personService) {
        this.service = service;
        this.personService = personService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('person:read')")
    public List<MemberDocResponse> all() {
        List<MemberDocResponse> memberDocResponses = new ArrayList<>();
        for (MemberDoc m : service.getAll()) {
            memberDocResponses.add(new MemberDocResponse(m));
        }
        return memberDocResponses;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('person:read')")
    public MemberDocResponse byId(@PathVariable Long id) {
        return new MemberDocResponse(service.getById(id));
    }

    @PutMapping
    @PreAuthorize("hasAuthority('person:write')")
    public MemberDocResponse create(@Valid @RequestBody MemberDocRequest item) {
        MemberDoc req = item.toMemberDoc(personService.getById(item.getPersonId()));
        return new MemberDocResponse(service.create(req));
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('person:write')")
    public MemberDocResponse update(@PathVariable Long id, @RequestBody MemberDocRequest item) {
        MemberDoc req = item.toMemberDoc(personService.getById(item.getPersonId()));
        return new MemberDocResponse(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('person:write')")
    public MemberDocResponse delete(@PathVariable Long id) {
        return new MemberDocResponse(service.delete(id));
    }
}
