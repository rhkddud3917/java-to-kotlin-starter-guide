package com.lannstark.lec10

interface Swimable {

    // 코틀린에서는 backing field가 없는 프로퍼티를 인터페이스에 만들 수 있다
    // 실제로 이 프로퍼티는 하위 클래스에서 구현을 하고 하위클래스에서 존재하는 것이다
    val swimAbility: Int

    // 인터페이스에서 직접 넣어줄 수 있는데 이러면 default값이 되는 것이다
    // 일단 3이라는 값을 가지고 있고 추가 override하고 싶다면 하위클래스에서 정의하는것이다
    val swimAbility2: Int
        get() = 3

    // defalut를 쓰지 않아도 자동으로 적용해준다
    fun act() {
        // 하위에서 구현이 된다고 믿고 인터페이스 내에서 자유롭게 사용이 가능하다
        println(swimAbility)
        println("어푸 어푸")
    }
}