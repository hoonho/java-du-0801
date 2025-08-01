package p2025_08_01.Board;

import java.util.HashMap;
import java.util.Map;

// UserService.java
// 사용자 회원가입 및 로그인 관리

public class UserService {
  private Map<String, User> userMap = new HashMap<>(); // ID 기준 사용자 저장
  private User loggedInUser = null;

  // 회원가입
  public void register(String id, String password) {
    if (userMap.containsKey(id)) {
      System.out.println("이미 존재하는 ID입니다.");
    } else {
      userMap.put(id, new User(id, password));
      System.out.println("회원가입이 완료되었습니다.");
    }
  }

  // 로그인
  public boolean login(String id, String password) {
    User user = userMap.get(id);
    if (user != null && user.getPassword().equals(password)) {
      loggedInUser = user;
      System.out.println(id + "님, 로그인 되었습니다.");
      return true;
    } else {
      System.out.println("ID 또는 비밀번호가 올바르지 않습니다.");
      return false;
    }
  }

  // 로그아웃
  public void logout() {
    if (loggedInUser != null) {
      System.out.println(loggedInUser.getUserId() + "님, 로그아웃 되었습니다.");
      loggedInUser = null;
    } else {
      System.out.println("현재 로그인된 사용자가 없습니다.");
    }
  }

  public User getLoggedInUser() {
    return loggedInUser;
  }

  public boolean isLoggedIn() {
    return loggedInUser != null;
  }
}
