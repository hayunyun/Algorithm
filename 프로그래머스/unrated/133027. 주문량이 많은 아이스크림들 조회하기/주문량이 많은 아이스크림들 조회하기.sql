# select * from july

select flavor
from first_half f
join
(select flavor, sum(total_order) july_total
from july
group by flavor) j
using(flavor)
order by (july_total + total_order) desc
limit 3













# -- 코드를 입력하세요
# select A.flavor from first_half A
# join
# (
#     SELECT flavor, sum(total_order) total_order from july
#     group by flavor
# ) B
# on A.flavor = B.flavor 
# order by (A.total_order + B.total_order) desc
# limit 3
# # SELECT * from july