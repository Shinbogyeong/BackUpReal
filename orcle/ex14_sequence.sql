-- ex14_sequence.sql


/*

시퀀스, Sequence
- 데이터 베이스 객체 중 하나
- 식별자를 만드는데 주로 사용 > PK 컬럼에서 잘 사용
- 일련번호를 만들어서 제공하는 객체(중복되지 않은 번호)
- 오라클 전용

시퀀스 객체 만들기
- create sequence 시퀀스명;

시퀀스 객체 삭제하기
- drop sequence 시퀀스명;

시퀀스 객체 사용하기
- 시퀀스명.nectVal 함수
- 시퀀스명.currVal 함수
*/

create sequence seqNum;

select seqNum.nextVal from dual; --계수기

select 'A' || seqNum.nextVal from dual; --상품번호, 주문번호
select 'A' || trim(to_char(seqNum.nextVal,'000')) from dual; --A001, A002, A003

--
select seqNum.currVal from dual; --10(자바 Queue.peek())


/*

시퀀스 상세 설정

- create sequence 시퀀스명;
- create sequence 시퀀스명;
    increment by n -- 증감치(양수, 음수)
    start with n --시작값(seed)
    maxvalue n --최댓값(넘어가면 에러)
    minvalue n --최솟값(넘어가면 에러
    cycle --순환구조(PK 써먹기에 곤란함;;)
    cache n;

*/
drop sequence seqTest;

create SEQUENCE seqTest
        increment by 1
        start with 1
        maxvalue 10
        cycle
        cache 5;

select seqTest.nextVal from dual;


create sequence seqA
        maxvalue 10
        cycle 
        cache 5;
        
create sequence seqB
        maxvalue 5
        cycle
        cache 3;
        
select 'ABC' || trim(to_char(seqA.nextVal, '00')) || trim(to_char(SEQB.nextval, '00'))  from dual;
--ABC0101
--ABC0202
--ABC0505
--ABC0601
--ABC0702


drop sequence seqNum;

create sequence seqNum;

select seqNum.nextVal from dual;

--ORA-08002: sequence SEQNUM.CURRVAL is not yet defined in this session
--currVal함수는 반드시 1번 이상의 nextVal가 호출되야만 동작이 된다.
select seqNum.currVal from dual;

/*
오라클 서버를 중지하는 방법
1. win+R> services.msc > OracleServiceXE > 중지
2. 시작메뉴 > Stop Database
3. cmd > net stop OracleServiceXE

오라클 서버를 시작하는 방법
1. win+R> services.msc > OracleServiceXE > 시작 
2. 시작메뉴 > Start Database
3. cmd > net start OracleServiceXE
*/


drop sequence seqNum;

create sequence seqNum;

select seqNum.nextVal from dual;


/*

들여쓰기나 대소문자에 관해 표준이 되는 coding convention이 정해져 있는지도 궁금합니다.. 그냥 일하는 회사에 맞춰서 사용하면 될까요??
- 프로젝트 단위
*/