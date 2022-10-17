package com.lannstark.lec10

// 코틀린에서 상속을 다루는 방법
class Lec10MainKT {

}

fun main() {
    // 클래스를 상속받을 때 주의점
    /*
    상위 클래스에서 하위 클래스가 오버라이드 하고 있는 프로퍼티를 생성자 블록이 init블락에서 사용하면 이상한 값이 나갈 수 있기 때문에
    상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 한다
    하위 클래스에서 오버라이드 하고 있는 프로퍼티에 접근하면 안된다 (final이 아닌 프로퍼티에 접근을 하면 안된다)

    정리 : 상위 클래스에서 오버라이드 된 값에 접근을 하면 하위 클래스에 재정의 된 get함수에 접근하는 것이고
    하위 클래스의 값은 초기화가 되어 있지 않다
     */
    // Derived의 생성자에서는 Base의 생성자를 호출하고 Base를 생성한 후 Base의 init에서 하위 클래스의 number를 호출하게 된다
    // 그러나 하위 클래스에서는 number가 초기화 되지 않은 상태이고 따라서 기본 값인 0이 출력이 된 후 하위 클래스 생성, 하위 클래스 init 실행된다
    Derived(300)

    // 키워드 정리
    // final : override를 할 수 없게 막는다, 기본으로 보이지 않게 존재한다
    // open : override를 열어준다
    // abstract : 반드시 override를 해야 한다
    // override : 상위 타입을 오버라이드 하고 있다 java에서는 오버라이드 어노테이션을 꼭 붙이지 않아도 됐지만
    //              코틀린에서는 오버라이드를 어노테이션이 아니라 키워드로서 반드시 붙여줘야 한다
}
// 상속이 가능하도록 open 키워드 넣음
open class Base(
    open val number: Int = 100
) {
    init {
        println("Base class")
        println(number)
    }
}


class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived class")
    }
}