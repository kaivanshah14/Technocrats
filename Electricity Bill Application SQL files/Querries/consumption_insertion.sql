CREATE DEFINER=`root`@`localhost` PROCEDURE `insertConsumptionData`(
	IN C_Month Date, 
	IN C_units_consumed INT,
	IN C_totalbill DECIMAL(8,2),
	IN C_customer_id INT
)
BEGIN
	
    INSERT INTO Consumption (bill_month, units_consumed, totalbill, customer_id)
    VALUES (C_Month, C_units_consumed, C_totalbill, C_customer_id);
    
    
END