--ex02_datatype.sql

/*

ANSI-SQL �ڷ���
- ����Ŭ �ڷ���
- �����ͺ��̽� > ������ > �ڷ���

1. ������
    - ���� + �Ǽ�
    a. number
        -(��ȿ�ڸ�) 38�ڸ� ������ ���ڸ� ǥ���ϴ� �ڷ���
        - 5~22byte
        - 1x10-130 ~ 9.999999x10 + 123
        - number(precision, scale)
            1. precision: �Ҽ� ���ϸ� ������ ��ü �ڸ���(1~38)
            2. scale: �Ҽ� ������ �ڸ���(0~127)
            ex) number -> 38�ڸ����� ǥ�� �����ϳ� ��� ����(����, �Ǽ� ����)
            ex) number(3) -> 3�ڸ����� ǥ�� ������ ����(����) -> -999 ~ +999
            ex) number(4,2) -> 4�ڸ����� ǥ�� ���� ����(�Ǽ�) -> -99.99 ~ +99.99
            ex) number(10,3) -> -9999999.999 ~ +9999999.999
        - ������ ���(���ͷ�)
            1. ����: 123
            2. �Ǽ�: 3.14
            
        - byte, int, float -> ����Ŭ? -> ��� X
            

*/

-- ���̺� �����ϱ�
drop table tblType;

-- ���̺� �����ϱ�
create table tblType (
    -- �÷� ����
    -- �÷��� �ڷ���
    
    --num number
    --num number(3)
    num number(4,2)

);



-- ���̺��� ��� ������ �������ÿ�.
select*from tblType;

-- ������ �߰��ϱ�
insert into tblType (num) values (100);
insert into tblType (num) values (200);
insert into tblType (num) values (300);
insert into tblType (num) values (99.99);
insert into tblType (num) values (99.99999999);
insert into tblType (num) values (3.14);
insert into tblType (num) values (9999); -- ORA-01438: value larger than specified precision allowed for this column
insert into tblType (num) values (12345.6789);
insert into tblType (num) values (1234567890123456789012345678901234567890); --38�ڸ�
insert into tblType (num) values (-1234567890123456789012345678901234567890);
insert into tblType (num) values (12345678901234567890123456789012345678901234567890);




/*

2. ������
    - ���� + ���ڿ�
    - �ڹ��� String�� ����
    - n(X) vs n(O)
    - var(X) vs var(O) -> var : ������ ũ�Ⱑ ���Ѵ�.
    
    a. char  (***********)
        - ���� �ڸ��� ���ڿ� -> �������� �����Ͱ� ª�Ƶ� ������ ������ �״�� �����Ѵ�.(��������)
        - char(n) : n�ڸ� ���ڿ�, n(����Ʈ)
            - �ּ� ũ��: 1����Ʈ
            - �ִ� ũ��: 2000����Ʈ
            ex) char  -> X
            ex) char(3)  -> �ִ� 3����Ʈ���� ���ڿ��� ���� -> ���ڵ�? -> ����(3����), �ѱ�(1����) utf8
            ex) char(10) -> �ִ� 10����Ʈ���� ���ڿ��� ���� -> ����(10����), �ѱ�(3����)
            ex) char(2000) -> ����(2000����), �ѱ�(666����)
    
    b. nchar
        - n : national > �����ڵ� ���� > UTF-16���� �����ϰڽ��ϴ�.(��繮�� -> 2����Ʈ ���)
        - nchar(n) : n�ڸ� ���ڿ�, n(���� ��)
            - �ּ� ũ��: 1����(2����Ʈ)
            - �ִ� ũ�� : 1000����(2000����Ʈ)
        - ��� �ƴ� ���ڸ� ������ �� ����
    
    c. varchar2 (***************************)
        - ���� �ڸ��� ���ڿ� -> ������ ũ�⸸ŭ ������ ũ�Ⱑ �پ���.
        - varchar2(n) : n�ڸ� ���ڿ�, n(����Ʈ)
            - �ּ� ũ�� : 1����Ʈ
            - �ִ� ũ�� : 4000����Ʈ
    
    d. nvarchar2
    
    lob(Large Object)
    
    e. clob, nclob
        - ��뷮 �ؽ�Ʈ ���� �ڷ���
        - 128TB
        - �� ��� ����, ������(�ӵ�����)
        
        
        
3. ��¥/ �ð���
    - �ڹ� Calendar, Date
    a. date (*****)
        - ����Ͻú���
        - 7byte
        - ����� 4712�� 1�� 1�� ~ 9999�� 12�� 31��
    
    b. timestamp
        - ����Ͻú��� + �и���(������)
        
        2020-05-12 12:30
        
    c. interval
        - ƽ��
        - �ð�
        - number ���
    
4. ���� ������ �ڷ���
    - �� �ؽ�Ʈ ������
    - �̹���, ����, ���� ��....
    a. blob
        - 128TB
        
    �Խ��� -> ÷�� ���� -> ÷�� ���ϸ�(+���) -> ���ڿ� - varchar2
    
    
    
number + varchar2 + date


*/



drop table tblType;


create table tblType (
    --name char(3),
    --name char(10),
    --nick varchar2(10)
    
    name char(10),
    nick nchar(10)

);



select*from tblType;

-- ������ �߰��ϱ�
insert into tblType (name) values ('abc');
insert into tblType (name) values ('abcd'); --ORA-12899: value too large for column "HR"."TBLTYPE"."NAME" (actual: 4, maximum: 3)
insert into tblType (name) values ('��');
insert into tblType (name) values ('ȫ�浿');--(actual: 9, maximum: 3)
insert into tblType (name) values ('123');
insert into tblType (name) values ('@#$%');

insert into tblType (name, nick) values ('ȫ�浿', '�ٺ�');
insert into tblType (name, nick) values ('��', '��');

-- char -> 'abc       '
-- varchar2-> 'abc'
insert into tblType (name, nick) values ('abc', 'abc');

inset into tblType (name, nick) values ('ȫ�浿', 'ȫ�浿');








drop table tblType;

create table tblType (
    
    name varchar2(30),
    age number(3),
    birthday date

);

insert into tblType (name, age, birthday) values ('ȫ�浿', 20, '1995-5-15');

select * from tblType;












