use eba;

drop table consumption;
drop table customer;

CREATE TABLE `customer` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `customertype` varchar(255) DEFAULT NULL,
  `areaCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

create table consumption(
billid int auto_increment primary key,
bill_month date NOT NULL,
units_consumed int NOT NULL DEFAULT 0,
totalbill decimal(8,2),
customer_id int NOT NULL, 
foreign key(customer_id) references customer(id)
);

-- this query is to create customer and consumption tables