package com.lannstark.lec03

import java.lang.IllegalArgumentException

// 코틀린에서 Type을 다루는 방법
class Lec03MainKT {
    fun main() {
        // 기본 타입
        // 코틀린에서는 선언된 기본 값을 보고 타입을 추론한다
        val number1 = 1 // Int
        val number2 = 1L // Long
        val number3 = 3.0f // Float
        val number4 = 3.0 // Double

        // 자바에서의 타입변환은 암시적으로 이뤄지지만 코틀린에서의 타입변환은 명시적으로 이뤄져야 한다
        val n1 = 4
        // 자바에서는 long타입으로 바꿔서 넣어주게 되는데 코틀린은 아니다
//        val n2: Long = n1 // Type mismatch
        // 타입 변환 메서드를 사용해서 명시적으로 변경시켜 줘야 한다
        val n2: Long = n1.toLong()
        val n3 = 3
        val n4 = 5
        val resultInt = n3 / n4
        val resultDouble = n3 / n4.toDouble()
        // nullable 은 적절한 처리가 필요하다
        val n5: Int? = 4
//        val n6: Long = n5.toLong()
        val n6: Long = n5?.toLong() ?: 4


        // 3가지 특이한 타입
        // Any
        /*
        java의 object역할 (모든 객체의 최상위 타입)
        모든 프리미티브 타입의 최상위 타입도 Any이다
        Any자체로는 null을 포함할 수 없어 null을 포함하고 싶다면 Any?을 사용
        Any에 equals / hashCode / toString 존재
         */
        // Unit
        /*
        java의 void와 동일한 역할
        void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
        함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미
        즉, 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현
         */
        // Nothing
        /*
        함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
        무조건 예외를 반환하는 함수 / 무한 루프 함수 등
        많이 쓰이지 않는다
         */
        fun fail(message: String): Nothing {
            throw IllegalArgumentException(message)
        }


        // String interpolation
        val person = Person("asdf", 100)
        // java
//        String log = String.format("이믈: %s", person.name);
        // kotlin
        val log = "이름: ${person.name}"
        // 중괄호 생략 가능
        // 생략하는 것은 가독성이 안좋으므로 비추천한다
        val name = person.name
        val log2 = "이름: $name"
        // append를 사용하지 않아도 됨
        // indent가 없어진 채로(줄바꿈은 유지) 문자열 생성됨
        val str = """
            ABC
            DEF
            ${name}
        """.trimIndent()


        // String indexing
        // 문자열에서 문자 가져오기
        val string = "ABC"
        val ch1 = str[0]
        val ch2 = str[1]

    }

    // 타입 캐스팅
    fun printAgeIfPerson(obj: Any) {
        // java의 instanceof
        if (obj is Person) {
            // 타입캐스팅 생략 가능
            // 스마트 캐스트라고 함
            println(obj.age)

            // java의 (Person) obj
            // obj가 Person 타입이 아니면 에러가 남
            val person = obj as Person
            println(person.age)

        }

        // obj가 Person의 인스턴스가 아닐때 is앞에 !붙이면 됨
        if (obj !is Person) {

        }
    }
    // obj에 null이 들어올 수 있다면?
    fun printAgeIfPerson2(obj: Any?) { // Any에 ? 붙여야 함
        // as? 에서 ?를 안붙이면 런타임에 NPE발생함
        // ?를 붙이면 null일경우 person = null 이 됨
        // obj가 Person이 아니어도 null이 된다 이게 다른 점이다
        val person = obj as? Person
        println(person?.age)
    }
}