-- ex16_update.sql

/*

update문
- DML(select, insert, update, delete)
- 원하는 행의 원하는 컬럼값을 수정하는 명령어
- update 테이블명 set 컬럼명 = 수정할 값 [, 컬럼명 = 수정할 값] X N [where절]
- where절!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

*/

--트랜잭션 처리
commit;
rollback;

select * from tblcountry;

-- 대한민국 -> 서울 => 세종시 이전
update tblcountry set
    capital = '세종시' 
        where name = '대한민국'; -- PK컬럼을 조건으로 지정을 하면 유일한 행을 검색할 수 있다.(****)
        --where area = 10; 보장X
        
-- 1년 후 > 인구 증가 > 10% 증가
update tblCountry set
    population = population * 1.1;
    
-- 'AS'에 속한 나라만 인구수 증가
update tblCountry set
    population = population * 1.1
        where continent = 'AS';
        
UPDATE TBLCOUNTRY SET
    CAPITAL = '제주시',
    AREA = AREA + 10,
    population = POPULATION * 1.2
        WHERE NAME = '대한민국';


-- 절대 하면 안되는 행동     -> PK는 절대로 수정하면 안된다!
select * from tblinsa;

update tblinsa set
    num = 2000
        where num = 1001;
    
    
    
    