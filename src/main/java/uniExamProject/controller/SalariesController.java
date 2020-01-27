package uniExamProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniExamProject.model.Salaries;
import uniExamProject.services.SalarySearchService;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/salaries"})
public class SalariesController {

    @Autowired
    private SalarySearchService salarySearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Salaries> fetchAllSalaries(){
        return salarySearchService.listSalaries();
    }
}
