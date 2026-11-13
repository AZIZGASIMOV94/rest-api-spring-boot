package io.github.azizgasimov94.employees.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** Composite primary key (emp_no, dept_no) of the dept_emp and dept_manager tables. */
@NoArgsConstructor
@EqualsAndHashCode
public class DepartmentAssignmentId implements Serializable {

    private Integer empNo;
    private String deptNo;
}
