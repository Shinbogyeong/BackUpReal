-- ex18_groupby.sql

/*

[WITH <Sub Query>]
SELECT column_list
FROM table_name
[WHERE search_condition]
[GROUP BY group_by_expression]
[HAVING serach_condition]
[ORDER BY order_expression [ASC|DESC]

group by 절
- 레코드들을 특정 컬럼값(1개 or N개)에 맞춰서 그룹을 나누는 역할
- 그룹을 왜 나누는지?
    -> 각각의 나눠진 그룹 대상 > 집계 함수를 적용하기 위해서(****) -> count, sum, avg, max, min
- group by 컬럼명 [,컬럼명] X N


**문법
SELECT 컬럼리스트
FROM 테이블명
WHERE 조건
GROUP BY 그룹기준
ORDER BY 정렬

**** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) - 반드시 암기(이해
1. FROM절
2. WHERE절
3. GROUP BY절
3. SELECT절
4. ORDER BY절


group by를 사용한 select절에서 사용할 수 있는 표현
1. 집계함수
2. groip by 한 컬럼
*/


-- tblInsa. 부서별로 직원수가 몇명?

select count(*) from tblInsa; --총직원수

select distinct buseo from tblInsa; --부서

select count(*) from tblInsa where buseo = '총무부'; --7
select count(*) from tblInsa where buseo = '개발부'; --14
select count(*) from tblInsa where buseo = '영업부'; --16
select count(*) from tblInsa where buseo = '기획부'; --7
select count(*) from tblInsa where buseo = '인사부'; --4
select count(*) from tblInsa where buseo = '자재부'; --6
select count(*) from tblInsa where buseo = '홍보부'; --6

--group by 적용
select
    buseo as 부서명,
    count(*) as 부서인원수,
    round(avg(basicpay)) as 부서평균급여,
    round(sum(basicpay)) as 부서급여총액
from tblInsa 
    group by buseo;


--ORA-00979: not a GROUP BY expression

--직위
select
    jikwi, --집합 데이터(그룹 기준)
    --name,   --개인 데이터(개별 레코드 기준)
    count(*) --집합 데이터(그룹 기준)
from tblinsa
    group by jikwi; --


-- 남자 직원수? 여자 직원수? -> 성별 그룹
select
    substr(ssn, 8, 1),
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(*)
from tblinsa
    group by substr(ssn, 8, 1);
    
    
--tblcountry
select * from tblcountry;

select
    continent,
    count(*),
    max(population)
from tblcountry
    group by continent;
    

select
    name,
    count(*)
from tblcountry
    group by name;
    

select
    gender,
    round(avg(height), 1),
    round(avg(weight), 1)
from tblcomedian
    group by gender;



select
    job,
    count(*)
from tbladdressbook
    group by job
        --order by job asc;
        order by count(*) desc;
        
        
select
    --substr(address, 1, 5)
    --instr(address,' ')
    substr(address, 1, instr(address,' ') -1),
    count(*)
from tbladdressbook
    group by substr(address, 1, instr(address,' ') -1);



/*

having 절
- 조건절
- group by에 대한 조건절 > 집계 결과를 대상으로 조건을 질문

where 절
- 조건절
- from에 대한 조건 절 > 레코드 하나 하나를 대상 조건을 질문

**문법
SELECT 컬럼리스트
FROM 테이블명
WHERE 조건
GROUP BY 그룹기준
HAVING 조건
ORDER BY 정렬

**** select를 구성하는 모든 절들은 실행 순서가 있다. (불변) - 반드시 암기(이해
1. FROM절
2. WHERE절
3. GROUP BY절
4. HAVING절
5. SELECT절
6. ORDER BY절

A. FROM절 -> WHERE절 : 개인(레코드 1개씩) 에 대한 조건
B. GROUP BY절 -> HAVING절 : 그룹(집계 함수)에 대한 조건

*/


--BUSEO             COUNT(*)
----------------- ----------
--총무부                   7
--개발부                  14
--영업부                  16
--기획부                   7
--인사부                   4
--자재부                   6
--홍보부                   6


--BUSEO             COUNT(*)
----------------- ----------
--총무부                   3
--개발부                   4
--영업부                   5
--기획부                   2
--인사부                   2
--자재부                   2
--홍보부                   1


--BUSEO             COUNT(*)
----------------- ----------
--총무부                   7
--영업부                  16
--기획부                   7
--인사부                   4

select
    buseo,
    count(*)
from tblinsa
    where basicpay > 2000000
    group by buseo
        having avg(basicpay) > 1500000;

-- tblCountry. 대륙별로 최대 인구수, 최소 인구수, 평균 인구수 가져오시오.
select
    continent,
    max(population) as 최대인구수,
    min(population) as 최소인구수,
    avg(population) as 평균인구수
from tblcountry
    group by continent;
    

-- hr.employees. 직업별(job_id) 직원수를 가져오시오.
select
    job_id,
    count(*) as 직원수
from employees
    group by job_id;

-- tblinsa. 부서별로 직원들의 급여 총합, 부서인원수, 최고급여액, 최저급여액 가져오시오.
select
    buseo,
    count(*),
    max(basicpay),
    min(basicpay)
from tblinsa
    group by buseo;

-- tblAddressbook. 고향별(hometown) 인원수를 가져오시오. 정렬(인원수 내림차순)
select
    hometown,
    count(*)
from tbladdressbook
    group by hometown
    order by count(*) asc;

-- tblinsa. 부서별 직급의 인원수 가져오시오. group + decode
select
    buseo as 부서,
    count(*) as 인원,
    count(decode(jikwi, '부장', '1')) as 부장,
    count(decode(jikwi, '과장', '1')) as 과장,
    count(decode(jikwi, '대리', '1')) as 대리,
    count(decode(jikwi, '사원', '1')) as 사원
from tblinsa
    group by buseo;


select
    buseo,
    jikwi,
    count(*)
from tblinsa
    group by buseo, jikwi
        order by buseo, jikwi;

-- 부서별 남여 인원수?
select
    buseo,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as 성별
    ,
    count(*)
from tblinsa
    group by buseo, substr(ssn, 8, 1)
        order by buseo, substr(ssn, 8, 1);





/*

rollup()
- group by에서 사용
- group by의 결과에서 집계 결과를 더 자세하게 반환한다.

*/

select
    buseo,
    count(*),
    sum(basicpay),
    round(avg(basicpay))
from tblinsa
    group by rollup(buseo);
    
    

select
    buseo,
    jikwi,
    count(*),
    sum(basicpay),
    round(avg(basicpay)),
    grouping_id(buseo, jikwi) --0(일방행),1(소계행, 3(총계행)
from tblinsa
    group by rollup(buseo, jikwi);
    
    
    
select
    buseo,
    jikwi,
    count(*),
    sum(basicpay),
    round(avg(basicpay)),
    grouping_id(buseo, jikwi) 
from tblinsa
    where jikwi in ('부장','과장')
    group by cube(buseo, jikwi);