package uniExamProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uniExamProject.model.DeptEmployee;
import uniExamProject.services.DeptEmployeeSearchService;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/deptsEmployees"})
public class DeptEmployeeController {

    private static final Logger log = LoggerFactory.getLogger(DeptEmployeeController.class);

    @Autowired
    private DeptEmployeeSearchService deptEmployeeSearchService;

    @RequestMapping(value = {"/all"},method = RequestMethod.GET)
    public Collection<DeptEmployee> deptEmployees(){
        log.info("Request for all department employees received");
        Collection<DeptEmployee> deptEmployees = deptEmployeeSearchService.listAllDeptEmployees();
        log.info("Found {} department employees", deptEmployees.size());
        return deptEmployees;
    }
}
