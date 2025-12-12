--Activity9--
select c.customer_name as Customername,
c.city,
s.salesman_name as salesmanname,
s.commission 
from customers c INNER JOIN salesman s
ON c.salesman_id = s.SALESMAN_ID;

select c.customer_name, c.city,
s.salesman_name as salesmanname,s.salesman_city
from customers c LEFT OUTER JOIN salesman s 
on c.salesman_id=s.salesman_id where c.grade<300
order by c.customer_id;

SELECT c.customer_name AS "Customer Name", c.city, s.salesman_name AS "Salesman", s.commission FROM customers c 
INNER JOIN salesman s ON c.salesman_id=s.salesman_id 
WHERE s.commission>12;

SELECT o.order_no, o.order_date, o.purchase_amount, c.customer_name AS "Customer Name", c.grade, s.salesman_name AS "Salesman", s.commission FROM orders o 
INNER JOIN customers c ON o.customer_id=c.customer_id 
INNER JOIN salesman s ON o.salesman_id=s.salesman_id;