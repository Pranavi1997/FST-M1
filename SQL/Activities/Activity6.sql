--Activity6--
SELECT distinct salesman_id from ORDERS;
SELECT order_no,order_date from orders order by order_date ASC;
SELECT order_no,PURCHASE_AMOUNT from orders order by PURCHASE_AMOUNT DESC;
SELECT * from orders where PURCHASE_AMOUNT<500; 
SELECT * from orders where PURCHASE_AMOUNT BETWEEN 1000 and 2000;