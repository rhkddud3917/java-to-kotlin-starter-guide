package com.lannstark.lec08;

public class Lec08Main {

  public static void main(String[] args) {

  }

  public static void printAll(String... strings) {
    for (String str : strings) {
      System.out.println(str);
    }
  }

  public void repeat(String str, int num, boolean useNewLine) {
    for (int i = 1 ; i <= num ; i++) {
      if (useNewLine) {
        System.out.println(str);
      } else {
        System.out.print(str);
      }
    }
  }

  public void repeat(String str, int num) {
    this.repeat(str, num, true);
  }

  public void repeat(String str) {
    this.repeat(str, 3);
  }

}
