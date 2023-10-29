CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
     # Write your MySQL query statement below.
       with cte AS 
        (select *,
        DENSE_RANK() OVER (ORDER BY salary desc) AS rnk
        from employee)

        select distinct salary 
        from cte where rnk=N
  );
END