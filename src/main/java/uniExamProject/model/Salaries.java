package uniExamProject.model;


import uniExamProject.model.Employees;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Salaries {

    @Column(name = "emp_no", nullable = false)
    private Long emp_no;

    @Column(name = "salary", nullable = false)
    private Long salary;

    @Id
    @Column(name = "from_date", nullable = false)
    private Date from_date;

    @Column(name = "to_date", nullable = false)
    private Date to_date;


    public Salaries() {

    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    private Employees employees;

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

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
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
        return "Salaries{" +
                "emp_no=" + emp_no +
                ", salary=" + salary +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
