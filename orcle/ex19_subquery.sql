-- ex19_subquery.sql

/*

메인쿼리, Main Query
- 하나의 select(insert, update, delete)로만 구성된 쿼리

서브쿼리, Sub Query
- 하나의 문장에 2대 이상의 select를 추가해서 구성된 쿼리
- 하나의 쿼리안에 또다른 쿼리가 들어있는 형태
- 삽입 위치:select절, from절, where절, order by절 등

- select + select x N
- insert + select x N
- update + select x N
- delete + select x N
*/

--tblcountry.인구수가 가장 많은 나라의 인구수는?
select max(population) from tblcountry;
select name from tblcountry where population = 120660;

select name from tblcountry where population = max(population);--ORA-00934: group function is not allowed here

select name from tblcountry where population = (select max(population) from tblcountry);


--tblinsa. 급여가 가장 많은 사람의 이름?
select max(basicpay) from tblinsa;
select name from tblinsa where basicpay = (select max(basicpay) from tblinsa);


--tblinsa. 평균 급여보다 많이 바든 직원들?
select avg(basicpay) from tblinsa;
select * from tblinsa where basicpay > (select avg(basicpay) from tblinsa);


--tblinsa '홍길동'과 같은 부서에 근무하는 사람들
select * from tblinsa where buseo = (select buseo from tblinsa where name = '홍길동') and name <> '홍길동';


--서브쿼리의 용도
-- 1. 조건절 비교값으로 사용
-- a. 반환값이 1행 1열 > 단일값, 값 1개 > 스칼라 쿼리(1행 1열) > 연산자 사용
-- b. 반환값이 N행 1열 > 다중값, 값 N개 > in 사용(열거형 비교)
-- c. 반환값이 1행 N열 > 복합값, 값 N개 > 연산자 사용(M:N)
-- d. 반환값이 N행 N열 > b + c > b와 c의 방식을 혼합해서 사용


-- 1.a
select
    *
from tblinsa
    where basicpay = (select max(basicpay) from tblinsa);
  
  
    
-- 1.b
-- 급여가 260만원 이상 받는 사람들이 근무하는 부서의 명단?
select
    *
from tblinsa
    where buseo in (select buseo from tblinsa where basicpay >= 2600000);
    
-- 기획부 대리와 같은 지역에 사는 사람들?
select * from tblinsa where city in(select city from tblinsa where buseo = '기획부' and jikwi = '대리');



-- 1.c
-- '홍길동'가 사는 지역과 같은 지역에 살고, 같은 직위를 가지는 직원"
select * from tblinsa where (city, jikwi) = (select city, jikwi from tblinsa where name ='홍길동');




--1.d
-- 급여를 260만원 이상 받는 직원의 부서와 사는곳이 동일한 직원들?
select buseo, city from tblinsa where basicpay >= 2600000;

select * from tblinsa
    where (buseo, city) in (select buseo, city from tblinsa where basicpay >= 2600000);




--서브쿼리의 용도
-- 1. 조건절 비교값으로 사용
--  a. 반환값이 1행 1열 > 단일값, 값 1개 > 스칼라 쿼리(1행 1열) > 연산자 사용
--  b. 반환값이 N행 1열 > 다중값, 값 N개 > in 사용(열거형 비교)
--  c. 반환값이 1행 N열 > 복합값, 값 N개 > 연산자 사용(M:N)
--  d. 반환값이 N행 N열 > b + c > b와 c의 방식을 혼합해서 사용

-- 2. 컬럼리스트에서 사용
--  a. 반환값이 1행 1열 > 스칼라 쿼리
--      1. 정적 쿼리 (모든 행에 동일한 값을 반환)
--      2. 상관 서브 쿼리 (서브 쿼리의 값과 바깥쪽 메인 쿼리의 값을 연계시켜 값을 반환) (*****)

select
    name,
    basicpay,
    avg(basicpay)
from tblinsa;


select
    name,
    basicpay,
    --(select 100 from dual),
    --100,
    (select round(avg(basicpay)) from tblinsa) as 평균급여
from tblinsa;


select
    name,
    buseo,
    (select round(avg(basicpay)) from tblinsa) as 평균급여,
    (select jikwi from tblinsa where name = '홍길동') --나머지 컬럼과 관게있는 서브쿼리만 사용
from tblinsa;


select * from tblMen;
select * from tblWomen;


-- 남자이름, 남자키, 여자이름, 여자키 -> 홍길동
select
    name as 남자이름,
    height as 남자키,
    couple as 여자이름,
    (select height from tblWomen where name = tblmen.couple) as 여자키
from tblMen
    --where name = '홍길동';
    where couple is not null; --커플
    
    
select * from employees; --직원
select * from departments; --부서

--직원의 이름과 부서명을 가져오시오.
select
    first_name || ' ' || last_name as name,
    --department_id,
    (select  department_name from departments where department_id = employees.department_id) as department
from employees;





--서브쿼리 문자
--10. tblAddressBook. 가장 많은 사람들이 가지고 있는 직업은 주로 어느 지역 태생(hometown)인가?
select 
    hometown, count(*)
from tbladdressbook
where job = 
(select job from tbladdressbook group by job having count(*) = (select max(count(job)) from tbladdressbook group by job))
    group by hometown
        order by count(*) desc;




--13. tblAddressBook. 이메일 도메인들 중 평균 아이디 길이가 가장 긴 이메일 사이트의 도메인은 무엇인가?
select 
    substr(email, instr(email, '@')) 
from tbladdressbook 
group by substr(email, instr(email, '@')) 
having avg(LENGTH(email)) = (select max(avg(LENGTH(email))) from tbladdressbook group by substr(email, instr(email, '@')));


--14. tblAddressBook. 평균 나이가 가장 많은 출신(hometown)들이 가지고 있는 직업 중 가장 많은 직업은?
select job
from tbladdressbook 
where hometown = (select hometown from tbladdressbook group by hometown having avg(age) = (select max(avg(age)) from tbladdressbook group by hometown))
group by job
having count(*) = (select max(count(*)) from tbladdressbook where hometown = (select hometown from tbladdressbook group by hometown having avg(age) = (select max(avg(age)) from tbladdressbook group by hometown)) group by job);


--16. tblAddressBook. 남자 평균 나이보다 나이가 많은 서울 태생 + 직업을 가지고 있는 사람들을 가져오시오.
select 
    * 
from tbladdressbook 
where age > (select avg(age) from tbladdressbook where gender = 'm') 
    and hometown = '서울' 
    and job not in( '백수' , '취업준비생');


--19. tblAddressBook. 가장 나이가 많으면서 가장 몸무게가 많이 나가는 사람과 같은 직업을 가지는 사람들을 가져오시오.
select 
    * 
from tbladdressbook
where job = (select job from tbladdressbook where age = (select max(age) from tbladdressbook) and weight = (select max(weight) from tbladdressbook));


--20. tblAddressBook. '건물주'와 '건물주자제분'들의 거주지가 서울과 지방의 비율이 어떻게 되느냐?
select 
    round(count(case
        when instr(address, '서울특별시') > 0 then '1'
    end) / count(*) * 100) as 서울,
    round(count(case
        when instr(address, '서울특별시') = 0 then '1'
    end)/ count(*) * 100) as 지방
from tblAddressBook where job in('건물주' ,'건물주자제분') ;


--21. tblAddressBook.  동명이인이 여러명 있습니다. 이 중 가장 인원수가 많은 동명이인(모든 이도윤)의 명단을 가져오시오.
select
    * 
from tbladdressbook
where name = (select name from tbladdressbook group by name having count(*) = (select max(count(name)) from tbladdressbook group by name));



--22. tblAddressBook. 가장 사람이 많은 직업의(332명) 세대별 비율을 구하시오.
--    [10대]       [20대]       [30대]       [40대]
--    8.7%        30.7%        28.3%        32.2%
select * from tblAddressBook;
select 
    substr(age, 1, 1)||'0대' as 세대,
    round(count(substr(age, 1, 1)) / (select max(count(*)) from tbladdressbook group by job) * 100, 1) as 비율
from tbladdressbook
where job = (select job from tbladdressbook group by job having count(*)= (select max(count(job)) from tbladdressbook group by job))
group by substr(age, 1, 1)
order by substr(age, 1, 1);


--38. employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select 
    first_name||' '||last_name as name, salary, department_id 
from employees
    where department_id in (select department_id from employees where salary >= 12000 );
    
    
--40. employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.
select * from employees
where department_id = (select department_id from employees where first_name = 'Jonathon');


--61. employees. 2001~2003년사이에 입사한 사원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id), 관리자 이름(fist_name)을 가져오시오.
--단, 관리자가 없는 사원정보도 결과에 포함시켜 가져오시오.
select * from employees;
select 
    first_name, hire_date, employee_id,
    (select first_name from employees e2 where e2.employee_id = e1.manager_id)
from employees e1
where to_char(hire_date, 'yy') in ('01', '02', '03');


--63. employees. last_name 에 'u' 가 포함되는 사원들과 동일 부서에 근무하는 사원들의 사번 및 last_name을 가져오시오.
select last_name, employee_id 
from employees 
where department_id in(select department_id from employees where instr(upper(last_name), 'U') > 0);

