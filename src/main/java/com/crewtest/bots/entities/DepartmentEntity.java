package com.crewtest.bots.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(name = "department")
@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @Column(name = "department_name", nullable = false, unique = true, length = 125)
    private String departmentName;

    @Column(name = "head_of_department_name", nullable = false, unique = true, length = 125)
    private String headOfDepartmentName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "department_has_lector",
            joinColumns = {@JoinColumn(name = "department_id")},
            inverseJoinColumns = {@JoinColumn(name = "lector_id")}
    )
    Set<LectorEntity> lectors = new HashSet<>();

    public DepartmentEntity(Integer departmentId, String departmentName, String headOfDepartmentName, Set<LectorEntity> lectors) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headOfDepartmentName = headOfDepartmentName;
        this.lectors = lectors;
    }

    public DepartmentEntity() {
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Set<LectorEntity> getLectors() {
        return lectors;
    }

    public void setLectors(Set<LectorEntity> lectors) {
        this.lectors = lectors;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadOfDepartmentName() {
        return headOfDepartmentName;
    }

    public void setHeadOfDepartmentName(String headOfDepartmentName) {
        this.headOfDepartmentName = headOfDepartmentName;
    }
}
