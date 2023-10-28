# Write your MySQL query statement below

SELECT c.name AS Customers
FROM customers AS c
LEFT JOIN Orders AS o ON c.id = o.customerID
WHERE o.customerID IS NULL