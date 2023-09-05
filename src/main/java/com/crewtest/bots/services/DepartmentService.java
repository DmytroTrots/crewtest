package com.crewtest.bots.services;

import com.crewtest.bots.entities.DepartmentEntity;
import com.crewtest.bots.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private DepartmentEntity findDepartmentByName(String departmentName) {
        return departmentRepository.findDepartmentEntityByDepartmentName(departmentName);
    }

    public String findHeadNameOfDepartment(String departmentName) {
        return findDepartmentByName(departmentName).getHeadOfDepartmentName();
    }

    public Map<String, Long> showNumberOfLectorsForEachDegree(String departmentName) {
        return findDepartmentByName(departmentName).getLectors().stream()
                .collect(Collectors.groupingBy(x -> x.getDegreeId().getDegreeName(), Collectors.counting()));
    }

    public double countAverageSalaryForDepartment(String departmentName) {
        return findDepartmentByName(departmentName).getLectors().stream()
                .mapToDouble(x -> x.getSalary().doubleValue()).average().orElse(0);
    }

    public int countNumberOfLectorsForDepartment(String departmentName) {
        return findDepartmentByName(departmentName).getLectors().size();
    }
}
