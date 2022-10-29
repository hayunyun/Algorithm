-- 코드를 입력하세요
SELECT ins.animal_id, ins.name
from animal_ins ins
join animal_outs outs
on ins.animal_id = outs.animal_id
order by datediff(outs.datetime, ins.datetime) desc
limit 2
