-- Actividad 1
DECLARE
    v_employee_id NUMBER := :employee_id;
BEGIN
    DELETE FROM customers WHERE EMPLOYEE_ID = ACCOUNT_MGR_ID;
    COMMIT;
END;

-- Actividad 1
CREATE OR REPLACE PROCEDURE eliminar_emp (param1 number)
IS
    BEGIN
    UPDATE customers
    SET account_mgr_id = null
    WHERE account_mgr_id = param1;
    
    DELETE FROM employees
    WHERE employee_id = param1;
    
END;

-- Actividad 2
CREATE OR REPLACE PROCEDURE eliminarDatosCliente(cust_id, customers.customer_id%TYPE) AS
BEGIN
    DELETE FROM orders
    WHERE customer_id = cust_id;
    
    DELETE FROM customers
    WHERE customer_id = cust_id;
END;
/*
DECLARE
    CURSOR c(cust_id customers.customer_id%TYPE) IS
        SELECT order_id FROM orders
        WHERE customer_id = cust_id;
    r c%ROWTYPE;
BEGIN
    LOOP
        OPEN c(x);
        LOOP
            FETCH c INTO r;
            EXIT WHEN c%NOTFOUND;
            eliminarOrderItem(r.order_id);
        END LOOP;
        CLOSE c;
        eliminarDatosCliente(x);
        EXIT LOOP WHEN x = y;
    END LOOP;
END;
*/
-- Actividad 3
CREATE OR REPLACE PROCEDURE salePromotion(p_promotion_id IN NUMBER) AS
BEGIN
    UPDATE ORDER_ITEMS oi
    SET oi.UNIT_PRICE = oi.UNIT_PRICE * 0.9
    WHERE oi.ORDER_ID IN (
        SELECT o.ORDER_ID
        FROM ORDERS o
        WHERE o.PROMOTION_ID = p_promotion_id
    );
END;

    
-- Actividad 4
CREATE OR REPLACE function 
DECLARE 

BEGIN


-- Actividad 5


-- Actividad 6

-- Algo
