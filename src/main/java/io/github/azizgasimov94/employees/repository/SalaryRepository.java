package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.Salary;
import io.github.azizgasimov94.employees.model.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    List<Salary> findByEmpNoOrderByFromDate(Integer empNo);
}
