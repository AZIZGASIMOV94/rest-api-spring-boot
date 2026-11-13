package io.github.azizgasimov94.employees.controller;

import io.github.azizgasimov94.employees.model.Department;
import io.github.azizgasimov94.employees.model.DepartmentEmployee;
import io.github.azizgasimov94.employees.model.DepartmentManager;
import io.github.azizgasimov94.employees.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<Department> listDepartments() {
        return departmentService.listDepartments();
    }

    @GetMapping("/{deptNo}")
    public Department getDepartment(@PathVariable String deptNo) {
        return departmentService.getDepartment(deptNo);
    }

    @GetMapping("/{deptNo}/employees")
    public Page<DepartmentEmployee> getEmployees(@PathVariable String deptNo,
                                                 @PageableDefault(size = 20, sort = "empNo") Pageable pageable) {
        return departmentService.getEmployees(deptNo, pageable);
    }

    @GetMapping("/{deptNo}/managers")
    public List<DepartmentManager> getManagerHistory(@PathVariable String deptNo) {
        return departmentService.getManagerHistory(deptNo);
    }
}
