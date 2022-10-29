-- 코드를 입력하세요
SELECT ins.animal_id, ins.name from animal_ins ins
join
(select animal_id, datetime from animal_outs) outs
on ins.animal_id = outs.animal_id
where ins.datetime > outs.datetime
order by ins.datetime