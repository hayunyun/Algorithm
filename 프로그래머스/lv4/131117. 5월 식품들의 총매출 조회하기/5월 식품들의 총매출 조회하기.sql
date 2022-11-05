select ord.product_id, pro.product_name, sum(amount)*pro.price total_sales
from food_order ord
join food_product pro
using(product_id)
where year(produce_date) = 2022 and month(produce_date) = 5
group by product_id
order by total_sales desc, product_id












# -- 코드를 입력하세요
# SELECT pro.product_id, pro.product_name, (pro.price * ord.amount) total_sales
# from food_product pro
# join
# (select product_id, sum(amount) amount, produce_date from food_order
# where year(produce_date) = 2022 and month(produce_date) = 5
# group by product_id) ord
# using(product_id)
# order by total_sales desc, product_id

# # select product_id, sum(amount) amount, produce_date from food_order
# # where year(produce_date) = 2022 and month(produce_date) = 5
# # group by product_id