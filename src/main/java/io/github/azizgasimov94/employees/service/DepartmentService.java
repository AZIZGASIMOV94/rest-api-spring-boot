package io.github.azizgasimov94.employees.service;

import io.github.azizgasimov94.employees.exception.NotFoundException;
import io.github.azizgasimov94.employees.model.Department;
import io.github.azizgasimov94.employees.model.DepartmentEmployee;
import io.github.azizgasimov94.employees.model.DepartmentManager;
import io.github.azizgasimov94.employees.repository.DepartmentEmployeeRepository;
import io.github.azizgasimov94.employees.repository.DepartmentManagerRepository;
import io.github.azizgasimov94.employees.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;
    private final DepartmentManagerRepository departmentManagerRepository;

    public List<Department> listDepartments() {
        return departmentRepository.findAll(Sort.by("deptNo"));
    }

    public Department getDepartment(String deptNo) {
        return departmentRepository.findById(deptNo)
                .orElseThrow(() -> new NotFoundException("Department " + deptNo + " not found"));
    }

    public Page<DepartmentEmployee> getEmployees(String deptNo, Pageable pageable) {
        requireDepartment(deptNo);
        return departmentEmployeeRepository.findByDeptNo(deptNo, pageable);
    }

    public List<DepartmentManager> getManagerHistory(String deptNo) {
        requireDepartment(deptNo);
        return departmentManagerRepository.findByDeptNoOrderByFromDate(deptNo);
    }

    private void requireDepartment(String deptNo) {
        if (!departmentRepository.existsById(deptNo)) {
            throw new NotFoundException("Department " + deptNo + " not found");
        }
    }
}
