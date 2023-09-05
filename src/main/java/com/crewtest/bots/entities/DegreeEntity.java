package com.crewtest.bots.entities;

import jakarta.persistence.*;

@Table(name = "degree")
@Entity
public class DegreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id", nullable = false)
    private Integer degreeId;

    @Column(name = "degree_name", nullable = false, unique = true, length = 125)
    private String degreeName;

    public DegreeEntity(Integer degreeId, String degreeName) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
    }

    public DegreeEntity() {
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
}
