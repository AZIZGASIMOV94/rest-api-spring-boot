package uniExamProject.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uniExamProject.model.DeptManager;
import uniExamProject.services.DeptManagerSearchService;

import java.util.Collection;

@RestController
@RequestMapping(value = {"DepartmentManager"})
public class DeptManagerController {

    private static final Logger log = LoggerFactory.getLogger(DeptManagerController.class);

    @Autowired
    private DeptManagerSearchService deptManagerSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<DeptManager> deptManagers(){
        log.info("Request for all department managers received");
        Collection<DeptManager> deptManagers = deptManagerSearchService.listAllDeptManagers();
        log.info("Found {} department managers", deptManagers.size());
        return deptManagers;
    }
}
