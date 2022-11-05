# select user_id from user_info
# where year(joined) = 2021

## 2021년에 가입

select year(sales_date) year, month(sales_date) month,
count(distinct o.user_id) puchased_users,
round((count(distinct o.user_id) / (select count(*) from user_info where year(joined) = 2021)), 1) puchased_ratio
from online_sale o
join user_info i
using(user_id)
where year(i.joined) = 2021
group by year, month
order by year, month

# select user_id from user_info
# where year(joined) = 2021

## 2021년에 가입 && 구매
# select count(distinct user_id) from online_sale
# where user_id in (select user_id from user_info
# where year(joined) = 2021)












# -- 코드를 입력하세요

# select year(sales_date) year, month(sales_date) month, 
# count(distinct A.user_id) puchased_users, 
# (round(count(distinct A.user_id) / (SELECT count(*) from user_info where year(joined) = 2021), 1)) puchased_ratio
# from online_sale A
# join
# (
#     SELECT user_id from user_info where year(joined) = 2021
# ) B
# on A.user_id = B.user_id
# group by year, month
# order by year, month


# # select year(sales_date) year, month(sales_date) month, 
# # count(distinct sale.user_id) puchased_users,
# # (round(count(distinct sale.user_id) / (SELECT count(user_id) from user_info where year(joined) = 2021), 1)) puchased_ratio
# # from online_sale sale
# # join user_info info
# # on sale.user_id = info.user_id
# # where year(info.joined) = 2021
# # group by year, month
# # order by year, month


# # SELECT count(*) from user_info where year(joined) = 2021
# # 2021년에 가입한 전체 회원 수