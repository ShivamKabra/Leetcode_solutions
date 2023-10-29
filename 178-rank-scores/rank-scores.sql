# Write your MySQL query statement below

WITH cte AS (
    SELECT *,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
    FROM scores
)

SELECT score, `rank`
FROM cte;
