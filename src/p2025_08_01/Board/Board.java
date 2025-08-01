package p2025_08_01.Board;

// Board.java
// 게시글 하나를 객체로 표현하는 클래스 (DTO/VO라고 불림)

public class Board {
  // 게시글 ID 자동 증가를 위한 static 변수
  private static int count = 0;

  // 게시글 고유 ID, 제목, 내용
  private int id;
  private String title;
  private String content;
  
  // 작성자
  private String writer;

  // 생성자: 제목과 내용을 받아 게시글을 생성하며, ID는 자동 부여
  public Board(String title, String content, String writer) {
    this.id = ++count; // 게시글 생성 시마다 ID 증가
    this.title = title;
    this.content = content;
    this.writer = writer;
  }

  // 게시글 ID를 반환 (읽기 전용)
  public int getId() {
    return id;
  }

  // 제목 반환
  public String getTitle() {
    return title;
  }

  // 내용 반환
  public String getContent() {
    return content;
  }

  // 작성자 반환
  public String getWriter() {
    return writer;
  }

  // 제목 수정
  public void setTitle(String title) {
    this.title = title;
  }

  // 내용 수정
  public void setContent(String content) {
    this.content = content;
  }
}
