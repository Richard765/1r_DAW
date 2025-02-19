/*EJERCICIO 5.4A*/
/*N*/
SELECT COUNT(*), region_name FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID
GROUP BY region_name;

/*Q*/
SELECT employee_id, first_name, last_name, salary, min_salary, max_salary FROM jobs j, employees e
WHERE j.job_id = e.job_id
AND salary NOT BETWEEN min_salary AND max_salary
ORDER BY employee_id;

/*K*/
SELECT job_title, AVG(salary) average_salary FROM employees e
INNER JOIN jobs j ON e.JOB_ID = j.job_id
GROUP BY job_title
HAVING average_salary > 10000
ORDER BY average_salary;



/*EJERCICIO 5.4B*/
/*5*/
SELECT CONCAT(last_name, " ", first_name) full_name, job_title FROM employees e
RIGHT JOIN jobs j ON e.JOB_ID = j.JOB_ID
ORDER BY full_name, job_title;

SELECT COUNT(*) FROM jobs;
SELECT COUNT(DISTINCT job_id) FROM employees;

/*6*/
DELETE FROM jobs j
WHERE j.JOB_ID NOT IN (SELECT DISTINCT e.JOB_ID from employees e);

/*8*/
SELECT e.EMPLOYEE_ID, e.phone_number FROM employees e
WHERE e.phone_number = (SELECT e2.phone_number FROM employees e2 WHERE e.PHONE_NUMBER = e2.PHONE_NUMBER AND e.EMPLOYEE_ID != e2.employee_id);

SELECT e.employee_id, e.phone_number FROM employees e
INNER JOIN employees e2 ON (e.PHONE_NUMBER = e2.PHONE_NUMBER AND e.EMPLOYEE_ID != e2.EMPLOYEE_ID);

/*12*/
SELECT d.department_id FROM departments d
WHERE d.DEPARTMENT_ID NOT IN (SELECT e.department_id
							FROM employees e 
							GROUP BY e.DEPARTMENT_ID
							HAVING COUNT(*) >= 4);

/*13*/


/*14*/

/*EJERCICIO 5.5*/
/*B*/

/*C*/
SELECT CONCAT(c.cust_first_name, " ", c.cust_last_name) Customer_name, CONCAT(e.first_name, " ", e.last_name) Employee_name FROM customers c
INNER JOIN employees e ON c.ACCOUNT_MGR_ID = e.EMPLOYEE_ID;

/*D*/
SELECT CONCAT(c.cust_first_name, " ", c.cust_last_name) Customer_name, COUNT(o.ORDER_ID) Orders FROM customers c
LEFT JOIN orders o ON c.CUSTOMER_ID = o.CUSTOMER_ID
WHERE o.ORDER_ID IS NULL
GROUP BY Customer_name;

/*E*/
SELECT CONCAT(c.cust_first_name, " ", c.cust_last_name) Customer_name, COUNT(o.ORDER_ID) Orders FROM customers c
INNER JOIN orders o ON c.CUSTOMER_ID = o.CUSTOMER_ID
GROUP BY Customer_name
HAVING Orders > 4;