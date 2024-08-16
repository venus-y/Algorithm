-- 코드를 입력하세요
SELECT ai.animal_id , ai.animal_type, ai.name from 
animal_ins ai inner join animal_outs ao using(animal_id)
where ai.sex_upon_intake like '%intact%'
and ao.sex_upon_outcome regexp('neutered|spayed')
order by ai.animal_id