CREATE DEFINER=`root`@`localhost` PROCEDURE `BillWithNameAndMonth`(IN custname varchar(255),IN cdate date, OUT cname varchar(255),OUT totalBill decimal(8,2))
BEGIN
Select customer.name ,consumption.totalbill from customer 
inner join consumption on customer.id=consumption.customer_id
where customer.name=custname
AND
Month(bill_month) = Month(cdate) ;
END