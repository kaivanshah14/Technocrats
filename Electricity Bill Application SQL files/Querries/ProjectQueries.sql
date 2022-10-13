create database eba;
use eba;

select * from customer;
select * from consumption;

call insertCustomerData(2,'yash','ajdcj','jfjoajf');


-- subtask 1
call allCustomerDetails();
-- subtask 2
CALL BillforAllforMonth('2020/02/01',@cname,@totalbill);
SELECT @cname,@totalbill;

-- subtask 3
Call BillWithNameAndMonth('yash','2020/02/02',@cname,@totalbill);
SELECT @cname,@totalbill;




