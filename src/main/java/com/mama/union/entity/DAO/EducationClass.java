package com.mama.union.entity.DAO;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "class_education")
public class EducationClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String name1;
    @Column
    private String name2;

    @Column
    private Timestamp updated;

//    @OneToMany(targetEntity = Person.class, mappedBy = "education", fetch = FetchType.LAZY)
//    private List<Person> personList;

}
