package uniExamProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = {"/deptsEmployees"})
public class DeptEmployeeController {

    @Autowired
    private DeptEmployeeSearchService deptEmployeeSearchService;

    @RequestMapping(value = {"/all"},method = RequestMethod.GET)
    public Collection<DeptEmployee> deptEmployees(){
        return deptEmployeeSearchService.listAllDeptEmployees();
    }
}
