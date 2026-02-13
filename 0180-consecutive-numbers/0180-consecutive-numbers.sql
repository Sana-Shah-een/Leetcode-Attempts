SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
JOIN Logs l2 ON l1.id = l2.id - 1
JOIN Logs l3 ON l1.id = l3.id - 2
WHERE BINARY l1.num = BINARY l2.num
AND BINARY l2.num = BINARY l3.num;
