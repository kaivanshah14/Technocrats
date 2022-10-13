use eba;

create table customer(
id int auto_increment primary key,
name varchar(255),
customertype varchar(255)
);

create table consumption(
billid int auto_increment primary key,
bill_month date,
units_consumed int,
totalbill decimal(8,2),
customer_id int, 
foreign key(customer_id) references customer(id)
);