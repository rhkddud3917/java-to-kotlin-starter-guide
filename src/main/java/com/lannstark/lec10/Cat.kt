package com.lannstark.lec10

// 타입을 쓸때는 앞에 붙여서 : 를 사용했지만
// 상속을 할 때에는 extends 카워드를 사요하지 않고 한 칸 뛰고 : 를 사용하면 된다
class Cat (
    species: String
// 상위 클래스의 생성자를 여기에서 호출한다
// 무조건 상위 클래스의 생성자를 바로 호출해야 한다
) : Animal(species, 4) {
    override fun move() {
        println("고양 고양")
    }
}