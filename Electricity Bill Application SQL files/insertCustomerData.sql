CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCustomerData`(IN cid int, IN cname varchar(255), IN ctype varchar(255), IN acode varchar(255))
BEGIN
INSERT INTO CUSTOMER(id, name, customertype, areaCode)
VALUES(cid, cname, ctype, acode);
END