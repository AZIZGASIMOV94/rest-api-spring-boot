package uniExamProject.repository;


import org.springframework.data.repository.CrudRepository;
import uniExamProject.model.Employees;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<Employees,Long> {

    Collection<Employees> findAllByFirstName(String lastName);

    Collection<Employees> findAllByLastName(String lastName);
}
