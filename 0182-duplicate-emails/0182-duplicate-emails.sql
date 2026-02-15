-- Solution-1 : Using GROUP BY
-- SELECT email AS 'Email' FROM Person GROUP BY email HAVING COUNT(email) > 1;

-- Solution-2: Using SELF JOIN
SELECT DISTINCT p1.email AS 'Email' FROM Person p1 JOIN Person p2 
on p1.email = p2.email and p1.id <> p2.id;