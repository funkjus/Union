package com.mama.union.entity.DTO.requests;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DAO.Person;
import com.mama.union.utils.validation.Education;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class PersonRequest {

    private Long id;

    @NotBlank(message = "Name may not be empty")
    private String fn;
    @NotBlank(message = "Secondname may not be empty")
    private String ln;

    private Timestamp birth;

    @Min(value = 0L, message = "Marital should not be less than 0")
    @Max(value = 3L, message = "Marital should not be more than 3")
    private Long maritalId;
    private Timestamp updated;

    @Education
    private String education;

    private List<MemberDocRequest> memberDoc;

    public Person toPerson(){
        Person p = new Person();
        p.setId(this.id);
        p.setFn(this.fn);
        p.setLn(this.ln);
        p.setBirth(this.birth);
        p.setMaritalId(0L);
        p.setUpdated(new Timestamp(new Date().getTime()));
        p.setEducation(this.education);
        List<MemberDoc> memberDocsRequest = new ArrayList<>();
        if (this.memberDoc != null && this.memberDoc.size() != 0){
            for(MemberDocRequest m : this.memberDoc){
                memberDocsRequest.add(m.toMemberDoc(p));
            }
        }
        p.setMemberDoc(memberDocsRequest);
        p.setJobDocs(new ArrayList<>());
        p.setPaymentDocList(new ArrayList<>());
        return p;
    }
}
