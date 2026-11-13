INSERT INTO employees VALUES
    (10001, '1953-09-02', 'Georgi',  'Facello', 'M', '1986-06-26'),
    (10002, '1964-06-02', 'Bezalel', 'Simmel',  'F', '1985-11-21'),
    (10003, '1959-12-03', 'Parto',   'Bamford', 'M', '1986-08-28'),
    (10004, '1954-05-01', 'Georgi',  'Koblick', 'M', '1986-12-01');

INSERT INTO departments VALUES
    ('d004', 'Production'),
    ('d005', 'Development'),
    ('d007', 'Sales');

INSERT INTO dept_emp VALUES
    (10001, 'd005', '1986-06-26', '9999-01-01'),
    (10002, 'd007', '1996-08-03', '9999-01-01'),
    (10003, 'd004', '1995-12-03', '9999-01-01'),
    (10004, 'd004', '1986-12-01', '9999-01-01');

INSERT INTO dept_manager VALUES
    (10003, 'd004', '1991-01-01', '1995-12-31'),
    (10004, 'd004', '1996-01-01', '9999-01-01');

-- Same start date for two employees: the old mapping (key = from_date only) merged these rows
INSERT INTO salaries VALUES
    (10001, 60117, '1986-06-26', '1987-06-26'),
    (10001, 62102, '1987-06-26', '1988-06-25'),
    (10004, 40054, '1986-06-26', '1987-12-01');

-- Same title for two employees: the old mapping (key = title only) merged these rows
INSERT INTO titles VALUES
    (10001, 'Senior Engineer', '1986-06-26', '9999-01-01'),
    (10003, 'Senior Engineer', '1995-12-03', '9999-01-01'),
    (10004, 'Engineer',        '1986-12-01', '1995-12-01'),
    (10004, 'Senior Engineer', '1995-12-01', '9999-01-01');
