-- Learn date and timestamp functions - DATE_ADD(), DATE_DIFF(),

-- IF usage
SELECT employee_id, first_name,
       IF(phone_number is not null, phone_number, '0000')
FROM employees WHERE manager_id  = 100;



-- IFNULL usage
SELECT employee_id, first_name,
       IFNULL(phone_number, '0000')
FROM employees WHERE manager_id  = 100;

-- Same result with COALESCE ( first not null value)
SELECT employee_id, first_name,
       COALESCE(phone_number, NULL, NULL, NULL, '0000')
FROM employees WHERE manager_id  = 100;

-- Same result using CASE
SELECT employee_id, first_name,
       CASE WHEN phone_number IS NULL THEN '0000' ELSE phone_number END  phone_number
FROM employees WHERE manager_id  = 100;

-- Concat
SELECT employee_id, CONCAT('Mr./Ms. ', first_name)
FROM employees WHERE manager_id  = 100;

-- Difference between TRUNCATE and ROUND
SELECT ROUND(0.666, 1),TRUNCATE(0.666, 1);

-- STRCMP (Works like java, returns 0 if equal)
SELECT STRCMP('a', 'a'),STRCMP('b', 'c');

-- CAST examples
SELECT CAST('2017-08-25' AS DATETIME)
SELECT CAST("2017-08-29" AS DATE);
SELECT CAST("2017-08-29" AS YEAR);
SELECT CAST(25.66 AS CHAR);
SELECT CAST(25.55 AS UNSIGNED); //26
SELECT CAST('25.55' AS UNSIGNED); //25



-- Other functions ISNULL(), NULLIF(), CAST, STRCMP(), UPPER(), CONCAT(), REVERSE(), TRIM(), SQRT, POWER(),
-- FLOOR(), CEILING(), ABS(), TRUNCATE(), ROUND(), REPLACE()
