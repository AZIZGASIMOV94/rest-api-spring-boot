package uniExamProject.services;

import uniExamProject.model.Employees;

import java.util.Collection;

public interface EmployeeSearchService {

    Collection<Employees> listEmployees();

    Collection<Employees> listEmployeesByFirstName(String firstName);

    Collection<Employees> listEmployeesByLastName(String lastName);
}
