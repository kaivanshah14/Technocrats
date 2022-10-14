CREATE DEFINER=`root`@`localhost` PROCEDURE `CustomerBillForAMonth`(
IN cdate Date)
BEGIN
	Select c.id,c.name,c.customertype,c.areaCode,co.billid,co.units_consumed,co.totalbill 
    from customer c inner join consumption co on
    c.id=co.customer_id and
    Month(co.bill_month) = Month(cdate)order by co.totalbill desc;
END
