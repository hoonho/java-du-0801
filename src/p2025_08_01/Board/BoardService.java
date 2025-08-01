package p2025_08_01.Board;

// BoardService.java
// 게시글을 저장하고 CRUD 기능을 처리하는 클래스 (비즈니스 로직 담당)

import java.util.ArrayList;
import java.util.List;

public class BoardService {
  // 게시글을 저장하는 리스트 (메모리 저장소)
  private List<Board> boards = new ArrayList<>();

  // 게시글 작성(Create)
  public void createBoard(String title, String content, String writer) {
    boards.add(new Board(title, content, writer));
    System.out.println("게시글이 등록되었습니다.");
  }

  // 전체 게시글 목록 출력(Read All)
  public void listBoards() {
    if (boards.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      return;
    }

    // 각 게시글의 ID와 제목을 출력
    for(Board board : boards) {
      System.out.printf("ID: %d | 제목 : %s | 작성자: %s\n", board.getId(), board.getTitle(), board.getWriter());
    }
  }

  // ID를 통해 게시글 하나를 가져오는 메서드(Read One)
  public Board getBoardByID(int id) {
    for (Board board : boards) {
      if (board.getId() == id) return board;
    }
    return null;  // 없을 경우 null 반환
  }

  // 게시글 수정(Update)
  public void updateBoard(int id, String newTitle, String newContent, String userId) {
    Board board = getBoardByID(id);

    if (board != null) {
      if (board.getWriter().equals(userId)) {
        board.setTitle(newTitle);
        board.setContent(newContent);
        System.out.println("게시글이 수정되었습니다.");
      } else {
        System.out.println("본인이 작성한 글만 수정할 수 있습니다.");
      } 
    }else {
      System.out.println("게시글을 찾을 수 없습니다.");
    }
  }

  // 게시글 삭제(Delete)
  public void deleteBoard(int id, String userId) {
    Board board = getBoardByID(id);
    if (board != null) {
      if (board.getWriter().equals(userId)) {
        boards.remove(board);
        System.out.println("게시글이 삭제되었습니다.");
      } else {
        System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
      }
    } else {
      System.out.println("게시글을 찾을 수 없습니다.");
    }
  }
}
