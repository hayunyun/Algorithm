select i.animal_id, i.animal_type, i.name
from animal_ins i
join animal_outs o
using(animal_id)
where i.sex_upon_intake != o.sex_upon_outcome
order by animal_id











# -- 코드를 입력하세요
# SELECT 
# ins.animal_id, ins.animal_type, ins.name
# from animal_ins ins
# join
# animal_outs outs
# on (ins.animal_id = outs.animal_id)
# where ins.sex_upon_intake != outs.sex_upon_outcome
# order by animal_id