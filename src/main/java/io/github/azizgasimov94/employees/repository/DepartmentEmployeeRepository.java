package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.DepartmentAssignmentId;
import io.github.azizgasimov94.employees.model.DepartmentEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, DepartmentAssignmentId> {

    Page<DepartmentEmployee> findByDeptNo(String deptNo, Pageable pageable);
}
