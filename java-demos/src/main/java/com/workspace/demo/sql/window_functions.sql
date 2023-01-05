-- Here are some MySQL window functions. We can also use windowing with agg functions like SUM(), AVG()
-- CUME_DIST()
-- DENSE_RANK()
-- FIRST_VALUE()
-- LAG()
-- LAST_VALUE()
-- LEAD()
-- NTH_VALUE()
-- NTILE()
-- PERCENT_RANK()
-- RANK()
-- ROW_NUMBER()

--  Rank by average department salary
select
  d.department_name,
  round(avg(e.salary), 1) salary,
  rank() over (
    order by
      avg(e.salary) desc
  ) salary_rank
from
  employees e
  left join departments d on e.department_id = d.department_id
group by
  1;

-- Ranking employees based on salary for each job type
SELECT
   employee_id,
   j.job_title,
   salary,
   DENSE_RANK() OVER (PARTITION BY j.job_title ORDER BY salary DESC) rank_without_gap,
   RANK() OVER (PARTITION BY j.job_title ORDER BY salary DESC) rank_with_gap
FROM employees e
INNER JOIN jobs j
      ON e.job_id = j.job_id
ORDER BY 2, 3 DESC

-- Sequence of employees by joining date using row_number()
SELECT employee_id, first_name, j.job_title, hire_date,
ROW_NUMBER() OVER (ORDER BY hire_date) row_num
FROM employees e
INNER JOIN
jobs j ON e.job_id=j.job_id
WHERE salary>=8000

-- Aggregate function in a window function. Get average salary per department for each row.
-- Good link - https://dev.mysql.com/doc/refman/8.0/en/window-functions-usage.html
SELECT e.first_name, d.department_name,
ROUND(AVG(e.salary),2) OVER (PARTITION BY d.department_name) avg_department_salary
FROM
employees e
LEFT JOIN departments d
ON e.department_id = d.department_id


-- Top salary earners from each department
SELECT * FROM (
 SELECT e.employee_id, e.first_name, d.department_name, e.salary, DENSE_RANK() OVER ( PARTITION BY d.department_name ORDER BY e.salary DESC) rk
 FROM employees e
 JOIN departments d
 ON
 e.department_id=d.department_id
 ) t WHERE rk = 1

-- earliest employees of each department
with temp as (
select employee_id, hire_date, department_id, rank() over ( partition by department_id order by hire_date ) rk
from employees
)
select * from temp where rk =1

-- LAG() and LEAD() simple examples
SELECT employee_id, first_name,
LAG(employee_id) OVER (ORDER BY employee_id) previous_emp_id,
LEAD(employee_id) OVER (ORDER BY employee_id) next_emp_id
FROM employees
ORDER BY employee_id

