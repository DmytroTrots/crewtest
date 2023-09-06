package com.crewtest.bots.services;

import com.crewtest.bots.entities.DegreeEntity;
import com.crewtest.bots.entities.DepartmentEntity;
import com.crewtest.bots.entities.LectorEntity;
import com.crewtest.bots.repositories.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;
    @InjectMocks
    private DepartmentService departmentService;
    private static DepartmentEntity departmentEntity;

    @BeforeAll
    static void beforeAll() {
        Set<LectorEntity> lectorEntities = new HashSet<>();
        lectorEntities.add(new LectorEntity(1, "NameOne", "SurnameOne", BigDecimal.valueOf(20000), new DegreeEntity(1, "assistant")));
        lectorEntities.add(new LectorEntity(2, "NameTwo", "SurnameTwo", BigDecimal.valueOf(10000), new DegreeEntity(2, "associate professor")));
        lectorEntities.add(new LectorEntity(3, "NameThree", "SurnameThree", BigDecimal.valueOf(3300), new DegreeEntity(3, "professor")));
        departmentEntity = new DepartmentEntity(1, "departmentTestName",
                "headTestName", lectorEntities);
    }

    @Test
    void findHeadNameOfDepartment_ShouldReturnCorrectNameOfHead() {
        Mockito.when(departmentRepository.findDepartmentEntityByDepartmentName(departmentEntity.getDepartmentName())).thenReturn(departmentEntity);

        String actualHeadName = departmentService.findHeadNameOfDepartment("departmentTestName");

        assertEquals(departmentEntity.getHeadOfDepartmentName(), actualHeadName);
    }

    @Test
    void findHeadNameOfDepartment_ShouldReturnNull() {
        Mockito.when(departmentRepository.findDepartmentEntityByDepartmentName("departmentTest")).thenReturn(null);

        String actualHeadName = departmentService.findHeadNameOfDepartment("departmentTest");

        assertNull(actualHeadName);
    }

    @Test
    void countAverageSalaryForDepartment_ShouldReturnCorrectAverageSalary() {
        Mockito.when(departmentRepository.findDepartmentEntityByDepartmentName(departmentEntity.getDepartmentName())).thenReturn(departmentEntity);

        double actualAverageSalary = departmentService.countAverageSalaryForDepartment("departmentTestName");

        assertEquals(11100, actualAverageSalary);

    }

    @Test
    void countNumberOfLectorsForDepartment_ShouldReturnThree() {
        Mockito.when(departmentRepository.findDepartmentEntityByDepartmentName(departmentEntity.getDepartmentName())).thenReturn(departmentEntity);

        int actualNumberOfLectors = departmentService.countNumberOfLectorsForDepartment("departmentTestName");

        assertEquals(departmentEntity.getLectors().size(), actualNumberOfLectors);
    }

    @Test
    void showNumberOfLectorsForEachDegree_ShouldReturnCorrectCollectedMap() {
        Mockito.when(departmentRepository.findDepartmentEntityByDepartmentName(departmentEntity.getDepartmentName())).thenReturn(departmentEntity);

        Map<String, Long> expectedMap = new HashMap<>();
        expectedMap.put("assistant", 1L);
        expectedMap.put("associate professor", 1L);
        expectedMap.put("professor", 1L);

        Map<String, Long> actualNumberOfLectorsForEachDegree = departmentService.showNumberOfLectorsForEachDegree("departmentTestName");

        assertEquals(expectedMap, actualNumberOfLectorsForEachDegree);
    }




}