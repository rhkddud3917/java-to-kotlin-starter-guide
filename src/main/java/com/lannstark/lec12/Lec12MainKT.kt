package com.lannstark.lec12

// 코틀린에서 object 키워드를 다루는 방법
class Lec12MainKT {
}



class Person (
    var name: String,
    var age: Int,
) {

    // companion object
    /*
     코틀린에는 static이라는 키워드 자체가 없고
     대신에 companion object 블록 안에 넣어둔 변수와 함수가 자바의 static 변수와 함수처럼 동작한다

     companion: 클래스와 동행하는 유일한 오브젝트

     companion object 즉, 동반객체 하나의 객체로 간주된다
     때문에 이름을 붙일 수도 있고, interface를 구현할 수도 있다

     companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것을 추천한다

     자바에서 코틀린의 companion object를 사용하는 법은 Lec12Main 참고
     자바에서 코틀린의 companion object를 사용하려면 @JvmStatic을 붙여야 한다
     */
    companion object Factory : Log {
        // val만 있으면 런타임시에 값이 할당이 되는데
        // const를 붙이면 컴파일시에 변수가 할당이 된다
        /*
        const : 진짜 상수에 붙이기 위한 용도이고 기본 타입과 String에만 붙일 수 있다
         */
        private const val MIN_AGE = 1

        @JvmStatic // 이 어노테이션을 붙이게 되면 자바에서 사용하는 것처럼 바로 함수에 접근이 가능하다
        fun newBaby(name: String): Person {
            // 코틀린에서도 바로 MIN_AGE형태로 가져와 사용할 수 있다
            return Person(name, MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }

    interface Log {
        fun log()
    }

}

// 싱글톤
/*
앞에 object만 붙여주면 된다
 */
object Singleton {
    var a: Int = 0
}
// 하나이기 때문에 인스턴스화하는 것이 아니라 아래와 같이 사용한다
fun main() {
    println(Singleton.a)
    Singleton.a = 10
}


// 익명 클래스
fun main2() {
    // java에서는 new Movable
    // 코틀린에서는 object : 타입이름
    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }
        override fun fly() {
            TODO("Not yet implemented")
        }

    })
}
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}




