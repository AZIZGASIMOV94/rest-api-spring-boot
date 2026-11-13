package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.DepartmentAssignmentId;
import io.github.azizgasimov94.employees.model.DepartmentManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, DepartmentAssignmentId> {

    List<DepartmentManager> findByDeptNoOrderByFromDate(String deptNo);
}
