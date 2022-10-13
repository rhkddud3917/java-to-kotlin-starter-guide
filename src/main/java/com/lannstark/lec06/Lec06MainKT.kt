package com.lannstark.lec06

// 코틀린에서 반복문을 다루는 방법
class Lec06MainKT {
    fun main() {

        // 향상된 for문
        val numbers = listOf(1L, 2L, 3L)
        // : 대신에 in을 쓴다
        for (number in numbers) {
            println(number)
        }

        // 전통적인 for문
        /*
        Progression(등차수열)을 상속받는 Range를 만든다 (.., downTo, step)
        등차수열을 만들어서 순회한다고 생각하면 된다
        .., downTo, step도 함수이다(중위함수)
         */
        for (i in 1..3) {
            println(i)
        }
        // 내려가는 경우
        for (i in 3 downTo 1) {
            println(i)
        }
        // 2칸씩 올라가는 경우
        for (i in 1..5 step 2) {
            println(i)
        }

        // while문
        // 자바와 완전히 동일
        var i = 1
        while (i <= 3) {
            println(i)
            i++
        }


    }
}