package com.lannstark.lec17lec18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lec17Main {

  public static void main(String[] args) {
    List<Fruit> fruits = Arrays.asList(
        new Fruit("사과", 1_000),
        new Fruit("사과", 1_200),
        new Fruit("사과", 1_200),
        new Fruit("사과", 1_500),
        new Fruit("바나나", 3_000),
        new Fruit("바나나", 3_200),
        new Fruit("바나나", 2_500),
        new Fruit("수박", 10_000)
    );


    /*
    자바에서는 람다를 쓸 때 람다 밖에 있는 변수를 사용하는 경우 제약이 있다
    final인 변수 혹은 실질적으로 final인 변수만 사용할 수 있다
     */
    String targetFruitName = "asdf";
    targetFruitName = "asdfasdf";
//    filterFruits(fruits, (fruit -> targetFruitName.equals(fruit.getName())));



  }

  private static List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
    List<Fruit> results = new ArrayList<>();
    for (Fruit fruit : fruits) {
      if (fruitFilter.test(fruit)) {
        results.add(fruit);
      }
    }
    return results;
  }

}
