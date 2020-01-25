package uniExamProject;

import java.util.Collection;

public class DeptEmployeeSearchServiceImpl implements DeptEmployeeSearchService {

    private DeptEmployeeRepository deptEmployeeRepository;

    public DeptEmployeeSearchServiceImpl(DeptEmployeeRepository deptEmployeeRepository) {
        this.deptEmployeeRepository = deptEmployeeRepository;
    }

    @Override
    public Collection<DeptEmployee> listAllDeptEmployees() {
        return (Collection<DeptEmployee>)deptEmployeeRepository.findAll();
    }
}
