package uniExamProject.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_no", nullable = false)
    private Long emp_no;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name= "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    public Employees() {
    }

    /*@ManyToMany(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST,CascadeType.MERGE
    })
    @JoinTable(
            name = "dept_emp",
            joinColumns = {@JoinColumn(name = "emp_no")},
            inverseJoinColumns = {@JoinColumn(name = "dept_no")}
    )
    private Collection<Departments> departments;*/

    /*public Collection<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Departments> departments) {
        this.departments = departments;
    }*/

    @OneToMany(mappedBy = "employees", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Salaries> salaries;

    @OneToMany(mappedBy = "employees", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Titles> titiles;


    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "emp_no")
    private Collection<DeptEmployee> deptEmployees;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "emp_no")
    private Collection<DeptManager> deptManagers;


    public Collection<DeptManager> getDeptManagers() {
        return deptManagers;
    }

    public void setDeptManagers(Collection<DeptManager> deptManagers) {
        this.deptManagers = deptManagers;
    }

    public Collection<DeptEmployee> getDeptEmployees() {
        return deptEmployees;
    }

    public void setDeptEmployees(Collection<DeptEmployee> deptEmployees) {
        this.deptEmployees = deptEmployees;
    }

    public Collection<Titles> getTitiles() {
        return titiles;
    }

    public void setTitiles(Collection<Titles> titiles) {
        this.titiles = titiles;
    }

    public Collection<Salaries> getSalaries() {
        return salaries;
    }

    public void setSalaries(Collection<Salaries> salaries) {
        this.salaries = salaries;
    }

    public Long getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Long emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_no=" + emp_no +
                ", birthDate=" + birthDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", hireDate=" + hireDate +
                '}';
    }
}
