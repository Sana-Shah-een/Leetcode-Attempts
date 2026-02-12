-- Solution-1: Using Window Function
-- DENSE_RANK() → same rank for ties, no gaps
-- SELECT score,DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
-- FROM Scores;

-- Solution-2: By using Self Join and Group Functions
SELECT 
    s1.score,
    COUNT(DISTINCT s2.score) AS 'rank'
FROM Scores s1
JOIN Scores s2
ON s1.score <= s2.score
GROUP BY s1.id, s1.score
ORDER BY s1.score DESC;
