-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.NAME FROM ANIMAL_INS AI JOIN ANIMAL_OUTS AO USING(ANIMAL_ID)
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME ASC