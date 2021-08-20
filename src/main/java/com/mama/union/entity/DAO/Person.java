package com.mama.union.entity.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;



@Data
@Entity
@Table(name = "person")

public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fn;
    @Column
    private String ln;
    @Column
    private String mn;
    @Column
    private Timestamp birth;

    @Column
    private String address;
    @Column
    private String phone;

    @Column(name = "birth_place")
    private String birthPlace;
    @Column(name = "live_place")
    private String livePlace;
    @Column(name = "reg_place")
    private String regPlace;

    @Column(name = "marital_id")
    private Long maritalId;

    @Column
    private String citizenship;
    @Column
    private String nationality;
    @Column
    private String comment;

    @Column
    private Timestamp updated;

//    @ManyToOne
//    @JoinColumn(name = "education")
    @Column
    private String education;

    @OneToMany(targetEntity = PaymentDoc.class, mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PaymentDoc> paymentDocList;

    @OneToMany(targetEntity = MemberDoc.class, mappedBy = "person", fetch = FetchType.EAGER)
    @Valid
    @JsonIgnore
    private List<MemberDoc> memberDoc;

    @OneToMany(targetEntity = JobDoc.class, mappedBy = "person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobDoc> jobDocs;

}
