-- -- Time Complexity: 
-- -- Window function + sorting per department  ->  approx O(N log N)

-- Solution-1: SubQuery -> temporary result written inside a query
-- SELECT d.name AS Department,e.name AS Employee,e.salary AS Salary
-- FROM(
--     SELECT *,
--     -- DENSE_RANK() -> same salary, same Rank (no skipping of numbers)
--     -- PARTITION BY departmentId -> Department-wise Ranking (Ranking restarts for each department)
--     DENSE_RANK() OVER(PARTITION BY departmentId 
--     ORDER BY salary DESC)AS rnk
--     FROM Employee
-- )e
-- JOIN Department d
-- on e.departmentId=d.id
-- WHERE rnk<=3;

-- Slutio-2: CTE(Common Table Expression) -> named temporary result created first, then used
WITH ranked AS
(
    SELECT d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary,
    DENSE_RANK() OVER(PARTITION BY departmentId ORDER BY salary DESC) AS rnk
    FROM Employee e JOIN Department d
    on e.departmentId = d.id 
)
SELECT Department,Employee,Salary 
FROM ranked WHERE rnk<=3
