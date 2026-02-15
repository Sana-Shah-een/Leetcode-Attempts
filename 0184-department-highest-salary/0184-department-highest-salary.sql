-- write by myself but then it did'nt return the expected output, duplicates not allowed in this case

-- SELECT  d.name AS 'Department',e.name AS 'Employee',
-- max(e.salary) AS 'Salary' 
-- FROM Employee e JOIN Department d
-- on e.departmentId = d.id GROUP By e.departmentId

-- Now get hint from leetcode 

SELECT d.name AS 'Department', e.name AS 'Employee',
e.salary AS 'Salary'
FROM Employee e JOIN Department d
ON e.departmentId = d.id 
WHERE e.salary = (
    SELECT max(salary) FROM Employee 
    WHERE departmentId = e.departmentId
);
