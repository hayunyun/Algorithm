select o.animal_id, o.name from animal_ins i
right join animal_outs o
using(animal_id)
-- where i.datetime is null
where i.animal_id is null
order by animal_id