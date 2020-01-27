package uniExamProject.repository;

import org.springframework.data.repository.CrudRepository;
import uniExamProject.model.DeptEmployee;

public interface DeptEmployeeRepository extends CrudRepository<DeptEmployee, Long> {
}
