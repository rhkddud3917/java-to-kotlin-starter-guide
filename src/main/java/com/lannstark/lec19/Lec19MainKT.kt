package com.lannstark.lec19

import com.lannstark.lec17lec18.Fruit
import com.lannstark.lec19.a.print as printA
import com.lannstark.lec19.b.print as printB

class Lec19MainKT {

}

// Type alias
/*
긴 이름의 클래스 혹은 함수 타입이 있을 때 축약하거나 더 좋은 이름을 쓰고 싶다
 */
typealias FruitFilter = (Fruit) -> Boolean
fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {}
// 이름이 긴 클래스를 컬렉션에 사용할 때도 사용가능
typealias USGTMAP = Map<String, UltraSuperGuardianTribe>
data class UltraSuperGuardianTribe(
    val name: String
)


// as import
/*
다른 패키지의 같은 이름의 함수를 동시에 가져오고 싶다면?
어떤 클래스나 함수를 임포트할 때 이름을 바꾸는 기능
 */
// 위의 import 문 참고
fun main() {
    printA()
    printB()
}


// 구조분해
/*
data class는 componentN이란 함수도 자동으로 만들어준다
몇번째 프로퍼티를 가져올 것인지
data class가 아닌데 구조분해를 사용하고 싶으면 componentN함수를 직접 구현해줄 수 있다
(key, value) 이런것도 구조분해 문법이다
 */
data class Person(
    val name: String,
    val age: Int,
)

class Person2(
    val name: String,
    val age: Int
) {
    // operator를 반드시 붙여야 한다
    operator fun component1(): String { return this.name }
}
fun main2() {
    val person = Person("asdf", 100)
    // 이름과 나이가 한번에 들어간다
    // val name = person.name
    // val age = person.age
    // 와 같다
    val name = person.component1()
    val age = person.component2()
    // 이 코드가 아래와 같이 된다 (구조분해 문법)
    val (name2, age2) = person
}


// Jump, Label
/*
return : 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환된다
break : 가장 가까운 루프가 제거된다
continue : 가장 가까운 루프를 다음 step 으로 보낸다
java 와 완전 동일
 */
fun main3() {
    val numbers = listOf(1,2,3)
    // forEach 에서는 continue, break을 쓸 수 없다
    numbers.map { number -> number + 1}
        .forEach { number -> print(number) }
    // break을 사용하고 싶을 때
    // 비추 그냥 for문 써라
    // run 은 약속된 라벨이다
    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@run
            }
        }
    }
    // continue를 사용하고 싶을 때
    // 비추 그냥 for문 써라
    // forEach는 약속된 라벨이다
    numbers.forEach { number ->
        if (number == 2) {
            return@forEach
        }
    }

    // 라벨
    /*
    특정 expression에 라벨이름@ 을 붙여 하나의 라벨로 간주하고 break, continue, return 등을 사용하는 기능
    라벨을 사용한 점프는 비추 사용하지 마라
     */
    // 우리가 아는 break은 가장 가까운 반복문을 멈추는 것이지만
    // 이렇게 쓰면 loop@가 있는 반복문을 멈춘다
    // 라벨이름은 아무거나 쓰면된다
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
        }
    }


    // takeIf, takeUnless
    /*
    takeIf : 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다
    takeUnless : 주어진 조건을 만족하지 않으면 그 값이, 아니면 Null이 반환된다
     */
    val a = 1
    val b = a.takeIf { a == 1 }
}