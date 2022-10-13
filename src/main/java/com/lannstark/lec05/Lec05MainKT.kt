package com.lannstark.lec05

import java.lang.IllegalArgumentException

// 코틀린에서 제어문을 다루는 방법
class Lec05MainKT {
    fun main() {

    }

    // if문
    /*
    java 에서 if-else if-else는 Statement이지만
    kotlin에서는 Expression이다
    Statement: 프로그램의 문장, 하나의 값으로 도출되지 않음
    Expression: 하나의 값으로 도출되는 문장 ex) java의 삼항연산자
     */
    // void -> Unit 생략됨
    fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            // new를 사용하지 않음
            throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다")
        }

        // 0 <= score && score <= 100 이렇게 쓰지 않아도 된다
        if (score !in 0..100) {
            throw IllegalArgumentException("${score}는 0과 100사이여야 합니다")
        }
    }

    fun getPassOrFail(score: Int): String {
        // 코틀린에서는 expression이므로 java의 삼항연산자처럼 하나의 값이 도출되어 다음과 같이 사용할 수 있다
        // 따라서 코틀린에서는 삼항 연산자가 없다
        return if (score >= 50) {
            return "P"
        }
        else {
            return "F"
        }
    }


    // switch 와 when
    /*
    코틀린에서는 switch case가 사라지고 when이 생겼다
    switch 대신에 when, case 대신 ->, default대신에 else 사용
    마찬가지로 expression이다
    조건부에는 어떤 expression이든 들어갈 수 있다 (원래 case가 들어가는 부분)
    조건부에는 여러개의 조건을 동시에 검사할 수도 있다
     */
    fun getGradeWithSwitch(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }

        // 아래와 같이 사용도 가능하다
        // 특정 값만이 아니고 다양한 조건으로 분기가 가능하다
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "D"
        }
    }

    // 조건부에 어떤 expression이든 들어갈 수 있음
    fun starsWithA(obj: Any): Boolean {
        return when (obj) {
            // 조건을 통해서 String인 것이 보장이 된다
            is String -> obj.startsWith("A")
            else -> false
        }
    }

    // 조건부에 여러개의 조건 동시에 검사
    fun judgeNumber(number: Int) {
        when (number) {
            1, 0, -1 -> println("기본 숫자입니다")
            else -> println("기본 숫자가 아닙니다")
        }
    }

    // when을 값 없이 early return 처럼 사용할 수 있다
    // java 코드 참고해보기
    fun judgeNumber2(number: Int) {
        when {
            number == 0 -> println("0")
            number % 2 == 0 -> println("짝수")
            else -> println("홀수")
        }
    }

}