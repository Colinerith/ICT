# ICT
### 1. 스프링 개발 환경 구축 
  - JDK 1.8
  - Spring (STS 3.9.11)
  - Tomcat 9.0.22
  - MariaDB 10.2.14
  - MySql WorkBench 8.0.26
  - 샘플 DB 구축
  - spring, Mariadb, MyBatis 연동을 통한 데이터 조회  
  -  <t> <img src="https://user-images.githubusercontent.com/75845861/129186039-3c41220a-6bb2-4bd9-abdd-efc0fbabc778.png" width="120" height="100"/>
    
    
### 2. API 가이드 작성  
  - SW 활용률 API 가이드 초안 작성  
    - 접속자 수, 부서별 접속자 수, 로그인 요청 수, 게시글 작성 수에 따른 request URL, request Parameters, Response Body를 명시
    - <t> <img src="https://user-images.githubusercontent.com/75845861/130008392-94069069-2344-4017-8ff4-d9612b601bae.png" width="500" height="400"/>  
  
### 3. Spring boot 개발 환경 설정 및 SQL 작성

SW활용 현황 통계 API 구축을 위한 SQL 작성

월별 접속자 수
일자별 접속자 수
평균 하루 로그인 수
휴일을 제외한 로그인 수 ( 해당 문제에서는 휴일을 포함합니다.) (API 구축시에는 추가 구현 필요 : 쿼리 + @(별도의 db생성 or 공공API 활용))
부서별 월별 로그인 수
