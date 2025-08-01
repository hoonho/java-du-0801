# 10일차

<br/>

## 콘솔로 다루는 게시판
자바 콘솔 환경에서 동작하는 게시판 프로그램입니다.   
기본적인 CRUD 게시글 기능, 회원가입/로그인 기능, 작성자 권한 제어를 포함합니다.   

<br/>

## 클래스 구성
|클래스 이름|역할|
|:--|:--|
|`Main`|사용자 입력 처리 및 메뉴 실행(UI)|
|`Board`|게시글 객체 정의 (제목, 내용, 작성자 등)|
|`BoardService`|게시글 목록 저장 및 CRUD 로직|
|`User`|사용자 정보 정의 (ID, 비밀번호)|
|`UserService`|회원가입, 로그인, 인증 상태 관리|

<br/><br/>

## 클래스 및 API 정리

<br/>

### [Board.java](https://github.com/hoonho/java-du-0801/blob/main/src/p2025_08_01/Board/Board.java)

<br/>

#### 필드
|변수명|타입|설명|
|:--|:--|:--|
|`id`|`int`|게시글 고유 ID|
|`title`|`String`|게시글 제목|
|`content`|`String`|게시글 내용|
|`writer`|`String`|작성자 ID|

<br/>

#### 생성자
```java
Board(String title, String content, String writer)
```

<br/>

#### 주요 메서드
```java
int getId()
String getTitle()
String getContent()
String getWriter()
void setTitle(String title)
void setContent(String content)
```

<br/>

--------------------------------------------------------------------

<br/>

### [User.java](https://github.com/hoonho/java-du-0801/blob/main/src/p2025_08_01/Board/User.java)

<br/>

#### 필드
|변수명|타입|설명|
|:--|:--|:--|
|`UserId`|`String`|사용자 ID|
|`password`|`String`|사용자 비밀번호|

<br/>

#### 생성자
```java
User(String userId, String password)
```

<br/>

#### 주요 메서드
```java
String getUserId()
String getPassword()
```

<br/>

--------------------------------------------------------------------

<br/>

### [BoardService.java](https://github.com/hoonho/java-du-0801/blob/main/src/p2025_08_01/Board/BoardService.java)

<br/>

#### 필드
|변수명|타입|설명|
|:--|:--|:--|
|`boards`|`List<Board>`|게시글 저장소|

<br/>

#### 주요 메서드
```java
// 게시글 작성
void createBoard(String title, String content, String writer)

// 게시글 목록 출력
void listBoards()

// ID로 게시글 찾기
Board getBoardById(int id)

// 게시글 수정 (작성자 일치 시에만 수정 가능)
void updateBoard(int id, String newTitle, String newContent, String userId)

// 게시글 삭제 (작성자 일치 시에만 삭제 가능)
void deleteBoard(int id, String userId)
```

<br/>

--------------------------------------------------------------------

<br/>

### [UserService.java](https://github.com/hoonho/java-du-0801/blob/main/src/p2025_08_01/Board/UserService.java)

<br/>

#### 필드
|변수명|타입|설명|
|:--|:--|:--|
|`userMap`|`Map<String, User>`|사용자 ID 기준 저장소|
|`loggedInUser`|`User`|현재 로그인된 사용자|

<br/>

#### 주요 메서드
```java
// 사용자 회원가입
void register(String id, String password)

// 로그인 성공 여부 반환
boolean login(String id, String password)

// 현재 로그인 사용자 로그아웃
void logout()

// 로그인 여부 확인
boolean isLoggedIn()

// 현재 로그인 사용자 반환
User getLoggedInUser()
```

<br/>

--------------------------------------------------------------------

<br/>

### [Main.java](https://github.com/hoonho/java-du-0801/blob/main/src/p2025_08_01/Board/Main.java)

<br/>

#### 주요 기능
* 메뉴 입력 (0~8)
  - 잘못된 입력(0에서 8 이외의 숫자나 문자) 예외 처리
* 로그인 상태에 따라 권한 분기
* Scanner 사용으로 사용자 입력 처리

<br/>

#### 콘솔 메뉴 구조
```plaintext
==== 게시판 메뉴 ====
1. 회원가입
2. 로그인
3. 로그아웃
4. 게시글 목록
5. 게시글 작성  ← 로그인 필요
6. 게시글 보기
7. 게시글 수정  ← 로그인 + 본인 글만 가능
8. 게시글 삭제  ← 로그인 + 본인 글만 가능
0. 종료
```

<br/>

#### 예외 처리
|상황|처리방식|
|:--|:--|
|메뉴에 문자 입력|`"숫자만 입력 가능합니다."`|
|메뉴 숫자 범위 초과 입력|`"잘못된 입력입니다."`|
|게시글 ID 없는 경우 조회 시|`"게시글이 없습니다."`|
|로그인 없이 작성/수정/삭제 시|`"로그인 후 이용 가능합니다."`|

<br/>

#### 추가 예정
* 게시글 파일 저장/불러오기
* 작성일 기록
* 웹 기반 UI로 전환 (Servlet/JSP/Spring-boot 등)