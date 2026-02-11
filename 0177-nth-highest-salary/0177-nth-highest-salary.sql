CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N=N-1;
  RETURN (
    -- Solution-1: Without SUBQUERY
        -- SELECT DISTINCT salary FROM Employee 
        -- ORDER BY salary DESC
        -- LIMIT 1 OFFSET N

    -- Solution-2: SUBQUERY
        SELECT salary FROM(
            SELECT DISTINCT salary 
            FROM Employee ORDER BY salary DESC
        )AS t
        LIMIT 1 OFFSET N


    -- Solution-3: MS SQL SERVER : T-SQL

        -- Declare @result INT;
        -- SELECT @result = salary 
        -- FROM (
        --     SELECT DISTINCT salary 
        --     FROM Employee 
        -- )AS t
        -- ORDER BY salary DESC
        -- OFFSET @N-1 ROWS FETCH NEXT 1 ROW ONLY;
        -- RETURN @result;
  );
END