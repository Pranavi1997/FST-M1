---Activity 11--

SELECT customer_id, customer_name FROM customers c
WHERE 1<(SELECT COUNT(*) FROM orders o WHERE c.customer_id = o.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman s
WHERE 1<(SELECT COUNT(*) FROM orders o WHERE s.salesman_id = o.salesman_id)
ORDER BY customer_name;

SELECT a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;