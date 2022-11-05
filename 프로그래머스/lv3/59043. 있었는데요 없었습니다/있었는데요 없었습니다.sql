select i.animal_id, i.name from animal_ins i
join
(select * from animal_outs) o
using(animal_id)
where o.datetime < i.datetime
order by i.datetime









# -- 코드를 입력하세요
# SELECT ins.animal_id, ins.name from animal_ins ins
# join
# (select animal_id, datetime from animal_outs) outs
# using(animal_id)
# where ins.datetime > outs.datetime
# order by ins.datetime