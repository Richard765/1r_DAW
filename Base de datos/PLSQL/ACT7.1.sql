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

CREATE TABLE departments_temp
    department_id