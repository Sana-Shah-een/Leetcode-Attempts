SELECT 
-- result rounded to 2 decimals
ROUND(COUNT(DISTINCT a.player_id)/ (SELECT COUNT(DISTINCT player_id) FROM Activity),2) AS Fraction
FROM Activity a 
JOIN
(
    -- har player ki frst login date
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity 
    GROUP BY player_id
)f
on a.player_id=f.player_id
-- DATE_ADD -> first login k next day ko add krta h 
AND a.event_date = DATE_ADD(f.first_login,INTERVAL 1 DAY);
