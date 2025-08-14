package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.Departments;
import uniExamProject.repository.DepartmentsRepository;
import uniExamProject.services.DepartmentsSearchService;

import java.util.Collection;

@Service
public class DepartmentsSearchServiceImpl implements DepartmentsSearchService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentsSearchServiceImpl.class);

    private DepartmentsRepository departmentsRepository;

    public DepartmentsSearchServiceImpl(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @Override
    public Collection<Departments> listAllDepartments() {
        log.info("Listing all departments");
        Collection<Departments> departments = (Collection<Departments>) departmentsRepository.findAll();
        log.info("Found {} departments", departments.size());
        return departments;
    }
}
