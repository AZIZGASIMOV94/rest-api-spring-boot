package io.github.azizgasimov94.employees.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

/** A period during which an employee managed a department. Table `dept_manager`. */
@Entity
@Table(name = "dept_manager")
@IdClass(DepartmentAssignmentId.class)
@Getter
@NoArgsConstructor
public class DepartmentManager {

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;
}
