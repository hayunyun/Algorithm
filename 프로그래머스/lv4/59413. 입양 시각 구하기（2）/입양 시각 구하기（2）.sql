-- 코드를 입력하세요
# select * from animal_outs

set @hour = -1;
select (@hour := @hour + 1) as hour, 
(select count(*) from animal_outs where hour(datetime) = @hour) count
from animal_outs
where @hour < 23;


# SELECT hour(datetime) hour, count(*) from animal_outs 
# where hour(datetime) between 0 and 23
# group by hour
# order by hour