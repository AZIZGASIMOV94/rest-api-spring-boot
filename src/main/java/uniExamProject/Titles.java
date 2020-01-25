package uniExamProject;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Titles {

    @Column(name = "emp_no", nullable = false)
    private Long emp_no;

    @Id
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "from_date", nullable = false)
    private Date from_date;

    @Column(name = "to_date", nullable = false)
    private Date to_date;

    public Titles() {

    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emp_no", nullable = false, insertable = false, updatable = false)
    private Employees employees;

    public Long getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Long emp_no) {
        this.emp_no = emp_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "Titles{" +
                "emp_no=" + emp_no +
                ", title='" + title + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                '}';
    }
}
