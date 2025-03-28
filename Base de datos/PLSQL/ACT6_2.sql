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
DECLARE
    v_promotion_id NUMBER := :promotion_id;
BEGIN
    UPDATE ORDER_ITEMS
    SET UNIT_PRICE = UNIT_PRICE * 0.9
    WHERE ORDER_ID IN (
        SELECT ORDER_ID FROM ORDERS WHERE PROMOTION_ID = v_promotion_id
    );
    COMMIT;
END;

-- Actividad 4
DECLARE
    v_location_id NUMBER := :location_id;
BEGIN
    UPDATE ORDER_ITEMS
    SET UNIT_PRICE = UNIT_PRICE * 1.1
    WHERE ORDER_ID IN (
        SELECT DISTINCT ORDER_ID FROM ORDERS WHERE WAREHOUSE_ID IN (
            SELECT WAREHOUSE_ID FROM WAREHOUSES WHERE LOCATION_ID = v_location_id
        )
    );
END;


-- Actividad 5


-- Algo
