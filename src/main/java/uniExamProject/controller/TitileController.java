package uniExamProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uniExamProject.services.TitileSearchService;
import uniExamProject.model.Titles;

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
