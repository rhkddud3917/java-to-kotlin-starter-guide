package com.lannstark.lec01

class Lec01MainKT {

    fun main() {
        // 가변
        var number11: Long = 10L
        // 자료형을 정해주지 않아도 됨 컴파일러가 추론해줌
        var number1 = 10L
        // 초기화를 해주지 않을 때에는 컴파일러가 자료형 추론을 하지 못하므로 자료형 명시해야 함
        var number12: Long

        // 불변
        // java의 final로 생각하면 됨
        val number21: Long = 10L
        val number2 = 10L
        val number22: Long

        // val로 지정한 자료구조(list) 여도 원소 추가가 가능하다
        // 모든 변수를 val로 먼저 만들고 필요한 경우에만 var사용하자

        // 프리미티브 타입, 레퍼런스 타입
        /*
        코틀린에서는 Long, long구분이 없다
        Long으로 전부 사용하면 코틀린에 상황에 맞춰서 내부적으로
        long같은 프리미티브 타입으로 변환하여 실행한다
        즉 프로그래머가 boxing, unboxing 고려하지 않아도 된다
         */

        // null 관련
        var number3: Long? = 1000L
        number3 = null
        /*
        기본적으로 모든 변수에는 null을 집어넣을 수 없다
        자료형뒤에 ?를 붙여줘야함 null이 들어갈 수 있다
         */

        // 객체의 인스턴스 화
        var person = Person("person")
        /*
        코틀린에서는 new를 붙이면 안된다
         */

        // Tools에서 Kotlin, show Kotlin byte code를 보고 Decompile을 누르면 자바코드로 볼 수 있다
    }
}