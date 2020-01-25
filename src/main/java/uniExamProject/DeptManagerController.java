package uniExamProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

@RestController
@RequestMapping(value = {"DepartmentManager"})
public class DeptManagerController {

    @Autowired
    private DeptManagerSearchService deptManagerSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<DeptManager> deptManagers(){
        return deptManagerSearchService.listAllDeptManagers();
    }
}
