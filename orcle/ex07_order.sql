-- ex07_order.sql


/*

정렬, sort
- order by절
- 레코드를 순서 정렬
- 원본 테이블의 레코드 정렬(XXX) - 오라클 데이터베이스에 있는 테이블내의 레코드 순서는 우리가 손댁 수 없다.(절대)
- 원본 테이블 -> select -> 결과 테이블(결과셋)의 정렬(****)
- 오름차순, 내림차순
- 특정 컬럼값을 기준으로 레코드를 정렬한다.(****)

SELECT 컬럼리스트
FROM 테이블
WHERE 조건
ORDER BY 정렬기준;

정렬의 기준이 될 수 있는 자료형(컬럼의 자료형)
1. 숫자형
    - 10 -> 20 -> 30
    - 30 -> 20 -> 10
2. 문자형
    - '가' -> '나' -> '다'
    - '다' -> '나' -> '가'
3. 날짜시간형
    - '2019' -> '2020' -> '2021'
    - '2021' -> '2020' -> '2019'




*/

select 
    last || first as name,
    weight
from tblcomedian
order by weight desc; --ascending, descending


select                         --3. 원하는 컬럼만 선별
    last || first as name,
    weight,
    gender
from tblcomedian               --1. 테이블 지정(전체 데이터)
where gender = 'm'             --2. 원하는 레코드만 선별
order by weight desc;          --4. 결과셋의 정렬


select 
    name, buseo, jikwi, city
from tblinsa
    order by name asc;

-- 다중정렬
select 
    name, buseo, jikwi, city
from tblinsa
    --order by buseo asc; --1차 정렬(기준 1개)
    --order by buseo asc, jikwi asc; --2차 정렬(기준 2개)
    --order by buseo asc, jikwi asc, city asc; --3차 정렬(기준 3개)
    order by 2 asc, 3 asc, 3 asc; --첨자로 컬럼을 지정 -> 사용금지~!


----- 고정된 컬럼을 정렬 기준으로 사용

----- 계산된 값을 정렬 기준으로 사용

select
    name, basicpay, sudang, basicpay + sudang as total
from tblinsa
order by basicpay + sudang desc;


select
    name, sudang, jikwi,
    case
        when jikwi in ('부장', '과장') then sudang * 2
        when jikwi in ('사원', '대리') then sudang * 1.5
    end as sudang2
from tblinsa
--order by sudang2 desc;
order by case
        when jikwi in ('부장', '과장') then sudang * 2
        when jikwi in ('사원', '대리') then sudang * 1.5
    end desc;


-- 팀(****0
-- 직위 정렬(부장, 과장, 대리, 사원)
select
    name, buseo, jikwi
--    case
--        when jikwi = '부장' then 1
--        when jikwi = '과장' then 2
--        when jikwi = '대리' then 3
--        when jikwi = '사원' then 4
--    end as no
from tblinsa
    order by case
        when jikwi = '부장' then 1
        when jikwi = '과장' then 2
        when jikwi = '대리' then 3
        when jikwi = '사원' then 4
    end asc;














