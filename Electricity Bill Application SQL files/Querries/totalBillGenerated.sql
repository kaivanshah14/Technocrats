CREATE DEFINER=`root`@`localhost` PROCEDURE `totalBillGenerated`(IN qdate date,OUT sumtotalBill decimal(8,2))
BEGIN
select sum(totalbill) into sumtotalBill from consumption 
where month(bill_month)=Month(qdate);

Select sumtotalBill as TotalMonthlySum;
END