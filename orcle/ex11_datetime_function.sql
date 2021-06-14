-- ex11_datetime_function.sql


/*

날짜시간 함수

sysdate
- 형재 시스템의 시각을 반환
- date sysdate
- 자바의 Calendar.getInstance(), new Date()


*/



select sysdate from dual;

/*

날짜 연산
- +연산, -연산
1. 시각 - 시각 = 시간(단위:일)
2. 시각 + 시간 = 시각
3. 시각 - 시간 = 시각

*/

-- 홍길동	08/10/11	21/05/17	4601
-- 시각 - 시각
select
    name, 
    ibsadate as 입사일,
    sysdate as 현재,
    round(sysdate - ibsadate) as "근무기간(일)",
    round((sysdate - ibsadate) * 24) as "근무기간(시)",
    round(((sysdate - ibsadate) * 24) * 60) as "근무기간(분)",
    round((((sysdate - ibsadate) * 24) * 60) * 60) as "근무기간(초)",
    round((sysdate - ibsadate) / 365) as "근무기간(년)" -- 근사치
    
from tblinsa;


-- 시각 + 시간(단위:일) = 시각
-- 시각 - 시간(단위:일) = 시각
select 
    sysdate ,
    sysdate + 100,
    sysdate - 100,
    sysdate + (2 /24)--2시간 뒤?
from dual;

/*
last_day()
- 해당 시각이 포함된 달의 마지막 날짜
- date last_day(date)
*/

SELECT
    sysdate, --21/05/17
    last_day(sysdate) --21/05/31
FROM dual;

/*
monthes_between()
- 시각 - 시각 = 시간(단위:일)
- 시각 - 시각 = 시간(단위:월) **
- number months_between(date, date)

*/



SELECT
    name,
    ibsadate as "입사일",
    sysdate - ibsadate as "근무시간(일)",
    (sysdate - ibsadate) / 30.4 as "근무시간(개월)",--한달이 며칠인줄 알고?
    months_between(sysdate, ibsadate) as "근무시간(개월)", --******
    (sysdate - ibsadate) / 365 as "근무시간(년)", --XX
    months_between(sysdate, ibsadate) / 12 as "근무시간(년)" --***
FROM tblinsa;






/*
add_months()
- number add_months(sate, number)

*/

select
    sysdate,
    sysdate + 31, --X
    add_months(sysdate, 1), --O
    sysdate + 100,
    add_months(sysdate, 12) --첫돌
from dual;



/*
- 시각 - 시각 = 일(시,분,초)
- 시각 - 시각 = 월(년) -> months_between **

시각 + 시간(일) = 시각
시각 - 시간(일) = 시각
시각 + 시간(월) = 시각 -> add_months()
시각 - 시간(월) = 시각 -> add_months()
*/


-- 컬럼리스트에서 사용
-- 조건절에서 사용
SELECT
    name,
    ibsadate,
    ceil(months_between(sysdate, ibsadate) /12) as "근무년차"
FROM tblinsa
    where months_between(sysdate, ibsadate) < (12 * 10) ;
