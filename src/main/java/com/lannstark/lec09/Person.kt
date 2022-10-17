package com.lannstark.lec09

import java.lang.IllegalArgumentException

// public 생략가능
// 생성자는 위에 작성을 해야 함
//class Person constructor(name: String, age: Int){
// constructor 지시어는 생략 가능하다
//class Person (name: String, age: Int){
// 생성 동시에 프로퍼티를 만들 수 있다
// 맨 위에 생성되는 생성자를 주 생성자(primary constructor)라고 한다 반드시 존재해야 한다
// 주 생성자에 파라미터가 하나도 없을 경우에는 생략이 가능하다
class Person (
    // ㅋㅓ스텀 getter를 만들기 위해서는 val을 빼줘야 한다
    name: String, var age: Int, name2: String
) { // body에 아무것도 존재하지 않으면 생략가능하다
    // 위에서 자료형 명시했으므로 생략
//    val name = name
//    var age = age

    // 코틀린에서는 필드만 만들면 getter, setter 자동으로 만들어준다
    // 프로퍼티 : 필드, getter, setter

    // 클래스 생성시점에 한번 실행이 되는 블럭이다
    // java에서 생성자에 실행되는 로직을 여기에 넣으면 된다
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일수 없습니다")
        }
        println("초기화 블록")
    }

    // 기본 생성자는 맨위에 명시한 생성자이고
    // 그 다음 생성자를 추가할 경우에는 아래와 같이 만들어줘야 한다
    // 기본 생성자를 호출한다
    // 부 생성자는 있을 수도 있고 없을 수도 있다
    // 부 생성자는 최종적으로 주 생성자인 this를 호출해야 한다
    // 부 생성자는 다른 부 생성자를 호출 할 수 있지만 최종적으로는 주 생성자를 호출해야 한다
    // 부 생성자는 body를 가질 수 있다
    /*
     주의점 : 코틀린에서는 default parameter를 추천한다
     만약 그것이 불가능하면 정적 팩토리 메소드를 추천한다
     따라서 실제로는 부 생성자를 쓸 일이 거의 없다
     */
    constructor(name: String): this(name, 1, name) {
        println("부 생성자1")
    }

    constructor(): this("ㅁㄴㅇㄹ") {
        println("부 생성자2")
    }

    // 출력 순서
    // 초기화 블록 -> 부생성자1 -> 부생성자2
    // 호출 순서(?)
    // 부생성자2 -> 부생성자1 -> 초기화 블록


    // 커스텀 getter
    // 메모리와 무관(프로퍼티처럼 보이게 만들어도 java로 바꾸면 둘다 동일한 함수로 나온다)
    // 함수처럼 만들수도 있고 프로퍼티처럼 만들수도 있다
    /*
    객체의 속성이라면(프로퍼티라면) custom getter, 그렇지 않다면 함수형식을 사용하는 것을 추천한다
     */
    // 함수처럼 만들기
    fun isAdult_java(): Boolean {
        return this.age >= 20
    }
    // 프로퍼티 처럼 만드는 방식
    // 커스텀 getter
    // 호출이 되었을 때 getter처럼 아래 코드다 실행이 됨
    val isAdult: Boolean
        get() = this.age >= 20
//        get() {
//            return thies.age >= 20
//        }
    // 자기 자신을 변형해줄 수 있다
    // 커스텀 getter를 만들기 위해서는 생성자에서 val을 빼줘야 한다
    // 주 생성자에서 받은 name을 불변 프로퍼티 name에 대입
    val name: String = name
        // name 대신 field라는 키워드가 들어가야 한다
        /*
        name.toUpperCase()하게 되면 name을 가져와야 하고 그러면 getName()을 호출하게 된다
        무한루프가 발생하는 것이다
        따라서 이를 막기 위해 예약어 field를 사용하고
        이는 backing field라고 하여 자기 자신을 가리키는 예약어를 뜻한다
        */
        //
        get() = field.toUpperCase()
    // 위의 방식은 잘 사용하지 않는다
    // 아래와 같은 방식을 주로 사용한다
    // 밖에서 볼 때는 요구사항에 맞고 안에서 볼때는 요구사항에 맞는 프로퍼티가 하나 더 있다고 생각하면 됨
//    fun getUppercaseName2(): String = this.name.toUpperCase()
    val uppercaseName2: String
        get() = this.name.toUpperCase()

    // 커스텀 setter
    /*
    setter 자체를 지양하다보니
    backing setter도 잘 사용하지 않는다
     */
    var name2: String = name2
        set(value) {
            field = value.toUpperCase()
        }

}
fun main() {
    val person = Person("asdf", 11, "asdf")
    // getter, setter를 자동으로 호출해준다
    println(person.age)
    person.age = 10
    // java 클래스도 . 을 통하여 getter나 setter를 쓸 수 있다
    val javaPerson = JavaPerson("asdf", 11)
    println(javaPerson.name)
    javaPerson.age = 10
}