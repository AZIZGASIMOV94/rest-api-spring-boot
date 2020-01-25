package uniExamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/employee"})
public class EmployeesController {

    @Autowired
    private EmployeeSearchService employeeSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Employees> fetchAllEmployees(){
        return employeeSearchService.listEmployees();
    }

    @RequestMapping(value = "/employeeName/{employeeName}", method = RequestMethod.GET)
    public Collection<Employees> fetchEmployeesByName(@PathVariable(value = "employeeName") String firstName) {
        return employeeSearchService.listEmployeesByFirstName(firstName);
    }

    @RequestMapping(value = "/employeeLastName/{employeeLastName}", method = RequestMethod.GET)
    public Collection<Employees> fetchEmplyeesByLastName(@PathVariable(value = "employeeLastName") String lastName){
        return employeeSearchService.listEmployeesByLastName(lastName);
    }
}
