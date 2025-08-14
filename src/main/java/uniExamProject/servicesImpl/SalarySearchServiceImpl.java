package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.Salaries;
import uniExamProject.repository.SalaryRepository;
import uniExamProject.services.SalarySearchService;

import java.util.Collection;

@Service
public class SalarySearchServiceImpl implements SalarySearchService {

    private static final Logger log = LoggerFactory.getLogger(SalarySearchServiceImpl.class);

    private SalaryRepository salaryRepository;

    public SalarySearchServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Collection<Salaries> listSalaries() {
        log.info("Listing all salaries");
        Collection<Salaries> salaries = (Collection<Salaries>) salaryRepository.findAll();
        log.info("Found {} salaries", salaries.size());
        return salaries;
    }
}
