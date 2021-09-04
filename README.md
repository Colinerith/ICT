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
  - [Week1](https://github.com/hjinha18/ICT/tree/main/Week1)
    
### 2. API 가이드 작성  
  - SW 활용률 API 가이드 초안 작성  
    - 접속자 수, 부서별 접속자 수, 로그인 요청 수, 게시글 작성 수에 따른 request URL, request Parameters, Response Body를 명시
    - <t> <img src="https://user-images.githubusercontent.com/75845861/130008392-94069069-2344-4017-8ff4-d9612b601bae.png" width="600" height="480"/>  
  - [API 가이드 문서](https://github.com/hjinha18/ICT/blob/main/Week2/SW%20%ED%99%9C%EC%9A%A9%EB%A5%A0%20API%20%EA%B0%80%EC%9D%B4%EB%93%9C_1.1.pdf)
  
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
- [Week3](https://github.com/hjinha18/ICT/tree/main/Week3)

### 4. SW 활용 현황 통계 API 완성 및 API 가이드 수정
   - [Week4](https://github.com/hjinha18/ICT/tree/main/Week4)
  
