-- ex12_casting_function.sql

/*
형변환 함수
1. to_char()    : 숫자 -> 문자
2. to_char()    : 날짜 -> 문자 ****
3. to_number()  : 문자 -> 문자
4. to_date()    : 문자 -> 날짜 ****


1. to_char()
- char to_char(숫자컬럼명, 형식문자열)

형식문자열 구성요소
a. 9 : 숫자 1개를 문자 1개로 바꾸는 역할(빈자리는 공백으로 치환한다.) + 부호 자리 추가
b. 0 : 숫자 1개를 문자 1개로 바꾸는 역할(빈자리는 0으로 치환한다.) + 부호자리 추가
c. $ : 통화 기호 표시
d. L : 통화 기호 표시(Local)
e. . : 소숫점 표시
f. , : 자릿수 표시(천 단위)

*/

select
    '@' || 100 || '@', -- number
    '@' || to_char(100) || '@', -- char
    '@' || to_char(100, '99999') || '@', --char, 5자리 문자열로 바꾸기
    '@' || ltrim(to_char(100, '99999')) || '@', --char, 5자리 문자열로 바꾸기 + 공백제거
    '@' || to_char(100, '00000') || '@', --char, 5자리 문자열로 바꾸기
    '@' || ltrim(to_char(100, '00000')) || '@' --char, 5자리 문자열로 바꾸기 + 공백제거
from dual;


select
    100,
    to_char(100, '$999'),
    to_char(100, 'L999'),
    '$' || 100
from dual;


select
    123.456,
    to_char(123.456),
    to_char(123.456, '999.999'),
    to_char(123.456, '999.99'),
    to_char(123.456, '999.9'), --round()유사 숫자 얘는 문자열 
    1000000,
    to_char(1000000, '9,999,999')
from dual;



/*
2. to_char()
-- ************
-- 날짜 -> 문자
-- char to_char(날짜컬렴명, '형식문자열')

형식 문자열 구성 요소
a. yyyy
b. yy
c. month
d. mon
e. mm
f. day
g. dy
h. ddd
i. dd
j. d
k. hh(hh12)
l. hh24
m. mi
n. ss
o. am(pm)
p. -, :
*/


select
    sysdate,
    to_char(sysdate, 'yyyy'),   --2021, 년(4자리) *****
    to_char(sysdate, 'yy')   ,  --21, 년(2자리)
    to_char(sysdate, 'month'),  --5월, 월(풀네임)
    to_char(sysdate, 'mon'),    --5월, 월(약어)
    to_char(sysdate, 'mm'),     --05, 월(2자리 숫자) *****
    to_char(sysdate, 'day'),    --월요일, 요일(풀네임) ***
    to_char(sysdate, 'dy'),     --월, 요일(약어) ***
    to_char(sysdate, 'ddd'),    --137, 날짜(올해..)
    to_char(sysdate, 'dd'),     --17, 날짜(이번달..)
    to_char(sysdate, 'd'),      --2, 날짜(이번주..) -> 요일(일1~ 토7) ***
    to_char(sysdate, 'hh'),     --10, 시(12h)
    to_char(sysdate, 'hh24'),   --10, 시(24h) *****
    to_char(sysdate, 'mi'),     --43, 분 *****
    to_char(sysdate, 'ss'),     --41, 초 *****
    to_char(sysdate, 'am')      --오전
from dual;


--컬럼리스트에서 사용
select
    name,
    to_char(ibsadate, 'yyyy-mm-dd'),--******
    --to_char(ibsadate, 'yyyy년mm월dd일'),
    to_char(ibsadate, 'yyyy') || '년'|| to_char(ibsadate, 'mm') || '월' || to_char(ibsadate, 'dd') || '일' as b,
    to_char(ibsadate, 'hh24:mi:ss')as 시분초,--******
    to_char(ibsadate, 'yyyy-mm-dd hh24:mi:ss')as 년월일시분초--******
from tblinsa;


-- 조건절에서 사용
-- 2010년에 입사한 사람들?

select
    name,
    ibsadate
from tblinsa
    --where ibsadate >= '2010-01-01' and ibsadate <= '2010-12-31'; --오답
    --where ibsadate between '2010-01-01' and '2010-12-31'; --오답
    --where ibsadate between '2010-01-01 00:00:00' and '2010-12-31 23: 59:59'; --안됨
    --where to_char(ibsadate, 'yyyy') = '2010'; --O
    --where to_char(ibsadate, 'mm') = '05';
--    where to_char(ibsadate, 'day') = '월요일';
--    where to_char(ibsadate, 'dy') = '월';
    where to_char(ibsadate, 'd') = 2; --***
    

--SQL에서 날짜 상수 표시법
--'2010-01-01' //O
--'2010-01-01 12:00:00' //X


select
    '2010-01-01' --시분초?? -> 00:00:00
from dual;



--정렬에서 사용
select
    name,
    to_char(ibsadate, 'yyyy-mm-dd hh24:mi:ss')as 입사일
from tblinsa
    order by to_char(ibsadate, 'mm') asc, to_char(ibsadate, 'yyyy') asc, to_char(ibsadate, 'dd');
    
    
--계절 순으로 출력
select
    name,
    to_char(ibsadate, 'yyyy-mm-dd hh24:mi:ss')as 입사일,
    case
        when to_char(ibsadate, 'mm') between '03' and '05' then '봄'
        when to_char(ibsadate, 'mm') between '06' and '09' then '여름'
        when to_char(ibsadate, 'mm') between '10' and '11' then '가을'
        when to_char(ibsadate, 'mm') in ('12', '01', '02') then '겨울'
    end as 계절
from tblinsa
    order by case
        when to_char(ibsadate, 'mm') between '03' and '05' then 1
        when to_char(ibsadate, 'mm') between '06' and '09' then 2
        when to_char(ibsadate, 'mm') between '10' and '11' then 3
        when to_char(ibsadate, 'mm') in ('12', '01', '02') then 4
    end asc;
    
    
    
    
/*
to_number()
- number to_number(문자열)
*/
--문자열은 좌측정열, 숫자는 좌측정열
select
    '123' as "AAAAAAAAAAAAAAAAAA", -- 문자열
    to_number('123'), --숫자형
    '123' * 2, --암시적 형변환 발생
    to_number('123') * 2    
from dual;











/*
to_date()
-***********************
- date to_date(문자열, 형식문자열)


SQL의 날짜시간 리터럴(상수)
- 문자열 표기
- 문맥에 따라 날짜 상수로 인식하기도 하고 문자열 상수로 인식하기도 한다. -> 암시적 형변환 발생

*/

select
    sysdate, --자료형(date)
    '2021-05-17', --자료형(char)
    sysdate - '2021-01-01' --자료형(char), 연산 안됨
from dual;

select
    *
from tblinsa
    where ibsadate > '2010-01-01'; --자료형(date)
    
    
    
    
    
    
select
    sysdate,
    '2021-05-17',
    to_date('2021-05-17', 'yyyy-mm-dd'),
    to_date('2021/05/17', 'yyyy/mm/dd'),
    to_date('20210517', 'yyyymmdd')
from dual;


-- 2010년 입사 명단?
select * from tblinsa where ibsadate between '2010-01-01' and '2010-12-31'; --'2010-01-01 00:00:00' ~ '2010-12-31 00:00:00'
select * from tblinsa where to_char(ibsadate, 'yyyy') = '2010'; --100%
select * from tblinsa where ibsadate between to_date('2010-01-01 00:00:00', 'yyyy-mm-dd hg24:mi:ss') 
                                                and to_date('2010-12-31 23:59:59', 'yyyy-mm-dd hg24:mi:ss');

select '14:23:45', to_date('14:23:45', 'hh24:mi:ss')from dual;                                        
        