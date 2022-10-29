-- 코드를 입력하세요
SELECT (left(product_code, 2)) category, count(*) products
from product 
group by category
order by category
# select * from product