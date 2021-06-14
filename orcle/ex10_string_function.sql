-- ex10_string_function.sql


/*
문자열 함수

upper(), lower(), intcap()
- varchar2 upper(컬럼명)
- varchar2 lower(컬럼명)
- varchar2 intcap(컬럼명)

*/

select
    first_name,
    upper(first_name),
    lower(first_name)
from employees;

select initcap('abc') from dual;

-- 이름에 'an'이 포함 검샘
select first_name from employees
    where first_name like'%AN%' or first_name like'%an%'
        or first_name like'%An%' or first_name like'%aN%';
        
select first_name from employees
where upper(first_name) like '%AN%';

/*
substr()
- 문자열 추출함수
- varchar2 substr(컬럼명, 시작위치, 가져올 문자 개수)
- varchar2 substr(컬럼명, 시작위치)
*/

select
    '가나다라마바사아자차카타파하',
    substr('가나다라마바사아자차카타파하', 5, 3),
    substr('가나다라마바사아자차카타파하', 5)
from dual;

--남자 직원
select * from tblinsa where ssn like '%-1%';
select * from tblinsa where substr(ssn, 8, 1) = '1';
select * from tblinsa where substr(ssn, 8, 1) = '2' or substr(ssn, 8, 1) = '3';
select * from tblinsa where substr(ssn, 8, 1) in ('2', '4');

select
    name, ssn,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) in('2', '4') then '여자'
    end as gender
from tblinsa;

select
    name, '19' || substr(ssn, 1, 2) as birthyear
from tblinsa;



--장급(부장, 과장) 들은 어떤 성을 가지고 있는지?
select
    distinct substr(name, 1, 1)
from tblinsa
    where jikwi in('부장', '과장')
    order by substr(name, 1, 1);
    
    
-- 직원 성? > 26가지

select
    distinct substr(name, 1, 1)
from tblinsa;

-- 각가의 성이 몇명인지?
select
    count(case
        when substr(name, 1, 1) = '김' then 1
    end) as "김",
    count(case
        when substr(name, 1, 1) = '이' then 1
    end) as "이",
    count(case
        when substr(name, 1, 1) = '박' then 1
    end) as "박",
    count(case
        when substr(name, 1, 1) = '정' then 1
    end) as "정",
    count(case
        when substr(name, 1, 1) = '최' then 1
    end) as "최",
    count(case
        when substr(name, 1, 1) in ('김', '이', '박', '정', '최') then 1
    end) as "기타"
from tblinsa;


-- 태어난 월별 순으로 정렬(ssn -> substr(ssn, 3, 2))
select
    *
from tblinsa
    order by substr(ssn, 3, 2) asc;
    
/*
length()
- 문자열 길이
- number length(컬럼명)
*/

-- 컬럼 리스트에서 사용
select name, LENGTH('name') from tblcountry;

-- 조건절에서 사용
select name from tblcountry where length(name) >3;
select name from tblcountry where length(name) between 4 and 6;
select name, capital from tblcountry where length(name) > length(capital);

--정렬에서 사용
select name, length(name) from tblcountry order by length(name) desc, name asc;

select
    case
        when length(title) >= 8 then substr(title, 1, 9) || '..'
        else title
    end
from tbltodo;

-- hr.employees
-- 1. 전체 이름(first_name + last_name : fullname)이 가장 긴->짧은 사람 순으로 가져오기
--      컬럼리스트 : first_name + last_name, length(fullename)
select first_name || last_name, length(first_name || last_name)
from hr.employees
    order by length(first_name || last_name) desc;



-- 2. 전체 이름(first_name + last_name : fullname)이 가장 긴 사람이 몇글자? 가장 짧은 사람이 몇글자?
--      컬럼리스트 : 숫자만 출력
select 
max(length(first_name || last_name)) as "긴 사람",
min(length(first_name || last_name)) as "짧은 사람"
from hr.employees;


-- 3. last_name이 4자인 사람들의 first_name이 궁금하다. 정렬 : first_name 길이 오름차순으로
select 
first_name
from hr.employees
    where length(last_name) = 4
    order by length(first_name) asc;
    
    
/*
instr()
- indexOf()
- 검색어의 위치를 반환
- one-based index(서수가 1부터 시작)
- number instr(컬럼명, 검색어)
- number instr(컬럼명, 검색어, 시작위치)
*/

select
    '안녕하세요. 홍길동님'as c1,
    instr('안녕하세요. 홍길동님', '홍길동') as c2,
    instr('안녕하세요. 홍길동님', '아무개') as c3,
    instr('안녕하세요. 홍길동님. 잘가세요, 홍길동님', '홍길동', 11) as c4,
    instr('안녕하세요. 홍길동님. 잘가세요, 홍길동님', '홍길동',  instr('안녕하세요. 홍길동님', '홍길동')) as c5
from dual;


-- 제목입니다. -> (*)제목입니다.
select
    case
        when instr(title, '자바') > 0 then '(*)' || title
        else title
    end as title
from tbltodo;


/*
lpad(), rpad(), left padding, right padding
- varchar 2 lpad(컬럼명, 개수, 문자)
- varchar2
*/

select
    '1',
    lpad('1',3,'0'),
    lpad('1',3,'@'),
    lpad('1',20,'=')
from dual;


/*
trum(), ltrim(), rtrim()
- varchar2 trim(컬럼명)
- varchar2 ltrim(컬럼명)
- varchar2 rtrim(컬렴명)
*/

select
    '    하나    둘    셋    ',
    trim('    하나    둘    셋    '),
    ltrim('    하나    둘    셋    '),
    rtrim('    하나    둘    셋    ')
from dual;


/*
replace
- 문자열 치환
- varchar2 replace(컬럼명, 찾을 문자열, 바꿀 문자열)
*/

select replace('홍길동', '홍', '김'), replace('홍길동', '이', '김') from dual;

--tblinsa. 직원명, 주민번호, 성별(남자, 여자)
select name, ssn, substr(ssn, 8, 1) from tblinsa;

select name, ssn, 
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end
from tblinsa;


select name, ssn, replace(replace(substr(ssn, 8, 1), '1', '남자'),'2', '여자')
from tblinsa;

select
    name,
    case
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        when continent = 'AU' then '오세아니아'
        when continent = 'SA' then '아메리카'
    end as continent,
    replace(replace(replace(replace(replace(continent, 'AS', '아시아'), 'EU', '유럽'), 'AF', '아프리카'),'AU', '오세아니아'),'SA','아메리카')
from tblcountry;


/*
decode()
- 문자열 치환
- replace()유사 + case end
- varchar2 decode(컬럼명, 찾을 문자열, 바꿀문자열, [ 찾을 문자열, 바꿀문자열, ] x N)
*/

select
    name,
    ssn,
    decode(substr(ssn, 8, 1), '1', '남자', '2', '여자'), --null로
     replace(replace(substr(ssn, 8, 1), '1', '남자'),'2', '여자') --원래 값으로
from tblinsa;



select
    name,
    continent,
    decode(continent, 'AS', '아시아', 'EU', '유럽', 'AF', '아프리카', 'AU' ,'호주', 'SA', '아메리카')
from tblcountry;


--**팁
-- DECODE를 유용하게 써먹는 경우

-- tblcomedian 남자 몇명? , 여자 몇명
select count(*) from tblcomedian where gender = 'm';
select count(*) from tblcomedian where gender = 'f';


select 
    count(case
        when gender ='m' then '남자'   
    end ) as "남자 인원수",
     count(case
        when gender ='f' then '여자'   
    end) as "여자 인원수"
from tblcomedian;


select
    count(decode(gender, 'm', 1)),
    count(decode(gender, 'f', 2))
from tblcomedian;


--tblinsa. 부장 몇명?, 과장 몇명? 대리 몇명?, 사원 몇명?
select
    count(decode(jikwi, '부장', 1)) as "부장",
    count(decode(jikwi, '과장', 1)) as "과장",
    count(decode(jikwi, '대리', 1)) as "대리",
    count(decode(jikwi, '사원', 1)) as "사원"
from tblinsa;

--tbladdressbook. job. 학생 몇명? 건물주 몇명?
select
    count(decode(job, '학생', 1)) as "학생 수",
    count(decode(job, '건물주', 1)) as "건물주 수"
from tbladdressbook;

-- tblAddressBook. address. 강동구 몇명? 마포구 몇명?
select
    count(case
        when instr(address, '강동구') > 0 then 1
    end) as "강동구",
    count(case
        when instr(address, '마포구') >0 then 1
    end) as "마포구"
from tbladdressbook;

select
    count(*) -count(decode(instr(address, '강동구'), 0 , 1))
from tbladdressbook;