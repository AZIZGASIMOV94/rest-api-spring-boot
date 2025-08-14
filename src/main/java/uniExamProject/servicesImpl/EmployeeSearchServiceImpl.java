package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.Employees;
import uniExamProject.repository.EmployeeRepository;
import uniExamProject.services.EmployeeSearchService;

import java.util.Collection;

@Service
public class EmployeeSearchServiceImpl implements EmployeeSearchService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeSearchServiceImpl.class);

    private EmployeeRepository employeeRepository;

    public EmployeeSearchServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Collection<Employees> listEmployees() {
        log.info("Listing all employees");
        Collection<Employees> employees = (Collection<Employees>) employeeRepository.findAll();
        log.info("Found {} employees", employees.size());
        return employees;
    }

    @Override
    public Collection<Employees> listEmployeesByFirstName(String firstName) {
        log.info("Listing employees with first name '{}'", firstName);
        Collection<Employees> employees = employeeRepository.findAllByFirstName(firstName);
        log.info("Found {} employees with first name '{}'", employees.size(), firstName);
        return employees;
    }

    @Override
    public Collection<Employees> listEmployeesByLastName(String lastName) {
        log.info("Listing employees with last name '{}'", lastName);
        Collection<Employees> employees = employeeRepository.findAllByLastName(lastName);
        log.info("Found {} employees with last name '{}'", employees.size(), lastName);
        return employees;
    }

}
