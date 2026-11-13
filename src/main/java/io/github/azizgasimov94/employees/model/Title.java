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
@Table(name = "titles")
@IdClass(TitleId.class)
@Getter
@NoArgsConstructor
public class Title {

    @Id
    @Column(name = "emp_no")
    private Integer empNo;

    @Id
    @Column(name = "title")
    private String title;

    @Id
    @Column(name = "from_date")
    private LocalDate fromDate;

    /** 9999-01-01 in the sample data means "current". */
    @Column(name = "to_date")
    private LocalDate toDate;
}
