package uniExamProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniExamProject.services.EmployeeSearchService;
import uniExamProject.model.Employees;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/employee"})
public class EmployeesController {

    private static final Logger log = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    private EmployeeSearchService employeeSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Employees> fetchAllEmployees(){
        log.info("Request for all employees received");
        Collection<Employees> employees = employeeSearchService.listEmployees();
        log.info("Found {} employees", employees.size());
        return employees;
    }

    @RequestMapping(value = "/employeeName/{employeeName}", method = RequestMethod.GET)
    public Collection<Employees> fetchEmployeesByName(@PathVariable(value = "employeeName") String firstName) {
        log.info("Request for employees with first name '{}' received", firstName);
        Collection<Employees> employees = employeeSearchService.listEmployeesByFirstName(firstName);
        log.info("Found {} employees with first name '{}'", employees.size(), firstName);
        return employees;
    }

    @RequestMapping(value = "/employeeLastName/{employeeLastName}", method = RequestMethod.GET)
    public Collection<Employees> fetchEmplyeesByLastName(@PathVariable(value = "employeeLastName") String lastName){
        log.info("Request for employees with last name '{}' received", lastName);
        Collection<Employees> employees = employeeSearchService.listEmployeesByLastName(lastName);
        log.info("Found {} employees with last name '{}'", employees.size(), lastName);
        return employees;
    }
}
