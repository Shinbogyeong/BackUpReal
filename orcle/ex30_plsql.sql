/*

ex30_plsql.sql

ANSI-SQL
- 비 절차성 언어(명령어 간의 순서가 없다. 흐름이 없다.) -> 제어 흐름이 없다. 문장 단위의 독립적인 언어


PL/SQL
- Procedural Language Extensions to SQL
- 절차성 언어
- 흐름과 제어를 추가
- ANSI-SQL 모두 지원

PL/SQL = ANSI-SQL + 확장(제어구조)

프로시저, Procedure
- 메소드, 함수, 서브루틴 등
- 순서가 있는 코드의 집합

1. 익명 프로시저
    - 1회용
    - 오라클 저장 X

2. 실명 프로시저
    - 반복용
    - 오라클 저장 프로시저
    - DB Object
    
    
PL/SQL 프로시저 블럭 구조(골격)

1. 4개의 키워드로 구성
    - declare
    - begin
    - exception
    - end
    
2. declare
    - 선언부
    - 프로시저에 사용할 변수, 객체 등을 선언하는 영역
    - 생략 가능

3. begin
    - 실행부(구현부)
    - begin ~ end : 블럭 역할
    - 프로시저 구현 코드를 작성하는 영역(메소드의 body 역할)
    - 생략 불가능
    - 업무 관련 코드 작성: ANSI-SQL + 연산, 제어 추가(PL/SQL 구문)
    - try절 역할

4. exception
    - 예외 처리부
    - catch절 역할
    - 예외 처리 코드를 작성하는 영역
    - 생략 가능

5. end
    - 실행부(구현부)
    - 생략 불가능
    
PL/SQL

1. 자료형
    - ANSI-SQL과 동일(확장)

2. 변수 선언하기
    - 변수명 자료형 [not null] [default 값];
    - name varchar2(100) not null
    - ANSI-SQL에서 테이블의 컬럼을 선언하는 방식과 유사
    - 변수는 주로 질의의 결과(***)나 인자값을 저장하는 용도로 사용
    
3. 대입 연산자
    - 컬럼명 = 값 // ANSI. update
    - 변수명 := 값 // PL/SQL
    
dbms_output.put_line
- 기본적으로 꺼진 상태

set serveroutput on;
set serveroutput off;

*/

declare
    num number;
    name varchar2(30);
    today date;
begin
    num := 10;
    dbms_output.put_line(num); -- syso
    
    name := '홍길동';
    dbms_output.put_line(name);
    
    today := '2021-05-26'; -- 리터럴 -> 암시적 형변환
    dbms_output.put_line(today);
    
    today := to_date('2021-05-26', 'yyyy-mm-dd'); -- FM
    dbms_output.put_line(today);
    
    today := sysdate;
    dbms_output.put_line(today);
    
end;


declare
    num1 number;
    num2 number default 200;
    num3 number not null := 300;
    num4 number not null default 400;
begin

    dbms_output.put_line('num1: ' || num1); -- null 출력
    dbms_output.put_line('num2: ' || num2); -- default 출력
    dbms_output.put_line('num3: ' || num3); -- 값 출력
    dbms_output.put_line('num4: ' || num4); -- default 출력

end;


/*

질의의 결과? (select)
- 여태까지(ANSI-SQL만 사용) -> select 결과 -> 1차 소비(눈) + 폐기
- 지금부터 -> select 결과 -> 변수 저장 -> 1,2,3차 소비

1. 1행 1열
    - 단일값
    - 1:1
    - 컬럼 1개 -> 변수 1개에 저장
    
2. 1행 N열
    - 복합값
    - N : N
    - 컬럼 N개 -> 변수 N개에 저장

3. N행 1열
    - 다중값 -> 커서 사용

4. N행 N열
    - 다중 + 복합값 -> 커서 사용
    
    
select into절
    - select의 결과값을 변수에 저장하는 구문

*/

select buseo from tblInsa where name = '홍길동';

declare
    vbuseo varchar2(15); -- 부서를 저장할 변수
begin
    
    -- PLS-00428: an INTO clause is expected in this SELECT statement
    -- PL/SQL 블럭 내부에서는 select의 결과를 반드시 변수에 저장해야 한다.
    -- 만약 변수에 저장하지 않는 일반 ANSI-SQL의 select문을 그냥 사용하면 에러가 발생한다.
    
    -- select into 사용
    -- select 컬럼 into 변수
    -- ANSI-SQL의 결과를 PL/SQL로 옮겨담는 작업 중 하나(***)
    select buseo into vbuseo from tblInsa where name = '홍길동';
    
    dbms_output.put_line('결과: ' || vbuseo); -- PL/SQL 변수
    
    -- PLS-00201: identifier 'BUSEO' must be declared
    -- PL/SQL 블럭 내부에서는 ANSI-SQL의 식별자(테이블명, 컬럼명 등)를 직접 사용할 수 없다.
    dbms_output.put_line('결과: ' || buseo); -- ANSI-SQL 식별자

end;



declare
    vname varchar2(15);
    vbuseo varchar2(15);
begin

    vname := '이순신';
    
    -- 기존의 ANSI-SQL을 구성하면서 PL/SQL 값을 상수로 사용할 수 있다.
    select buseo into vbuseo from tblInsa where name = vname;
    
    dbms_output.put_line(vbuseo);

end;




declare
    vcount number;
begin

    select count(*) into vcount from tblInsa where buseo = '총무부';
    dbms_output.put_line('총무부 직원수: ' || vcount || '명');
    
end;



-- select into
-- 1. 컬럼의 갯수 = 변수의 갯수
-- 2. 자료형 일치
-- 3. 순서 일치
ㄴ
declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
    vbasicpay number;
begin

    select name, buseo, jikwi, basicpay into vname, vbuseo, vjikwi, vbasicpay from tblInsa where name = '홍길동';
    dbms_output.put_line(vbuseo);
    dbms_output.put_line(vjikwi);
    dbms_output.put_line(vbasicpay);

end;


-- 프로시저 생성 + ANSI-SQL(select) + 결과(PL/SQL 변수에 저장)

set serveroutput on;

declare
    vname varchar2(15);
begin

    select name into vname from tblInsa where basicpay = (select max(basicpay) from tblInsa);
    
    dbms_output.put_line(vname);

end;



declare
    vname varchar2(15);
    vbasicpay number;
begin

    select name, basicpay into vname, vbasicpay from tblInsa where basicpay = (select max(basicpay) from tblInsa);
    
    dbms_output.put_line(vname);
    dbms_output.put_line(vbasicpay);

end;

CREATE TABLE tbltemp
    AS
        SELECT
            name,
            buseo,
            jikwi,
            city
        FROM
            tblinsa
        WHERE
            city = '서울';

select * from tblTemp;


-- tblInsa -> 연봉 1위 -> tblTemp 추가(insert)

declare
    vname varchar2(15);
    vbuseo varchar2(15);
    vjikwi varchar2(15);
    vcity varchar2(15);
begin
    
    --1.
    select name, buseo, jikwi, city into vname, vbuseo, vjikwi, vcity from tblInsa
        where basicpay = (select max(basicpay) from tblInsa);
        
    --2.
    insert into tblTemp (name, buseo, jikwi, city) values (vname, vbuseo, vjikwi, vcity);
    
    
    
end;

select * from tblTemp;


-- tblInsa. 연봉 꼴지 -> 같은 부서 직원을 tblTemp 삭제

declare
    vbuseo varchar2(15);
begin

    --1.
    select buseo into vbuseo from tblInsa
        where basicpay = (select min(basicpay) from tblInsa);
        
    --2.
    delete from tblTemp where buseo = vbuseo;

end;


/*

참조 자료형
- 테이블로부터 직접 자료형을 알아내는 방법
- 생산성 + 유지보수성

1. %type
    - 사용하는 테이블의 특정 컬럼 자료형을 그대로 참조해서 변수에 적용
    a. 자료형
    b. 길이
    c. not null

*/

declare
    vname varchar2(20);
    vssn tblInsa.ssn%type; -- 실제 테이블 컬럼을 참조해서 자료형을 복사해 온다.
    vsudang tblInsa.sudang%type;
begin
    select name, ssn, sudang into vname, vssn, vsudang from tblInsa where name = '홍길동';
    dbms_output.put_line(vname);
    dbms_output.put_line(vssn);
    dbms_output.put_line(vsudang);
end;


/*

1. %type
    - 컬럼 참조
    
2. %rowtype
    - 행 참조
    - %type의 집합

*/

declare
    -- 변수 10개
    vnum tblInsa.num%type;
    vname tblInsa.name%type;
    vssn tblInsa.ssn%type;
    vibsadate tblInsa.ibsadate%type;
    vcity tblInsa.city%type;
    vtel tblInsa.tel%type;
    vbuseo tblInsa.buseo%type;
    vjikwi tblInsa.jikwi%type;
    vbasicpay tblInsa.basicpay%type;
    vsudang tblInsa.sudang%type;
begin

    select * into vnum, vname, vssn, vibsadate, vcity, vtel, vbuseo, vjikwi, vbasicpay, vsudang from tblInsa where name = '홍길동';
    dbms_output.put_line(vnum);
    dbms_output.put_line(vname);
    dbms_output.put_line(vtel);
    
end;


declare
    vrow tblInsa%rowtype; -- 테이블의 모든 컬럼의 집합 참조, 레코드 참조
begin
    select * into vrow from tblInsa where name = '홍길동';
    dbms_output.put_line(vrow.name);
    dbms_output.put_line(vrow.buseo);
    dbms_output.put_line(vrow.city);
end;


declare
    vgender varchar2(1);
begin
    select substr(ssn, 8, 1) into vgender from tblInsa where name = '이순신';
    
    dbms_output.put_line(vgender);
    
end;


-- 제어문(조건문

declare
    vnum number := 10; -- 1. 변수 생성 + 초기화
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    end if;

end;

declare
    vnum number := -10; -- 1. 변수 생성 + 초기화
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    else
        dbms_output.put_line('양수아님');
    end if;

end;



declare
    vnum number := -10;
begin

    if vnum > 0 then
        dbms_output.put_line('양수');
    elsif vnum < 0 then -- else if, elsif, elseif 등
        dbms_output.put_line('양수아님');
    else
        dbms_output.put_line('영');
    end if;

end;


-- 특별 상여금
create table tblBonus (

    seq number primary key,                             -- 지급내역번호(PK)
    pnum number not null references tblInsa(num),       -- 직원번호(FK)
    bonus number not null,                              -- 지급액
    regdate date default sysdate not null               -- 지급날짜

);

create sequence seqBonus;

-- 특정 1명 -> 보너스 지급(직위에 따라)

declare
    vjikwi tblInsa.jikwi%type;
    vnum tblinsa.num%type;
    vbonus number;
    vbasicpay tblInsa.basicpay%type;
begin
    
    -- 1.
    select jikwi, num, basicpay into vjikwi, vnum, vbasicpay from tblInsa where name = '홍길동';
    
    -- 2. 직위 보너스 금액 산정
    if vjikwi in ('부장', '과장')
        then vbonus := vbasicpay * 2;
    elsif vjikwi in ('대리', '사원')
        then vbonus := vbasicpay * 1.5;
    end if;
    
    -- 3. 보너스 지급
    insert into tblBonus (seq, pnum, bonus, regdate) values (seqBonus.nextVal, vnum, vbonus, default);

end;

select * from tblInsa;
select * from tblBonus;

select
    i.name as 직위명,
    i.jikwi as 직위,
    i.basicpay as 급여,
    b.bonus as 보너스
from tblInsa i
    inner join tblBonus b
        on i.num = b.pnum;
        
        

/*

case문

ANSI-SQL(case문)과는 다른 구문
1. ANSI-SQL의 case : 표현식 정도 수준만 사용 가능
2. PL/SQL의 case: 문장 단위 실행도 가능

*/


select
    name,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblInsa;


-- tblCountry. continent

declare

    vname tblCountry.name%type;
    vcontinent tblCountry.continent%type;
    vresult varchar2(30);

begin

    select name, continent into vname, vcontinent from tblCountry where name = '대한민국';
    
    if vcontinent = 'AS'
        then vresult := '아시아';
    elsif vcontinent = 'EU'
        then vresult := '유럽';
    elsif vcontinent = 'AF'
        then vresult := '아프리카';
    else
        vresult := '기타';
    end if;
    
    dbms_output.put_line(vname || '-' || vresult);
    
    case vcontinent
        when 'AS' then vresult := '아시아';
        when 'EU' then vresult := '유럽';
        when 'AF' then vresult := '아프리카';
        else vresult := '기타';
    end case;
    
end;
/

/*

반복문

1. loop
- 무한 루프
- 탈출 조건 처리

2. for loop
- 지정 횟수 반복(자바 for문 유사)

3. while loop
- 조건 반복(자바 while문 유사)

*/

set serveroutput on;

begin

    loop
        dbms_output.put_line(to_char(sysdate, 'hh24:mi:ss'));
    end loop;
    
end;
/

declare
    vnum number := 1; -- 루프 변수 역할
begin

    loop
    
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
        
        -- if + break (자바)
        exit when vnum > 10;
    
    end loop;

end;
/


create table tblLoop (
    seq number primary key,
    data varchar2(30) not null
);

create sequence seqLoop;

-- 더미 데이터 + 10000개 추가
-- data: '데이터1', '데이터2', '데이터3', ..

declare
    vnum number := 1;
begin

    loop
        
        insert into tblLoop (seq, data) values (seqLoop.nextVal, '데이터' || vnum);
        vnum := vnum + 1;
        
        exit when vnum > 10000;
        
    end loop;

end;
/

select * from tblLoop;

delete from tblLoop;

declare
    vname tblInsa.name%type;
    vnum number;
begin

    -- tblInsa. 직원번호 1015 ~ 1045. 이름. tblLoop 추가
    
    vnum := 1015;
    
    loop
    
        -- 1.
        select name into vname from tblInsa where num = vnum;
        
        -- 2.
        insert into tblLoop (seq, data) values (seqLoop.nextVal, vname);
        
        vnum := vnum + 1;
        
        exit when vnum > 1045;

    end loop;

end;
/

select * from tblLoop;



-- for loop
begin
    
    -- i: 루프변수
    -- in: 연결 키워드
    -- 1: 초기값
    -- 10: 최대값
    -- ..: 증가
    
    for i in 1..10 loop
    
        dbms_output.put_line(i);
    
    end loop;
    
    for i in reverse 1..10 loop
    
        dbms_output.put_line(i);
    
    end loop;

end;
/

create table tblGugudan (
    dan number not null,
    num number not null,
    result number not null,
    
    constraint tblgugudan_dan_num_pk primary key(dan, num) -- 복합키
);

alter table tblGugudan
    add contraint tblgugudan_dan_num_pk primary key(dan, num);

drop table tblgugudan;


-- 2단 ~ 9단 : insert x 72번

begin
    
    for vdan in 2..9 loop
        
        for vnum in 1..9 loop
            
            insert into tblGugudan (dan, num, result)
                values (vdan, vnum, vdan * vnum);
            
        end loop;
    
    end loop;
    
end;
/

select * from tblGugudan;



declare
    vname tblInsa.name%type;
begin
    
     for vnum in 1030..1040 loop
    
        select name into vname from tblInsa where num = vnum;
        
        insert into tblLoop (seq, data) values (seqLoop.nextVal, vname);

    end loop;

end;
/

select * from tblLoop;



declare
    vnum number := 1;
begin

    while vnum <= 10 loop
        
        dbms_output.put_line(vnum);
        vnum := vnum + 1;
        
    end loop;

end;
/




-- 예외 처리부
declare
    vnum number;
    vname number;
begin
    
    dbms_output.put_line('시작');
    
    --ORA-06502: PL/SQL: numeric or value error: character to number conversion error
    select name into vname from tblInsa where num = 1001;
    dbms_output.put_line(vname);
    
    --vnum := 10;
    vnum := 0;
    
    --ORA-01476: divisor is equal to zero
    dbms_output.put_line(100/vnum);
    
    dbms_output.put_line('끝');
    
exception
    --catch절. 예외 처리부
    
    when VALUE_ERROR then
        dbms_output.put_line('자료형 불일치');
    
    when zero_divide then
        dbms_output.put_line('0으로 나누려고 함');
    
    
    when others then  -- catch (Exeption e) : 모든 종류의 예외 처리
        dbms_output.put_line('예외처리');

end;





/*

PL/SQL
- select -> 결과셋 -> PL/SQL 변수

1. select into 절 사용
- 결과셋의 레코드가 1개일때만 사용 가능(***)
- 결과셋의 컬럼은 1개 이상 ~ 

declare
    변수 선언;
begin
    select 컬럼 into 변수 from 테이블;
end;

2. cursor 사용
- 결과셋의 레코드가 0개 이상이 때 사용 가능(N개)
- 컬럼셋의 컬럼은 1개 이상
- 일반적으로 결과셋의 레코드가 2개 이상일 때 권장
- 자바의 Iterator 구조와 유사

declare
    커서 선언;
begin
    커서 열기;
        loop
            레코드 접근 -> 커서 사용
        end loop;
    커서 닫기;
end;

*/

set serveroutput on;



declare
    vname tblInsa.name%type;
begin
    select name into vname from tblInsa; -- where num = 1001;-- PK
    dbms_output.put_line(vname);
end;
/



declare
    vname tblInsa.name%type;
    
    -- 커서 선언
    cursor vcursor is select name from tblInsa; -- 결과셋 참조 객체
begin
    
    -- 커서 열기: 커서가 가지고 있는 select문이 실행된다. > 결과셋 > 커서가 참조
    open vcursor;
    
        -- 커서 조작 -> 결과셋 탐색
        -- loop: 결과셋의 레코드들을 탐색 루프
        loop
            
            -- 커서를 전진한다. + 커서 가르키는 레코드의 컬럼 접근(읽기)
            fetch vcursor into vname; -- select name into vname;
            
            -- 탈출 -> 더이상 읽어올 레코드가 없을 때
            exit when vcursor%notfound; -- 커서 프로퍼티
            
            dbms_output.put_line(vname);
            
        end loop;
    
    -- 커서 닫기
    close vcursor;
    
end;
/

create view vwTest
as
select name from tblInsa;


select * from tblCountry;

declare
    cursor vcursor
        is select name, capital, population from tblCountry order by name;
    vname tblCountry.name%type;
    vcapital tblCountry.capital%type;
    vpopulation tblCountry.population%type;
begin

    open vcursor;
        loop
            -- select name, capital, population into vname, vcapital, vpopulation
            fetch vcursor into vname, vcapital, vpopulation;
            exit when vcursor%notfound;
            
            dbms_output.put_line(vname || '-' || vcapital || '-' || vpopulation);
        end loop;
    close vcursor;

end;
/


select * from tblBonus;

-- 개발부 직원 -> 모두 보너스 지급
declare

    cursor vcursor is select num, basicpay from tblInsa where buseo = '개발부';
    vnum tblInsa.num%type;
    vbasicpay tblInsa.basicpay%type;

begin
    
    open vcursor;
        loop
        
            fetch vcursor into vnum, vbasicpay;
            exit when vcursor%notfound;
            
            -- 여기부터 업무에 따라 고민..
            insert into tblBonus (seq, pnum, bonus, regdate)
                values (seqBonus.nextVal, vnum, round(vbasicpay * 0.7), default);
                
            
        
        end loop;
    close vcursor;
    
end;
/

select * from tblBonus;





-- tblInsa. 개발부 직원 + 모든 컬럼
declare
    cursor vcursor is select * from tblInsa where buseo = '개발부';
    vrow tblInsa%rowtype; -- 레코드 참조 변수(컬럼 10개)
begin

    open vcursor;
    
        loop
        
            fetch vcursor into vrow; -- 컬럼 10개 -> 변수 10개 복사
            
            exit when vcursor%notfound;
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');
        
        end loop;
    
    close vcursor;

end;
/

-- 간단한 버전
declare
    cursor vcursor is select * from tblInsa where buseo = '개발부'; -- 그대로
    -- vrow tblInsa%rowtype; -- 생략 -> 아래에서 만든다.
begin

    -- open vcursor;
    
        for vrow in vcursor loop -- loop + fetch + exit when
        
            -- fetch vcursor into vrow;
            
            -- exit when vcursor%notfound;
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');
        
        end loop;
    
    -- close vcursor;

end;
/


declare
    cursor vcursor is select * from tblInsa where buseo = '개발부';
begin
    
        for vrow in vcursor loop -- loop + fetch + exit when
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');
        
        end loop;

end;
/




-- 권장 안함
create view vwDev
as
select * from tblInsa where buseo = '개발부';

select * from vwDev;
select * from (select * from tblInsa where buseo = '개발부'); -- 인라인 뷰


-- 인라인 커서 -> 가독성 낮음
-- 단순한 쿼리에 한해서 사용
declare
    cursor vcursor is select * from tblInsa where buseo = '개발부';
begin
    
        for vrow in (select * from tblInsa where buseo = '개발부') loop
            
            dbms_output.put_line(vrow.name);
            dbms_output.put_line(vrow.buseo);
            dbms_output.put_line('---');
        
        end loop;

end;
/



/*

프로시저
- PL/SQL 블럭(declare, begin, exception, end)

1. 익명 프로시저
    - 1회용(DB에 저장이 안됨, HDD에 *.sql로 저장)
    - 객체X
    - 속도 느림
    - 테스트용, 임시 개발용
    
2. 실명 프로시저
    - 저장용(DB에 저장이 됨)
    - 객체O
    - 재사용 가능, 타 유저에게 공유 가능
    - 속도 빠름
    - 업무용
   
   
실명 프로시저 > 저장 프로시저(Stored Procedure)
1. 저장 프로시저(Stored Procedure)
    - 매개변수 구성 or 반환값 구성 -> 자유

2. 저장 함수(Stored Function)
    - 매개변수 필수, 반환값 필수 -> 고정
    
    
익명 프로시저 선언
[declare
    변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end;

저장 프로시저 선언
create [or replace] procedure 프로시저명

is(as)
    [변수 선언;
    커서 선언;]
begin
    구현부;
[exception
    예외처리;]
end [프로시저명];

*/

declare
    vnum number;
begin

    vnum := 100;
    dbms_output.put_line(vnum);

end;
/


create or replace procedure procTest
is
    vnum number;
begin

    vnum := 100;
    dbms_output.put_line(vnum);

end procTest;
/



/*

저장 프로시저를 호출하는 방법

1. 스크립트 환경에서 호출하기(ANSI-SQL 환경에서)
2. PL/SQL 블럭에서 호출하기

*/

-- 2. PL/SQL 블럭에서 호출하기
-- PL/SQL 환경
begin
    procTest; -- 인자값 없는 메소드 호출
end;
/


-- ANSI-SQL 환경
procTest;

-- 1. 스크립트 환경에서 호출하기(ANSI-SQL 환경에서)
execute procTest;
exec procTest;
call procTest(); -- call 사용시 () 필수






/*


프로젝트 적용
1. 두 방식 모두 사용
2. 비율 알아서 나누기..
    a. 핵심 업무(저장 프로시저). 잡다한 업무(ANSI-SQL)
    b. 회원, 게시판(저장 프로시저). 관리자(ANSI-SQL)


SQL 처리 순서

1. ANSI-SQL or 익명 프로시저
    : 클라이언트 구문 작성(select) -> 실행(Ctrl+Enter) -> 명령어가 오라클 서버에 전달
        -> 서버에서 명령어를 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 도출
        -> 결과셋을 클라이언트에게 반환
    : 한번 실행했던 명령어를 다시 실행 -> 위의 과정을 다시 처음부터 끝까지 모든 과정을 재실행한다.
    : 첫번째 실행 비용 = 다시 실행 비용

2. 저장 프로시저(PL/SQL)
    : 클라이언트 구문 작성(select) -> 실행(Ctrl+Enter) -> 명령어가 오라클 서버에 전달
        -> 서버에서 명령어를 수신 -> 구문 분석(파싱) -> 컴파일 -> 실행 -> 결과 도출
        -> 결과셋을 클라이언트에게 반환
    : 한번 실행했던 명령어를 다시 실행 -> "구문 분석(파싱) -> 컴파일" 과정이 생략된다. : 이부분 비용 감소
    : 첫번째 실행 비용 > 다시 실행 비용
    
    
*/

set serveroutput on;

/*



*/

/*

프로젝트
1. 샘플 -> 프로시저
2. ANSI-SQL

업무 분석 -> 요구 사항 -> ERD -> DDL -> 업무 + SQL (ANSI-SQL) -> 반복, 유기적 연결.. -> 프로시저

질의 실행
1. ANSI-SQL
2. 익명 프로시저 = ANSI-SQL + PL/SQL = 개발자용(테스트용) 
3. 저장 프로시저 = ANSI-SQL + PL/SQL = 코드 저장 = 영구적 재사용

*/



-- ANSI-SQL
select name from tblInsa; -- 구문분석, 파싱

create or replace procedure proInsa
is
    cursor vcursor is select name from tblInsa;
    vname tblInsa.name%type;
begin

    open vcursor;
    
        loop
        
            fetch vcursor into vname;
            exit when vcursor%notfound;
            
            -- 클라이언트에게 반환하는 작업이라고 가정(return)
            dbms_output.put_line(vname);
            
        end loop;
    
    close vcursor;

end;
/


begin
    proInsa;
end;
/


-- 프로시저 == 메소드
-- 1. 매개변수
-- 2. 반환값

-- 매개변수
create or replace procedure procTest(pnum number) -- 매개변수 리스트
is
    vsum number := 0; -- 로컬 변수
begin

    vsum := pnum + 100;
    dbms_output.put_line(vsum);

end procTest;
/

begin
procTest(59);
procTest(100);
procTest(200);
end;
/



create or replace procedure procTest (
    width number,
    height number default 10 -- default 활용 -> 메소드 오버로딩 유사 구현
)
is
    vresult number;
begin

    vresult := width * height;
    dbms_output.put_line(vresult);

end procTest;
/

begin
    procTest(100, 200);
    procTest(100);
end;
/



/*

매개변수 모드(******)
- 매개변수의 값을 전달하는 방식

1. in 모드(기본 모드)
2. out 모드
3. in out 모드(사용 안함)

*/

create or replace procedure procTest(
    vnum1 in number, -- in mode
    vnum2 in number,
    vresult out number, -- out mode(주소값 참조 변수) -> 반환값 역할
    vresult2 out number,
    vresult3 out number
)
is
begin

    vresult := vnum1 + vnum2;
    vresult2 := vnum1 * vnum2;
    vresult3 := vnum1 / vnum2;

end;
/

declare
    vsum number;
    vsum2 number;
    vsum3 number;
begin
    procTest(10 ,20, vsum, vsum2, vsum3);
    dbms_output.put_line(vsum);
    dbms_output.put_line(vsum2);
    dbms_output.put_line(vsum3);
end;
/


-- 프로시저로 제작
-- 요구사항] 부서 지정 -> 부서 내에서 급여를 가장 많이 받는 직원의 이름을 반환
create or replace procedure procTest(
    pbuseo in varchar2,
    pname out varchar2
)
is
    vsalary number;
begin

    --select name into pname from tblInsa 
        --where basicpay = (select max(basicpay) from tblInsa buseo = pbuseo);
        
    select max(basicpay) into vsalary from tblInsa where buseo = pbuseo;
    
    select name into pname from tblInsa where basicpay = vsalary;

end procTest;


declare
    vname varchar2(30);
begin
    procTest('개발부', vname);
    dbms_output.put_line(vname);
end;
/



-- 요구사항] 직원번호 -> 같은 지역의 직원 수, 같은 직위의 직원 수, 같은 부서의 직원 수 반환
select * from tblInsa;
create or replace procedure procTest(
    pnum number,        -- 직원번호(in)
    pcnt1 out number,   -- 같은 지역
    pcnt2 out number,   -- 같은 직위
    pcnt3 out number    -- 같은 부서
)
is
begin
    
    -- 같은 지역
    select count(*) into pcnt1 from tblInsa
        where city = (select city from tblInsa where num = pnum);
    
    -- 같은 직위
    select count(*) into pcnt2 from tblInsa
        where jikwi = (select jikwi from tblInsa where num = pnum);
        
    -- 같은 부서
    select count(*) into pcnt3 from tblInsa
        where buseo = (select buseo from tblInsa where num = pnum);

end procTest;
/

declare
    vcnt1 number;
    vcnt2 number;
    vcnt3 number;
begin
    procTest(1001, vcnt1, vcnt2, vcnt3);
    dbms_output.put_line('같은 지역: ' || vcnt1);
    dbms_output.put_line('같은 직위: ' || vcnt2);
    dbms_output.put_line('같은 부서: ' || vcnt3);
end;
/


set serveroutput on;

-- 특정 직원 퇴사 -> 담당 업무 존재 확인 -> 업무 위임 -> 퇴사
select * from tblStaff;
select * from tblProject;

create or replace procedure procDeleteStaff(
    pseq number,                -- 퇴사할 직원번호(tblStaff.PK)
    pstaff number,              -- 위임받을 직원번호(tblProject.staff)
    presult out number         -- 성공(1) or 실패(0)
)
is
    vcnt number; -- 퇴사 직원의 담당 프로젝트 수
begin

    -- 1. 퇴사 직원의 담당 프로젝트가 있는지?
    select count(*) into vcnt from tblProject where staff_seq = pseq;
    dbms_output.put_line('퇴사할 직원이 ' || vcnt || '개의 프로젝트를 담당하고 있습니다.');
    
    -- 2. 1의 결과 -> 있으면(위임), 없으면(X)
    if vcnt > 0 then
        -- 위임
        update tblProject set staff_seq = pstaff where staff_seq = pseq;
        dbms_output.put_line(pseq || '의 프로젝트를 ' || pstaff || '에게 위임합니다.');
    else
        null; -- 이 블럭에서는 정말로 아무것도 하지 않겠다는 표현(개발자 의도)
        dbms_output.put_line('위임할 프로젝트가 없습니다.');
    end if;
    
    -- 3. 퇴사 처리
    delete from tblStaff where seq = pseq;
    dbms_output.put_line(pseq || '가 퇴사합니다.');
    
    presult := 1; -- 4. 성공
    
exception
    when others then
        presult := 0; -- 4. 실패
    
end procDeleteStaff;


select * from tblStaff;
select * from tblProject;

declare
    vresult number; -- 성공 유무
begin
    procDeleteStaff(1, 2, vresult);
    
    if vresult = 1 then
        dbms_output.put_line('퇴사 성공');
    else
        dbms_output.put_line('퇴사 실패');
    end if;
end;


/*

DB 프로젝트
- 업무 100개
- ANSI-SQL: 200 ~ 500개
- 일부(주요) 업무 : 프로시저로 생성, 10~20%
- 일부(특수) 업무 : 함수, 트리가 생성, 3~5%

- 실제 프로젝트 -> 일부 사용O, 일부 사용 X
- 교육(위업)프로젝트 -> 골고루 사용O -> X -> 포트폴리오에 들어갈 정도의 분량
*/



/*
1. 저장 프로시저
    - 반환값이 0개 이상(갯수는 0개 이상, 일반적으로는 1개 이상)
    - 반호나값이 0개 이상(out 파라미터 x N개 생성

2. 저장 함수
    - 반드시 매개변수가 있어야 한다. (갯수는 0개 이상, 일반적으로는 1개 이상)
    - 반드시 반환값이 있어야 한다.(반드시 1개)
*/


--public int fnSum(int pnum1, pnum2) { }

--create or replace function fnSum ( pnum1 number, pnum2 number) return number

create or replace function fnSum (
    pnum1 number,
    pnum2 number
    --presult out number --out을 사용하는 행동 > 반환값이 여러개일 수 있다는 뜻
) return number
is
begin
    return pnum1 + pnum2;
    
end fnSum;


declare
    vresult number;
begin
    vresult := fnSum(100, 200);
    dbms_output.put_line(vresult);
    
    dbms_output.put_line(fnSum(300, 400));
end;



select name


-- 반환값을 받는 방식의 차이때문에 사용이 되는 용도가 다르다.
-- PL/SQL(X)
-- 저장 함수는 ANSI-SQL에서 사용이 가능하다(************)

select name, basicpay, sudang, basicpay + sudang, fnSum(basicpay + sudang) from tblInsa;

select name, buseo, jikwi,
    case
        when substr(ssn, 8, 1) = '1' then '남자'
        when substr(ssn, 8, 1) = '2' then '여자'
    end as gender
from tblinsa;


--저장함수 : ANSI-SQL을 보조하는 역할
--저장프로시저 : 행동의 단위(메소드 개념)

create or replace function fnGender(
    pssn varchar2
)return varchar2
is
begin
    return case
                when substr(pssn, 1, 1) = '1' then '남자'
                when substr(pssn, 1, 1) = '2' then '여자'
           end;
end fnGender;


/

-- 저장프로시저
-- out parameter
-- 1. 결과셋의 레코드가 1개일때 대응
-- 2. 결과셋의 레코드가 N개일때 대응
create or replace procedure procTest(
    pnum in number,         --직원 번호
    pname out varchar2,     --직원 이름
    pjikwi out varchar2,    --직위
    pbuseo out varchar2     --부서
)
is
begin
    select name, jikwi, buseo into pname, pjikwi, pbuseo from tblinsa
        where num = pnum;
        --dbms_output.put_line(pname);
        --dbms_output.put_line(pjikwi);
        --dbms_output.put_line(pbuseo);
end procTest;

/
declare 
    vname tblinsa.name%type;
    vjikwi tblinsa.jikwi%type;
    vbuseo tblinsa.buseo%type;
begin
    procTest(1001, vname, vjikwi, vbuseo);
        dbms_output.put_line(vname);
        dbms_output.put_line(vjikwi);
        dbms_output.put_line(vbuseo);
end;


/
-- 부서 -> 목록 반환
-- 1. 저장 프로시저 -> 단일값 반환(커서 반환 가능, ANSI-SQL 자료형 + PL/SQL 자료형 (커서))
-- 2. 저장 함수 -> 단일값 반환(커서 반환 불가능, ANSI- SQL 자료형만 반환가능(number, string, date))

create or replace procedure procTest(
    pbuseo in varchar2,         --부서(조건)
    pcursor out sys_refcursor   --sys_refcursor: cursor 자료형과 동일한 자료형. 반환값 타입으로 사용.
)
is
begin
    
    --cursor pcusor is select문..
    open pcursor
        for select * from tblinsa where buseo = pbuseo;
end procTest;
/

declare
    pcursor sys_refcursor;
    vrow tblinsa%rowtype;
begin

    procTest('개발부', pcursor);
    
    -- pcursor + opened..
    loop
        fetch pcursor into vrow;
        exit when pcursor%notfound;
        dbms_output.put_line(vrow.name);
    end loop;
    
end;
/
-- 직원 번호 전달 -> 어디 거주? 같은 지역 직원 명단 반환
create or replace procedure procTest(   
    pnum number,            --직원 번호
    pcursor out sys_refcursor   --직원 명단
)
is
    vcity tblinsa.city%type;
begin
    -- 어디 거주?
    select city into vcity from tblinsa where num = pnum;
    
    -- 같은 지역 직원 명단 반환
    open pcursor for
        select * from tblinsa where city = vcity;

end procTest;
/
--확인    
declare
     vcursor sys_refcursor;
     vrow tblinsa%rowtype;
begin
    procTest(1030, vcursor);
    
    loop
        fetch vcursor into vrow;
        exit when vcursor%notfound;
        
        dbms_output.put_line(vrow.name || '-' ||vrow.city);
    end loop;
    
end;


/*

트리거, Trigger
- 프로시저의 한 종류
- 개발자의 호출이 아닌, 미리 지정한 특정 사건이 발생하면 자동으로 실행되는 프로시저(예약+이벤트)
- 특정 테이블 지정 -> 감시 -> insert or update or delete -> 메리 준비해놓은 프로시저가 자동 실행
- 트리거가 많아지면 시스템 속도가 느려진다.

트리거 구문

create or replace trigger 트리거명
    - 트리거 옵션
    before|after
    insert|update|delete on 테이블명
    [for each row]
declare
    선언부;
begin
    실행부;
exception
    예외처리부
end;

*/

/
create table tblLog(
    seq number primary key,
    num number not null references tblinsa(num),
    regdate date default sysdate not null
)


create sequence seqLog;


create table tblBoard(
    seq number primary key,
    num number not null references tblinsa(num),
    subject varchar2(1000) not null
)

create sequence seqBoard;


--트리거 객체 생성 + 트리거 작동 시작1
--직원들 -> tblBoard글 작성 -> 관리자 확인 + 모니터링 + tblLog
create or replace trigger trgBoard
    after   --사건 전/후
    insert  --감시 사건
    on tblBoard --감시 대상
declare
begin
    dbms_output.put_line('직원이 글을 작성했습니다.');
end;
/

--글쓰기
insert into tblBoard values (seqBoard.nextVal, 1003, '테스트입니다.');
/

create or replace trigger trgBoard
    after   
    insert  
    on tblBoard 
declare
    vnum number;
begin
    
    -- 누가 글을 썼는지 tblLog 테이블에 기록
    -- 누가?? -> 마지막 글을 쓴 사람?
    select num into vnum from tblBoard where seq = (select max(seq) from tblBoard);
    
    --로그 기록
    insert into tblLog(seq, num, regdate) values (seqLog.nextVal, vnum, default);
end;
/

insert into tblBoard values (seqBoard.nextVal, (select num from tblinsa where name = '홍길동'), '테스트입니다.');
/


insert into tblBoard(seq, num, subject)
    values (seqBoard.nextVal, (select num from tblInsa where name = '홍길동'), '테스트입니다.');

insert into tblBoard(seq, num, subject)
    values (seqBoard.nextVal, (select num from tblInsa where name = '이순신'), '테스트입니다.');

insert into tblBoard(seq, num, subject)
    values (seqBoard.nextVal, (select num from tblInsa where name = '유관순'), '테스트입니다.');

select * from tblLog;

-- inner join 
select 
    i.name as 직원명,
    to_char(l.regdate, 'hh24:mi:ss') as 시각
from tblLog l
    inner join tblInsa i
        on i.num = l.num;

--상관 서브 쿼리
select 
    (select name from tblInsa where num = tblLog.num) as 직원명,
    to_char(regdate, 'hh24:mi:ss') as 시각 
from tblLog;

commit;
rollback;







-- 자식 테이블 찾기!!!
-- 1. ERD 확인
--  - ERD 없음;;
--  - ERD 갱싱 안함;;

-- 2. 조회 -- 관리자
SELECT fk.owner, fk.constraint_name , fk.table_name
FROM all_constraints fk, all_constraints pk
WHERE fk.R_CONSTRAINT_NAME = pk.CONSTRAINT_NAME
AND fk.CONSTRAINT_TYPE = 'R'
AND pk.TABLE_NAME = 'TBLUSER' -- 검색할 테이블명(대문자 작성)
ORDER BY fk.TABLE_NAME;

drop table tblOrder;
drop table tblUser;

-- 3. ERD 도구 -> 역공학

-- 4. 강제 삭제 -> FK 걸려있어도 무시하고 삭제
-- 그다지 좋은 방법은 아님.
-- 자식이 있는 부모 테이블을 삭제하는 방법(부모를 강제로 삭제, 자식 테이블은 그대로 유지)
drop table tblUser cascade constraints purge; --Table TBLUSER이(가) 삭제되었습니다.



-- 퇴사
delete from tblBoard;
commit;
rollback;


-- tblinsa. 직원 퇴사
-- 특정 요일(목)에는 퇴사를 할 수 없다.
-- 퇴사
delete from tblinsa where num = 1002;
/

rollback;

create or replace trigger trgInsa
    before
    delete
    on tblinsa
begin
    --dbms_output.put_line('트리거 발생');
    
    if to_char(sysdate, 'dy') = '목' then
        --현재 실행되려는 delete 작업을 없었던걸로 만들기 -> 강제로 예외발생!!(throw new Exception)
        -- -20000 ~ 299999
        raise_application_error(-20001, '목요일에는 퇴사가 불가능합니다.');
    end if;
    
end trgInsa;

/
--로그 트리거
-- tblMen 테이블에서 발생하는 모든 변화를 기록하는 로그 테이블
create table tblLogMen( 
    seq number primary key,
    message varchar2(1000) not null,
    regdate date default sysdate not null
);
/
create sequence seqLogMen;
/

create or replace trigger trgLogMen
    after
    insert or update or delete
    on tblMen
declare
    vmessage varchar2(1000);
begin
    
    --어떤 사건? insert or update or delete
    --dbms_output.put_line('사건발생');
    
    --예약 상수
    if inserting then
        vmessage := '새 인원이 추가되었습니다.';
    elsif updating then
        vmessage := '특정 인원의 정보가 수정되었습니다.';
    elsif deleting then
        vmessage := '특정 인원이 삭제되었습니다.';
    end if;
    
    insert into tblLogMEn (seq, message, regdate)
        values (seqLogMen.nextval, vmessage, default);
        
end trgLogMen;
/
rollback;
select * from tblmen;
/
delete from tblmen where name = '홍길동';
/
update from tblmen set name = 'ㅎㅎ' where name = '홍길동';
/

select * from tblLogmen;
/



/*
[for each row]

1. 생략
    - 문장 단위 트리거
    - 트리거 실행 횟수 1회
    - DML에 의해서 적용된 행의 갯수와 무관하게 단 1회만 실행
    - 목적: 행동 자체가 중요한 트리거(적용된 레코드(데이터)는 그다지 중요하지 않다.)
    
2. 사용
    - 행 단위 트리거
    - 트리거 실행 횟수 N회
    - DML에 의해서 적용된 행의 갯수와 동일한 횟수만큼 실행
    - 목적: 적용되는 레코드의 정보가 중요한 트리거
        - 가상 컬럼(Pseudo Column)
            a. :old
            b. :new
*/

-- 트리거 발생 확인
select * from tbltodo;


create sequence seqTodo start with 21;

insert into tbltodo values (seqTodo.nextval, '프로시저 만들기', sysdate, null);
insert into tbltodo values (seqTodo.nextval, '강아지 목욕시키기', sysdate, null);
insert into tbltodo values (seqTodo.nextval, '장보기', sysdate, null);
insert into tbltodo values (seqTodo.nextval, '프로젝트 정리하기', sysdate, null);
insert into tbltodo values (seqTodo.nextval, '오라클 복습하기', sysdate, null);

commit;
/


create or replace trigger trgAddTodo
    after
    insert on tbltodo
    for each row
begin
    dbms_output.put_line('트리거 발생' || to_char(sysdate, 'hh24:mi:ss'));
    dbms_output.put_line('새로추가된 행의 정보:' || :new.seq);
    dbms_output.put_line('새로추가된 행의 정보:' || :new.title);
end;
/

set serveroutput on;
/


create or replace trigger trgEditTodo
    after
    update on tbltodo
    for each row
begin
    dbms_output.put_line('수정 트리거 발생' || to_char(sysdate, 'hh24:mi:ss'));
    dbms_output.put_line('수정되기 전 제목:' || :old.title);
    dbms_output.put_line('수정된 후 제목:' || :new.title);
    dbms_output.put_line(' ');
end;
/

update tbltodo set title = title || '.' where seq = 1;


-- 프로시저 vs 트리거
-- 회원제 + 게시판 운영 + 글작성 + 포인트 누적
create table tblUser(
    id varchar2(50) primary key,        --아이디(PK)
    name varchar2(50) not null,         --이름
    point number default 1000 not null  --포인트
);

create table tblBoard1(
    seq number primary key,                             --글번호(PK)
    subject varchar2(100) not null,                     --제목
    regdate date default sysdate not null,              --날짜
    id varchar2(50) not null references tblUser(id)    --작성자
);

insert into tblUser values ('hong', '홍길동', default);
select * from tblUser;

insert into tblboard1 values (1, '안녕하세요', default, 'hong'); -- ,rmfwkrtjd
update tblUser set point = point + 100 where id = 'hong';
select * from tblboard1;
/

--글쓰기 감시 -> 포인트 증가
create or replace trigger trgAddBoard
    after
    insert on tblboard1
    for each row --글쓴이의 id가 필요해서
begin

    update tblUser set point = point + 100 where id = :new.id;
    
end;




--게시판
select * from tblBoard;

--댓글
create table tblComment(
    seq number primary key,                             --댓글 번호(PK)
    subject varchar2(100) not null,
    regdate date default sysdate not null,
    pseq number not null references tblboard1(seq)      --게시판 글번호(FK)
);

create sequence seqComment;

select * from tblboard1;

insert into tblcomment values (seqComment.nextval, '댓글입니다.', default, 1);

select * from tblcomment;

--글 삭제: 먼저 댓글을 삭제하고~ 본 글을 삭제
-- 1. 딸린 댓글의 글 번호 select
-- 2. 1번 댓글들을 delete
-- 3. 게시판 클을 delete
delete from tblboard1 where seq =1 ;

create or replace trigger trgDeleteBoard
    before
    delete on tblBoard1
    for each row
begin

    --댓글 삭제
    delete from tblcomment where pseq = :old.seq;   --tblboard.seq 컬럼값, 삭제될 글번호
    
end;


--트리거.
-- 1. 트리거가 뭐예요?
-- 2. 프로젝할 때 트리거를 언제 적용해봤냐? 그때 네가 느낀것들??






/*
인덱스, Index
- 색인(Index): 키워드 나열 -> 페이지 연결
- 검색(select)을 빠른 속도로 하기 위해서 사용하는 도구
- 특정 컬럼(키워드)만 모아놓은 별도의 테이블

- 하나의 테이블 > 데이터 많이 저장(백만단위 이상)
    1. 상단에 있는 레코드 접근 -> 접근 속도 빠름
    2. 하단에 있는 레코드 접근 -> 접근 속도 느림
    
- 인덱스 사용
    - select 작업이 테이블 대상으로 실행X
    - select 작업이 인덱스 대상으로 실행O
    
- 오라클은 테이블 생성 시 인덱스를 명시적으로 생성하지 않아도 자동으로 생성한다.
    - PK, Unique 제약이 붙은 컬럼은 자동으로 인덱스가 생성되낟.
    1. PK를 where절에 조건으로 select -> 속도 빠름
    2. 일반컬럼을 where절에 조건으로 select -> 속도 느림
    

    
*/

-- num(PK), name(일반컬럼)
select num from tblinsa;        --속도 동일
select name from tblinsa;       --속도 동일

select * from tblinsa where num = 1001;         --속도 빠름
select * from tblinsa where name = '홍길동';    --속도 느림


-- 제약 사항 복사X
create table tblindex
as
    select * from tbladdressbook;
    
    
select count(*) from tblindex;
insert into tblindex
    select * from tblindex;
    
    
    
-- 인덱스가 없는 상태에 검색
select name from tblindex where name = '홍길동';













