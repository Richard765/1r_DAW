-- Actividad 1

CREATE TRIGGER check_employee_salary
    BEFORE UPDATE ON employees
    FOR EACH ROW
BEGIN
    SELECT 

    DECLARE min_sal INT;
    DECLARE max_sal INT;

    IF NEW.salary != OLD.salary OR
       (SELECT min_salary FROM jobs WHERE job_id = NEW.job_id) != (SELECT min_salary FROM jobs WHERE job_id = OLD.job_id) OR
       (SELECT max_salary FROM jobs WHERE job_id = NEW.job_id) != (SELECT max_salary FROM jobs WHERE job_id = OLD.job_id) THEN

        SELECT min_salary, max_salary INTO min_sal, max_sal
        FROM jobs
        WHERE job_id = NEW.job_id;

        IF NEW.salary < min_sal OR NEW.salary > max_sal THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'El salario no está dentro del rango permitido del puesto.';
        END IF;

        UPDATE trigger_log SET trigger_count = trigger_count + 1 WHERE id = 1;
    END IF;
END;

---------------------------------------- Actividad 2 -----------------------------------------------

CREATE TRIGGER check_order_total
    BEFORE UPDATE ON orders
    FOR EACH ROW
BEGIN
    SELECT 
    
    IF 

-- Actividad 3
CREATE TRIGGER check_inventory
    BEFORE INSERT 
    
    
    
    
CREATE OR REPLACE TRIGGER trg_sequences
BEFORE INSERT ON promotions
FOR EACH ROW
DECLARE
    tmp NUMBER;
BEGIN
    SELECT contador INTO tmp



--------------------------------------------------------------------------------------

SELECT * FROM promotions;
ALTER TABLE promotions ADD promo_percentage NUMBER(5,2);

ALTER TABLE promotions RENAME TO pro
-------------------------------------------------------------------------------------

--------Modificar una foreign key y borrar la foreign key
ALTER TABLE 
--------Modificar algun campo y que de error, cambiar un (EJ:VARCHAR A NUMBER)

--------Cambiar un number a un varchar



--------Deshabilitar ck, modificar 2 campos y rehabilitar la ck
--Primer ejemplo
ALTER TABLE employees
    DISABLE CONSTRAINT EMP_DEP_FK;

ALTER TABLE job_history
    DISABLE CONSTRAINT JHIS_DEP_FK;

ALTER TABLE departments
    DISABLE CONSTRAINT DEPT_ID_PK;
    
ALTER TABLE departments MODIFY department_id NUMBER(4);
ALTER TABLE employees MODIFY department_id NUMBER(4);
ALTER TABLE job_history MODIFY department_id NUMBER(4);

ALTER TABLE departments MODIFY department_id NUMBER(5, 1);
ALTER TABLE employees MODIFY department_id NUMBER(5, 1);
ALTER TABLE job_history MODIFY department_id NUMBER(5, 1);

ALTER TABLE employees
    ENABLE CONSTRAINT EMP_DEP_FK;
    
ALTER TABLE job_history
    ENABLE CONSTRAINT JHIS_DEP_FK;

ALTER TABLE departments
    ENABLE CONSTRAINT DEPT_ID_PK;
    
    
--SEGUNDO EJEMPLO
ALTER TABLE employees
    DISABLE CONSTRAINT EMP_DEP_FK;

ALTER TABLE job_history
    DISABLE CONSTRAINT JHIS_DEP_FK;

ALTER TABLE departments
    DISABLE CONSTRAINT DEPT_ID_PK;

CREATE TABLE departments_temp (
    department_id NUMBER(2)
);
    

-------------------------------------------------------
-- 
ALTER TABLE




-------------------------------------------------------
--CASES 3
--Case 3.1
CREATE TABLE customers

--Case 3.2
CREATE TABLE customers (
    customer_id NUMBER(12),
    cust_name VARCHAR2(100),
    cust_first_name VARCHAR(20),
    cust_last_name VARCHAR(20),
    cust_email VARCHAR(50),
    account_mgr_id NUMBER(6),
    cust_geo_location SDO_GEOMETRY,
    

CREATE TABLE cust_addresses (
    customer_id NUMBER(2),
    cust_address VARCHAR2(200)
);

--Case 3.3



--Creamos tablas copia para no degradar la BDD de cara
--a posteriores selects. Ojo que las FK no estarán definidas
--pero no las usaremos por simplicidad en la resolución 
--de los ejercicios

create table customers_2 as 
select * from customers;

create table orders_2 as 
select * from orders;

create table order_items_2 as
select * from order_items;

-- Procedure to remove a customer
create or replace NONEDITIONABLE PROCEDURE del_customer (cust_id HR.customers_2.customer_id%type) is
begin
    delete from customers_2 where customer_id = cust_id;
end;

-- Procedure to delete a range of customers
create or replace NONEDITIONABLE PROCEDURE del_customers (cust_id_l HR.customers_2.customer_id%type, cust_id_h HR.customers_2.customer_id%type) is
  cursor customer_c is -- define cursor
    select customer_id from customers_2
        where customer_id between cust_id_l and cust_id_h;
  row_customers customer_c%rowtype;  --define record for cursor
begin
 open customer_c;  -- open cursor
 loop
   fetch customer_c into row_customers; 
   exit when customer_c%notfound;
   dbms_output.put_line('Deleting customer: ' || row_customers.customer_id);
   del_orders(row_customers.customer_id);
   del_customer(row_customers.customer_id);
 end loop;
 close customer_c;
end;

-- Procedure to delete an order_items
create or replace NONEDITIONABLE PROCEDURE del_order_items (order_id HR.orders_2.order_id%type) is
begin
    delete from order_items_2 where order_id = order_id;
end;

-- Procedure to delete an order
create or replace NONEDITIONABLE PROCEDURE del_orders (cust_id HR.customers_2.customer_id%type) is
  cursor orders_c is -- define cursor
    select order_id from orders_2 where customer_id = cust_id;
  row_orders orders_c%rowtype;  --define record for cursor
begin
 open orders_c;  -- open cursor
 loop
   fetch orders_c into row_orders; 
   exit when orders_c%notfound;
   dbms_output.put_line('Deleting order: ' || row_orders.order_id);
   del_order_items(row_orders.order_id);
   delete from orders where order_id = row_orders.order_id;
 end loop;
 close orders_c;
end;

--Main program
--On to output messages
set serveroutput ON; 
Declare
	l constant HR.customers_2.customer_id%type := 200; --Constant1 for employee
	h constant HR.customers_2.customer_id%type := 210; --Constant2 for employee
Begin 
	del_customers(l,h);
End;
/
	
    