package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findByFirstNameIgnoreCase(String firstName, Pageable pageable);

    Page<Employee> findByLastNameIgnoreCase(String lastName, Pageable pageable);

    Page<Employee> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName, Pageable pageable);
}
