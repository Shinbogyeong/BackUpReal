-- ex08_aggregation_function.sql


/*

집계 함수, Aggrefation Function
1. count()
2. sum()
3. avg()
4. max()
5. min()


1. count()
- 결과셋의 레코드 갯수를 반환
- number count(컬럼명)
- null은 카운트에서 제외한다.(****)

*/

select name from tblcountry;
select count(name) from tblcountry; --14


select count(name) --3. 33
from tblinsa --1. 60
where city in ('서울', '경기'); --2.33


select area from tblcountry;
select count(area) from tblcountry;

select population from tblcountry;
select count(population) from tblcountry; --13

select name, name from tblcountry;
--ORA-00937: not a single-group group function
--컬럼 리스트에 집계 함수와 단일 컬럼은 동시에 사용할 수 없다.
select count(name), name from tblcountry;

select count(name) from tblcountry;
select name from tblcountry;


select count(name), count(area) from tblcountry;

-- 살짝 고민?
-- tblCountry의 나라 갯수?
select count(name) from tblcountry; --14
select count(capital) from tblcountry;
select count(area) from tblcountry;
select count(popoulation) from tblcountry; --null있음, 13

select count(*) from tblcountry; --14

select *from tblcountry;

select * from tbltodo;

-- 아직 안한 일의 갯수
select count(*) from tbltodo where completedate is null;

-- 한 일의 갯수
select count(*) from tbltodo where completedate is not null;

-- 안한 일의 갯수, 한 일의 갯수
select 
    count(*) as "전체 할일 갯수",
    count(completedate) as "한 일의 갯수",
    count(*) - count(completedate) as "아직 안한 일의 갯수"
from tbltodo;



select
    count(*) as "총 직원수", --60
    count(tel) as "연락처가 있는 직원수", --57
    count(*) - count(tel) as "연락처가 없는 직원수" --3
from tblinsa;



-- tblinsa -> buseo 컬럼 -> 어떤 부서들이 있나요?
-- tblinsa -> buseo 컬럼 -> 부서가 몇개인가요?
select count(distinct buseo) as "총 부서 수" from tblinsa;


-- tblcomedian 남자 몇명? , 여자 몇명
select count(*) from tblcomedian where gender = 'm';
select count(*) from tblcomedian where gender = 'f';

--전체 인원수, 남자 인원수, 여자 인원수 -> 결과 셋
-- count()+ case end + null존재
SELECT
    *
FROM tblcomedian;


select 
    count(*) as "전체 인원수",
    count(case
        when gender ='m' then '남자'   
    end ) as "남자 인원수",
     count(case
        when gender ='f' then '여자'   
    end) as "여자 인원수"
from tblcomedian;


select avg(basicpay) from tblinsa; --1556526

--ORA-00934: group function is not allowed here ****
--평균 급여보다 많이 맞는 직월들 명단을 가져오시오.
--where절은 집계함수를 사용할 수 없다. > where절은 개인에 대한 조건절(집합 정보를 가져올 수 없다.)
select * from tblinsa where basicpay > avg(basicpay); --27


-- tblCountry. 아시아(AS)와 유럽(EU)에 속한 나라의 개수?? -> 7개
-- 인구수가 7000 ~ 20000 사이인 나라의 개수?? -> 2개
select 
count(
    case
--    when continent ='AS'oR continent ='EU' then '나라'
    when continent in ('AS', 'EU') then '나라'-- 안됨
    end
) as "나라의 개수",
count(
    case
    when population between '7000' and '20000' then '나라'
    end
) as "나라의 개수"
from tblcountry;




-- hr.employees
-- job_id > 'IT_PROG' 중에서 급여가 5000불이 넘는 직원이 몇명? -> 2명
SELECT
    *
FROM hr.employees;
SELECT
    case
    when job_id = 'IT_PROG' then '급여'
    end
FROM hr.employees;


-- tblInsa
-- tel. 010을 안쓰는 사람은 몇명?(연락처가 없는 사람은 제외) -> 42명
-- city. 서울, 경기, 인천 -> 그 외의 지역 인원수? -> 18명
-- 80년대생 + 여자 직원 총 몇명? -> 9명





/*

2. sum()
- number sum(컬럼명)
- 해당 컬럼값들의 합을 구한다.
- 숫자형만 대상(문자형X, 날짜형 X)

*/

select weight from tblcomedian;
select sum(weight) from tblcomedian;

select som(first) from tblcomedian; --ORA-00904: "SOM": invalid identifier 문자형 안됨

select
    sum(basicpay), sum(sudang),
    sum(basicpay) + sum(sudang),
    sum(basicpay + sudang)
from tblinsa;


/*
3. avg()
- number avg(컬럼명)
- 해당 컬럼값들의 평균값을 반환한다.
- 숫자형만 가능하다.
- 해당 컬럼이 null을 가진 항목은 제외한다.
*/

select
    sum(basicpay),
    count(*),
    sum(basicpay) /count(*), --평균
    avg(basicpay)--평균
from tblinsa;

--평균 인구수? 14475, 15588
select
    sum(population) / count(*), --14로나눔
    sum(population) / count(population), --13로나눔!!이게 avg
    avg(population), --13로 나눔(null을 갖는 값은 빼버린다.)
    count(*), --14
    count(population) --13
from tblcountry;


-- 회사 성과급 지금
-- : 10명의 팀원 -> 7명 참여 프로젝트 수익 발생, 3명 관련없음
-- 1. 균등 지금 -> 수익 / 모든 팀원수 = sum() / count(*)
-- 2. 차등 지금 -> 수익 / 참여 팀원수 = sum() / count(참여팀원) = avg()


/*
4. max()
- object max(컬럼명) : 최댓값 반환
- 숫자형, 문자형, 날짜형

5. min()
- object min(컬럼명) : 최솟값 반환
- 숫자형, 문자형, 날짜형
*/

select max(basicpay), min(basicpay) from tblinsa;

select max(name), min(name) from tblinsa;

select max(ibsadate), min(ibsadate) from tblinsa;



-- 문제 풀어보기

--sum()
--1. 유럽과 아프리카에 속한 나라의 인구 수 합? tblCountry > 14,198
SELECT 
  SUM(population)
FROM tblCountry
    where continent in('EU', 'AF');
    
--2. 매니저(108)이 관리하고 있는 직원들의 급여 총합? hr.employees > 39,600
select sum(salary) from employees where manager_id = 108;

--3. 직업(ST_CLERK, SH_CLERK)을 가지는 직원들의 급여 합? hr.employees > 120,000
desc employees;
select sum(salary) from employees where job_id in('ST_CLERK', 'SH_CLERK');

--4. 서울에 있는 직원들의 급여 합(급여 + 수당)? tblInsa > 33,812,400
DESC TBLINSA;
SELECT SUM(BASICPAY + SUDANG) FROM TBLINSA WHERE city = '서울';

--5. 장급(부장+과장)들의 급여 합? tblInsa > 36,289,000
SELECT SUM(BASICPAY) FROM TBLINSA WHERE jikwi IN ('부장', '과장');

--
--avg()
--1. 아시아에 속한 국가의 평균 인구수? tblCountry > 39,165
SELECT * FROM TBLCOUNTRY;
SELECT POPULATION FROM TBLCOUNTRY WHERE CONTINENT = 'AS';

--2. 이름(first_name)에 'AN'이 포함된 직원들의 평균 급여?(대소문자 구분없이) hr.employees > 6,270.4
SELECT * FROM EMPLOYEES;
SELECT avg(SALARY) FROM EMPLOYEES WHERE FIRST_NAME LIKE '%AN%' or FIRST_NAME LIKE '%an%' or FIRST_NAME LIKE '%An%';
SELECT avg(SALARY) FROM EMPLOYEES WHERE upper(FIRST_NAME) LIKE '%AN%';

--3. 장급(부장+과장)의 평균 급여? tblInsa > 2,419,266.66
select avg(basicpay) from tblinsa where jikwi in ('부장', '과장');

--4. 사원급(대리+사원)의 평균 급여? tblInsa > 1,268,946.66
select avg(basicpay) from tblinsa where jikwi in ('대리', '사원');

--5. 장급(부장,과장)의 평균 급여와 사원급(대리,사원)의 평균 급여의 차액? tblInsa > 1,150,320
select
    avg(case
        when jikwi in ('부장', '과장') then basicpay
    end)
    - 
    avg(case
        when jikwi in('대리', '사원') then basicpay
    end)
from tblinsa;

--
--max(),min()
--1. 면적이 가장 넓은 나라의 면적은? tblCountry > 959
select *from tblcountry;
select max(area) from tblcountry;

--2. 급여(급여+수당)가 가장 적은 직원은 총 얼마를 받고 있는가? tblInsa > 988,000
select min(basicpay + sudang) from tblinsa;
