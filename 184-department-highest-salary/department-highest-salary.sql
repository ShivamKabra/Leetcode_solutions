# Write your MySQL query statement below
with cte as (
select  d.name as Department,
e.name as Employee,e.salary,  max(e.salary) over(partition by e.departmentid) as max_Salary
from employee as e
left join department as d
on e.departmentID = d.id)



select Department, Employee, salary
from cte 
where Salary = max_salary;
