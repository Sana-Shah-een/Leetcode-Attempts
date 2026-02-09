# name of employee find krna th so that's why e.name
# e.managerid ki id equal ho employee id se (e.managerId = m.id)
# employee ki salary zyada ho manager ki salary se (e.salary>m.salary)
SELECT e.name AS 'Employee' FROM Employee e INNER JOIN Employee m on e.managerId=m.id WHERE e.salary>m.salary;