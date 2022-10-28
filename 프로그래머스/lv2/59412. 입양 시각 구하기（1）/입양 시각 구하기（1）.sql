-- 코드를 입력하세요
SELECT hour(datetime), count(*) from animal_outs where date_format(datetime, '%T') between '09:00:00' and '19:59:00' 
group by hour(datetime)
order by hour(datetime)

# date_format(ao.datetime,'%T') between '09:00:00' and '19:59:00'