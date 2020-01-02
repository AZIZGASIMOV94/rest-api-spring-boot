package uniExamProject;

import java.util.Collection;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    private EmployeeRepository employeeRepository;

    public EmployeeSearchServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Collection<Employee> listEmployees() {
        return (Collection<Employee>) employeeRepository.findAll();
    }
}
