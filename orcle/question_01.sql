--question_01.sql

--1. traffic_accident. 각 교통 수단 별(지하철, 철도, 항공기, 선박, 자동차) 발생한 총 교통 사고 발생 수, 총 사망자 수, 사건 당 평균 사망자 수를 가져오시오.
select 
    trans_type,
    sum(total_acct_num) as 교통사고발생수,
    sum(death_person_num) as 총사망자수,
    avg(death_person_num) as 평균사망자수
from traffic_accident
    group by trans_type;

--2. tblZoo. 종류(family)별 평균 다리의 갯수를 가져오시오.
select
    family,
    round(avg(leg)) as 평균다리수
from tblzoo
    group by family;

--3. tblZoo. 체온이 변온인 종류 중 아가미 호흡과 폐 호흡을 하는 종들의 갯수를 가져오시오.
select
    breath,
    count(*)
from tblzoo
    where thermo = 'variable'
    group by breath;
    
select
    count(decode(breath, 'gill', '1')) as 아가미,
    count(decode(breath, 'lung', 1)) AS 폐
from tblzoo
where thermo  = 'variable';

--4. tblZoo. 사이즈와 종류별로 그룹을 나누고 각 그룹의 갯수를 가져오시오.
select
    family,
    sizeof,
    count(*)
from tblzoo
    group by sizeof, family
    order by family, sizeof;

--6. tblTodo. 완료한 일의 갯수와 완료하지 않은 일의 갯수를 가져오시오.
select 
    count(case
        when completedate is not null then 1
    end) as "완료한일의갯수",
    count(case
        when completedate is null then 1
    end) as "완료하지않은일의갯수"
from tbltodo;


--7. tblAddressBook. 서울에 사는 10대, 20대, 30대, 40대 인원수를 가져오시오.
select
    count(case
        when age like '1_' then 1
    end) as "10대",
    count(case
        when age like '2_' then 1
    end) as "20대",
    count(case
        when age like '3_' then 1
    end) as "30대",
    count(case
        when age like '4_' then 1
    end) as "40대"
from tbladdressbook
    where address like '%서울%';

--7. tblAddressBook. 서울에 사는(where) 10대, 20대, 30대, 40대(group by) 인원수(count)를 가져오시오.
select
    floor(age / 10) * 10 || '대' as 연령,
    count(*) as 인원수
from tbladdressbook
    where instr(address, '서울') = 1 
        group by floor(age / 10)
            order by floor(age / 10);


--8. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.
select *
from tbladdressbook
    where address like '%'||hometown||'%';

--9. tblAddressBook. 역삼로에 사는 사람 중 gmail을 사용하는 사람들을 가져오시오.
select *
from tbladdressbook
    where instr(address,'역삼로') > 0 and instr(email, '@gmail.com') > 0;

--11. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.
select
    *
from tbladdressbook
    where tel like '%123%' and gender = 'f';

--12. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.
--고민해보기
select
    email
from tbladdressbook
    group by email
        having count(*) >= 2;
    

--15. tblAddressBook. 성씨별 인원수가 100명 이상 되는 성씨들을 가져오시오.
select
    substr(name,1,1),
    count(*)
from tbladdressbook
    group by substr(name,1,1)
        having count(*) > 100;


--17. tblAddressBook. 이메일이 스네이크 명명법으로(where) 만들어진 사람들 중에서 
--여자이며(where), 20대이며(where), 키가 150~160cm 사이며(where), 고향이 서울 또는 인천인 사람들만(where) 가져오시오.
select
    *
from tbladdressbook
    where instr(email,'_') > 0 
        and gender = 'f'
        and floor(age/10) = 2
        and height between 150 and 160
        and hometown in('서울', '인천');

--18. tblAddressBook. gmail.com을 사용하는 사람들의 성별 > 세대별(10,20,30,40대) 인원수를 가져오시오.
select
    floor(age/10),
    gender
from tbladdressbook
    where instr(email, 'gmail.com') > 0
    group by floor(age/10), gender
        order by floor(age/10), gender;


--53. employees. 총 사원 수 및 2003, 2004, 2005, 2006 년도 별 고용된 사원들의 총 수를 가져오시오.
--고민해 보기
select
    to_char(hire_date, 'yy'),
    count(*)
from employees
    group by  rollup(to_char(hire_date, 'yy')) ;

--55. employees. 직업이 'AD_PRESS' 인 사람은 A 등급을, 'ST_MAN' 인 사람은 B 등급을, 
--'IT_PROG' 인 사람은 C 등급을, 'SA_REP' 인 사람은 D 등급을, 'ST_CLERK' 인 사람은 E 등급을 기타는 0 을 부여하여 가져오시오.
select
    first_name||' '||last_name,
    case
        when job_id = 'AD_PRES' then 'A'
        when job_id = 'ST_MAN' then 'B'
        when job_id = 'IT_PROG' then 'C'
        when job_id = 'ST_CLERK' then 'D'
        when job_id = 'ST_CLERK' then 'E'
        else '0' 
    end as 등급
from employees;

