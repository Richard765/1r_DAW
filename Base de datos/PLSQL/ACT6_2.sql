-- Actividad 1
DECLARE
    v_employee_id NUMBER := :employee_id;
BEGIN
    DELETE FROM CUSTOMERS WHERE EMPLOYEE_ID = v_employee_id;
    DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = v_employee_id;
    COMMIT;
END;

-- Actividad 2
DECLARE
    v_customer_x NUMBER := :customer_x;
    v_customer_y NUMBER := :customer_y;
BEGIN
    FOR r IN (SELECT ORDER_ID FROM ORDERS WHERE CUSTOMER_ID BETWEEN v_customer_x AND v_customer_y) LOOP
        DELETE FROM ORDER_ITEMS WHERE ORDER_ID = r.ORDER_ID;
        DELETE FROM ORDERS WHERE ORDER_ID = r.ORDER_ID;
    END LOOP;
    DELETE FROM CUSTOMERS WHERE CUSTOMER_ID BETWEEN v_customer_x AND v_customer_y;
    COMMIT;
END;

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
    COMMIT;
END;

