# MyPlanner-ver1.0
MyPlanner-ver1.0 (personal project 2023-10-14)
: Spring Boot + thymeleaf로 제작한 일정 관리 어플리케이션

## 프로젝트 소개
- 프로젝트 유형 : 개인 프로젝트
- 프로젝트 명 : MyPlanner
- 소개 : 계정을 통해 일정을 등록, 수정, 삭제, 검색, 조회 할 수 있는 어플리케이션
<br>

## 🕰️ 개발 소요 기간
- 사전 "학습" 및 설계, 자료 조사, 모든 과정 포함하여 약 2주 소요
 
### 🧑‍🤝‍🧑 전체 기능 구성
- 암호화 복호화 패키지를 사용한 계정 등록 로그인
- 일정 등록, 수정, 삭제, 검색, 조회 기능 (CRUD 기능 + 검색 구현)
- 달력 api 사용 

### ⚙️ 개발 환경
- `Java 11`
- `JDK 11`
- **IDE** : Eclipse 4.21
- **Framework** : Springboot(2.x)
- **Database** : Oracle DB(11xe)
- **ORM** : Mybatis
- **View** : Thymeleaf, JQuery, Bootstrap
- **build toll** : Maven
- 
## 📌 주요 기능
- 로그인 및 로그아웃
- 일정 등록
- 일정 수정
- 일정 삭제
- 일정 검색
- 일정 조회

## 파일 구성
- DTO (클래스명.java) -> 입력 또는 출력 할 데이터를 변수에 담는 역할
- DAO (인터페이스명.java) -> 매핑 시킬 추상 메소드와 반환 데이터 타입, 매개변수 지정
- Contoller (컨트롤러명.java) -> 이벤트 호출에 응답하는 Service 메소드 실행 (데이터는 이동만 연산 처리는 Service 에서)
- Service (서비스명.java) -> DAO와 DB 사이에서 데이터를 연산 및 가공하는 곳
- Mapper (DAO명과 동일하게 작성.xml) -> DAO 와 매핑될 쿼리문을 작성하는 곳


