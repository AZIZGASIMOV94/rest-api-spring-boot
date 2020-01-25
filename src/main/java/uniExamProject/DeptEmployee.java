package uniExamProject;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class DeptEmployee {


    @Column(name = "emp_no", nullable = false)
    private Long emp_no;

    @Column(name = "dept_no", nullable = false)
    private Long dept_no;

    @Column(name = "from_date", nullable = false)
    private Date from_date;

    @Column(name = "to_date", nullable = false)
    private Date to_date;

    public DeptEmployee() {

    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    private Employees employees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_no", nullable = false, insertable = false, updatable = false)
    private Departments departments;

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Long getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Long emp_no) {
        this.emp_no = emp_no;
    }

    public Long getDept_no() {
        return dept_no;
    }

    public void setDept_no(Long dept_no) {
        this.dept_no = dept_no;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    @Override
    public String toString() {
        return "DeptEmployee{" +
                "emp_no=" + emp_no +
                ", dept_no=" + dept_no +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
