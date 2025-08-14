package uniExamProject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniExamProject.model.Salaries;
import uniExamProject.services.SalarySearchService;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/salaries"})
public class SalariesController {

    private static final Logger log = LoggerFactory.getLogger(SalariesController.class);

    @Autowired
    private SalarySearchService salarySearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Salaries> fetchAllSalaries(){
        log.info("Request for all salaries received");
        Collection<Salaries> salaries = salarySearchService.listSalaries();
        log.info("Found {} salaries", salaries.size());
        return salaries;
    }
}
