# Write your MySQL query statement below

select e2.name as Employee
from employee as e1
join employee as e2
on e1.ID = e2.managerID
where e2.salary>e1.salary;