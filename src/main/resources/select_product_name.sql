SELECT o.product_name AS product
FROM ORDERS o
         JOIN CUSTOMERS c ON o.customer_id = c.id
WHERE LOWER(c.name) = 'alexey';