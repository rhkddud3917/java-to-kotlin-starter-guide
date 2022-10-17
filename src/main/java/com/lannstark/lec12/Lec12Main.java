package com.lannstark.lec12;

public class Lec12Main {

  public static void main(String[] args) {
    // Companion object에 이름을 명시하지 않은 경우
//    Person.Companion.newBaby("abd");
    // 이름을 명시한 경우
    Person.Factory.newBaby("ABC");
    // 해당 함수에 @JvmStatic 어노테이션을 붙인 경우
    Person.newBaby("ABC");
  }

}
