package uniExamProject;


import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<Employees ,Long> {

    public Collection<Employees> findAllByFirstName(String lastName);

    public Collection<Employees> findAllByLastName(String lastName);
}
