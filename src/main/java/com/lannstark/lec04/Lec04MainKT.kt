package com.lannstark.lec04

// 코틀린에서 연산자를 다루는 법
class Lec04MainKT {
    fun main() {
        // 단항연산자, 산술연산자
        // ++, --, +, -, +=, *=, /=, /, * 등 자바와 완전히 동일


        // 비교연산자
        // >, <, >=, <=
        // java와 동일하지만
        // 객체들사이에서 사용하면 자동으로 compareTo 함수를 호출한다
        val money1 = JavaMoney(1000L)
        val money2 = JavaMoney(2000L)
        // java
//        money1.compareTo(money2) > 0
        // kotlin
        money1 > money2

        // 동등성 : 두 객체의 값이 같은가
        // java 에서 equals 사용
        // kotlin에서 == 사용하면 간접적으로 equals를 호출해준다
        // 동일성 : 주소가 같은가
        // java에서 == 으로 비교
        // kotlin에서 === 사용
        val money3 = money1
        println(money1 == money3) // 값을 비교
        println(money1 === money3) // 주소를 비교


        // 논리 연산자
        // &&, ||, !
        // java와 완전히 동일하고 lazy연산을 수행한다


        // 특이한 연산자
        // in , !in
        // 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
        // a..b
        // a부터 b까지 범위 객체를 생성한다
        // a[i]
        // a에서 특정 index i의 값을 가져온다
        // a[i] = b
        // a의 특정 index i에 b를 넣는다


        // 연산자 오버로딩
        // 코틀린에서는 객체마다 연산자를 직접 오버로딩 할 수 있다
        // Money클래스 참고
        val money4 = Money(1000)
        val money5 = Money(2000)
        // plus함수를 호출한다
        println(money4 + money5)


    }
}