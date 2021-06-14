--ex29_normalization


/*
정규화, Nomalization

- 모델링 작업 > ERD > 안정성 높고, 작업하기 편한 ERD
- ERD 수정하는 작업(공식)
- 자료의 손실이나, 불필요한 정보를 없애고, 데이터의 일관성을 유지하고, 
  데이터 종속을 최소화하기 위해 자료구조를 (ERD)를 수정하는 작업
- 우리가 만든 테이블(ERD) = 비정형, 비정규형 상태 -> 정규화 -> 정규화된 구조
- 제 1 정규화, 제 2 정규화, 제 3 정규화
- 1 ~ 3 정규화 + 역정규화


관계형 데이터베이스 시스템이 지향하는 데이터베이스 상태
1. 되도록 셀이 NULL 상태를 가지지 않는다. NULL 상태의 셀이 많으면 좋지 않다.
2. 중복값을 저장하지 않는다. > 동일한 성격의 데이터 1개 이상의 테이블에 저장하지 않는다.
    > 같은 데이터를 여기저기 동시에 저장하지 않는다. > 공간 낭비, 수정
3. 하나의 셀 > 반드시 원자값 저장(단일값, 분리될 수 없는 값(Scaler)



정규화 목적
1. null 제거
2. 중복값 제거
3. 자료 삽입, 갱신, 삭제에 따른 이상 현상 제거 > 데이터 무결성 보장

1. 삽입 이상(Insertion Anormaly)
    - 특정 테이블에 데이터를 삽입할 때 원하지 않는 데이터까지 같이 넣어야 하는 상화

2. 갱신 이상(Update Anormaly(
    - 동일한 데이터가 2개 이상의 테이블에 존재 > 그 중 1개는 수정했지만, 다른 1개를 수정 못했을 때
        > 두 데이터간의 이상 오류가 발생 > 2개 데이터 중 어떤 데이터가 올바른 데이터인지 구분 못하는 상황 발생

3. 삭제 이상(Deletion Anormaly)
    - 특정 테이블에서 데이터를 삭제할 때 원하지 않는 데이터까지 같이 지워야 하는 상황
    
- 면접 질문: 함수 종속에대해 설명해 보시오
함수 종속(Functional Dependency)
- 하나의 테이블내의 컬럼끼리 관계 표현
- 정규화는 '부분 함수 종속'이나 '이행 함수 종속'을 모두 없애고, 모든 컬럼의 관계를
    '완전 함수 종속'으로 만드는 작업이다.
    
    
1. 완전 함수 종속, Full Functional Dependency
2. 부분 함수 종속, Partial Functional Dependency
3. 이행 함수 종속, Transitive Functional Dependency


정규화
- 1NF ~ 3NF(Normal Form)
- 비정규형 -> (정규화) -> 정규형
- 1개 테이블 -> (정규화) -> 2개 이상의 테이블

제 1 정규화, 1NF
- 모든 컬럼(속성)은 원자값을 가진다.
- 여러개로 분리 가능한 값을 1개의 컬럼안에 넣지 말것

제 2 정규화, 2NF
- 기본 키가 아닌 모든 컬럼은 기본키에 완전 함수 종속이어야 한다.
- 부분 함수 종속 컬럼 발견!! > 부분 함수 종속 제거
- 일부 컬럼이 복합키 모두에게 종속이 아니라, 복합키 일부에만 종속되는 현상

제 3 정규화, 3NF
- 기본 키가 아닌 모든 컬럼은, 기본키가 아닌 다른 컬럼에 종속되면 안된다.
- 이행 함수 종속 컬럼 발견!! > 이행 함수 종속 제거

역정규화
- 정규화된 결과를 다시 원래대로 되돌리는 작업
- 2개 테이블 > 1개 테이블
- 수업 중 사용 금지


"ERD -> 정규화'
'요구분석서 + ERD + 정규화" -> 완성 이번주
*/












