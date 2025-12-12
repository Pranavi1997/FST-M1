--Activity8--
select customer_id, MAX(purchase_amount) as MAX_Amount from ORDERS group by customer_id;
select salesman_ID,order_date,MAX(purchase_amount) as MAX_Amount from ORDERS WHERE ORDER_DATE = TO_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id,order_date;
SELECT customer_id, order_date, MAX(purchase_amount) AS MaxAmount FROM orders GROUP BY customer_id, order_date HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);