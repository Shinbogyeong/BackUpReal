-- ex09_numeric_function.sql


/*

숫자 함수
- 자바 Math 클래스

round()
- 반올림 함수
- number round(컬럼명) : 정수 반환
- number round(컬럼명, 소수이하자릿수) : 실수 반환
- 숫자형, 날짜형

*/


select height, weight, height/ weight, round(height/ weight) from tblcomedian;

select first, 10 / 3 from tblcomedian; --10
select 10 / 3 from tblinsa; --60

select 10 / 3 from tblinsa where name ='홍길동';

select * from dual; --시스템 테이블
select 10 /3 from dual;

select round(987.653), round(987.653, 1), round(987.653, 2) from dual;

select round(avg(basicpay)) from tblinsa;

select round(name) from tblinsa;
select round(ibsadate), ibsadate from tblinsa;


/*
floor(), trunc()
- 절삭 함수
- 무조건 내림 함수
- 자바의 정수/정수 -> 몫
- number floor(컬럼명_
- number trunc(컬럼명 [,t소수이하 자릿수])

*/
select
    5.6789,
    round(5.6789),
    floor(5.6789),
    trunc(5.6789,2)
from dual;

/*

ceil()
- 무조건 올림 함수
- number ceil(컬럼명)


*/

select
    3.1,
    round(3.1),
    ceil(3.1),
    ceil(3.00000000000001), --4
    floor(3.999999999999999) --3
from dual;


/*
mod()
- 나머지 함수
- number mod(피제수, 제수)

*/

select mod(10, 3) from dual;

--100분 -> 1시간 40분
-- 100 / 60 -> 몫(시간)
-- 100 % 60 -> 나머지(분)

select
    floor(100 / 60) as 시,
    mod(100, 60) as 분
from dual;
