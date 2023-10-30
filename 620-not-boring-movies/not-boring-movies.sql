# Write your MySQL query statement belo
select id, movie, description, rating
from cinema
where id mod 2 !=0 and description!="boring"
order by rating desc;