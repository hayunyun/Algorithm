-- 코드를 입력하세요
# sales_date, product_id, user_id, sales_amount

# select * from online_sale where date_format(sales_date, '%m') = '03'; 

select date_format(sales_date, '%Y-%m-%d') sales_date, product_id, user_id, sales_amount 
from online_sale where year(sales_date) = 2022 and month(sales_date) = 3
union all
select date_format(sales_date, '%Y-%m-%d') sales_date, product_id, null, sales_amount 
from offline_sale where year(sales_date) = 2022 and month(sales_date) = 3
order by sales_date, product_id, user_id

# SELECT * from online_sale onl left join offline_sale off 
# on onl.product_id = off.product_id where date_format(onl.sales_date, '%m') = '03';