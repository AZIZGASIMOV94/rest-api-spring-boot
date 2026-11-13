package io.github.azizgasimov94.employees.controller;

import io.github.azizgasimov94.employees.model.Employee;
import io.github.azizgasimov94.employees.model.Salary;
import io.github.azizgasimov94.employees.model.Title;
import io.github.azizgasimov94.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Page<Employee> search(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName,
                                 @PageableDefault(size = 20, sort = "empNo") Pageable pageable) {
        return employeeService.search(firstName, lastName, pageable);
    }

    @GetMapping("/{empNo}")
    public Employee getEmployee(@PathVariable Integer empNo) {
        return employeeService.getEmployee(empNo);
    }

    @GetMapping("/{empNo}/salaries")
    public List<Salary> getSalaryHistory(@PathVariable Integer empNo) {
        return employeeService.getSalaryHistory(empNo);
    }

    @GetMapping("/{empNo}/titles")
    public List<Title> getTitleHistory(@PathVariable Integer empNo) {
        return employeeService.getTitleHistory(empNo);
    }
}
