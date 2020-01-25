package uniExamProject;

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
