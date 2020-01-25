package uniExamProject;


import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<Employees ,Long> {

    Collection<Employees> findAllByFirstName(String lastName);

    Collection<Employees> findAllByLastName(String lastName);
}
