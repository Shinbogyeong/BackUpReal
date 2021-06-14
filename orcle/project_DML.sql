/*
[4번]
10. 취업 현황 관리 - (관리자, 교육생)
11. 상담일지 - ( 관리자, 교사 별)
12. 만족도 조사 - (관리자, 교사별, 교육생)
*/
--취업현황더미에 분야추가 하기



--------------------------[관리자, 취업현황]-----------------------------------
/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회]
- 전체 과정의 목록을 출력한다.
    - 과정 고유번호
    - 교육생 정원
    - 과정명
    - 과정 시작 날짜
    - 과정 종료 날짜
*/

select
    oc.openCourseSeq as "개설과정 고유번호",       --개설과정고유번호
    oc.registercount as "교육생등록인원" ,         --교육생등록인원
    tc.name as "과정명",                           --과정명
    oc.begindate as "과정시작날짜",                --과정시작날짜
    oc.enddate as "과정종료날짜"                    --과정종료날짜
     
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq;
        
        
/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회] > [특정 과정 조회]
- 특정 과정을 수강했던 교육생 목록을 출력한다.
    - 교육생 이름
    - 회사 이름
    - 분야
    - 연봉
    - 근무지역
*/
select
    cs.completeStudentSeq as "종료교육생고유번호",
    st.name as "교육생 이름",            --교육생 이름
    em.companyname as "회사 이름",       --회사 이름
    em.annualincome as "연봉",          --연봉
    em.area as "근무지역"                --근무지역
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq
            inner join tblEnrollment en
                on en.opencourseseq = oc.opencourseseq
                inner join tblStudent st
                    on en.studentSeq = st.studentSeq
                        inner join tblCompleteStudent cs
                            on en.enrollmentSeq = cs.enrollmentSeq
                                inner join tblEmployment em
                                    on em.completeStudentSeq = cs.completeStudentSeq
                                        where oc.openCourseSeq = 1; -- 선택한 과정 번호 넣기

/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회] > [특정 과정 조회] > [취업 현황 추가]
- 특정 과정을 수강했던 교육생 목록을 추가한다.
    - 회사 이름
    - 분야
    - 연봉
    - 근무지역
    - 교육종료교육생고유번호
*/
--INSERT INTO tblemployment (employmentSeq, companyName, annualincome, area, completestudentseq) VALUES (employmentSeq.nextval,'회사이름','연봉','근무지역', 교육종료교육생고유번호);


/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회] > [특정 과정 조회] > [취업 현황 수정]
- 특정 과정을 수강했던 교육생 목록을 수정한다.
    - 회사 이름
    - 분야
    - 연봉
    - 근무지역
    - 교육종료교육생고유번호
*/
--update tblemployment set
--    companyName = '회사이름', 
--    annualincome = '연봉', 
--    area = '근무지역'
--where completestudentseq = 교육종료교육생 번호;


/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회] > [특정 과정 조회] > [취업 현황 삭제]
- 선택한 특정 교육생의 취업 현황 데이터를 모든 테이블에서 삭제한다.
    - 회사 이름
    - 분야
    - 연봉
    - 근무지역
*/
--delete from tblemployment where completestudentseq = 교육종료교육생 번호;





--------------------------[교육생, 취업현황]-----------------------------------
/*
[메인] > [교육생] > [취업 현황 조회] > [전체 과정 조회]
- 전체 과정의 목록을 출력한다.
    - 과정 고유번호
    - 교육생 정원
    - 과정명
    - 과정 시작 날짜
    - 과정 종료 날짜
*/

select
    oc.openCourseSeq as "개설과정 고유번호",       --개설과정고유번호
    oc.registercount as "교육생정원" ,             --교육생정원
    tc.name as "과정명",                           --과정명
    oc.begindate as "과정시작날짜",                --과정시작날짜
    oc.enddate as "과정종료날짜"                    --과정종료날짜
     
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq;
        
        
/*
[메인] > [관리자] > [취업 현황 관리] > [전체 과정 조회] > [특정 과정 조회]
- 특정 과정을 수강했던 교육생 목록을 출력한다.
    - 교육생 이름
    - 회사 이름
    - 분야
    - 연봉
    - 근무지역
*/
-- 이름 앞글자만 출력하기!!
select
    substr(st.name, 1,1) || 'OO' as "교육생 이름",            --교육생 이름
    em.companyname as "회사 이름",       --회사 이름
    em.annualincome as "연봉",          --연봉
    em.area as "근무지역"                --근무지역
from tblOpenCourse oc
    inner join tblTotalCourse tc
        on oc.totalCourseSeq = tc.totalCourseSeq
            inner join tblEnrollment en
                on en.opencourseseq = oc.opencourseseq
                inner join tblStudent st
                    on en.studentSeq = st.studentSeq
                        inner join tblCompleteStudent cs
                            on en.enrollmentSeq = cs.enrollmentSeq
                                inner join tblEmployment em
                                    on em.completeStudentSeq = cs.completeStudentSeq
                                        where oc.openCourseSeq = 1; -- 선택한 과정 번호 넣기
                                        
     
     
                                        
--------------------------[관리자, 상담일지]-----------------------------------      

/*
[메인] > [관리자] > [상담일지] 

1. [전체 개설과정 조회]
- 전체 과정의 정보를 출력한다.
  - 과정 고유 번호
  - 과정명
  - 교사명
  - 과정 시작 날짜
  - 과정 종료 날짜
  - 강의실명
*/

select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    t.name as "교사명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜",
    cr.name as "강의실명"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq
        inner join tblteacher t
        on oc.teacherseq = t.teacherseq
            inner join tblclassroom cr
            on oc.classroomseq = cr.classroomseq;


/*
[메인] > [관리자] > [상담일지] 
1.1. [전체 개설과정 조회] > [특정 개설 과정 별 교육생 조회]
- 전체 교육생의 정보를 출력한다.
  - 고유 교육생 번호
  - 교육생 이름
  - 과정명
  - 교사명
  - 상담 날짜
  - 상담 내용
*/
select
    s.studentseq as "고유 교육생 번호",
    s.name as "교육생이름",
    tc.name as "과정명",
    cd.counselingdate as "상담날짜",
    cd.content as "상담내용"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq
        inner join tblteacher t
        on oc.teacherseq = t.teacherseq
            inner join tblenrollment en
            on oc.opencourseseq = en.opencourseseq
                inner join tblCounselingDiary cd
                on en.enrollmentSeq = cd.enrollmentseq
                    inner join tblstudent s
                    on en.studentSeq = s.studentSeq
                        where oc.opencourseseq = 1; --특정 개설과정 고유번호 입력






--------------------------[교사, 상담일지]-----------------------------------   

/*
[메인] > [교사] > [상담일지] 

1. [전체 개설과정 조회]
- 전체 과정의 정보를 출력한다.
  - 과정 고유 번호
  - 과정명
  - 교사명
  - 과정 시작 날짜
  - 과정 종료 날짜
  - 강의실명
*/
select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    t.name as "교사명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜",
    cr.name as "강의실명"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq
        inner join tblteacher t
        on oc.teacherseq = t.teacherseq
            inner join tblclassroom cr
            on oc.classroomseq = cr.classroomseq;
            
/*
[메인] > [교사] > [상담일지] 

1.1. [전체 개설과정 조회] >  [특정 개설과정 별 교육생 조회]
- 전체 교육생의 정보를 출력한다.
  - 고유 교육생 번호
  - 교육생 이름
  - 과정명
  - 교사명
  - 상담 날짜
  - 상담 내용

*/            
            
select
    s.studentseq as "고유 교육생 번호",
    s.name as "교육생이름",
    tc.name as "과정명",
    cd.counselingdate as "상담날짜",
    cd.content as "상담내용"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq
        inner join tblteacher t
        on oc.teacherseq = t.teacherseq
            inner join tblenrollment en
            on oc.opencourseseq = en.opencourseseq
                inner join tblCounselingDiary cd
                on en.enrollmentSeq = cd.enrollmentseq
                    inner join tblstudent s
                    on en.studentSeq = s.studentSeq
                        where oc.opencourseseq = 1; --특정 개설과정 고유번호 입력


/*
[메인] > [교사] > [상담일지] 

1.1.1. [전체 개설과정 조회] >  [특정 개설과정 별 교육생 조회] > [특정 교육생 상담일지 추가]
    - 특정 교육생의 상담일지 추가한다. 
      - 상담 날짜
      - 상담 내용
*/         

--INSERT INTO tblCounselingDiary(counselingDiarySeq, counselingDate, content, enrollmentSeq) VALUES(counselingDiarySeq.nextval, '상담날짜', '상담내용', 수강신청고유번호);


/*
1.1.2. [전체 개설과정 조회] >  [특정 개설과정 별 교육생 조회] > [특정 교육생 상담일지 수정]
    - 특정 교육생의 상담일지 수정한다. 
      - 상담 날짜
      - 상담 내용
*/
update tblcounselingdiary set
    counselingDate = '상담날짜',
    content = '상담내용'
where counselingDiarySeq = 1; -- 수정하고 싶은 상담일지교유번호 입력 or 교육생번호


/*
[메인] > [교사] > [상담일지] 

1.1.1. [전체 개설과정 조회] >  [특정 개설과정 별 교육생 조회] > [특정 교육생 상담일지 삭제]
    - 선택한 특정 교육생의 상담 일지를 모든 테이블에서 삭제한다.
*/ 
delete from tblcounselingdiary where counselingDiarySeq = 1; -- 수정하고 싶은 상담일지교유번호 입력



--------------------------[관리자, 만족도 조사]-----------------------------------  

/*
[메인] > [관리자] > [만족도 조사 결과 조회]

1. [전체 개설 과정 조회 - 강의평가]
    - 개설 과정 고유 번호
    - 개설 과정 이름
    - 개설 과정 시작 날짜
    - 개설 과정 종료 날짜
*/

select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq;
    
    
/*
[메인] > [관리자] > [만족도 조사 결과 조회]

1.1 [전체 개설 과정 조회 - 강의평가] > [특정 개설 과정 조회]
        - 개설 과목 이름
        - 개설 과목 기간(시작 년월일)
        - 개설 과목 기간(종료 년월일)
*/

select
    os.opensubjectseq as "개설과목고유번호",
    ts.name as "개설과목이름",
    os.begindate as "개설과목 시작날짜",
    os.enddate as "개설과목 종료날짜"
from tblopencourse oc
    inner join tblopensubject os
    on oc.opencourseseq = os.opencourseseq
        inner join tbltotalsubject ts
        on os.totalsubjectseq  = ts.totalsubjectseq
            where oc.opencourseseq = 1; --개설과정고유번호 입력


/*
[메인] > [관리자] > [만족도 조사 결과 조회]

1.1.1. [전체 개설 과정 조회 - 강의평가] > [특정 개설 과정 조회] > [특정 과목 조회]
            - 강의평가 고유번호
            - 과목 이름
            - 교육생이름
            - 평가 내용
            - 만족도(점수) -> 만족도(점수) 전체 평균
*/
select
    cs.coursesurveyseq as "강의평가 고유번호",
    ts.name as "개설과목이름",
    s.name as "교육생이름",
    cs.surveycomment as "평가내용",
    cs.score as "점수"
    
from tblenrollment en
    inner join tblstudent s
    on en.studentseq = s.studentseq
        inner join tblcoursesurvey cs
        on en.enrollmentseq = cs.enrollmentseq
            inner join tblopensubject os
            on cs.opensubjectseq = os.opensubjectseq
                inner join tbltotalsubject ts
                on os.totalsubjectseq = ts.totalsubjectseq
                    where os.opensubjectseq = 1; --개설과목고유번호 입력


/*
[메인] > [관리자] > [만족도 조사 결과 조회]

1.1.1.1. [전체 개설 과정 조회 - 강의평가] > [특정 개설 과정 조회] > [특정 과목 조회] > [특정 과목 삭제]
          - 선택한 특정 과목의 데이터를 모든 테이블에서 삭제한다.
*/
delete from tblcoursesurvey where coursesurveyseq = 1; --강의평가고유번호 입력


/*
[메인] > [관리자] > [만족도 조사 결과 조회]

2. [전체 개설 과정 조회 - 교사평가]
    - 개설 과정 고유 번호
    - 개설 과정 이름
    - 개설 과정 시작 날짜
    - 개설 과정 종료 날짜
*/
select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq;
 

/*
[메인] > [관리자] > [만족도 조사 결과 조회]

2.1. [전체 개설 과정 조회 - 교사평가] > [특정 개설 과정 조회]
        - 개설 과정 이름
        - 느낀점
*/
select 
    tc.name as "개설 과정 이름",
    ts.teachersurveyseq as "교사평가 고유번호",
    ts.studentcomment as "느낀점"
    
from tblenrollment en
    inner join tblteachersurvey ts
    on en.teachersurveyseq = ts.teachersurveyseq
        inner join tblopencourse oc
        on en.opencourseseq = oc.opencourseseq
            inner join tbltotalcourse tc
            on oc.totalcourseseq = tc.totalcourseseq
                    where oc.opencourseseq = 1; -- 특정 개설과정 입력

/*
[메인] > [관리자] > [만족도 조사 결과 조회]

2.1.1 [전체 개설 과정 조회 - 교사평가] > [특정 개설 과정 조회] > [특정 교사평가 삭제]
          - 선택한 특정 교사평가 데이터를 모든 테이블에서 삭제한다.  
*/
delete from tblteachersurvey where teachersurveyseq = 1; --특정교사평가 고유번호를 입력한다.





--------------------------[교사, 만족도 조사]-----------------------------------  

/*
[메인] > [교사] > [만족도 조사 결과 조회]

1. [전체 개설 과정 조회 - 강의평가]
    - 개설 과정 고유 번호
    - 개설 과정 이름
    - 개설 과정 시작날짜
    - 개설 과정 종료날짜
*/
select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq;
    
    
/*
[메인] > [교사] > [만족도 조사 결과 조회]

1.1. [전체 개설 과정 조회 - 강의평가] > [특정 개설 과정 조회]
        - 개설과목고유번호
        - 개설 과목 이름
        - 개설 과목 시작날짜
        - 개설 과목 종료날짜
*/
select
    os.opensubjectseq as "개설과목고유번호",
    ts.name as "개설과목이름",
    os.begindate as "개설과목 시작날짜",
    os.enddate as "개설과목 종료날짜"
from tblopencourse oc
    inner join tblopensubject os
    on oc.opencourseseq = os.opencourseseq
        inner join tbltotalsubject ts
        on os.totalsubjectseq  = ts.totalsubjectseq
            where oc.opencourseseq = 1; --개설과정고유번호 입력

/*
[메인] > [교사] > [만족도 조사 결과 조회]

1.1.1. [전체 개설 과정 조회 - 강의평가] > [특정 개설 과정 조회] > [특정 과목 조회]
            - 과목 이름
            - 평가 내용
            - 만족도(점수) -> 만족도(점수) 전체 평균
*/
select 
    tc.name as "개설 과정 이름",
    ts.teachersurveyseq as "교사평가 고유번호",
    ts.studentcomment as "느낀점"
    
from tblenrollment en
    inner join tblteachersurvey ts
    on en.teachersurveyseq = ts.teachersurveyseq
        inner join tblopencourse oc
        on en.opencourseseq = oc.opencourseseq
            inner join tbltotalcourse tc
            on oc.totalcourseseq = tc.totalcourseseq
                    where oc.opencourseseq = 1; -- 특정 개설과정 입력
                    
                    
/*
[메인] > [교사] > [만족도 조사 결과 조회]
2. [전체 개설 과정 조회 - 교사평가]
    - 개설 과정 고유 번호
    - 개설 과정 이름
    - 개설 과정 시작날짜
    - 개설 과정 종료날짜

*/
select
    os.opensubjectseq as "개설과목고유번호",
    ts.name as "개설과목이름",
    os.begindate as "개설과목 시작날짜",
    os.enddate as "개설과목 종료날짜"
from tblopencourse oc
    inner join tblopensubject os
    on oc.opencourseseq = os.opencourseseq
        inner join tbltotalsubject ts
        on os.totalsubjectseq  = ts.totalsubjectseq
            where oc.opencourseseq = 1; --개설과정고유번호 입력

/*
[메인] > [교사] > [만족도 조사 결과 조회]
2.1. [전체 개설 과정 조회 - 교사평가] > [특정 개설 과정 조회]
        - 개설 과목 이름
        - 개설 과목 시작날짜
        - 개설 과목 종료날짜
        - 느낀점

*/
select 
    tc.name as "개설 과정 이름",
    ts.teachersurveyseq as "교사평가 고유번호",
    ts.studentcomment as "느낀점"
    
from tblenrollment en
    inner join tblteachersurvey ts
    on en.teachersurveyseq = ts.teachersurveyseq
        inner join tblopencourse oc
        on en.opencourseseq = oc.opencourseseq
            inner join tbltotalcourse tc
            on oc.totalcourseseq = tc.totalcourseseq
                    where oc.opencourseseq = 1; -- 특정 개설과정 입력




--------------------------[교육생, 만족도 조사]-----------------------------------  
/*
[메인] > [교육생] > [만족도 조사]

1. [강의 평가]
    - 수료한 모든 과목의 목록을 출력한다.
        - 과목명
        - 과목 기간(시작 년월일)
        - 과목 기간(종료 년월일)
*/
select
    os.opensubjectseq as "개설과목고유번호",
    ts.name as "개설과목이름",
    os.begindate as "개설과목 시작날짜",
    os.enddate as "개설과목 종료날짜"
from tblopencourse oc
    inner join tblopensubject os
    on oc.opencourseseq = os.opencourseseq
        inner join tbltotalsubject ts
        on os.totalsubjectseq  = ts.totalsubjectseq
            where oc.opencourseseq = 1; --개설과정고유번호 입력
            
/*
[메인] > [교육생] > [만족도 조사]

1.1. [강의 평가] >[특정 과목 선택]
            - 평가 내용을 입력한다.
            - 만족도(점수)를 입력한다.
*/
--INSERT INTO tblCourseSurvey VALUES(courseSurveySeq.nextVal, '평가내용', 평가점수, 개설과목 고유번호, 수강신청고유번호);


/*
[메인] > [교육생] > [만족도 조사]
2. [교사 평가]
    - 과정명 출력
    - 과정 기간(시작 년월일) 출력
    - 과정 기간(종료 년월일) 출력
    - 교사명 출력
    - 느낀점
*/
select
    oc.opencourseseq as "개설과정 고유번호",
    tc.name as "과정명",
    oc.begindate as "과정 시작 날짜",
    oc.enddate as "과정 종료 날짜"
from tblopencourse oc
    inner join tbltotalcourse tc
    on oc.totalcourseseq = tc.totalcourseseq;

update tblTeacherSurvey set
    teacherSurveySeq = 교사평가고유번호,
    studentComment = '느낀점',
where teacherSurveySeq = 1; --해당 교사평가고유번호 입력




/*
교육생 로그인하기
*/

create or replace procedure procLoginStudent
(
    pid in number,    --아이디
    ppw in number,     --비밀번호
    presult out number  --성공(1), 실패(0)
)
is
    vid number;
    vpw number;
    
begin

    select studentseq into vid from tblstudent where (studentseq = pid and ssn = ppw);
    select ssn into vpw from tblstudent where (studentseq = pid and ssn = ppw);
    
    if vid > 0 then 
        presult := 1;
        dbms_output.put_line('로그인 성공');
        
--    elsif  then
--        presult := 0;
--        dbms_output.put_line('로그인 실패');
    end if;
    
    exception when others then dbms_output.put_line('로그인 실패');
end procLoginStudent;
/

declare
    presult number;
begin
    procLogin(관리자id, 관리자pw, presult);
end;
/
--id : studentseq 1, pw : ssn 2716495



/*
교육생 로그인하기
*/

create or replace procedure procLoginManager
(
    pid in number,    --아이디
    ppw in number,     --비밀번호
    presult out number  --성공(1), 실패(0)
)
is
    vid number;
    vpw number;
    
begin

    select managerseq into vid from tblmanager where (managerseq = pid and managerpw = ppw);
    select managerpw into vpw from tblmanager where (managerseq = pid and managerpw = ppw);
    
    if vid > 0 then 
        presult := 1;
        dbms_output.put_line('로그인 성공');
      
    end if;
    
    exception when others then dbms_output.put_line('로그인 실패');
end procLoginManager;
/

declare
    presult number;
begin
    procLogin(교육생번호, 교육생ssn, presult);
end;
/



/*
교사 로그인하기
*/

create or replace procedure procLoginManager
(
    pid in number,    --아이디
    ppw in number,     --비밀번호
    presult out number  --성공(1), 실패(0)
)
is
    vid number;
    vpw number;
    
begin

    select teacherseq into vid from tblteacher where (teacherseq = pid and ssn = ppw);
    select ssn into vpw from tblteacher where (teacherseq = pid and ssn = ppw);
    
    if vid > 0 then 
        presult := 1;
        dbms_output.put_line('로그인 성공');
      
    end if;
    
    exception when others then dbms_output.put_line('로그인 실패');
end procLoginManager;
/

declare
    presult number;
begin
    procLogin(교사번호, 교사ssn, presult);
end;
/




INSERT INTO tblAttendance (attendanceSeq, AttendanceDate, inTime, outTime, condition, studentSeq)
values (attendanceSeq.nextVal, '2021-03-02', '09:15', '17:51', '지각', 61);

/*교육생 입실찍기*/
create or replace procedure procAttendin(
    pid in varchar2
)
is
begin
    if to_char(sysdate, 'hh24:mi') > '09:10' then
        update  tblAttendance set 
        inTime = to_char(sysdate, 'hh24:mi'),
        condition = '지각'
        where studentSeq =  pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
    else
        update  tblAttendance set 
        inTime = to_char(sysdate, 'hh24:mi'),
        condition = '정상'
        where studentSeq =  pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
    end if;
end procAttendin;


/

set serveroutput on;
/
begin
    procAttendin(61);
end;
/
SELECT * FROM TBLATTENDANCE WHERE STUDENTSEQ = 61 AND ATTENDANCEDATE = TO_CHAR(SYSDATE, 'YY-mm-dd');
/

rollback;
/*교육생 퇴실찍기*/
create or replace procedure procAttendout(
    pid in varchar2
)
is
begin
    if to_char(sysdate, 'hh24:mi') > '17:50'  then -- 정상퇴실

        update tblAttendance set
            outTime = to_char(sysdate, 'hh24:mi')
                where studentseq = pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
        
    elsif to_char(sysdate, 'hh24:mi') < '17:50' then -- 조퇴
    
        update tblAttendance set
            outTime = to_char(sysdate, 'hh24:mi'),
            condition = '조퇴'
                where studentseq = pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
            
    end if;
end procAttendout;
/
commit;
/
begin
procAttendout(61);
end;
/
rollback;


--(확인)
begin
    procAttendgoout(61);
end;



--end;
--/
--SELECT * FROM TBLATTENDANCE WHERE STUDENTSEQ = 1 AND ATTENDANCEDATE = TO_CHAR(SYSDATE, 'YY-mm-dd');

/*교육생 월별 출결 조회*/
create or replace procedure procAttendout(
    pid in varchar2
)
is
begin
    if to_char(sysdate, 'hh24:mi') > '17:50'  then -- 정상퇴실

        update tblAttendance set
            outTime = to_char(sysdate, 'hh24:mi')
                where studentseq = pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
        
    elsif to_char(sysdate, 'hh24:mi') < '17:50' then -- 조퇴
    
        update tblAttendance set
            outTime = to_char(sysdate, 'hh24:mi'),
            condition = '조퇴'
                where studentseq = pid and attendancedate = to_char(sysdate, 'yy-mm-dd');
            
    end if;
end procAttendout;
/
commit;
--begin
--procAttendout(1);
--end;
/

create or replace procedure procAttendanceM(
    pid varchar2,
    pyear varchar2,
    pmonth varchar2
)
is
    cursor vcursor
        is select attendancedate, intime, outtime, condition, studentseq from tblattendance;
    vattendancedate tblattendance.attendancedate%type;
    vintime tblattendance.intime%type;
    vouttime tblattendance.outtime%type;
    vcondition tblattendance.condition%type;
    vstudentseq tblattendance.studentseq%type;
    
    vnormal number;
    vlate number;
    vearlyout number;
    vabscent number;
    vother number;
    vout number;
begin
 open vcursor;

        
        loop
            -- select name, capital, population into vname, vcapital, vpopulation
            fetch vcursor into vattendancedate, vintime, vouttime, vcondition, vstudentseq;
            exit when vcursor%notfound;
            
            if vstudentseq = pid and to_char(vattendancedate, 'mm') = pmonth and to_char(vattendancedate, 'yyyy')= pyear
            then
                if vcondition in ('정상', '지각', '조퇴', '기타') then
                    dbms_output.put_line('출결날짜: '||vattendancedate||',   
                    시간: '||vintime||',   퇴실시간: '||vouttime||',   출결상태: '||vcondition||',   학생번호: '||vstudentseq);
                elsif vcondition in ('결석', '외출') then
                    dbms_output.put_line('출결날짜: '||vattendancedate||',   출결상태: '||vcondition||',   학생번호: '||vstudentseq);
                end if;
            end if;
                        
        end loop;
    close vcursor;  
    
    select count(*) into vnormal from twhere studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '정상';
    
    select count(*) into vlate from tblattendance 
    where studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '지각';
    
    select count(*) into vearlyout from tblattendance 
    where studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '조퇴';
    
    select count(*) into vabscent from tblattendance 
    where studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '결석';
    
    select count(*) into vout from tblattendance 
    where studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '외출';
    
    select count(*) into vother from tblattendance 
    where studentseq = pid and to_char(attendancedate, 'mm') = pmonth and to_char(attendancedate, 'yyyy')= pyear and condition = '기타';
    
    dbms_output.put_line(' ');
    dbms_output.put_line(pyear||'년'|| pmonth||'월별 출결');
    dbms_output.put_line('정상출결 횟수: '||vnormal );
    dbms_output.put_line('지각출결 횟수: '||vlate );
    dbms_output.put_line('조퇴출결 횟수: '||vearlyout );
    dbms_output.put_line('결석출결 횟수: '||vabscent );
    dbms_output.put_line('외출출결 횟수: '||vout );
    dbms_output.put_line('기타출결 횟수: '||vother );
    
end procAttendanceM;


/

begin
procAttendanceM(61, 2021, '05');
end;

/


/*성별 구분 함수*/
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

select name, fnGender(ssn), ssn 
from tblStudent;

/

/*교사 수정 프로시저*/
create or replace procedure procTeacherModify (
    pseq number,   --교사번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblteacher set name = pinput where teacherseq= pseq;
    elsif pnum = 2 then update tblteacher set ssn = pinput where teacherseq= pseq;
    elsif pnum = 3 then update tblteacher set phoneNumber = pinput where teacherseq= pseq;
    elsif pnum = 4 then update tblteacher set condition = pinput where teacherseq= pseq;
    end if;
end procTeacherModify;
/

begin
procTeacherModify(1, 1, '채제원');
end;
/


select * from tblteacher;
/


/*교육생 수정 프로시저*/
create or replace procedure procStudentModify (
    pseq number,   --교육생번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblStudent set name = pinput where studentseq= pseq;
    elsif pnum = 2 then update tblStudent set phoneNumber = pinput where studentseq= pseq;
    elsif pnum = 3 then update tblStudent set ssn = pinput where studentseq= pseq;
    elsif pnum = 4 then update tblStudent set enrollDate = pinput where studentseq= pseq;
    elsif pnum = 5 then update tblStudent set birth = pinput where studentseq= pseq;
    elsif pnum = 6 then update tblStudent set condition = pinput where studentseq= pseq;
    elsif pnum = 7 then update tblStudent set dropDate = pinput where studentseq= pseq;
    end if;
end procStudentModify;
/

begin
procStudentrModify(1, 1, '신보경');
end;
/


select * from tblStudent;
/


/*취업현황 수정 프로시저*/
create or replace procedure procEmploymentrModify (
    pseq number,   --취업현황번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblEmployment set companyName = pinput where employmentSeq= pseq;
    elsif pnum = 2 then update tblEmployment set annualIncome = pinput where employmentSeq= pseq;
    elsif pnum = 3 then update tblEmployment set area = pinput where employmentSeq= pseq;
    elsif pnum = 4 then update tblEmployment set completeStudentSeq = pinput where employmentSeq= pseq;
    end if;
end procEmploymentrModify;
/

begin
procEmploymentrModify(1, 1, '신보경');
end;
/


select * from tblEmployment;
/


/*성적 수정 프로시저*/
create or replace procedure procScoreModify (
    pseq number,   --성적번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblScore set hasdwritingScore = pinput where scoreSeq= pseq;
    elsif pnum = 2 then update tblScore set practiceScore = pinput where scoreSeq= pseq;
    elsif pnum = 3 then update tblScore set attendanceScore = pinput where scoreSeq= pseq;
    elsif pnum = 4 then update tblScore set testSeq = pinput where scoreSeq= pseq;
    elsif pnum = 5 then update tblScore set enrollmentSeq = pinput where scoreSeq= pseq;
    end if;
end procScoreModify;
/

begin
procScoreModify(1, 1, 20);
end;
/


select * from tblScore;
/



/*강의실 수정 프로시저*/
create or replace procedure procClassroomModify (
    pseq number,   --강의실번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblClassroom set name = pinput where classroomSeq= pseq;
    elsif pnum = 2 then update tblClassroom set condition = pinput where classroomSeq= pseq;
    elsif pnum = 3 then update tblClassroom set limitCount = pinput where classroomSeq= pseq;
    end if;
end procClassroomModify;
/

begin
procClassroomModify(1, 1, '강의실이름');
end;
/


select * from tblClassroom;
/


/*개설과정 수정 프로시저*/
create or replace procedure procOpenSubModify (
    pseq number,   --개설과정번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblOpenSubject set beginDate = pinput where openSubjectSeq= pseq;
    elsif pnum = 2 then update tblOpenSubject set endDate = pinput where openSubjectSeq= pseq;
    elsif pnum = 3 then update tblOpenSubject set openCourseSeq = pinput where openSubjectSeq= pseq;
    elsif pnum = 4 then update tblOpenSubject set totalSubjectSeq = pinput where openSubjectSeq= pseq;
    elsif pnum = 5 then update tblOpenSubject set period = pinput where openSubjectSeq= pseq;
    end if;
end procOpenSubModify;
/

begin
procOpenSubModify(1, 1, '2020-01-01');
end;
/


select * from tblOpenSubject;
/


/*전체과목 수정 프로시저*/
create or replace procedure procTotalSubModify (
    pseq number,   --전체과목번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblTotalSubject set name = pinput where totalSubjectSeq= pseq;
    end if;
end procTotalSubModify;
/

begin
procTotalSubModify(1, 1, '자바의 모든것');
end;
/


select * from tblTotalSubject;
/

/*자격증 정보 수정 프로시저*/
create or replace procedure proctblLicenseU (
    pseq number,   --자격증고유번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblLicense set name = pinput where licenseSeq= pseq;
    elsif pnum = 2 then update tblLicense set licenseType = pinput where licenseSeq= pseq;
    elsif pnum = 3 then update tblLicense set testAgency = pinput where licenseSeq= pseq;
    elsif pnum = 4 then update tblLicense set round = pinput where licenseSeq= pseq;
    elsif pnum = 5 then update tblLicense set receptionFee = pinput where licenseSeq= pseq;
    elsif pnum = 6 then update tblLicense set writtenRegisterBegin = pinput where licenseSeq= pseq;
    elsif pnum = 7 then update tblLicense set writtenRegisterEnd = pinput where licenseSeq= pseq;
    elsif pnum = 8 then update tblLicense set writtenTestDate = pinput where licenseSeq= pseq;
    elsif pnum = 9 then update tblLicense set writtenResultDate = pinput where licenseSeq= pseq;
    elsif pnum = 10 then update tblLicense set practicalRegisterBegin = pinput where licenseSeq= pseq;
    elsif pnum = 11 then update tblLicense set practicalRegisterEnd = pinput where licenseSeq= pseq;
    elsif pnum = 12 then update tblLicense set practicalTestDate = pinput where licenseSeq= pseq;
    elsif pnum = 13 then update tblLicense set practicalResultDate = pinput where licenseSeq= pseq;
    end if;
end proctblLicenseU;
/

begin
proctblLicenseU(1, 1, '정보관리');
end;
/


select * from tblLicense;
/


 
 
/*전체교재 수정 프로시저*/
create or replace procedure procAllBookModify (
    pseq number,   --전체교재고유번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblAllBook set name = pinput where allBookSeq= pseq;
    elsif pnum = 2 then update tblAllBook set  publisher= pinput where allBookSeq= pseq;
    elsif pnum = 3 then update tblAllBook set writer = pinput where allBookSeq= pseq;
    elsif pnum = 4 then update tblAllBook set price = pinput where allBookSeq= pseq;

    end if;
end procAllBookModify;
/

begin
procAllBookModify(1, 1, '안녕하세요');
end;
/


select * from tblAllBook;
/


-- 구인공고 수정 프로시저
create or replace procedure proctblJobPostU (
    pseq number,   --구인공고고유번호
    pnum number,   --수정할 컬럼번호
    pinput varchar2 --입력받은 값
)
is
begin
    if pnum = 1 then update tblJobPost set recruitField = pinput where jobPostSeq= pseq;
    elsif pnum = 2 then update tblJobPost set companyName = pinput where jobPostSeq= pseq;
    elsif pnum = 3 then update tblJobPost set recruitBegin = pinput where jobPostSeq= pseq;
    elsif pnum = 4 then update tblJobPost set recruitEnd = pinput where jobPostSeq= pseq;
    elsif pnum = 5 then update tblJobPost set career = pinput where jobPostSeq= pseq;
    elsif pnum = 6 then update tblJobPost set educationLevel = pinput where jobPostSeq= pseq;
    elsif pnum = 7 then update tblJobPost set annualIncom = pinput where jobPostSeq= pseq;
    elsif pnum = 8 then update tblJobPost set workArea = pinput where jobPostSeq= pseq;
    elsif pnum = 9 then update tblJobPost set workTime = pinput where jobPostSeq= pseq;
    elsif pnum = 10 then update tblJobPost set selectionCount = pinput where jobPostSeq= pseq;
    end if;
end proctblJobPostU;
/

begin
proctblJobPostU(1, 2, '로레알');
end;
/

select * from tblJobPost;



-- 3. 수강중인 교육생의 당일 출결 업데이트하는 프로시저
create or replace procedure proMAttendance
is
    cursor vcursor is select studentseq from tblStudent where condition = '수료중';
    vseq tblStudent.studentSeq%type;
begin
    open vcursor;
        loop
            fetch vcursor into vseq;
            exit when vcursor%notfound;
                
                insert into tblAttendance(attendanceSeq, AttendanceDate, inTime, outTime, condition, studentSeq)
                    values (attendanceSeq.nextVal, to_char(sysdate, 'yy-mm-dd'), null , null, '기타', vseq);
                
        end loop;
    close vcursor;
    
end;


--확인
begin
proMAttendance;
end;

desc tblStudent;
drop table TBLAttendenceCheck;

create table tblAttendenceCheck(
    seq number,
    Studentseq number,
    regdate date not null,
    condition varchar2(20)
)

CREATE SEQUENCE attendenceCheckSeq;

ALTER TABLE tblAttendenceCheck
    ADD CONSTRAINT PK_TBLAC PRIMARY KEY (seq);

ALTER TABLE tblAttendenceCheck
    ADD CONSTRAINT FK_TBLAC_tblStudent FOREIGN KEY (Studentseq)
        REFERENCES tblStudent(Studentseq);



create table tblAttendenceCheck(
    seq number,
    sseq number,
    regdate date not null,
    condition varchar2(20)
)

create sequence attendenceSeq;

select * from tblattendance;

/
-- 이상출결 입력 트리거
create or replace trigger trgEditAttendance
    after
    update on tblattendance
    for each row
begin
    if :new.condition in ('지각', '조퇴', '외출') then
    insert into AttendenceCheck values (attendenceSeq.nextVal, :new.studentseq, :new.attendancedate, :new.condition);
end;
/

begin
    procAttendin(61);
end;
/
select * from AttendenceCheck;
/
begin
procAttendout(61);
end;

desc  tblattendance;
/
-- 결석 입력 트리거
create or replace trigger trgEditAttendance
    before
    insert on tblattendance 
declare
    regdate varchar2(20);
begin
    select max(to_char(attendancedate, 'yy-mm-dd')) into regdate from tblattendance;
        
    if regdate <> to_char(sysdate, 'yy-mm-dd') then
    update tblattendance set
        condition = '결석'
            where condition = '기타' 
            and 
            regdate <> to_char(sysdate, 'yy-mm-dd') and attendancedate = regdate;
   end if;
end;
/

    


/

select * from tblattendance where to_char(attendancedate, 'yy-mm-dd hh24:mi:ss') < (select max(to_char(attendancedate-1, 'yy-mm-dd'))|| ' '|| '23:59:59'  from tblattendance);
select * from tblattendance where to_char(ATTENDANCEDATE, 'yy-mm-dd') = to_char(sysdate, 'yy-mm-dd');
/
begin
proMAttendance;
end;
/
INSERT INTO tblAttendance values (attendanceSeq.nextVal, '2021-06-03', '09:10', '17:54', '기타', 61);
INSERT INTO tblAttendance values (attendanceSeq.nextVal, '2021-06-03', '09:10', '17:54', '기타', 62);
INSERT INTO tblAttendance values (attendanceSeq.nextVal, '2021-06-03', '09:10', '17:54', '기타', 62);
update tblAttendance set
condition = '기타' where attendancedate = '2021-06-03' ;
update tblAttendance set
condition = '기타' where attendancedate = '2021-06-02' ;

INSERT INTO tblAttendance values (attendanceSeq.nextVal, '2021-06-05', '09:10', '17:54', '정상', 61);

INSERT INTO tblAttendance values (attendanceSeq.nextVal, '2021-06-06', '09:10', '17:54', '정상', 61);

desc tblattendance;
delete from tblattendance where attendancedate = '2021-06-03';
delete from tblattendance where attendancedate = '2021-06-04';
delete from tblattendance where attendancedate = '2021-06-05';
delete from tblattendance where attendancedate = '2021-06-06';

rollback;
select * from tblattendance where attendancedate = '2021-06-02';
select * from tblattendance where attendancedate = '2021-06-03'; --O
select * from tblattendance where attendancedate = '2021-06-04'; --O
select * from tblattendance where attendancedate = '2021-06-05'; --O
select * from tblattendance where attendancedate = to_char(sysdate, 'yyyy-mm-dd'); --O
select * from tblattendance where attendancedate = to_char(sysdate); --O
select * from tblattendance where attendancedate = sysdate;-- 안됨

 select max(attendancedate) from tblattendance ;--where attendanceseq = max(attendanceseq) group by attendancedate;
 
 
 --익명으로 이름을 변경해주는 함수
 select name, fnanony(name) from tblstudent where studentseq = 1;

create or replace function fnAnony(
    fname varchar2
)return varchar2
is
begin
    return substr(fname, 1, 1) || 'OO';
end fnAnony;




-- 교육생 생년월일로 연령대 ,,
/
create or replace function fnAge(
    pbirth varchar2 
) return varchar2 
is
begin

    return case  
        when substr((to_char(sysdate,'yyyy') - substr(pbirth,1,4)) ,1,1) = '1' then  '10대' 
        when substr((to_char(sysdate,'yyyy') - substr(pbirth,1,4)) ,1,1) = '2' then  '20대' 
        when substr((to_char(sysdate,'yyyy') - substr(pbirth,1,4)) ,1,1) = '3' then  '30대' 
        when substr((to_char(sysdate,'yyyy') - substr(pbirth,1,4)) ,1,1) = '4' then  '40대' 
        when substr((to_char(sysdate,'yyyy') - substr(pbirth,1,4)) ,1,1) = '5' then  '50대' 
    end;
end fnAge;
/


select name, fnAge(birth) from tblStudent;