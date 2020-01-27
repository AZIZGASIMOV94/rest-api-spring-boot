package uniExamProject.servicesImpl;

import uniExamProject.model.Employees;
import uniExamProject.repository.EmployeeRepository;
import uniExamProject.services.EmployeeSearchService;

import java.util.Collection;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    private EmployeeRepository employeeRepository;

    public EmployeeSearchServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Collection<Employees> listEmployees() {
        return (Collection<Employees>) employeeRepository.findAll();
    }

    @Override
    public Collection<Employees> listEmployeesByFirstName(String firstName) {
         return employeeRepository.findAllByFirstName(firstName);

    }

    @Override
    public Collection<Employees> listEmployeesByLastName(String lastName) {
        return employeeRepository.findAllByLastName(lastName);
    }

}
