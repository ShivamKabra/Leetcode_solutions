# Write your MySQL query statement below

select distinct p1.email as Email
from person as p1
inner join person as p2
where p1.id!=p2.id and p1.email=p2.email;