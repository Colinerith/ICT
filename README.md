# ICT
### 1. 스프링 개발 환경 구축 
  - JDK 1.8
  - Spring (STS 3.9.11)
  - Tomcat 9.0.22
  - MariaDB 10.2.14
  - MySql WorkBench 8.0.26
  - 샘플 DB 구축
  - spring, Mariadb, MyBatis 연동을 통한 데이터 조회  
  -  <t> <img src="https://user-images.githubusercontent.com/75845861/129186039-3c41220a-6bb2-4bd9-abdd-efc0fbabc778.png" width="200" height="180"/>
    
    
### 2. API 가이드 작성  
  - SW 활용률 API 가이드 초안 작성  
    - 접속자 수, 부서별 접속자 수, 로그인 요청 수, 게시글 작성 수에 따른 request URL, request Parameters, Response Body를 명시
    - <t> <img src="https://user-images.githubusercontent.com/75845861/130008392-94069069-2344-4017-8ff4-d9612b601bae.png" width="600" height="500"/>  
  
### 3. Spring boot 개발 환경 설정 및 SQL 작성
- Spring boot 2.2.2
- DB, Table 생성
  - requestcode(requestCode, code_explain)
  - requestinfo(requestID, requestCode, userID, createDate)
  - user(userID, DEPARTMENT, USERNAME)
  ![image](https://user-images.githubusercontent.com/75845861/130792663-6738e339-d92b-4c37-a240-84934a05c7ee.png)

- SW활용 현황 통계 API 구축을 위한 SQL 작성
  1. 월별 접속자 수
  2. 일자별 접속자 수
  3. 평균 하루 로그인 수
  4. 휴일을 제외한 로그인 수
  5. 부서별 월별 로그인 수
