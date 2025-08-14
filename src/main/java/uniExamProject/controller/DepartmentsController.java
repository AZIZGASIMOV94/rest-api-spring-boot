package uniExamProject.controller;


import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uniExamProject.model.Departments;
import uniExamProject.services.DepartmentsSearchService;

@RestController
@RequestMapping(value = {"/departments"})
public class DepartmentsController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentsController.class);

    @Autowired
    private DepartmentsSearchService departmentsSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Departments> departments(){
        log.info("Request for all departments received");
        Collection<Departments> departments = departmentsSearchService.listAllDepartments();
        log.info("Found {} departments", departments.size());
        return departments;
    }
}
