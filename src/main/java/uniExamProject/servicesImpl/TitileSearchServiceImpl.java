package uniExamProject.servicesImpl;

import uniExamProject.model.Titles;
import uniExamProject.repository.TitileRepository;
import uniExamProject.services.TitileSearchService;

import java.util.Collection;

public class TitileSearchServiceImpl implements TitileSearchService {

    private TitileRepository titileRepository;

    public TitileSearchServiceImpl(TitileRepository titileRepository) {
        this.titileRepository = titileRepository;
    }

    @Override
    public Collection<Titles> listTitles() {
        return (Collection<Titles>) titileRepository.findAll();
    }
}
