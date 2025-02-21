/*Ejercicios 5.4.B*/
/*4*/
DELETE FROM job_history
WHERE employee_id IN (
	SELECT employee_id FROM employees 
    WHERE hire_date <= '1999-12-31'
);

/*6*/
DELETE FROM jobs j
WHERE j.job_id NOT IN (
	SELECT job_id FROM employees
	WHERE job_id is not null);




/*9*/
SELECT CONCAT(e.first_name, " ", e.last_name) employee_name, e.salary FROM employees e
WHERE e.salary = (SELECT MIN(salary) FROM employees);


/*10*/
UPDATE employees SET salary = salary * 1.1
WHERE salary = (SELECT MIN(salary) FROM employees);

UPDATE employees SET salary = salary * 1.10
WHERE salary = (SELECT m FROM ( SELECT MIN(salary) m FROM employees ) e);

/*12*/
SELECT d.department_id FROM departments d
WHERE d.DEPARTMENT_ID NOT IN (SELECT e.department_id
							FROM employees e 
							GROUP BY e.DEPARTMENT_ID
							HAVING COUNT(*) >= 3);
                            
SELECT d.DEPARTMENT_NAME, COUNT(e.EMPLOYEE_ID) employees FROM employees e
RIGHT JOIN departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY d.DEPARTMENT_NAME
HAVING employees <= 3;
                            
/*15*/
SELECT e.first_name, e.last_name FROM jobs j
INNER JOIN employees e ON j.job_id = e.job_id;