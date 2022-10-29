-- 코드를 입력하세요
# 차집합
SELECT ins.name, ins.datetime from animal_ins ins 
left join
animal_outs outs
on ins.animal_id = outs.animal_id
where outs.animal_id is null
order by datetime limit 3
# using(animal_id)