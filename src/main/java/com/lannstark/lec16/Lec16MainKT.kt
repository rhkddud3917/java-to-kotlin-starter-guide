package com.lannstark.lec16

import javax.print.attribute.standard.MediaSize

// 코틀린에서 다양한 함수를 다루는 방법
class Lec16MainKT {
    fun main() {
        val str = "ABC"
        print(str.lastChar())

        val person = Person("asdf", "asdf", 100)
        person.nextYearAge()
    }
}

// 확장함수
/*
자바 코드 위에 자연스럽게 코틀린 코드를 추가할 수 없을까?
, 자바로 만든 라이브러리를 유지보수할 때 코틀린 코드를 덫붙이고 싶을 때
-> 어떤 클래스 안에 있는 메소드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자
-> 클래스의 멤버 함수처럼 사용이 가능하다

확장함수가 public이고 수신객체 클래스의 private함수를 가져오면 캡슣화가 깨진다?
-> 확장함수는 클래스에 있는 private, protected 멤버를 가져올 수 없다

확장함수와 멤버함수의 시그니쳐가 동일한 경우
-> 멤버함수가 우선적으로 호출된다
-> 확장함수를 만들었지만, 다른 기능의 똑같은 멤버함수가 생기면 오류가 발생할 수 있다

확장함수가 오버라이드 된다면
Srt가 Train을 상속받는 경우
val train: Train -> Train의 확장함수
val srt1: Train -> Train의 확장함수
val srt2: Srt -> Srt의 확장함수
-> 해당변수의 현재 타입 즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다

자바에서는 코틀린의 확장함수를 정적 메소드를 부르는 것처럼 사용가능하다
ex) Lec16MainKTKt.lastChar("ABC")
Lec16Main.java 참고

확장 프로퍼티에도 적용이 된다
확장 프로퍼티의 원리는 확장함수 + cumtom getter와 동일하다
 */
/*
fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
    this를 이용해 실제 클래스 안의 값에 접근
}

확장하려는 클래스를 수신객체타입, this를 수신객체라고 한다
*/
// String 클래스를 확장하는 것이다
fun String.lastChar(): Char {
    // 함수 안에서는 this를 통해 인스턴스에 접근 가능하다
    return this[this.length - 1]
}
// 멤버함수와 확장함수의 시그니처가 같은 경우
fun Person.nextYearAge(): Int {
    println("확장함수")
    return this.age + 1
}
// 확장 프로퍼티에도 적용이 된다
val String.lastChar: Char
    get() = this[this.length - 1]


// 중위 (infix) 함수
/*
변수.함수이름(argument) 대신
변수 함수이름 argument

멤버함수에도 붙일 수 있다
 */
fun Int.add(other: Int): Int {
    return this + other
}
infix fun Int.add2(other: Int): Int {
    return this + other
}
fun main() {
    3.add(3)
    // infix는 두가지방식 모두 사용가능
    2 add2 4
    3.add2(3)
}


// inline 함수
/*
함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
바이트 코드로 변환을 해보면 함수안의 로직이 함수를 호출하는 쪽에 복붙이 되어 사용이 된다
-> 함수를 파라미터로 전달할 때에 오버헤드를 줄일 수 있다
-> 하지만 inline함수의 사용은 성능 측정과 함께 신중하게 사용되어야 한다
 */
inline fun Int.add3(other: Int): Int {
    return this + other
}


// 지역함수
/*
함수안에 함수를 선언할 수 있다
함수 내에서 중복되는 코드를 함수화 할 수 있다
-> 함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 때 사용
그러나 depth가 깊어지기도하고 코드가 깔끔하지 않다

비추한다
 */
fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            TODO()
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}