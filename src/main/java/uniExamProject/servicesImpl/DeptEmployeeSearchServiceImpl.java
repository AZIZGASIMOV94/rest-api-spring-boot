package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.DeptEmployee;
import uniExamProject.repository.DeptEmployeeRepository;
import uniExamProject.services.DeptEmployeeSearchService;

import java.util.Collection;

@Service
public class DeptEmployeeSearchServiceImpl implements DeptEmployeeSearchService {

    private static final Logger log = LoggerFactory.getLogger(DeptEmployeeSearchServiceImpl.class);

    private DeptEmployeeRepository deptEmployeeRepository;

    public DeptEmployeeSearchServiceImpl(DeptEmployeeRepository deptEmployeeRepository) {
        this.deptEmployeeRepository = deptEmployeeRepository;
    }

    @Override
    public Collection<DeptEmployee> listAllDeptEmployees() {
        log.info("Listing all department employees");
        Collection<DeptEmployee> deptEmployees = (Collection<DeptEmployee>)deptEmployeeRepository.findAll();
        log.info("Found {} department employees", deptEmployees.size());
        return deptEmployees;
    }
}
