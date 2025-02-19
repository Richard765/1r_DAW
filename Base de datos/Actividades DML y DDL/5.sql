/*ACTIVIDAD 5_4A*/

/*A*/
SELECT * FROM employees
WHERE hire_date < "2003-05-01";

/*B*/
SELECT first_name, last_name, department_name FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

/*C*/
SELECT first_name, last_name, job_title FROM employees e
INNER JOIN jobs j ON j.JOB_ID = e.JOB_ID;

/*D*/
SELECT e.employee_id, CONCAT(e.first_name, " ", e.last_name) employee_name, e.manager_id, CONCAT(m.first_name, " ", m.last_name) manager_name
FROM employees e 
INNER JOIN employees m ON e.manager_id = m.employee_id;

/*E*/
SELECT job_title, employee_id, DATEDIFF(end_date, start_date) FROM job_history jh
INNER JOIN jobs j ON jh.JOB_ID = j.JOB_ID
WHERE department_id LIKE "80";

/*F*/
SELECT d.department_name, AVG(e.salary) FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE e.COMMISSION_PCT IS NOT NULL
GROUP BY department_name;

/*G*/
SELECT j.job_id, job_title, COUNT(*), SUM(salary), MAX(salary) - MIN(salary) AS difference_salary FROM employees e
INNER JOIN jobs j ON e.JOB_ID = j.JOB_ID
GROUP BY j.job_id;

/*H*/
SELECT d.department_id, department_name, YEAR(hire_date) year, COUNT(employee_id) employees FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY d.department_id, department_name, year
ORDER BY d.department_id;

/*I*/
SELECT COUNT(*) new_employees, MONTH(hire_date) month FROM employees
WHERE YEAR(hire_date) = "2003"
GROUP BY month
ORDER BY month;

/*J*/
SELECT department_name, COUNT(e.employee_id) employees FROM departments d
INNER JOIN employees e ON d.department_id = e.department_id
GROUP BY d.department_id
HAVING employees > 5
ORDER BY d.DEPARTMENT_ID;

/*K*/
SELECT job_title, AVG(salary) average_salary FROM employees e
INNER JOIN jobs j ON j.JOB_ID = e.job_id
GROUP BY job_title
HAVING average_salary > 10000
ORDER BY average_salary;

/*L*/
SELECT department_id, department_name, region_name  from departments d
INNER JOIN locations l ON d.location_id = l.location_id
INNER JOIN countries c ON l.country_id = c.country_id
INNER JOIN regions r ON c.region_id = r.region_id;

/*M*/
SELECT CONCAT(first_name, " ", last_name) employee_name, region_name region FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID;

/*N*/
SELECT COUNT(*), region_name FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID
GROUP BY region_name;

/*O*/
SELECT COUNT(*), region_name FROM departments d
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID
GROUP BY region_name;

/*P*/
SELECT d.department_id, d.department_name, CONCAT(md.first_name, " ", md.last_name) manager_department, CONCAT(me.first_name, " ", me.last_name) manager_employee 
FROM departments d
INNER JOIN employees md ON d.MANAGER_ID = md.EMPLOYEE_ID
LEFT JOIN employees me ON md.MANAGER_ID = me.EMPLOYEE_ID
ORDER BY d.department_id;

/*Q*/
SELECT employee_id, first_name, last_name, salary, min_salary, max_salary FROM jobs j, employees e
WHERE j.job_id = e.job_id
AND salary NOT BETWEEN min_salary AND max_salary
ORDER BY employee_id;

/*R*/
SELECT e.employee_id, CONCAT(first_name, " ", last_name), de_e.department_name current_department, de_jh.department_name old_department
FROM job_history jh
INNER JOIN employees e ON jh.EMPLOYEE_ID = e.EMPLOYEE_ID
INNER JOIN departments d ON jh.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN departments de_jh ON jh.DEPARTMENT_ID = de_jh.DEPARTMENT_ID
INNER JOIN departments de_e ON e.DEPARTMENT_ID = de_e.DEPARTMENT_ID
WHERE de_e.department_name != de_jh.department_name
ORDER BY e.EMPLOYEE_ID;

/*S*/
SELECT e.employee_id, CONCAT(first_name, " ", last_name), j.job_title current_job, j_jh.job_title old_job
FROM employees e
INNER JOIN jobs j ON e.JOB_ID = j.JOB_ID
INNER JOIN job_history jh ON e.EMPLOYEE_ID = jh.EMPLOYEE_ID
INNER JOIN jobs j_jh ON jh.JOB_ID = j_jh.JOB_ID
WHERE j_jh.job_title != j.job_title
ORDER BY e.EMPLOYEE_ID;

/*Ejercicio clase Display job title, employee ID, number of days between ending
date and starting date for all jobs in department 80; from job
history.*/
SELECT job_title, employee_id, DATEDIFF(end_date, start_date) FROM job_history jh
INNER JOIN jobs j ON jh.JOB_ID = j.JOB_ID
WHERE department_id = 80;

/*Display employees and their managers.*/
SELECT e.employee_id, CONCAT(e.first_name, " ", e.last_name) employee_name, e.manager_id, CONCAT(m.first_name, " ", m.last_name) manager_name FROM employees e
INNER JOIN employees m ON e.manager_id = m.employee_id;

/*Display department ID, year and Number of employees joined(hired).*/
SELECT d.department_id, YEAR(hire_date) year, COUNT(employee_id) employees FROM employees
GROUP BY department_id, year
ORDER BY department_id, year;

/*Display the name of all employees and the region in which theywork.*/
SELECT CONCAT(e.first_name, " ", e.last_name), r.region_name FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID;

/*Display the number of employees per region.*/
SELECT r.region_name, COUNT(*) FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
INNER JOIN locations l ON d.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID
GROUP BY r.REGION_NAME;

/*T*/
INSERT INTO departments (department_id, department_name, manager_id, location_id)
SELECT 85, "Sales abroad", manager_id, location_id
FROM departments
WHERE department_id = 80;

INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (SELECT 85, "Sales abroad", manager_id, location_id FROM departments WHERE department_id = 80);


/*U*/
UPDATE locations
SET LOCATION_ID


/*V.1*/
SELECT CONCAT(e.first_name, " ", e.last_name), e.department_id, e.job_id FROM employees e
INNER JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
WHERE d.DEPARTMENT_NAME like "%sales%"
order by e.manager_id;

/*V.2*/
UPDATE employees
SET department_id = 85
WHERE employee_id between 146 AND 149;

/*V.3*/
UPDATE employees
SET department_id = 85
WHERE manager_id IN (SELECT DISTINCT manager_id FROM employees WHERE employee_id between 146 AND 149);
