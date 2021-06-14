\/*조인, 로우넘 문제*/

--65, 67, 68, 69

-- 로우넘

--1. tblInsa. 남자 급여(기본급+수당)을 (내림차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select name, buseo, pay, rownum from (select 
    name,
    buseo,
    basicpay + sudang as pay
from tblinsa
    where substr(ssn, 8, 1) = '1'
        order by basicpay + sudang desc);

--2. tblInsa. 여자 급여(기본급+수당)을 (오름차순)순위대로 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select name, buseo, pay, rownum from (select 
    name,
    buseo,
    basicpay + sudang as pay
from tblinsa
    where substr(ssn, 8, 1) = '2'
        order by basicpay + sudang asc);

--3. tblInsa. 여자 인원수가 가장 많은 부서 및 인원수 가져오시오.
select buseo, cnt, rownum from (
select
    buseo,
    count(buseo) as cnt
from tblinsa 
     where substr(ssn, 8, 1) = '2'
        group by buseo
            order by count(buseo) desc)   
    where rownum = '1';

--4. tblInsa. 지역별 인원수 (내림차순)순위를 가져오시오.(city, 인원수)
select city, cnt, rownum as 순위 from(
select 
    city,
    count(city) as cnt
from tblinsa
    group by city
        order by count(city) desc);

--5. tblInsa. 부서별 인원수가 가장 많은 부서 및 인원수 출력.
select buseo, cnt, rownum from(select buseo, count(buseo) as cnt from tblinsa group by buseo order by count(buseo) desc)
    where rownum = '1';

--6. tblInsa. 남자 급여(기본급+수당)을 (내림차순) 3~5등까지 가져오시오. (이름, 부서, 직위, 급여, 순위 출력)
select name, pay, rnum from(select name, pay, rownum as rnum from (select name, basicpay + sudang as pay from tblinsa where substr(ssn, 8, 1) = '1' order by basicpay + sudang desc))
    where rnum between 3 and 5;

--7. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.
select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)
    where rownum <= '5';

--8. tblhousekeeping. 지출 내역(가격 * 수량) 중 가장 많은 금액을 지출한 내역 3가지를 가져오시오.
select item, expense, rownum from(select item, price * qty as expense from tblhousekeeping order by price * qty desc)
    where rownum <= 3;

--9. tblinsa. 평균 급여 2위인 부서에 속한 직원들을 가져오시오.   
select * from tblinsa where buseo = (select buseo from(select buseo, cnt, rownum rnum from (select buseo, avg(basicpay + sudang) as cnt from tblinsa group by buseo order by avg(basicpay + sudang) desc))
    where rnum = 2);

--10. tbltodo. 등록 후 가장 빠르게 완료한 할일을 순서대로 5개 가져오시오.
select title, completedate, rownum from
    (select title, completedate from tbltodo where completedate is not null order by completedate asc)
where rownum <= '5'   ;


--32. tblInsa. 남자 직원 중에서 급여를 3번째로 많이 받는 직원과 9번째로 많이 받는 직원의 급여 차액은 얼마?
select (select pay from(select name, pay, rownum as rnum from (select name, basicpay + sudang as pay from tblinsa where substr(ssn, 8, 1) = '1' order by basicpay + sudang desc))
    where rnum = 3) - (select pay from(select name, pay, rownum as rnum from (select name, basicpay + sudang as pay from tblinsa where substr(ssn, 8, 1) = '1' order by basicpay + sudang desc))
    where rnum = 9) as 차액 from dual;

--70. employees, departments. 커미션(commission_pct)을 가장 많이 받은 상위 4명의 
--부서명(department_name), 사원명 (first_name), 급여(salary), 커미션(commission_pct) 정보를 가져오시오. 
--결과는 커미션 을 많이 받는 순서로 가져오되 동일한 커미션에 대해서는 급여가 높은 사원을 먼저 정렬하시오.
select depname, fname, salary, pct, rownum from 
(select 
    e.first_name as fname, 
    e.salary as salary,
    e.commission_pct as pct,
    d.department_name as depname
from employees e
    inner join departments d
        on e.department_id = d.department_id
            order by e.commission_pct)
where rownum <= 4;


-- 조인
select * from employees;
select * from departments;
select * from jobs;

-- 33. employees, departments. 사원들의 이름, 부서번호, 부서명을 가져오시오.
select 
    e.first_name||' '||e.last_name as 사원명, 
    e.department_id as 부서번호,
    d.department_name as 부서명
from employees e
    inner join departments d
        on e.department_id = d.department_id;

-- 34. employees, jobs. 사원들의 정보와 직업명을 가져오시오.
select
    e.*,
    j.job_title
from employees e
    inner join jobs j
        on e.job_id = j.job_id;
    

-- 35. employees, jobs. 직무(job_id)별 최고급여(max_salary) 받는 사원 정보를 가져오시오.
select
    *
from employees e
    inner join jobs j
        on e.salary = j.max_salary and e.job_id = j.job_id;

-- 36. departments, locations. 모든 부서와 각 부서가 위치하고 있는 도시의 이름을 가져오시오.
select
    d.department_name,
    l.city
from departments d
    left outer join locations l
--    inner join locations l
        on d.location_id = l.location_id;

-- 37. locations, countries. location_id 가 2900인 도시가 속한 국가 이름을 가져오시오.
select * from countries;
select * from locations;

select
    c.country_name
from countries c
    inner join locations l
        on c.country_id = l.country_id
            where l.location_id = '2900';
            
select
    c.country_name
from countries c
    inner join locations l
        on c.country_id = l.country_id
            and l.location_id = '2900';

-- 38. employees. 급여를 12000 이상 받는 사원과 같은 부서에서 근무하는 사원들의 이름, 급여, 부서번호를 가져오시오.
select * from employees where department_id in(
select
    department_id
from employees
    where salary >= 12000
    group by department_id);

-- 39. employees, departments. locations.  'Seattle'에서(LOC) 근무하는 사원의 이름, 직위, 부서번호, 부서이름을 가져오시오.
select 
    e.first_name || ' '|| e.last_name,
    e.job_id,
    d.department_id,
    d.department_name
from employees e
    inner join departments d
        on e.department_id = d.department_id
            inner join locations l
                on l.location_id = d.location_id
                    where l.city = 'Seattle';

-- 40. employees, departments. first_name이 'Jonathon'인 직원과 같은 부서에 근무하는 직원들 정보를 가져오시오.
select * from employees where department_id = 
(select
    d.department_id
from employees e
    inner join departments d
    on e.department_id = d.department_id
    where e.first_name = 'Jonathon');


-- 41. employees, departments. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을 출력하는데 월급이 3000이상인 사원을 가져오시오.
select
    e.first_name||' '||e.last_name,
    d.department_name,
    e.salary
from employees e
    inner join departments d
    on e.department_id = d.department_id
        where e.salary >=3000;


-- 42. employees, departments. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름, 월급을 가져오시오.
select
    e.department_id,
    d.department_name,
    e.first_name||' '||e.last_name,
    e.salary
from employees e
    inner join departments d
    on e.department_id = d.department_id
        where e.department_id = 10;
        
-- 43. employees, departments. 모든 부서의 정보를 가져오되 부서장이 있는 부서는 부서장의 정보도 같이 가져오시오.
select 
    *  
from departments d
    left outer join employees e
    on e.employee_id = d.manager_id;

-- 44. departments, job_history. 퇴사한 사원의 입사일, 퇴사일, 근무했던 부서 이름을 가져오시오.
select 
    h.start_date,
    h.end_date,
    d.department_name
from job_history h
    inner join departments d
    on h.department_id = d.department_id;

-- 45. employees. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 
--각각의 컬럼명을 '사원번호', '사원이름', '관리자번호', '관리자이름'으로 하여 가져오시오.
select
    e1.employee_id as 사원번호,
    e1.first_name||' '||last_name as 사원이름,
    e1.manager_id as "관리자 번호",
    (select e2.first_name||' '||e2.last_name from employees e2 where e1.manager_id = e2.employee_id) as "관리자 이름"
from employees e1;

-- 46. employees, jobs. 직책(Job Title)이 Sales Manager인 사원들의 입사년도와 입사년도(hire_date)별 평균 급여를 가져오시오. 
--년도를 기준으로 오름차순 정렬.
select * from employees;
select * from jobs;

select 
    to_char(e.hire_date, 'yy')||'년' as 입사년도,
    avg(salary) as 평균급여
from employees e
inner join jobs j
on e.job_id = j.job_id
    where j.job_title = 'Sales Manager'
        group by to_char(e.hire_date, 'yy');


-- 47. employees, departments. locations. 
--각 도시(city)에 있는 모든 부서 사원들의 평균급여가 가장 낮은 도시부터 도시명(city)과 평균연봉, 해당 도시의 사원수를 가져오시오. 
--단, 도시에 근 무하는 사원이 10명 이상인 곳은 제외하고 가져오시오.
select
    l.city,
    avg(e.salary),
    count(*)
from employees e
    inner join departments d
    on e.department_id = d.department_id
        inner join locations l
        on l.location_id = d.location_id
                group by l.city
                having count(l.city) < 10
                    order by avg(e.salary);
                


        

-- 48. employees, jobs, job_history. ‘Public  Accountant’의 직책(job_title)으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 가져오시오. 
--현재 ‘Public Accountant’의 직책(job_title)으로 근무하는 사원은 고려 하지 말것
select 
    h.employee_id,
    e.first_name||' '||e.last_name
from job_history h
inner join jobs j
on j.job_id = h.job_id
    inner join employees e
    on e.employee_id = h.employee_id
        where j.job_title ='Public Accountant' ;
        
        
-- 49. employees, departments, locations. 커미션을 받는 모든 사람들의 first_name, last_name, 부서명, 지역 id, 도시명을 가져오시오.
select
    e.first_name||' '||e.last_name,
    d.department_name,
    l.location_id,
    l.city
from employees e
    inner join departments d
    on e.department_id = d.department_id
        inner join locations l
        on l.location_id = d.location_id
            where e.commission_pct is not null;
            
            
-- 50. employees. 자신의 매니저보다 먼저 고용된 사원들의 first_name, last_name, 고용일을 가져오시오.
select
    e1.first_name||' '||e1.last_name as 이름,
    e1.hire_date as 고용일
from employees e1
    inner join employees e2
    on e1.manager_id = e2.employee_id
        where e1.hire_date < e2.hire_date;


-- 51. employees. 매니저로 근무하는 사원이 총 몇명인가?
select count(*) from employees where employee_id in(select manager_id from employees group by manager_id having manager_id is not null);


-- 52. employees. 자신의 매니저보다 연봉(salary)를 많이 받는 사원들의 성(last_name)과 연봉(salary)를 가져오시오.
select 
    e1.first_name||' '||e1.last_name,
    e1.salary
from employees e1
    inner join employees e2
    on e1.manager_id = e2.employee_id
        where e1.salary >= e2.salary;


-- 53. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.
--사원 총 수??
select to_char(hire_date, 'yyyy') as 년도, count(to_char(hire_date, 'yyyy')) as "사원 수" 
from employees group by to_char(hire_date, 'yyyy') having to_char(hire_date, 'yyyy') between 2003 and 2006
order by to_char(hire_date, 'yyyy');

-- 54. employees, departments. 
-- 2007년에 입사(hire_date)한 사원들의 사번(employee_id), 이름(first_name), 성(last_name), 부서명(department_name)을 가져오시오. 
-- 단, 부서에 배치되지 않은 사원은 'Not Assigned'로 가져오시오.
select
    e.employee_id, 
    e.first_name,
    e.last_name,
    case
        when d.department_name is not null then d.department_name
        when d.department_name is null then 'Not Assigned'
    end as "부서명"
from employees e
    left outer join departments d
    on e.department_id = d.department_id
        where to_char(hire_date, 'yy') = 07;
        
        
-- 55. employees. 직업이 'AD_PRESS' 인 사람은 A 등급을, 'ST_MAN' 인 사람은 B 등급을, 'IT_PROG' 인 사람은 C 등급을, 
-- 'SA_REP' 인 사람은 D 등급을, 'ST_CLERK' 인 사람은 E 등급을 기타는 0 을 부여하여 가져오시오.
select 
    case
        when job_id = 'AD_PRES' then 'A'
        when job_id = 'ST_MAN' then 'B'
        when job_id = 'IT_PROG' then 'C'
        when job_id = 'SA_REP' then 'D'
        when job_id = 'ST_CLERK' then 'E'
        else '0'
    end as 등급,
    e.*
from employees e;

-- 56. employees, jobs. 업무명(job_title)이 ‘Sales Representative’인 사원 중에서 
--연봉(salary)이 9,000이상, 10,000 이하인 사원들의 이름(first_name), 성(last_name)과 연봉(salary)를 가져오시오.
select
    e.first_name,
    e.last_name,
    e.salary
from employees e
    inner join jobs j
    on j.job_id = e.job_id
        where (j.job_title = 'Sales Representative') and (e.salary between 9000 and 10000);


-- 57. employees, departments. 부서별로 가장 적은 급여를 받고 있는 사원의 이름, 부서이름, 급여를 가져오시오.
--이름은 last_name만 가져오고, 부서이름으로 오름차순 정렬하고, 부서가 같은 경우 이름을 기준 으로 오름차순 정렬하여 가져오시오. 
select 
    d.department_name,
    e.last_name,
    e.salary
from employees e
    left outer join departments d
    on d.department_id = e.department_id 
    where (e.department_id, e.salary) in
        (select department_id, min(salary) from employees group by department_id)
    order by d.department_name asc;


-- 58. employees, departments, locations. 
--사원의 부서가 속한 도시(city)가 ‘Seattle’인 사원의 이름, 해당 사원의 매니저 이름, 사원 의 부서이름을 가져오시오. 
--이때 사원의 매니저가 없을 경우 ‘없음’이라고 가져오시오. 이름은 last_name만 가져오고, 사원의 이름을 오름차순으로 정렬하시오.
select * from employees;
select * from departments;
select * from locations;
select 
    e.last_name as 사원명,
    (case
    when e1.last_name is not null then e.last_name
    when e1.last_name is null then '없음'
    end) as 매니저명,
    d.department_name
from employees e
    left outer join employees e1
    on e.manager_id = e1.employee_id
        inner join departments d
        on d.department_id = e.department_id
            inner join locations l
            on l.location_id = d.location_id
                where l.city = 'Seattle'
                    order by e.last_name asc;


-- 59. employees, jobs. 각 업무(job) 별로 연봉(salary)의 총합을 구하고자 한다.
--연봉 총합이 가장 높은 업무부터 업무명(job_title)과 연봉 총합을 가져오시오. 단 연봉총합이 30,000보다 큰 업무만 가져오시오.
select * from employees;
select * from jobs;
select 
    j.job_title,
    sum(salary)
from employees e
    inner join jobs j
    on j.job_id = e.job_id
        group by j.job_title
        having sum(salary) >= 30000
            order by sum(salary) desc;

-- 60. employees, departments, locations, jobs. 
--각 사원(employee)에 대해서 사번(employee_id), 이름(first_name), 업무명(job_title), 부서 명(department_name)을 가져오시오.
--단 도시명(city)이 ‘Seattle’인 지역(location)의 부서 (department)에 근무하는 사원을 사원번호 오름차순으로 가져오시오.
select
    e.employee_id,
    e.first_name,
    j.job_title,
    d.department_name
from employees e
    inner join departments d
    on e.department_id = d.department_id
        inner join locations l
        on l.location_id = d.location_id
            inner join jobs j
            on j.job_id = e.job_id
                where l.city = 'Seattle'
                order by e.employee_id;

-- 61. employees. 2001~20003년사이에 입사한 사원의 이름(first_name), 입사일(hire_date), 관리자사번 (employee_id), 관리자 이름(fist_name)을 가져오시오.
-- 단, 관리자가 없는 사원정보도 결과에 포함시켜 가져오시오.
select
    e1.first_name,
    e1.hire_date,
    e1.employee_id,
    e2.first_name as 관리자이름
from employees e1
    inner join employees e2
    on e1.manager_id = e2.employee_id
        where to_char(e1.hire_date, 'yy') in(01, 02, 03);

-- 62. employees, departments. ‘Sales’ 부서에 속한 사원의 이름(first_name), 급여(salary), 부서이름(department_name)을 가져오시오. 
--단, 급여는 100번 부서의 평균보다 적게 받는 사원 정보만 가져오시오.
select
    e.first_name,
    e.salary,
    d.department_name
from employees e
    inner join departments d
    on d.department_id = e.department_id
        where d.department_name = 'Sales' and salary <= (select avg(salary) from employees where department_id = 100);


-- 63. employees. last_name 에 'u' 가 포함되는 사원들과 동일 부서에 근무하는 사원들의 사번 및 last_name을 가져오시오
select
    employee_id, last_name
from employees
    where department_id in(select department_id from employees where instr(upper(last_name), 'U') > 0);


-- 64. employees, departments. 부서별 사원들의 최대, 최소, 평균급여를 조회하되, 
--평균급여가 ‘IT’ 부서의 평균급여보다 많고, ‘Sales’ 부서의 평균보다 적은 부서 정보만 가져오시오. 
select * from employees;
select * from departments;
select
    d.department_name,
    count(*),
    min(e.salary),
    max(e.salary),
    round(avg(e.salary),1)
from employees e
    inner join departments d
    on d.department_id = e.department_id
        group by d.department_name
        having avg(salary) between 
            (select avg(e.salary) from employees e inner join departments d on e.department_id = d.department_id where d.department_name ='IT') 
            and 
            (select avg(e.salary) from employees e inner join departments d on e.department_id = d.department_id where d.department_name ='Sales');
            
select * from employees;
select * from departments;

-- 65. employees, departments. 각 부서별로 사원이 한명만 있는 부서만 가져오시오. 
--단, 사원이 없는 부서에 대해서는 ‘신생부서’라는 문자열을 가져오고,  결과는 부서명이 내림차순으로 정렬되게 하시오.
-- 사원이없는 부서를 어떻게 뽑을까

select
    case
        when count(e.department_id) = 1 then d.department_name
        when count(e.department_id) = 0 then d.department_name || '신생부서'
    end as 부서명,
    count(e.department_id) as 인원
from employees e
    right outer join departments d
    on d.department_id = e.department_id
        group by d.department_name 
        having count(e.employee_id)=1 or count(e.employee_id)=0;



-- 66. employees, departments. 부서별 입사월별 사원수를 가져오시오. 
--단, 사원수가 5명 이상인 부서만 가져오고,  결과는 부서이름 순으로 하시오.
select
    d.department_name,
    to_char(e.hire_date, 'mm')as 월,
    count(e.employee_id) as 사원수
from employees e
    inner join departments d
    on d.department_id = e.department_id
        where e.department_id in (select department_id from employees group by department_id having count(*) >= 5)
        group by d.department_name, to_char(e.hire_date, 'mm')
            order by d.department_name asc;


-- 67. employees, departments, locations, countries. 국가(country_name) 별 도시(city)별 사원수를 가져오시오.  
--부서정보가 없는 사원은 국가명과 도시명 대신에 ‘부서없음’을 넣어서 가져오시오.
select
    case
        when c.country_name is null then '부서없음'
        else c.country_name
    end as "국가명",
    case
        when l.city is null then '부서없음'
        else l.city
    end as "도시명",
    count(e.employee_id)
from employees e
    left outer join departments d
    on d.department_id = e.department_id
        left outer join locations l
        on l.location_id = d.location_id
            left outer join countries c
            on c.country_id = l.country_id
                group by c.country_name, l.city;
                

                
-- 68. employees, departments. 각 부서별 최대 급여자의 아이디(employee_id), 이름(first_name), 급여(salary)를 가져오시오.
select * from employees;
select * from departments;
select
    department_id,
    max(salary)
from employees 
        group by department_id;


-- 69. employees. 커미션(commission_pct)별 사원수를 가져오시오. 커미션은 0.2, 0.25는 모두 0.2로, 0.3, 0.35는 0.3 형태로 바꾸시오. 
--단, 커미션 정보가 없는 사원들도 있는 데 커미션이 없는 사원 그룹은 ‘커미션 없음’으로 바꿔 가져오시오.
-- 커미셩 없음 어떻게 하지
select * from employees;
select
    case
        when trunc(commission_pct,1) is not null then trunc(commission_pct,1)
        when trunc(commission_pct,1) is null then 0
    end as 커미션,
    count(employee_id)
from employees
    group by trunc(commission_pct, 1);
    
select 
case
    
    when '0'||substr(commission_pct,1,2) ='0' then '커미션 없음'
    else '0'||substr(commission_pct,1,2)
end,
count(*) 
from hr.employees
group by substr(commission_pct,1,2);
