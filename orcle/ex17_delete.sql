-- ex17_delete.sql


/*

delete문
- DML
- 데이터를 삭제하는 명령어(레코드, 행)
- delete [from] 테이블명 [where절]
*/

commit;
rollback;

select * from tblcountry;

delete from tblcountry;
delete from tblcountry where Continent = 'AS';
delete from tblcountry where name = '대한민국';