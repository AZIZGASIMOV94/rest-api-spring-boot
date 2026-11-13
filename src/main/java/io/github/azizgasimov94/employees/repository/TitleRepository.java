package io.github.azizgasimov94.employees.repository;

import io.github.azizgasimov94.employees.model.Title;
import io.github.azizgasimov94.employees.model.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, TitleId> {

    List<Title> findByEmpNoOrderByFromDate(Integer empNo);
}
