package com.lannstark.lec10

class Penguin(
    species: String
// 인터페이스를 구현할 때에도 똑같이 : 를 사용한다 콤마로 뒤에 연결해서 붙여주면 된다
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭 펭")
    }

    // 프로퍼티를 override하기 위해서는 상위클래스에서 open 키워드를 붙여야 한다
    override val legCount: Int
        // 상위 클래스에 접근하는 키워드는 super로 동일하다
        get() = super.legCount + this.wingCount

    override fun act() {
        // 중복되는 인터페이스를 특정할 때에는 super<타입>.함수 를 사용하면 된다
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override val swimAbility: Int
        get() = 3
}