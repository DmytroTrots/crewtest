package com.crewtest.bots.services;

import com.crewtest.bots.entities.DepartmentEntity;
import com.crewtest.bots.entities.LectorEntity;
import com.crewtest.bots.exeption.AbsentDepartmentException;
import com.crewtest.bots.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private DepartmentEntity findDepartmentByName(String departmentName) throws AbsentDepartmentException {
        DepartmentEntity departmentEntity = departmentRepository.findDepartmentEntityByDepartmentName(departmentName);
        if (departmentEntity == null){
            throw new AbsentDepartmentException("No such department");
        }
        return departmentEntity;
    }

    public String findHeadNameOfDepartment(String departmentName) {
        DepartmentEntity department = null;
        try {
            department = findDepartmentByName(departmentName);
        } catch (AbsentDepartmentException e) {
            log.error(e.getMessage());
        }
        if (department != null){
            return department.getHeadOfDepartmentName();
        }
        return null;
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Map<String, Long> showNumberOfLectorsForEachDegree(String departmentName) {
        DepartmentEntity department = null;
        try {
            department = findDepartmentByName(departmentName);
        } catch (AbsentDepartmentException e) {
            log.error(e.getMessage());
        }
        if (department == null){
            return null;
        }
        Set<LectorEntity> lectorSet = department.getLectors();
        if (lectorSet == null || lectorSet.isEmpty()) {
            return null;
        }
        return lectorSet.stream().collect(Collectors.groupingBy(x -> x.getDegreeId().getDegreeName(), Collectors.counting()));
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public double countAverageSalaryForDepartment(String departmentName) {
        DepartmentEntity department = null;
        try {
            department = findDepartmentByName(departmentName);
        } catch (AbsentDepartmentException e) {
            log.error(e.getMessage());
        }
        if (department == null){
            return 0;
        }
        Set<LectorEntity> lectorSet = department.getLectors();
        if (lectorSet == null || lectorSet.isEmpty()) {
            return 0;
        }
        return lectorSet.stream()
                .mapToDouble(x -> x.getSalary().doubleValue()).average().orElse(0);
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public int countNumberOfLectorsForDepartment(String departmentName) {
        DepartmentEntity department = null;
        try {
            department = findDepartmentByName(departmentName);
        } catch (AbsentDepartmentException e) {
            log.error(e.getMessage());
        }
        if (department == null){
            return 0;
        }
        Set<LectorEntity> lectorSet = department.getLectors();
        if (lectorSet == null || lectorSet.isEmpty()) {
            return 0;
        }
        return lectorSet.size();
    }
}
