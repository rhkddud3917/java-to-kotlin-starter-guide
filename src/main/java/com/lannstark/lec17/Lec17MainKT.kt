package com.lannstark.lec17

// 코틀린에서 람다를 다루는 방법
// 강의노트 참고!!!!!!!!!!!!!!!!
class Lec17MainKT {
    // java에서 람다를 다루기 위한 노력
    /*
    자바에서 함수는 변수에 할당되거나 파라미터로 전달할 수 없다 (2급시민)
    자바에서는 함수를 넘기는 것처럼 보여지지 근본적으로 넘길 수 없다
     */


}

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 코틀린에서의 람다
    /*
    코틀린에서는 함수가 그 자체로 값이 될 수 있다.
    변수에 할당할수도, 파라미터로 넘길 수도 있다

    함수의 타입: (파라미터 타입...) -> 반환 타입
     */
    // 함수 이름이 없고 바로 파라미터를 적는다
    // 람다를 만드는 방법 1
    // isApple의 타입은 Fruit를 받아서 Boolean을 반환하는 함수라는 뜻이다
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다를 만드는 방법 2
    // 이 방법이 더 많이 쓰인다
    val isApple2: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}
    // 람다를 직접 호출하는 방법 1
    isApple(fruits[0])
    // 람다를 직접 호출하는 방법 2
    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple)
    // 바로 함수 블록을 넣어주는 것도 가능하다
    filterFruits(fruits, {fruit: Fruit -> fruit.name == "사과"})
    // 가장 마지막 파라미터가 함수일 때 중괄호를 소괄호 밖으로 빼면 자동으로 마지막 파라미터로 들어간다
    filterFruits(fruits) {fruit: Fruit -> fruit.name == "사과"}
    // 타입을 추론 가능하면 생략가능하다
    filterFruits(fruits) {fruit -> fruit.name == "사과"}
    // 파라미터가 1개이면 파라미터를 it으로 쓸 수있다 -> 이 방식은 비추한다 위의 방법 사용하라 사용하는 곳에서 무엇인지 모르기 때문
    filterFruits(fruits) {it.name == "사과"}
    // 람다를 여러 줄 작성할 경우에는 return을 따로 명시하지 않더라고 마지막 줄의 결과가 람다의 반환값이다
    filterFruits(fruits) {fruit ->
        println("asdf")
        fruit.name == "사과"
    }


    // Closure
    /*
    자바에서는 람다를 쓸 때 람다 밖에 있는 변수를 사용하는 경우 제약이 있다
    final인 변수 혹은 실질적으로 final인 변수만 사용할 수 있다
    Lec17Main.java 참고
    */
    /*
    코틀린에서는 가능하다 (non - final
    코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있는다
    이렇게 해야만, 람다를 진정한 일급 시민으로 간주할 수 있다
    이 데이터 구조를 Clusure이라고 부른다
    */
    var target = "asdf"
    target = "asdfasdf"
    filterFruits(fruits) {it.name == target}


    // try with resources -> use 코드 분석 (7강 참고)
    /*
    Closeable을 구현한 T에 대한 확장함수이고
    inline 함수이다
    람다를 받게 만들어진 함수이다
     */
}

// 함수 인터페이스를 사용하는 것이 아니라 함수 자체를 넘길 수 있다
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}


