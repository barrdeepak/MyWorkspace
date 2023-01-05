-- Special functions like SELF JOINS, UNNEST in BQ, struct datatypes.

-- SELF JOIN to find pairs of employees and their managers along with their name salaries.
-- There no manager who makes less than employee.
SELECT e.employee_id,e.first_name,e.salary, e.manager_id, m.employee_id,m.first_name,m.salary
FROM employees e
JOIN employees m
ON e.manager_id = m.employee_id
ORDER BY 1


-- Unique pairs using self join
SELECT d1.department_name, d2.department_name FROM departments d1
JOIN departments d2
ON d1.department_name > d2.department_name