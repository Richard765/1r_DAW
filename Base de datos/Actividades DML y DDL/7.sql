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

/*B*/
SELECT CONCAT(cust_first_name, " ", cust_last_name), date_of_birth FROM customers
WHERE date_of_birth > '2025-02-21';

UPDATE customers SET date_of_birth = NULL
WHERE date_of_birth > '2025-02-21';

SELECT CONCAT(cust_first_name, " ", cust_last_name), date_of_birth FROM customers
WHERE date_of_birth IS NULL;

/*Listado todos los almacenes que no tengan inventario*/
SELECT w.warehouse_name FROM warehouses w
LEFT JOIN inventories i ON w.WAREHOUSE_ID = i.WAREHOUSE_ID
WHERE i.WAREHOUSE_ID IS NULL;

SELECT w.WAREHOUSE_NAME FROM warehouses w
WHERE w.WAREHOUSE_ID IN (SELECT i.WAREHOUSE_ID FROM inventories i);

/*De cada almacen que articulos tiene y cantidad*/
SELECT w.warehouse_name, pi.PRODUCT_NAME, i.QUANTITY_ON_HAND FROM warehouses w
INNER JOIN inventories i ON w.WAREHOUSE_ID = i.WAREHOUSE_ID
INNER JOIN product_information pi ON i.PRODUCT_ID = pi.PRODUCT_ID
ORDER BY w.WAREHOUSE_NAME, pi.PRODUCT_NAME;

/*De cada almacen cuantos articulos distintos tiene*/
SELECT w.warehouse_name, COUNT(DISTINCT i.PRODUCT_ID) different_products FROM warehouses w
INNER JOIN inventories i ON w.WAREHOUSE_ID = i.WAREHOUSE_ID
GROUP BY w.WAREHOUSE_NAME
ORDER BY w.WAREHOUSE_NAME;

/*Inventario de producto por region*/
SELECT SUM(i.quantity_on_hand) productos, r.region_name FROM inventories i
INNER JOIN warehouses w ON i.WAREHOUSE_ID = w.WAREHOUSE_ID
INNER JOIN locations l ON w.LOCATION_ID = l.LOCATION_ID
INNER JOIN countries c ON l.COUNTRY_ID = c.COUNTRY_ID
INNER JOIN regions r ON c.REGION_ID = r.REGION_ID
GROUP BY r.REGION_NAME;

/*De cada empleado de cuantos customers es manager*/
SELECT CONCAT(e.first_name, " ", e.last_name) employee_name, COUNT(c.customer_id) FROM employees e
INNER JOIN customers c ON e.EMPLOYEE_ID = c.ACCOUNT_MGR_ID
GROUP BY employee_name;

/*Por cada order una con el total de order items (suma), ordertotal*/
SELECT o.order_id, SUM(oi.QUANTITY * oi.unit_price) product_sum, o.ORDER_TOTAL FROM orders o
INNER JOIN order_items oi ON o.ORDER_ID = oi.ORDER_ID
GROUP BY o.ORDER_ID, o.ORDER_TOTAL
ORDER BY o.ORDER_ID;

/*Solo mostrar donde pxq no es igual al ordertotal*/
SELECT o.order_id, SUM(oi.QUANTITY * oi.unit_price) product_sum, o.ORDER_TOTAL FROM orders o
INNER JOIN order_items oi ON o.ORDER_ID = oi.ORDER_ID
GROUP BY o.ORDER_ID, o.ORDER_TOTAL
HAVING product_sum != o.ORDER_TOTAL
ORDER BY o.ORDER_ID;