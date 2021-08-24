[0. (요약) RestController를 활용한 간단 API 구현](https://www.notion.so/3-0-RestController-API-566012cc61ce40f68ce5b41aa6fc155e)
1. [스프링부트 개발 환경 셋팅](https://www.notion.so/3-1-2255f6505a2e4e998aebf8e6a0d8a596)
2. [통계 API(SW활용현황)을 위한 DB, TABLE 생성](https://www.notion.so/3-2-SW-API-DB-Table-5f322ca66bfb471295f6006818f911db)
3. [[20년도 로그인 수 API] 스프링부트, mybatis, mariadb 연동](https://www.notion.so/3-3-20-API-Mybatis-mariadb-2172c07d53844c909f8a346811a082d1)

  

application.properties  
- port, contextpath, view, db 등 각종 설정을 한 곳에서 진행합니다.
- 설정내용은 serverport, contextpath를 진행하였고
- suffix에 jsp를 줌으로써 /WEB-INF/views 아래에 jsp 파일로 자동으로 맵핑해주도록 합니다.  


  
spring 프레임워크
- dependency injection : 스프링 프레임워크의 핵심 기능
- transaction management
- 라이브러리만 쓰는 방식으로 처리 가능, 모듈 결합이 쉬움

- spring은 기존 Java EE(Enterprise Edition)의 기능을 커버하면서 더 깔끔하고 간단
- 그래서 이제는 Java SE(Standard Edition) + EE 대신 SE + Spring

- MVC, 트랜잭션, 인증과 권한  세 가지 공부
- 각각을 위해 DI, AOP, Servlet Filter를 알아야 함
- 느슨한 결합력과 인터페이스  


MVC2 패턴
- Model: 애플리케이션의 정보(데이터, 비즈니스 로직)
- View: 사용자 제공 화면
- Controller: Model - View 상호 작용
- Client -> FrontController -> Controller -> Model (Service) -> Controller -> View
1. Model Component
 - DB 등과 연동하여 사용자가 입력한 데이터나 사용자에게 출력할 데이터를 다루는 곳
 - 여러 개의 데이터 변경 작업(DML)의 트랜잭션을 다루기도 함
 - DAO 클래스, Service 클래스
2. View Component
 - 모델이 처리한 데이터나 작업 결과를 가지고 사용자에게 출력할 화면을 만듦
 - 생성된 화면은 웹 브라우저가 출력, HTML/CSS/Java Script를 구성하여 UI를 만듦
 - HTML, JSP를 사용해 작성
3. Controller Component
 - 클라이언트의 요청을 받았을 때 그 요청에 대해 실제 업무를 수행하는 모델 컴포넌트를 호출
 - 클라이언트가 보낸 데이터가 있다면, 모델을 호출할 때 전달하기 쉽게 적절히 가공
 - 모델이 업무 수행을 완료하면 그 결과를 가지고 화면을 생성하도록 뷰에 전달 (클라이언트 요청에 대해 모델과 뷰를 결정해 전달)
 - MVC 1: JSP가 담당


Front Controller 패턴
- 모든 요청을 처리하는 하나의 대표 컨트롤러를 두는 패턴
- Controller의 공통 로직을 앞단에서 처리.
- MVC 패턴과 함께 많이 사용
- Spring에서 정의한 Front Controller를 DispatcherServlet이라 한다.


Spring 웹 요청 처리 흐름
1. DispatcherServlet: web.xml에 정의된 URL 패턴에 맞는 요청을 받고 URL과 컨트롤러의 매핑 작업을 HandlerMapping에 요청
2. HandlerMapping: 요청 정보(URL)를 기준으로 컨트롤러를 결정하며 결과를 HandlerExecution Chain 객체에 담아 리턴. 요청에 해당하는 Interceptor가 있다면 함께 담아서 줌 (= ControllerMapping)
3. HandlerAdapter: 컨트롤러의 메소드를 호출. 실행될 Interceptor가 있다면 Interceptor의 preHandle() 메소드를 실행한 뒤 다음 컨트롤러의 메소드를 호출해 요청을 처리. DispatcherServlet을 HandlerMapping으로 찾은 Controller와 연결하는 역할 (= ControllerAdapter)
4. Controller: 요청을 처리한 뒤 처리한 결과 및 뷰 정보(ModelAndView)를 DispatcherServlet에 전달
5. DispatcherServlet: 컨트롤러에서 받은 View 이름과 매칭되는 실제 View 파일을 찾기 위해 ViewResolver에 요청
6. ViewResolver: 컨트롤러가 처리한 결과를 보여줄 뷰를 결정. 컨트롤러에서 전달받은 View 이름에 prefix, suffix 프로퍼티를 추가한 값이 실제 사용할 뷰 파일의 경로가 됨. ViewResolver는 매핑되는 View 객체를 DispatcherServlet에 전달. View 이름으로 실제 사용할 View객체(JSP)를 찾아주는 역할.
7. View: DispatcherServlet은 ViewResolver에서 전달받은 View에 Model을 넘겨서 클라이언트에게 보여줄 화면을 생성


  
    
    
### [배포서술자 - web.xml]
> 배포서술자 (DD, Deployment Desciption)  
- WEB-INF/web.xml (약속된 위치)
- 웹 애플리케이션의 기본적인 환경설정을 위해 작성하는 파일
- 서버가 구동될 때 web.xml을 읽고 웹 애플리케이션을 설정함

Servlet Mapping
- MVC 패턴으로 개발된 웹페이지에서 Controller를 담당하는 서블릿에 접근하려면 Mapping 필요
- web.xml에서 설정하거나, @(Annotation)을 이용한다. (Servet 3.0부터)

web.xml 주요 태그
1. \<filter>, \<filter-mapping>
- filter를 url-pattern과 매핑하려면 \<filter> 와 \<filter-mapping> 태그 내의 \<filter-name>이 동일해야 함
- 요청이 들어왔을 때 filter 적용 순서는 web.xml에 정의된 순서. 응답 시에는 반대 순서로 적용
2. ContextLoaderListener
- ContextLoaderListener를 \<listener>로 등록하고 \<context-param>을 이용해 공통으로 사용될 Bean 정보를 담고 있는 설정 파일을 지정
- 설정 파일을 지정하지 않으면 WEB-INF/applicationContext.xml을 설정 파일로 사용
3. Servlet Mapping 설정 (\<servlet>, \<servlet-mapping>)
- \<servlet-name> 이름의 서블릿을 \<url-pattern>과 매핑시키려면 \<servlet>과 \<servlet-mapping>의 \<servlet-name>이 같아야 함
- \<init-param>은 서블릿의 설정 파일을 지정. 지정하지 않으면 \<servlet-name> 뒤에 '-servlet.xml'이 붙은 파일명이 설정 파일

ContextLoaderListener와 DispatcherServlet
 - ContextLoaderListener는 공통 bean 설정을 담당하는 부모,
 - DispatcherServlet은 Controller쪽을 담당하는 자식 관계
 - ContextLoaderListener를 먼저 설정
