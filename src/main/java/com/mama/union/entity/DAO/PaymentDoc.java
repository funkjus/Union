package com.mama.union.entity.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "doc_payment")
public class PaymentDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationClass organizationClass;

    @Column
    private Timestamp created;
    @Column
    private Timestamp finished;
    @Column
    private Timestamp updated;

}
