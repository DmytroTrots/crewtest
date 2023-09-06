package com.crewtest.bots.utils;

import com.crewtest.bots.entities.LectorEntity;
import com.crewtest.bots.services.DepartmentService;
import com.crewtest.bots.services.LectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class RequestDecider {

    private final String DEPARTMENT_HEAD = "head of department";
    private final String DEPARTMENT_STATISTICS = "statistics";
    private final String DEPARTMENT_SALARY = "salary";
    private final String DEPARTMENT_EMPLOYEE = "employee";
    private final String GLOBAL_SEARCH = "global";
    private final LectorService lectorService;
    private final DepartmentService departmentService;


    public RequestDecider(LectorService lectorService, DepartmentService departmentService) {
        this.lectorService = lectorService;
        this.departmentService = departmentService;
    }

    public void getNeededRequest(String request) {
        String[] arrayOfStringToGetSearchField = request.split(" ");

        if (request.matches(".*" + DEPARTMENT_HEAD + ".*")) {
            String depName = arrayOfStringToGetSearchField[arrayOfStringToGetSearchField.length - 1];
            String nameOfHead = departmentService.findHeadNameOfDepartment(depName);
            if (nameOfHead == null){
                return;
            }
            log.info("Head of " + depName + " department is " + nameOfHead);
        } else if (request.matches(".*" + DEPARTMENT_STATISTICS + ".*")) {
            Map<String, Long> statisticOfDepartment = null;
            if (arrayOfStringToGetSearchField.length >=2){
                String depName = arrayOfStringToGetSearchField[1];
                statisticOfDepartment = departmentService.showNumberOfLectorsForEachDegree(depName);
            }
            if (statisticOfDepartment == null){
                return;
            }
            statisticOfDepartment.forEach((key, value) -> log.info(key + " - " + value));
        } else if (request.matches(".*" + DEPARTMENT_SALARY + ".*")) {
            String depName = arrayOfStringToGetSearchField[arrayOfStringToGetSearchField.length - 1];
            double averageSalary = departmentService.countAverageSalaryForDepartment(depName);
            log.info("The average salary of " + depName + " is " + averageSalary);
        } else if (request.matches(".*" + DEPARTMENT_EMPLOYEE + ".*")) {
            String depName = arrayOfStringToGetSearchField[arrayOfStringToGetSearchField.length - 1];
            double employeeCount = departmentService.countNumberOfLectorsForDepartment(depName);
            log.info("" + employeeCount);
        } else if (request.matches(".*" + GLOBAL_SEARCH + ".*")) {
            String template = arrayOfStringToGetSearchField[arrayOfStringToGetSearchField.length - 1];
            List<LectorEntity> lectorsList = lectorService.getAllLectorsWhereNameOrSurnameLikeString(template);
            lectorsList.forEach(x -> log.info(x.getName() + " " + x.getSurname() + ", "));
        } else {
            log.warn("The result is not found, please, use one of the following templates to make a request:\n" +
                    "Who is head of department {department_name}\n" +
                    "Show {department_name} statistics\n" +
                    "Show the average salary for the department {department_name}\n" +
                    "Show count of employee for {department_name}\n" +
                    "Global search by {template}");
        }
    }
}
