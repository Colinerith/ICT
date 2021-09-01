### 1. DB Table 구성

1. requestInfo Table  
![image](https://user-images.githubusercontent.com/75845861/131650901-f14cc095-a047-479d-9ff4-5869923c21fe.png)

2. user Table  
![image](https://user-images.githubusercontent.com/75845861/131637436-e8f092e0-dd78-4997-b619-0160108bc12d.png)

3. holiday Table  
: 별도의 공휴일 테이블을 두어 '휴일을 제외한 로그인 수'를 제공할 수 있도록 함  
![image](https://user-images.githubusercontent.com/75845861/131614208-b18fbc87-0918-4982-ad73-dc7d41b98dce.png)

### 2. SQL
1. 연도별 접속자 수
``` SQL
    <select id="selectLoginYear" parameterType="string" resultType="hashMap">
        select distinct count(*) as yearCnt
        from statistc.requestinfo
        where requestCode = 'L' and left(createDate, 2) = #{year};
    </select>
```
2. 월별 접속자 수
``` SQL
    <select id="selectLoginMonth" parameterType="string" resultType="hashMap">
        select distinct count(*) as monthCnt
        from statistc.requestinfo
        where requestCode = 'L' and SUBSTRING(createDate, 3, 2) = #{month};
    </select>
```
3. 일별 접속자 수
``` SQL
    <select id="selectLoginDate" parameterType="string" resultType="hashMap">
        select distinct count(*) as dateCnt
        from statistc.requestinfo
        where requestCode = 'L' and SUBSTRING(createDate, 5, 2) = #{date};
    </select>
```
4. 평균 하루 로그인 수
``` SQL
    <select id="avgLoginDate" resultType="hashMap">
		select avg(cnt)
		from (
			select count(*) avgCnt
			from statistc.requestinfo
			where requestCode = 'L'
			group by createDate
		) as dateCnt
    </select>
```
5. 휴일을 제외한 평균 하루 로그인 수  
: holiday Table의 date와 일치하지 않으며, createDate의 7~8번째 값(요일)이 06(일요일)이 아닌 값
``` SQL
    <select id="avgLoginWeekday" resultType="hashMap">
		select avg(cnt) as avgCnt
		from (
			select count(*) cnt
			from statistc.requestinfo
			where requestCode = 'L' and SUBSTRING(createDate, 7, 2) != '06' and
				SUBSTRING(createDate, 3, 4) NOT IN (select date from holiday) 
			group by createDate
		) as dateCnt
    </select>
```  
(참고) 다음 SQL문의 결과는 아래와 같다.  
``` SQL  
select *
from statistc.requestinfo
where requestCode = 'L' and SUBSTRING(createDate, 3, 4) NOT IN (select date from holiday) and SUBSTRING(createDate, 7, 2) != '06'
group by createDate
```
![image](https://user-images.githubusercontent.com/75845861/131650739-4c419003-014b-477f-9d74-b38a1b56792c.png)

6. 부서별 월별 로그인 수
``` SQL
    <select id="selectLoginMonthDepartment" parameterType="string" resultType="hashMap">
		select Count as monthCnt
        from
        (
        select department, SUBSTRING(createDate, 3, 2) as Month, IFNULL(count(*), 0) as Count
		from requestinfo, user
	    where requestinfo.userID = user.userID and requestCode = 'L'
	    group by SUBSTRING(createDate, 3, 2), department
        ) as tmp
        where Month = #{month} and department = #{department}
    </select>
```

### 3. URL & 출력값
1. 연도별 접속자 수
![image](https://user-images.githubusercontent.com/75845861/131642337-dff09b8d-ab89-4492-910b-81502f3a7694.png)

2. 월별 접속자 수  
![image](https://user-images.githubusercontent.com/75845861/131651164-cfaee0fc-abbd-40ec-bd18-806cdec2428d.png)

3. 일별 접속자 수
![image](https://user-images.githubusercontent.com/75845861/131651310-57192c7b-bf2f-4ae6-8bf2-008bcc9a2f98.png)

4. 평균 하루 로그인 수
![image](https://user-images.githubusercontent.com/75845861/131651541-14df41a9-9a3a-43d3-b25a-00ec1da037ef.png)

5. 휴일을 제외한 평균 하루 로그인 수  
![image](https://user-images.githubusercontent.com/75845861/131651579-5520e46a-e8dc-491a-b2ad-57b3e4584bab.png)

6. 부서별 월별 로그인 수
![image](https://user-images.githubusercontent.com/75845861/131651697-c4525f50-14d7-4c5c-a24b-ee2f2487ac6a.png)
