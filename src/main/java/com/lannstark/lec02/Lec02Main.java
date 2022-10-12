package com.lannstark.lec02;

public class Lec02Main {

  public static void main(String[] args) {

  }

  public long earlyReturn(Long number) {
    if (number == null) {
      return 0;
    }

    // 다음 로직
    return 1;
  }

  public boolean startsWithA1(String str) {
    if (str == null) {
      throw new IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A");
  }


  public Boolean startsWithA2(String str) {
    if (str == null) {
      return null;
    }
    return str.startsWith("A");
  }


  public boolean startsWithA3(String str) {
    if (str == null) {
      return false;
    }
    return str.startsWith("A");
  }

}
