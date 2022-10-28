-- 코드를 입력하세요
# SELECT sum(total_order) from first_half

select ingredient_type, sum(total_order) from first_half as half, icecream_info as info
where half.flavor = info.flavor
group by ingredient_type

# select sum(total_order) from first_half where flavor in (select flavor from icecream_info where ingredient_type = 'sugar_based')

# select sum(total_order) from first_half where flavor in (select flavor from icecream_info where ingredient_type = 'fruit_based')


# select flavor from icecream_info where ingredient_type = 'sugar_based'