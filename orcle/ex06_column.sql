-- ex06_column.sql

/*

distinct
- 컬럼 리스트에 사용
- 중복값을 제거한다.
- distinct 컬럼명

*/

select * from tblCountry;

--tblCountry에는 어떤 대륙이 있나요?? -> 분류 질문
select continent from tblcountry;
select distinct continent from tblcountry;


select * from tblinsa;

--tblinsa. 어떤 부서가 있나요?
select buseo from tblinsa;
select distinct buseo from tblinsa;

-- 중복값이 단 1개도 없어도 동작된다. > 중복값이 없는 컬럼에 distinct를 적용하는건 의미가 없다.
select DISTINCT name from tblinsa; -- 중복값이 단 1개도 없어도 동작된다.

--개발부 황진이
--개발부 채정희
select buseo, name from tblinsa; --60명
select distinct buseo, name from tblinsa; --60명

select buseo, jikwi from tblinsa; --60명
select distinct buseo, jikwi from tblinsa; -- 23













/*

이틀 결론
1. 자료형 
    -number, varchar2, char, date
    
2. select
    a. from 절
    b. select 컬럼 리스트 -> 별칭(Alias), 연산자(산술)
    c. where 절 -> 연산자(산술, 비교, 논리), between, in like, is null
    
    
    
case
- 모든곳에서 사용이 가능
    - 컬럼리스트에서 사용
    - 조건절에서 사용
    - 정렬에서 사용
- 자바의 if/switch과 비슷한 행동
- 문장 단위의 제어(x)-> 값을 제어(o)
- 조건을 만족하지 못하는 컬럼은 null을 반환(***)
*/

select
    last || first as name,
    gender
from tblcomedian;

select
    last || first as name,
    case
        when gender = 'm' then '남자'
        when gender = 'f' then '여자'
    end as gender
from tblcomedian;


select * from tblcountry;

SELECT
    name,
    case
        when continent = 'AS' then '아시아'
        when continent = 'EU' then '유럽'
        when continent = 'AF' then '아프리카'
        --when continent = 'AU' then '오세아니아'
        --when continent = 'SA' then '남아메리카'
        --else '기타'
        --when continent = 'AU' then continent --조건의 반환값이 반드시 상수일 필요가 없다.
        --else continent
        --else capital -- 의미는 다른 항목들과 동일
        --else population --자료형이 다른 항목들과 동일
    end as continent
from tblcountry;



select
    last || first as name,
    weight,
    case
        when weight > 100 then '과체중'
        when weight > 50 then '정상체중'
        when weight > 0 then '저체중'
    end as state,
    case
        when weight between 50 and 100 then '정상체중'
        else '비정상 체중'
    end as state2
from tblcomedian;


select
    title,
    case
        when completedate is null then '완료'
        when completedate is not null then '미완료'
    end as state
from tblTodo;


select
    name,
    jikwi,
    case
        when jikwi in('과장', '부장') then '세단'
        when jikwi in('대리', '사원') then '경차'
    end as car
from tblinsa;


select
    name,
    buseo,
    jikwi,
    --3년 미만: 주니어
    --3년 ~ 7년 미만 : 시니어
    --7년 이상 : 익스퍼트
    case
        when ibsadate > '2018-05-14' then '주니어'
        when ibsadate <= '2018-05-14' and ibsadate > '2014-05-14'then '시니어'
        when ibsadate <= '2014-05-14' then '익스퍼트'
    end as state
from tblinsa;


select
    name,
    case
        when couple is null then '없음'
        when couple is not null then '있음'
    end as state
from tblMen;


--tblinsa. sudang
-- 결과셋: name, buseo, jikwi, sudang, 추가수당(계산)
-- 정책1: 직위별 수당 + a > 부장(x2) , 과장 (x1.7), 대리(x1.5), 사원(X1.3)
-- 정책2: 직위별 수당 + a > 부장,과장(x2), 대리,사원(x1.5)









