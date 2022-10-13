CREATE DEFINER=`root`@`localhost` PROCEDURE `BillforAllforMonth`(IN edate date, OUT cname varchar(255),OUT totalBill decimal(8,2))
BEGIN
Select customer.name ,consumption.totalbill from customer 
inner join consumption on customer.id=consumption.customer_id
where Month(bill_month) = Month(edate) ;

END