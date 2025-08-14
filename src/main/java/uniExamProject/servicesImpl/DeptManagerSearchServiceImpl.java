package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.DeptManager;
import uniExamProject.repository.DeptManagerRepository;
import uniExamProject.services.DeptManagerSearchService;

import java.util.Collection;

@Service
public class DeptManagerSearchServiceImpl implements DeptManagerSearchService {

    private static final Logger log = LoggerFactory.getLogger(DeptManagerSearchServiceImpl.class);

    private DeptManagerRepository deptManagerRepository;

    public DeptManagerSearchServiceImpl(DeptManagerRepository deptManagerRepository) {
        this.deptManagerRepository = deptManagerRepository;
    }

    @Override
    public Collection<DeptManager> listAllDeptManagers() {
        log.info("Listing all department managers");
        Collection<DeptManager> deptManagers = (Collection<DeptManager>) deptManagerRepository.findAll();
        log.info("Found {} department managers", deptManagers.size());
        return deptManagers;
    }
}
