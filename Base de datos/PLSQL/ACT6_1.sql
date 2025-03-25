-- Actividad 1
set serveroutput on;
begin
    DBMS_OUTPUT.PUT_LINE('Hello world !!!');
END;

-- Actividad 2
set serveroutput on;
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;
END;


-- Actividad 3
SET SERVEROUTPUT ON;
BEGIN
    FOR i IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE((2 * i) - 1);
    END LOOP;
END;

SET SERVEROUTPUT ON;
DECLARE
    i NUMBER;
    x NUMBER;
BEGIN
    i := 0;
    x := 1;
    LOOP
    EXIT WHEN i = 10;
        DBMS_OUTPUT.PUT_LINE(x);
        x := x + 2;
        i := i + 1;
    END LOOP;
END;

-- Actividad 4
SET SERVEROUTPUT ON;
DECLARE
    CURSOR c IS
        SELECT first_name, last_name FROM employees;
    r c%ROWTYPE;
BEGIN
    OPEN c;
    LOOP
        FETCH c INTO r;
        EXIT WHEN c%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(r.first_name || ', ' || r.last_name);
    END LOOP;
    CLOSE c;
END;

-- Actividad 5
SET SERVEROUTPUT ON;
DECLARE
    CURSOR c (department employees.department_id%TYPE) IS
        SELECT first_name, last_name FROM employees
        WHERE department_id = department;
    r c%ROWTYPE;
BEGIN
    OPEN c(80);
    LOOP
        FETCH c INTO r;
        EXIT WHEN (c%NOTFOUND);
        DBMS_OUTPUT.PUT_LINE(r.first_name || ', ' || r.last_name);
    END LOOP;
    CLOSE c;
END;
        
-- Actividad 6
SET SERVEROUTPUT ON;
DECLARE
    CURSOR c (department employees.department_id%TYPE) IS
        SELECT employee_id, first_name, last_name FROM employees
        WHERE department_id = department;
    
    CURSOR history (emp_id employees.employee_id%TYPE) IS
        SELECT job_id, department_id FROM job_history
        WHERE employee_id = emp_id;
    
    emp_record c%ROWTYPE;
    hist_record history%ROWTYPE;
BEGIN
    OPEN c(80);
    LOOP
        FETCH c INTO emp_record;
        EXIT WHEN c%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Employee: ' || emp_record.first_name || ', ' || emp_record.last_name);
        
        OPEN history(emp_record.employee_id);
        LOOP
            FETCH history INTO hist_record;
            EXIT WHEN history%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE('>>>>>>> Job: ' || hist_record.job_id || ', Department: ' || hist_record.department_id);
        END LOOP;
        CLOSE history;
        
    END LOOP;
    CLOSE c;
END;
    