package com.mama.union.entity.DAO;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "class_org")
public class OrganizationClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String address;

    @Column
    private Timestamp updated;

    @OneToMany(targetEntity = PaymentDoc.class, mappedBy = "organizationClass", fetch = FetchType.LAZY)
    private List<PaymentDoc> paymentDocList;

}
