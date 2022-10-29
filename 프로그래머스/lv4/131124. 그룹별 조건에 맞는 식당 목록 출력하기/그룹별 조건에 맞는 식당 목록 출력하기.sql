-- 코드를 입력하세요
select member_name, review_text, date_format(review_date, '%Y-%m-%d') review_date 
from member_profile pro
join rest_review rev
 on pro.member_id = rev.member_id
where pro.member_id = (
    SELECT member_id from rest_review
    group by member_id
    order by count(member_id) desc
    limit 1
)
order by review_date, review_text

# select 

# SELECT member_id, count(*) counts from rest_review
# group by member_id
# order by counts desc
# limit 1