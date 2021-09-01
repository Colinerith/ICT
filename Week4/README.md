### 1. DB Table 구성

1. requestInfo Table
: 별도의 공휴일 테이블을 두어 '휴일을 제외한 로그인 수'를 제공할 수 있도록 함  
![image](https://user-images.githubusercontent.com/75845861/131637509-ad72164c-0d02-4a42-9248-b7ca256cb2e0.png)

2. user Table  
![image](https://user-images.githubusercontent.com/75845861/131637436-e8f092e0-dd78-4997-b619-0160108bc12d.png)

3. holiday Table  
![image](https://user-images.githubusercontent.com/75845861/131614208-b18fbc87-0918-4982-ad73-dc7d41b98dce.png)

### 2. SQL
1. 연도별 접속자 수
''' XML
    <select id="selectLoginYear" parameterType="string" resultType="hashMap">
        select distinct count(*) as yearCnt
        from statistc.requestinfo
        where requestCode = 'L' and left(createDate, 2) = #{year};
    </select>
'''

2. 월별 접속자 수

3. 일별 접속자 수
4. 

### 3. URL & 출력값
1. 연도별 접속자 수
![image](https://user-images.githubusercontent.com/75845861/131642337-dff09b8d-ab89-4492-910b-81502f3a7694.png)

2. 월별 접속자 수

3. 일별 접속자 수
