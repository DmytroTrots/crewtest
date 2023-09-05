package com.crewtest.bots.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Table(name = "lectors")
@Entity
public class LectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lector_id", nullable = false)
    private Integer lectorId;

    @Column(name = "name", nullable = false, length = 125)
    private String name;

    @Column(name = "surname", nullable = false, unique = true, length = 125)
    private String surname;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "degree_id", nullable = false)
    private DegreeEntity degreeId;

    @ManyToMany(mappedBy = "lectors")
    private Set<DepartmentEntity> departments = new HashSet<>();

    public LectorEntity(Integer lectorId, String name, String surname, BigDecimal salary, DegreeEntity degreeId) {
        this.lectorId = lectorId;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.degreeId = degreeId;
    }

    public LectorEntity() {
    }

    public Integer getLectorId() {
        return lectorId;
    }

    public void setLectorId(Integer lectorId) {
        this.lectorId = lectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public DegreeEntity getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(DegreeEntity degreeId) {
        this.degreeId = degreeId;
    }
}
