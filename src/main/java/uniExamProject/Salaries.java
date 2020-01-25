package uniExamProject;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Salaries {

    @Column(name = "emp_no", nullable = false)
    private Long emp_no;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "from_date", nullable = false)
    private Date from_date;

    @Column(name = "to_date", nullable = false)
    private Date to_date;
}
