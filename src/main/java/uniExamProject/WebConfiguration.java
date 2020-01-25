package uniExamProject;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class WebConfiguration {

    @Bean
    public EmployeeSearchService employeeSearchService(EmployeeRepository employeeRepository){
        return new EmployeeSearchServiceImpl(employeeRepository);
    }

    @Bean
    public SalarySearchService salarySearchService(SalaryRepository salaryRepository){
        return new SalarySearchServiceImpl(salaryRepository);
    }

    @Bean
    public TitileSearchService titileSearchService(TitileRepository titileRepository){
        return new TitileSearchServiceImpl(titileRepository);
    }
}
