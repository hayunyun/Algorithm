select product_code, (price * total) sales 
from product p
join
(select product_id, sum(sales_amount) total from offline_sale group by product_id) o
using(product_id)

order by sales desc, product_code











# -- 코드를 입력하세요
# # SELECT product_code, (a.price * b.amount) sales from product a
# # join
# # (select product_id, sum(sales_amount) amount from offline_sale
# # group by product_id) b
# # using(product_id)
# # group by product_code
# # order by sales desc, product_code

# (select product_id, sum(sales_amount) amount from offline_sale
# group by product_id)