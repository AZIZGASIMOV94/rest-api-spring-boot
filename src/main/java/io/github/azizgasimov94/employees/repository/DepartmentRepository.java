package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
