-- 코드를 입력하세요
SELECT info.rest_id, rest_name, food_type, favorites, address, score from rest_info info inner join 
(select rest_id, round(AVG(review_score), 2) score from rest_review group by rest_id) review
where 
info.rest_id = review.rest_id and 
address like ('서울%') order by score desc, favorites desc


# (select rest_id, round(AVG(review_score), 2) score from rest_review group by rest_id)