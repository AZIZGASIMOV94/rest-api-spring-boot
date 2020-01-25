package uniExamProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = {"titles"})
public class TitileController {

    @Autowired
    private TitileSearchService titileSearchService;


    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Titles> fetchAllTitiles(){
        return titileSearchService.listTitles();
    }

}
