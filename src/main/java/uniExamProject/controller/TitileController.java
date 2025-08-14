package uniExamProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(TitileController.class);

    @Autowired
    private TitileSearchService titileSearchService;


    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Titles> fetchAllTitiles(){
        log.info("Request for all titles received");
        Collection<Titles> titles = titileSearchService.listTitles();
        log.info("Found {} titles", titles.size());
        return titles;
    }

}
