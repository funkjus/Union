package com.mama.union.entity.DTO.responses;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DAO.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonResponse {

    private Long id;
    private String fn;
    private String ln;
    private String mn;

    private Timestamp birth;
    private Long maritalId;
    private Timestamp updated;
    private String education;

    private List<MemberDocResponse> memberDoc;

    public PersonResponse(Person p) {
        this.id = p.getId();
        this.fn = p.getFn();
        this.ln = p.getLn();
        this.mn = p.getMn();
        this.birth = p.getBirth();
        this.maritalId = p.getMaritalId();
        this.updated = p.getUpdated();
        this.education = p.getEducation();
        List<MemberDocResponse> memberDocResponses = new ArrayList<>();
        if(p.getMemberDoc() != null && p.getMemberDoc().size() != 0){
            for (MemberDoc d : p.getMemberDoc()) {
                memberDocResponses.add(new MemberDocResponse(d));
            }
        }
        this.memberDoc = memberDocResponses;
    }
}
