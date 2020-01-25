package uniExamProject;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/departments"})
public class DepartmentsController {

    @Autowired
    private DepartmentsSearchService departmentsSearchService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Collection<Departments> departments(){
        return departmentsSearchService.listAllDepartments();
    }
}
