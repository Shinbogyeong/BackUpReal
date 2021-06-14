--ex30_plsql.sql


/*
PL/SQL


ANSI-SQL
- 비 절차성 언어(명령어간의 순서가 없다. 흐름이 없다.) -> 제어 흐름이 없다. 문장 단위의 독립적인 언어


PL/SQL
- Procedural Language Extension to SQL
- 절차성 언어
- 흐름과 제어를 추가
- ANSI  SQL 모두 지원

PL/SQL = ANSI-SQL + 확장(제어구조)


프로시저, Procedure
- 메소드, 함수, 서브루틴 등..
- 순서가 있는 코드의 집합

1. 익명 프로시저
    - 1회용
    - 오라클에 저장 X
    
2. 실명 프로시저
    - 반복용
    - 저장 프로시저
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
    - begin ~end : 블럭 역할
    - 프로시저 구현 코드를 작성하는 영역(메소드 body역할)
    - 생략 불가능
    - 업무 관련 코드 작성 : ANSI-SQLR + 영ㄴ산, 제어추가(PL/SQL 구문)
    - try절 역할
    
4. exception
    - 예외 처리부
    - catch절 역할
    - 예외 처리 코드를 작성하는 영역
    - 생략 사능
5. end
    - 실행부(구현부)
    - 생략 불가능
    
PL/SQL

1. 자료형
    - ANSI-SQL과 동일(확장)
    
2. 변수 선언하기
    - 변수명 자료형 [not null] [pdefault 값];
    - name varchar2(100) not null
    - ANSI-SQL에서 테이블의 컬럼을 선언하는 방식과 유사
    - 변수는 주로 질의의 결과(***)나 인자값을 저장하는 용도로 사용
    
3. 대입연산
    - 컬럼명 = 값 //ANSI.update
    - 변수명 : = 값 //PL/SQl
  
  
dbms_output.put_line(num)
- 기본적으로 꺼진 상태

set serveroutput on;
set serveroutput off;
    
*/




declare
    num number;
begin 
    num := 10;
    dbms_output.put_line(num);--syso
end;





-- 프로시저 생성 + ANSI-SQL(select) + 결과(PL/SQL 변수에 저장)

declare
    vname varchar2(15);
    vbasicpay number;
begin
    select name,basicpay into vname, vbasicpay from tblinsa
        where basicpay = (select max(basicpay) from tblinsa);
        
        dbms_output.put_line(vname);
        dbms_output.put_line(vbasicpay);
end;



create table tbltemp
as
select name, buseo, jikwi, city from tblinsa where city = '서울';


select * from tbltemp;

--tblinsa -> 연봉 1위(select) -> tbltemp 추가(insert)
--shift + f4보여줌 팝업으루

declare
    vname varchar2(15); 
    vbuseo varchar2(15);
    vjikwi varchar2(15);
    vcity   varchar2(15);
begin
    --1.
   select name, buseo, jikwi, city into vname, vbuseo, vjikwi, vcity from tblinsa
        where basicpay = (select max(basicpay) from tblinsa); 
        
        
    --2.
    insert into tbltemp (name, buseo, jikwi, city) values (vname, vbuseo, vjikwi, vcity);
end;


select * from tbltemp;




--tblinsa. 연봉 꼴지 -> 같은 부서 직원을 tbltemp삭제
declare
    vbuseo varchar2(15);
begin

    --1.
     select buseo into vbuseo from tblinsa
        where basicpay = (select max(basicpay) from tblinsa); 
        
        
    --2.
    delete from tbltemp where buseo = vbuseo;
end;






/*
참조 자료형
- 테이블로부터 직접 자료형을 알아내는 방법
- 생산성 + 유지보수성

1. %type
    - 사용하는 테이블의 특정 컬럽 자료형을 그대로 참조해서 변수에 적용
    a. 자료형
    b. 길이
    c. not null
    
2. %row


*/

declare
    vname varchar2(20);
    vssn tblinsa.ssn%type; --실제 테이블 컬럼 자료형을 그대로 참조해서 자료형을 복사해 온다.
    vsudang tblinsa.sudang%type;
begin
    select name, ssn, sudang into vname, vssn, vsudang from tblinsa where name ='홍길동';
    dbms_output.put_line(vname);
    dbms_output.put_line(vssn);
    dbms_output.put_line(vsudang);
end;

declare
    --변수 10개
    vnum tblinsa.num%type;
    vname tblinsa.name%type;
    vssn tblinsa.ssn%type;
    vibsadate tblinsa.ibsadate%type;
    vcity tblinsa.city%type;
    vtel tblinsa.tel%type;
    vbuseo tblinsa.buseo%type;
    vjikwi tblinsa.jikwi%type;
    vbasicpay tblinsa.basicpay%type;
    vsudang tblinsa.sudang%type;
begin
    select * into vnum, vname, vssn, vibsadate, vcity ,vtel, vbuseo, vjikwi, vbasicpay, vsudanggfg \ from tblinsa where name = '홍길동';
.\end








