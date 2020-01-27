package uniExamProject.servicesImpl;

import uniExamProject.model.DeptManager;
import uniExamProject.repository.DeptManagerRepository;
import uniExamProject.services.DeptManagerSearchService;

import java.util.Collection;

public class DeptManagerSearchServiceImpl implements DeptManagerSearchService {

    private DeptManagerRepository deptManagerRepository;

    public DeptManagerSearchServiceImpl(DeptManagerRepository deptManagerRepository) {
        this.deptManagerRepository = deptManagerRepository;
    }

    @Override
    public Collection<DeptManager> listAllDeptManagers() {
        return (Collection<DeptManager>) deptManagerRepository.findAll();
    }
}
