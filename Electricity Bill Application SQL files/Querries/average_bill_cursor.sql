CREATE DEFINER=`root`@`localhost` PROCEDURE `average_total_bill`(
	IN C_Type VARCHAR(255),
	OUT C_Avg DECIMAL(8,2)
)
BEGIN
	DECLARE flag INT DEFAULT false;
    DECLARE ct INT DEFAULT 0;
	DECLARE ty VARCHAR(255);
    DECLARE Res Decimal(8,2) DEFAULT 0;
    DECLARE temp Decimal(8,2);
	DECLARE c1 CURSOR FOR 
    SELECT c.customerType, co.totalBill FROM Customer c
	INNER JOIN Consumption co ON c.id = co.customer_id;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET flag = true;

	OPEN c1;
    
	customer: LOOP
    
    FETCH c1 INTO ty, temp;
    
    IF flag THEN
		LEAVE customer;
    END IF;
    
    IF ty = C_Type THEN
		SET res = res + temp;
        SET ct = ct + 1;
    END IF;
    
	END LOOP customer;
	
    CLOSE c1;
    
    SET C_Avg = res/ct;
END