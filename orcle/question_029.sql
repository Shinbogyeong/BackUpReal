--question_029.sql

--001
select name, capital, population continent, area from tblcountry;

--002.
select name, capital from tblcountry;

--003.

 select name as "[국가명]", capital as "[수도명]",  population as "[인구수]", area as "[면적]", continent as "[대륙]" 
from tblcountry;

--004.
select '국가명 : ' || name ||','|| '수도명:' || capital ||','|| '인구수:' || population as "[국가정보]"
from tblCountry;

--005. 
select first_name ||''|| last_name as "[이름]", email || '@gmail.com' as "[이메일]", phone_number as "[이메일]", salary as "[급여]"
from employees;


--006.
select name, area from tblcountry where area <=100;

--007.
select name from tblcountry where continent in ('AS', 'EU');

--008.
select first_name||last_name, phone_number from employees where job_id = 'IT_PROG';

--009.
select first_name||last_name, phone_number, hire_date from employees where last_name = 'Grant';

--010.
select  first_name||last_name, salary, phone_number from employees where manager_id = 120;

--011
select * from employees;
select (first_name||' '||last_name) as name, phone_number, email, department_id from employees where department_id in (60, 80,100);

--012
select * from tblinsa where buseo = '기획부';

--013
select name, jikwi, tel from tblinsa where jikwi = '부장';

--014
desc tblinsa;
select * from tblinsa where (basicpay + sudang >=1500000) and city = '서울';

--015
select * from tblinsa where (sudang <= 150000) and jikwi in('사원', '대리');

--016
select * from tblinsa;
select * from tblinsa where (basicpay * 12) >= 20000000 and jikwi in ('과장', '부장') and city = '서울';

--017
select * from tblcountry;
select * from tblcountry where name like '_국';
select * from tblcountry where name like '%국'; --추가조건

--018
select * from employees where phone_number like '515%';

--019
select * from employees where job_id like 'SA%';

--020
select * from employees where first_name like '%de%' ;
select * from employees where first_name like '%de%' or  first_name like '%DE%' or first_name like '%De%';

--021
select * from tblinsa where ssn like '%-1%';

--022
select * from tblinsa where ssn like '%-2%';

--023
select * from tblinsa where ssn like '__07%' or ssn like '__08%' or ssn like '__09%';
select * from tblinsa where ssn like '__07%' or ssn like '__08%' or ssn like '__09%';

--024
select * from tblinsa where city in('인천','서울') and name like '김%';

--025
select * from tblinsa where  buseo in ('영업부', '총무부', '개발부') and jikwi in('사원', '대리') and tel like '010%';

--026
select * from tblinsa where city in('서울', '인천', '경기') and (ibsadate BETWEEN '2008-01-01' and '2009-12-31');

--027
select * from employees where department_id is null; 

--028
select DISTINCT job_id from employees;

--029
select department_id  from employees where hire_date BETWEEN '2002-01-01' and '2004-12-31';

--030
select * from employees;
select manager_id from employees where salary >= 5000;

--031
select  jikwi from tblinsa where ssn like'8%-1%';

--032
select distinct city from tblinsa where tel is null;

--033
select buseo, name from tblinsa where tel is null;