package com.mama.union.entity.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "doc_job")
public class JobDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String place;
    @Column
    private String post;

    @Column
    private Timestamp created;
    @Column
    private Timestamp finished;
    @Column
    private Timestamp updated;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

}
