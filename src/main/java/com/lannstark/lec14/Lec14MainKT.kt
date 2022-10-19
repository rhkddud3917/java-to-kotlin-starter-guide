package com.lannstark.lec14

// 코틀린에서 다양한 클래스를 다루는 방법
fun main() {
    handleCar(Avante())
}

// Sealed class
/*
상속이 가능하도록 추상클래스를 만들까 하는데 외부에서는 이 클래스를 상속 받지 않았으면 좋겠을 때 사용하고 싶다
따라서 우리가 작성한 클래스만 하위 클래스가 되도록 봉인하자라는 의미에서 만들어졌다

컴파일 타임 때 하위 클래스의 타입을 모두 기억한다
즉, 런타임 때 클래스 타입이 추가될 수 없다
하위 클래스는 같은 패키지에 있어야 한다
Enum과 다른점
- 클래스를 상속받을 수 있다
- 하위 클래스는 멀티 인스턴스가 가능하다
*/
// 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다 -> 런타임 때 클래스 타입이 추가될 수 없다
// 위의 장점으로 추상화가 필요한 Entity 나 Dto에는 sealed class를 주로 활용한다
sealed class HyundaCar(
    val name: String,
    val price: Long
)

class Avante : HyundaCar("avante", 1000L)
class Sonata : HyundaCar("sonata", 2000L)
class Grandeur : HyundaCar("grandeur", 3000L)

// when과 enum class를 같이 사용할 때와 같은 효과를 얻을 수 있다
// Country.kt 참고
private fun handleCar(car: HyundaCar) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
    }
}