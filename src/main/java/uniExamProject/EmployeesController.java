package uniExamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/employee"})
public class EmployeesController {

    @Autowired
    private EmployeeSearchService employeeSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Employee> fetchAllEmployees(){

        return employeeSearchService.listEmployees();

    }
}
