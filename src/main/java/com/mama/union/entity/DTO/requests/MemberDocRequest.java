package com.mama.union.entity.DTO.requests;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DAO.Person;
import lombok.Data;

import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Data
public class MemberDocRequest {

    private Long id;

    @Min(value = 1L, message = "Num should not be less than 1")
    private Long num;
    private Timestamp created;
    private Timestamp completed;
    private Long personId;

    public MemberDoc toMemberDoc(Person p){
        MemberDoc m = new MemberDoc();
        m.setId(this.id);
        m.setNum(this.num);
        m.setCreated(this.created);
        m.setCompleted(this.completed);
        m.setPerson(p);
        return m;
    }
}
