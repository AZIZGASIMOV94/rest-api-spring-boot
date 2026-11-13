package io.github.azizgasimov94.employees.service;

import io.github.azizgasimov94.employees.exception.NotFoundException;
import io.github.azizgasimov94.employees.model.Employee;
import io.github.azizgasimov94.employees.model.Salary;
import io.github.azizgasimov94.employees.model.Title;
import io.github.azizgasimov94.employees.repository.EmployeeRepository;
import io.github.azizgasimov94.employees.repository.SalaryRepository;
import io.github.azizgasimov94.employees.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;
    private final TitleRepository titleRepository;

    /** Lists employees, optionally filtered by first and/or last name (case-insensitive, exact match). */
    public Page<Employee> search(String firstName, String lastName, Pageable pageable) {
        boolean byFirst = StringUtils.hasText(firstName);
        boolean byLast = StringUtils.hasText(lastName);
        if (byFirst && byLast) {
            return employeeRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName, pageable);
        }
        if (byFirst) {
            return employeeRepository.findByFirstNameIgnoreCase(firstName, pageable);
        }
        if (byLast) {
            return employeeRepository.findByLastNameIgnoreCase(lastName, pageable);
        }
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployee(Integer empNo) {
        return employeeRepository.findById(empNo)
                .orElseThrow(() -> new NotFoundException("Employee " + empNo + " not found"));
    }

    public List<Salary> getSalaryHistory(Integer empNo) {
        requireEmployee(empNo);
        return salaryRepository.findByEmpNoOrderByFromDate(empNo);
    }

    public List<Title> getTitleHistory(Integer empNo) {
        requireEmployee(empNo);
        return titleRepository.findByEmpNoOrderByFromDate(empNo);
    }

    private void requireEmployee(Integer empNo) {
        if (!employeeRepository.existsById(empNo)) {
            throw new NotFoundException("Employee " + empNo + " not found");
        }
    }
}
