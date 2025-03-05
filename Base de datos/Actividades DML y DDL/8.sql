-- Ejercicios examen --
-- Genera una única consulta que de un listado de los nombres y apellidos de todos los employees y de todos los customers --
SELECT first_name, last_name FROM employees
UNION
SELECT cust_first_name, cust_last_name FROM customers;

-- Mostrar todas las órdenes, su suma total ,la suma de todas las líneas que componen la orden (tabla order_item), --
-- la diferencia entre el total de la orden y la suma de sus order_items así como el id del manager de cada orden.  --
SELECT o.ORDER_ID, o.ORDER_TOTAL, SUM(oi.UNIT_PRICE * oi.QUANTITY) AS SUM_ORDER_ITEMS, 
(o.ORDER_TOTAL - SUM(oi.UNIT_PRICE * oi.QUANTITY)) AS DIFFERENCE, e.EMPLOYEE_ID AS MANAGER_ID
FROM ORDERS o
INNER JOIN ORDER_ITEMS oi ON o.ORDER_ID = oi.ORDER_ID
INNER JOIN CUSTOMERS c ON o.CUSTOMER_ID = c.CUSTOMER_ID
INNER JOIN EMPLOYEES e ON c.CUSTOMER_ID = e.EMPLOYEE_ID
GROUP BY o.ORDER_ID, o.ORDER_TOTAL, e.EMPLOYEE_ID;
