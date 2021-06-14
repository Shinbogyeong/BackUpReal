--ex23_pseudo.sql


/*

Pseudo column, 의사 컬럼
- 실제 컬럼이 아닌데 컬럼처럼 행동하는 객체

rownum
- 오라클 전용, MS-SQL(top), mySQL(limit)
- 행번호를 반환하는 컬럼
- 서브 쿼리에 많이 의존
- rownum은 주로 from 절이 호출될때 같이 실행된다.(**********)
*/

--와일드카드(*)와 다른 컬럼(표현식 등)은 목록으로 연결될 수 없다.
select *, sysdate from tblcountry;

select tblcountry.*, sysdate from tblcountry;

select c.*, sysdate from tblcountry c;
select c.*, rownum from tblcountry c;

-- 질문의 조건에 1행이 포함되면 결과O, 포함이 안되면 결과 X
select c.*, rownum from tblcountry c where rownum = 1;
select c.*, rownum from tblcountry c where rownum <= 5;
select c.*, rownum from tblcountry c where rownum = 5;
select c.*, rownum from tblcountry c where rownum >= 3 and rownum <=7;


select                          --2.
    name, 
    basicpay,
    rownum
from tblInsa                    --1. 60명 + rownum 할당
    order by basicpay desc;     --3. rownum 이미 1번에 할당이 끝났자.
    
    
--인라인 뷰(from절 서브쿼리)
select name, basicpay, rnum, rownum from (select name, basicpay, rownum as rnum from tblInsa order by basicpay desc);

select name, basicpay, rownum from (select name, basicpay from tblInsa order by basicpay desc) where rownum <= 10;
select name, basicpay, rownum from (select name, basicpay from tblInsa order by basicpay desc) where rownum = 1;
select name, basicpay, rownum from (select name, basicpay from tblInsa order by basicpay desc) where rownum >= 3 and rownum <= 5;

-- 급여 순위 3~5등
-- rnum: 가운데 쿼리의 rnum : 정적인 번호
-- rownum: 바깥쪽 쿼리의 rownum : 동적인 번호
select name, basicpay, rnum, rownum from (select name, basicpay, rownum as rnum from (select name, basicpay from tblInsa order by basicpay desc))
    where rnum between 3 and 5;


-- basicpay + sudang -> 급여 순위
select name, basicpay + sudang as salary from tblinsa order by basicpay + sudang desc;
--정리. 이 2가지 경우만 이해하면 끝
--Case A
select name, salary, rownum as rnum from (select name, basicpay + sudang as salary from tblinsa order by basicpay + sudang desc)
    where rownum <= 3;
--Case B    
select name, salary, rnum from (select name, salary, rownum as rnum from (select name, basicpay + sudang as salary from tblinsa order by basicpay + sudang desc))
    where rnum between 5 and 10;
    

-- 지역별(home town)거주자가 몇명
select hometown, cnt, rownum as rnum from (select 
    hometown,
    count(*) as cnt
from tbladdressbook
    group by hometown
        order by count(*) desc);


-- tblAddressBook. 직업별 인원수 -> 순위 1~10등, 11~20등
select job, cnt, rnum from(select job, cnt, rownum as rnum from(select job, count(*) as cnt from tbladdressbook group by job order by count(*) desc))
    where rnum between 11 and 20;
