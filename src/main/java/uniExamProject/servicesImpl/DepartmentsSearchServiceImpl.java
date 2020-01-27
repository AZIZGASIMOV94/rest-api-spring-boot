package uniExamProject.servicesImpl;

import uniExamProject.model.Departments;
import uniExamProject.repository.DepartmentsRepository;
import uniExamProject.services.DepartmentsSearchService;

import java.util.Collection;

public class DepartmentsSearchServiceImpl implements DepartmentsSearchService {

    private DepartmentsRepository departmentsRepository;

    public DepartmentsSearchServiceImpl(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @Override
    public Collection<Departments> listAllDepartments() {
        return (Collection<Departments>) departmentsRepository.findAll();
    }
}
