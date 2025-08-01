package p2025_08_01.Board;

// Main.java
// 콘솔에서 사용자 입력을 받아 게시판 기능을 제어하는 클래스 (UI와 main 메서드 담당)

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 게시판 로직을 처리할 서비스 객체 생성
    BoardService boardService = new BoardService();

    // 작성자 정보를 받기 위한 객체 생성
    UserService userService = new UserService();

    // 사용자 입력을 받기 위한 Scanner 객체 생성
    Scanner sc = new Scanner(System.in);

    // 무한 루프: 사용자 종료(0번) 선택 전까지 계속 실행
    while (true) {
      // 메뉴 출력
      System.out.println("\n==== 게시판 메뉴 ====");
      System.out.println("1. 회원가입");
      System.out.println("2. 로그인");
      System.out.println("3. 로그아웃");
      System.out.println("4. 게시글 목록");
      System.out.println("5. 게시글 작성");
      System.out.println("6. 게시글 보기");
      System.out.println("7. 게시글 수정");
      System.out.println("8. 게시글 삭제");
      System.out.println("0. 종료");

      // 사용자 메뉴 선택 입력 받기
      int choice = -1;

      // 숫자 입력만 받도록 예외 처리
      while (true) {
        System.out.print("메뉴 선택: ");
        String input = sc.nextLine();

        try {
          choice = Integer.parseInt(input);
          if (choice < 0 || choice > 8) {
            System.out.println("\n잘못된 입력입니다. (0~8 사이의 숫자만 입력하세요.)");
            continue;
          }
          break;
        } catch (NumberFormatException e) {
          System.out.println("\n숫자만 입력 가능합니다.");
        }
      }

      // 선택된 메뉴 번호에 따라 기능 수행
      switch (choice) {
        case 1:
          // 회원가입
          System.out.print("\nID: ");
          String regId = sc.nextLine();
          System.out.print("\nPW: ");
          String regPw = sc.nextLine();
          userService.register(regId, regPw);
          break;

        case 2:
          // 로그인
          System.out.print("\nID: ");
          String loginId = sc.nextLine();
          System.out.print("\nPW: ");
          String loginPw = sc.nextLine();
          userService.login(loginId, loginPw);
          break;

        case 3:
          // 로그아웃
          userService.logout();
          break;

        case 4:
          // 게시글 전체 목록 보기
          boardService.listBoards();
          break;

        case 5:
          // 게시글 작성
          if (!userService.isLoggedIn()) {
            System.out.println("\n로그인 후 이용 가능합니다.");
            break;
          }

          System.out.print("\n제목: ");
          String title = sc.nextLine();
          System.out.print("\n내용: ");
          String content = sc.nextLine();
          String writer = userService.getLoggedInUser().getUserId();
          boardService.createBoard(title, content, writer);
          break;

        case 6:
          // 게시글 상세 보기
          System.out.print("\n게시글 ID 입력: ");
          int viewId = Integer.parseInt(sc.nextLine());
          Board board = boardService.getBoardByID(viewId);
          if (board != null) {
            System.out.println("\n제목: " + board.getTitle());
            System.out.println("\n내용: " + board.getContent());
            System.out.println("\n작성자: " + board.getWriter());
          } else {
            System.out.println("\n게시글이 없습니다.");
          }
          break;

        case 7:
          // 게시글 수정
          if (!userService.isLoggedIn()) {
            System.out.println("\n로그인 후 이용 가능합니다.");
            break;
          }

          System.out.print("\n수정할 게시글 ID: ");
          int updateId = Integer.parseInt(sc.nextLine());
          System.out.print("\n새 제목: ");
          String newTitle = sc.nextLine();
          System.out.print("\n새 내용: ");
          String newContent = sc.nextLine();
          boardService.updateBoard(updateId, newTitle, newContent, userService.getLoggedInUser().getUserId());
          break;

        case 8:
          // 게시글 삭제
          if (!userService.isLoggedIn()) {
            System.out.println("\n로그인 후 이용 가능합니다.");
            break;
          }

          System.out.print("\n삭제할 게시글 ID: ");
          int deleteId = Integer.parseInt(sc.nextLine());
          boardService.deleteBoard(deleteId, userService.getLoggedInUser().getUserId());
          break;

        case 0:
          // 프로그램 종료
          System.out.println("\n프로그램을 종료합니다.");
          sc.close();
          return;

        default:
          // 잘못된 입력 처리
          System.out.println("\n잘못된 입력입니다.");
      }
    }
  }
}
