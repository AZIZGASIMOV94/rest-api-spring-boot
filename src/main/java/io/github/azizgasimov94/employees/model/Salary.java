package io.github.azizgasimov94.employees.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
@Getter
@NoArgsConstructor
public class Salary {

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "salary")
    private Integer amount;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;
}
