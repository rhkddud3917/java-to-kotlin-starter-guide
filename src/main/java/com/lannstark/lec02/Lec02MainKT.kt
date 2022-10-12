package com.lannstark.lec02

import java.lang.IllegalArgumentException

// 코틀린에서 null을 다루는 방법
class Lec02MainKT {
    fun main() {
        // Safe Call
        val str: String? = "ABC"
//        println(str.length) // 불가능
        println(str?.length) // 가능
        /*
        null이 아니면 실행을 하고 null이면 null를 반환
         */

        // Elvis 연산자
        val str2: String? = "ABC"
        str2?.length ?: 0
        /*
        앞의 연산 결과가 null이면 뒤의 값을 사용
        safe call과 같이 사용이 된다
         */

        // 플랫폼 타입
        /*
        java 클래스에서 어노테이션 @NotNull, @Nullable 등을 통애서 null관련 정보를 세팅을 하지 않으면
        코틀린이 null 관련 정보를 알 수 없고 런타임시 NPE가 발생할 수 있다
        이처럼 코틀린이 null관련 정보를 알 수 없는 타입을 플랫폼 타입이라고 한다
        어노테이션이 없다면 코틀린은 일단 된다고 생각을 한다 (null체크를 하는 빨간줄이 그어지지 않는다)
        따라서 코틀린에서 자바코드를 사용할 때에는 null관련 정보를 챙겨줘야 한다
         */
        var person = Person("asdf")
        // Person.getName이 어노테이션을 통해서 nullable이므로 (java코드 상에서) 빨간줄이 뜨게 된다
        // java와 같이 호환되어서 사용할 수 있다
        // 반대로 @NotNull
//        println(person.getName().length)

    }

    // null 아님 단언
    /*
    nullable type이지만, 아무리 생각해도 null이 될 수 없는 경우
    !! 를 쓰면 됨
    혹시나 Null이 들어오게 되면 런타임에 NPE발생함
    따라서 사용할 때 주의 필요
     */
    fun startsWithA0(str: String?): Boolean {
        // 절대 null이 아니라고 컴파일러에게 알려주는 것
        return str!!.startsWith("A")
    }

    fun earlyReturn(number: Long?): Long {
        number ?: return 0

        // 다음 로직
        return 1
    }

    fun startsWithA1(str: String?): Boolean {
        return str?.startsWith("A")
            ?: throw IllegalArgumentException("null")

//        if (str == null) {
//            throw IllegalArgumentException("null")
//        }
//        return str.startsWith("A")
    }

    // null을 반환할 수 있으므로 ? 붙여야 함
    fun startsWithA2(str: String?): Boolean? {
        return str?.startsWith("A")

//        if (str == null) {
//            return null
//        }
//        return str.startsWith("A")
    }

    fun startsWithA3(str: String?): Boolean {
        return str?.startsWith("A") ?: false

//        // str이 null일 수 있는데 반환타입에 null이 없으므로 빨간줄이 뜨게 됨
////        return str.startsWith("A")
//
//        if (str == null) {
//            return false;
//        }
//        // str이 초록색인 이유는 null이 아님을 컴파일러가 알려주는 것
//        return str.startsWith("A")
    }

    // str이 null이 아님을 보장해줄 때 (파라미터에 ?를 붙이지 않은 경우)
    fun startsWithA4(str: String): Boolean {
        return str.startsWith("A")
    }




}