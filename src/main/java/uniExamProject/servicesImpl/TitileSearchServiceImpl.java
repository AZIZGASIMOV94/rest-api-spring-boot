package uniExamProject.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import uniExamProject.model.Titles;
import uniExamProject.repository.TitileRepository;
import uniExamProject.services.TitileSearchService;

import java.util.Collection;

@Service
public class TitileSearchServiceImpl implements TitileSearchService {

    private static final Logger log = LoggerFactory.getLogger(TitileSearchServiceImpl.class);

    private TitileRepository titileRepository;

    public TitileSearchServiceImpl(TitileRepository titileRepository) {
        this.titileRepository = titileRepository;
    }

    @Override
    public Collection<Titles> listTitles() {
        log.info("Listing all titles");
        Collection<Titles> titles = (Collection<Titles>) titileRepository.findAll();
        log.info("Found {} titles", titles.size());
        return titles;
    }
}
