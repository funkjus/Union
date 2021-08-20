package com.mama.union.entity.DTO.responses;

import com.mama.union.entity.DAO.MemberDoc;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class MemberDocResponse {

    private Long id;
    private Long num;
    private Timestamp created;
    private Timestamp completed;
    private Long personId;

    public MemberDocResponse(MemberDoc doc) {
        this.id = doc.getId();
        this.num = doc.getNum();
        this.created = doc.getCreated();
        this.completed = doc.getCompleted();
        this.personId = doc.getPerson().getId();
    }
}
