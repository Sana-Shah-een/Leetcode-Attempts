CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  -- OFFSET zero se start hota mean OFFSET 0 = 1st Row , OFFSET 1 = 2nd Row That's why N=N-1
  SET N=N-1;
  RETURN (
        SELECT DISTINCT salary FROM Employee 
        ORDER BY salary DESC
        LIMIT 1 OFFSET N
  );
END
