-- SELECT 
-- CASE
-- -- when id is odd then it swaps with its next id but also check whn last id is odd then the same id is return
--     WHEN id % 2 = 1 AND id < (SELECT MAX(id) FROM Seat) THEN id+1
-- -- when id is even then it swaps with its previous one
--     WHEN id % 2 =0 THEN id-1
--     ELSE id
-- END AS id,
-- student FROM Seat 
-- ORDER BY id ASC;

-- got the new concept through chatgpt (WINDOW FUNCTIONS)
-- LEAD()-> Gets value from the next row (Looks forward)
-- LAG()-> Gets value from a previous row (Looks backward)

-- LEAD(column, offset, default_value) OVER (ORDER BY column)
-- column → value you want from next row
-- offset → how many rows forward
-- default_value → value returned if no next row exists

SELECT id,
CASE
    WHEN id % 2 = 1 THEN LEAD(student,1,student) OVER(ORDER BY id)
    WHEN id % 2 = 0 THEN LAG(student,1) OVER (ORDER BY id)
END AS student 
FROM Seat 
ORDER BY id;
