WITH RECURSIVE hierarchy AS (
    -- Step 1: build levels from CEO
    SELECT
        employee_id,
        employee_name,
        manager_id,
        salary,
        1 AS level
    FROM Employees
    WHERE manager_id IS NULL

    UNION ALL

    SELECT
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        h.level + 1
    FROM Employees e
    JOIN hierarchy h
        ON e.manager_id = h.employee_id
),

descendants AS (
    -- Step 2: find all descendants of each employee
    SELECT
        e.employee_id AS manager_id,
        e.employee_id AS employee_id
    FROM Employees e

    UNION ALL

    SELECT
        d.manager_id,
        e.employee_id
    FROM descendants d
    JOIN Employees e
        ON e.manager_id = d.employee_id
)

SELECT
    h.employee_id,
    h.employee_name,
    h.level,
    COUNT(d.employee_id) - 1 AS team_size,
    SUM(e.salary) AS budget
FROM hierarchy h
JOIN descendants d
    ON h.employee_id = d.manager_id
JOIN Employees e
    ON d.employee_id = e.employee_id
GROUP BY h.employee_id, h.employee_name, h.level
ORDER BY level ASC, budget DESC, employee_name ASC;