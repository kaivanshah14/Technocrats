CREATE DEFINER=`root`@`localhost` PROCEDURE `modify_customer`(
	IN C_Id INT, 
    IN C_Name VARCHAR(255),
    IN C_Type VARCHAR(255),
    IN C_AreaCode VARCHAR(255)
)
BEGIN

	UPDATE Customer
	SET name = C_Name
	WHERE id = C_Id AND C_Name IS NOT NULL;
	
    UPDATE Customer
	SET customerType = C_Type
	WHERE id = C_Id AND C_Type IS NOT NULL;
    
    UPDATE Customer
	SET areaCode = C_AreaCode
	WHERE id = C_Id AND C_AreaCode IS NOT NULL;
    
END