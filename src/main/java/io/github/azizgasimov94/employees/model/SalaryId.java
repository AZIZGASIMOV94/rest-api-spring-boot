package io.github.azizgasimov94.employees.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/** Composite primary key (emp_no, from_date) of the salaries table. */
@NoArgsConstructor
@EqualsAndHashCode
public class SalaryId implements Serializable {

    private Integer empNo;
    private LocalDate fromDate;
}
