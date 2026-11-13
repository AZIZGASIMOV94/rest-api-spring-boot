package io.github.azizgasimov94.employees;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeesApiIntegrationTest {

    @Autowired
    private MockMvc mvc;

    // ---------------------------------------------------------------- employees

    @Test
    void listsEmployeesWithPaging() throws Exception {
        mvc.perform(get("/api/employees").param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[*].empNo", contains(10001, 10002)))
                .andExpect(jsonPath("$.totalElements").value(4))
                .andExpect(jsonPath("$.totalPages").value(2));
    }

    @Test
    void filtersByFirstNameIgnoringCase() throws Exception {
        mvc.perform(get("/api/employees").param("firstName", "georgi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].lastName", contains("Facello", "Koblick")));
    }

    @Test
    void filtersByFirstAndLastName() throws Exception {
        mvc.perform(get("/api/employees").param("firstName", "Georgi").param("lastName", "Koblick"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].empNo", contains(10004)));
    }

    @Test
    void getsOneEmployee() throws Exception {
        mvc.perform(get("/api/employees/10001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Georgi"))
                .andExpect(jsonPath("$.gender").value("M"))
                .andExpect(jsonPath("$.hireDate").value("1986-06-26"));
    }

    @Test
    void unknownEmployeeReturns404() throws Exception {
        mvc.perform(get("/api/employees/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Employee 99999 not found"));
    }

    @Test
    void nonNumericEmployeeIdReturns400() throws Exception {
        mvc.perform(get("/api/employees/abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void salaryHistoryKeepsRowsWithTheSameStartDate() throws Exception {
        mvc.perform(get("/api/employees/10001/salaries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].amount", contains(60117, 62102)));
        mvc.perform(get("/api/employees/10004/salaries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].amount", contains(40054)));
    }

    @Test
    void titleHistoryIsOrderedAndNotMergedAcrossEmployees() throws Exception {
        mvc.perform(get("/api/employees/10004/titles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].title", contains("Engineer", "Senior Engineer")));
        mvc.perform(get("/api/employees/10003/titles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    // -------------------------------------------------------------- departments

    @Test
    void listsDepartmentsSortedById() throws Exception {
        mvc.perform(get("/api/departments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].deptNo", contains("d004", "d005", "d007")));
    }

    @Test
    void getsOneDepartment() throws Exception {
        mvc.perform(get("/api/departments/d005"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deptName").value("Development"));
    }

    @Test
    void listsEmployeesOfDepartment() throws Exception {
        mvc.perform(get("/api/departments/d004/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[*].empNo", contains(10003, 10004)));
    }

    @Test
    void listsManagerHistoryOfDepartment() throws Exception {
        mvc.perform(get("/api/departments/d004/managers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].empNo", contains(10003, 10004)));
    }

    @Test
    void unknownDepartmentReturns404() throws Exception {
        mvc.perform(get("/api/departments/d999/employees"))
                .andExpect(status().isNotFound());
    }
}
