-- 코드를 입력하세요
SELECT AI.NAME, AI.DATETIME FROM ANIMAL_INS AI LEFT JOIN ANIMAL_OUTS AO
USING(ANIMAL_ID)
WHERE AO.DATETIME IS NULL
ORDER BY AI.DATETIME ASC
LIMIT 3