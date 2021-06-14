-- ex22_union.sql

/*

join
- 테이블을 합치는 기술
- 횡(가로) : 테이블의 컬럽괃 다른 테이블의 컬럼을 더하는 작업

unoin
- union, union all, intersect, minus
- 테이블을 합치는 기술
- 종(세로) : 테이블의 레코드와 다른 테이블의 레코드를 더하는 작업
- 수학 집합 개념 지원(합집합, 교집합, 차집합...)



*/

select * from tblMen;
select * from tblWomen;

select * from tblMen m
    inner join tblWomen w
        on m.couple = w.name;
        
-- 데이터베이스 연산
-- union
-- 1. 컬럼의 개수
-- 2. 컬럼의 타입
-- 1과 3가 불일치 하면 union 실패
select * from tblMen
union -- +
select * from tblWomen;


create table tblUnionA (
    color varchar2(30) not null
);
    

create table tblUnionB (
    color varchar2(30) not null
);

insert into tbluniona values('red');
insert into tbluniona values('yellow');
insert into tbluniona values('blue');
insert into tbluniona values('black');
insert into tbluniona values('white');

insert into tblunionb values('orange');
insert into tblunionb values('green');
insert into tblunionb values('skyblue');
insert into tblunionb values('yellow');
insert into tblunionb values('red');


-- union: 두테이블을 합쳤을 때 중복되는 행을 자동으로 제거
select * from tblunionA
union
select * from tblunionB;

--union all: 두 테이블을 합쳤을 때 중복되는 행을 그대로 포함
select * from tblunionA
union all
select * from tblunionB;

--intersect : 두 테이블을 합쳤을 때 중복되는 행만 포함
select * from tblunionA
intersect
select * from tblunionB;

-- minus: A- B
select * from tblunionA
minus
select * from tblunionB;
