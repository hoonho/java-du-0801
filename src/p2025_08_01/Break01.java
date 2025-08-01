package p2025_08_01;

public class Break01 {
  public static void main(String[] args) {

    // 무한루프 for문
    // for (;;) {}

    for (int i = 1;;i++) {
      if (i > 100) break;
      System.out.println(i+"출력");
    }
  }
}
