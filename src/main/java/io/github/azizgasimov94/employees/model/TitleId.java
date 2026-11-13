package io.github.azizgasimov94.employees.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/** Composite primary key (emp_no, title, from_date) of the titles table. */
@NoArgsConstructor
@EqualsAndHashCode
public class TitleId implements Serializable {

    private Integer empNo;
    private String title;
    private LocalDate fromDate;
}
