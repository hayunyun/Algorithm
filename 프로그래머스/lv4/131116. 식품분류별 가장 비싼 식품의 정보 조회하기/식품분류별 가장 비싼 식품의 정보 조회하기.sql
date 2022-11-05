-- 코드를 입력하세요
select a.category, b.max_price, a.product_name
from food_product a
join (select category, max(price) max_price from food_product 
where category in ('과자', '국', '김치', '식용유')
group by category) b
using(category)
where a.price = b.max_price
order by max_price desc

# SELECT A.category, b.max_price, A.product_name from food_product A,
# (select max(price) max_price, category from food_product 
# where category in ('과자', '국', '김치', '식용유')
# group by category) B
# where A.price = B.max_price and A.category = B.category
# order by price desc

# select max(price) max_price, category from food_product 
# where category in ('과자', '국', '김치', '식용유')
# group by category