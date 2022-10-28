-- 코드를 입력하세요
SELECT A.food_type, A.rest_id, A.rest_name, A.favorites
from rest_info A join
(select food_type, Max(favorites) as favorites
from rest_info 
group by food_type) B
where A.favorites = B.favorites
group by food_type
order by food_type desc



# SELECT *
# from rest_info
# order by food_type desc