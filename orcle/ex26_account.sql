--ex26_account.sql


/*

계정
- DCL
- 계정 생성
- 리소스 접근 권한 제어

사용자 계정 생성하기
- 시스템 권한을 가지고 있는 계정만 할 수 있다.
    - 관리자만 가능(SYS, SYSTEM, 관리자 권한을 부여받은 계정 등)
    - 계정 생성 권한을 가지는 일반 계정
    
create user 계정명 identified by 암호;
alter user 계정명 identified by 암호;
alter user 계정명 account lock;
alter user 계정명 account unlick;
drop user 계정명;

*/

--ORA-01031: insufficient privileges
create user hong identified by java1234;

--system으로 접속
show user;

create user hong identified by java1234;

-- 계정 권한 조작
-- 1. grant 권한 to 계정
-- 2. revoke 권한 from 계정

-- 권한
-- 1. 권한
-- 2. 롤(Role): 권한의 집합

--grant create session to hong; --단일 권한 부여
grant connect, resource to hong; --롤(수많은 권한 집합), 가장 흔한 롤 부여
grant create view to hong;

show user;

DROP TABLE tblRegistrationStatus;
DROP TABLE registrationStatusSeq;

CREATE TABLE tblRegistrationStatus (
    registrationStatusSeq number NOT NULL,      -- 시험지등록번호(PK)
    registrationDate date NULL,                 -- 시험지등록날짜
    condition varchar2(15) NOT NULL            -- 시험지등록여부
--    openSubjectSeq number NOT NULL              -- 개설과목 고유번호(FK)
);

CREATE SEQUENCE registrationStatusSeq;   

ALTER TABLE tblRegistrationStatus
    ADD CONSTRAINT PK_TBLREGISTSTATUS PRIMARY KEY (registrationStatusSeq);

ALTER TABLE tblRegistrationStatus 
    ADD CONSTRAINT CK_TBLREGISTATUS_CONDITION CHECK(condition in ('등록','미등록'));   



INSERT INTO tblRegistrationStatus VALUES(registrationStatusSeq.nextval, null, '등록');

select * from tblRegistrationStatus;



CREATE TABLE nono (
    registrationStatusSeq number NOT NULL,      -- 시험지등록번호(PK)
    registrationDate  varchar2(100) NULL                 -- 시험지등록날짜
--    condition NOT NULL            -- 시험지등록여부
--    openSubjectSeq number NOT NULL              -- 개설과목 고유번호(FK)
);

INSERT INTO nono VALUES(1, 'Q1. System.out.print("10 + 20 = " + 10 + 20);');

select * from nono;









