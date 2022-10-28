-- 코드를 입력하세요
# SELECT * from user_info where gender is not null
# order by year(joined), gender

select year(sales_date) year, month(sales_date) month,
gender, count(distinct(online.user_id)) users 
from online_sale as online
left join user_info as user
on online.user_id = user.user_id
where gender is not null
group by year, month, gender
order by year, month, gender