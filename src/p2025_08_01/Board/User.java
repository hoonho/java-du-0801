package p2025_08_01.Board;

// User.java
// 사용자 ID와 비밀번호를 저장하는 클래스

public class User {
  private String userId;
  private String password;

  public User(String userId, String password) {
    this.userId = userId;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }
}
