197. Rising Temperature
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+

SELECT w2.id
FROM Weather w1
INNER JOIN Weather w2
ON DATE_ADD(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate
WHERE w1.temperature<w2.temperature

627. Swap Salary
-- Swap the sex of all rows i.e. m => f and f => m
UPDATE salary SET sex = IF(sex = 'm', 'f','m');


607. Sales Person
SELECT DISTINCT s.name FROM salesperson s
LEFT JOIN
(SELECT sales_id FROM orders o
 JOIN company c ON o.com_id = c.com_id WHERE c.name ='RED'
 ) t
 ON s.sales_id = t.sales_id WHERE t.sales_id IS NULL
