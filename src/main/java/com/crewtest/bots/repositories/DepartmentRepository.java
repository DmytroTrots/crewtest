package com.crewtest.bots.repositories;

import com.crewtest.bots.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

    DepartmentEntity findDepartmentEntityByDepartmentName(String departmentName);

}
