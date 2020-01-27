package uniExamProject.servicesImpl;

import uniExamProject.model.Salaries;
import uniExamProject.repository.SalaryRepository;
import uniExamProject.services.SalarySearchService;

import java.util.Collection;

public class SalarySearchServiceImpl implements SalarySearchService {

    private SalaryRepository salaryRepository;

    public SalarySearchServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Collection<Salaries> listSalaries() {
        return (Collection<Salaries>) salaryRepository.findAll();
    }
}
