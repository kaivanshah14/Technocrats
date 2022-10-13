CREATE DEFINER=`root`@`localhost` PROCEDURE `allCustomerDetails`()
BEGIN
select * from customer;
END