-- Solution-1: Using CTEs (Common Table Expressions)
WITH dup_tiv AS (
    -- Find all tiv_2015 values that occur more than once (duplicates)
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
),
unique_loc AS (
    -- Find all unique locations (lat, lon) that occur exactly once
    SELECT lat, lon
    FROM Insurance
    GROUP BY lat, lon
    HAVING COUNT(*) = 1
)
-- Join Insurance table with duplicate tiv_2015 and unique locations
SELECT ROUND(SUM(i.tiv_2016), 2) AS tiv_2016
FROM Insurance i
JOIN dup_tiv t ON i.tiv_2015 = t.tiv_2015
JOIN unique_loc l ON i.lat = l.lat AND i.lon = l.lon;


-- -- Solution-2: Using WHERE IN with subqueries
-- SELECT ROUND(SUM(tiv_2016), 2) AS tiv_2016
-- FROM Insurance
-- WHERE tiv_2015 IN (
--     -- Subquery: Get tiv_2015 values that appear more than once
--     SELECT tiv_2015
--     FROM Insurance
--     GROUP BY tiv_2015
--     HAVING COUNT(*) > 1
-- )
-- AND (lat, lon) IN (
--     -- Subquery: Get unique (lat, lon) locations
--     SELECT lat, lon
--     FROM Insurance
--     GROUP BY lat, lon
--     HAVING COUNT(*) = 1
-- );

-- -- Solution-3: Using JOINs directly without CTE
-- SELECT ROUND(SUM(i.tiv_2016), 2) AS tiv_2016
-- FROM Insurance i
-- JOIN (
--     -- Subquery: Find duplicate tiv_2015 values
--     SELECT tiv_2015
--     FROM Insurance
--     GROUP BY tiv_2015
--     HAVING COUNT(*) > 1
-- ) t ON i.tiv_2015 = t.tiv_2015
-- JOIN (
--     -- Subquery: Find unique (lat, lon) locations
--     SELECT lat, lon
--     FROM Insurance
--     GROUP BY lat, lon
--     HAVING COUNT(*) = 1
-- ) l ON i.lat = l.lat AND i.lon = l.lon;