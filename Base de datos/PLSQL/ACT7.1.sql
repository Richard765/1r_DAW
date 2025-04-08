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
