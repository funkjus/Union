package com.mama.union.entity.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "doc_member")
public class MemberDoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long num;

    @Column
    private Timestamp created;
    @Column
    private Timestamp finished;
    @Column
    private Timestamp completed;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "org_id")
    private OrganizationClass organization;

    @Column
    private Timestamp updated;
}
