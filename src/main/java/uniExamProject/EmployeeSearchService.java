package uniExamProject;

import java.util.Collection;

public interface EmployeeSearchService {

    public Collection<Employees> listEmployees();

    public Collection<Employees> listEmployeesByFirstName(String firstName);

    public Collection<Employees> listEmployeesByLastName(String lastName);
}
