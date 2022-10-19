package com.lannstark.lec13

// 코틀린에서 중첩 클래스를 다루는 방법
class Lec13MainKT {

    // 중첩 클래스 종류
    // 1. static을 사용하는 중첩 클래스
    /*
    클래스 안에 static을 붙인 클래스, 밖의 클래스 직접 참조 불가
     */
    // 2. static을 사용하지 않는 중첩 클래스
    /*
    ㄱ. 내부 클래스 (inner class)
        - 클래스 안의 클래스, 밖의 클래스 직접 참조 가능 (ex. JavaHouse.this.address)
        - 바깥 클래스의 참조를 가지고 있다 (내부 클래스에서 바깥 클래스 참조를 가지고 바깥 클래스 필드 접근 가능)
        - 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고 이를 디버깅 하기 어렵다
        - 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아 직렬화에 있어 제한이 있다
        - 따라서 권장하지 않는다
        - JavaHouse 참고
    ㄴ. 지역 클래스 (local class)
        - 메소드 내부에 클래스를 정의 (실제로 거의 안씀)
    ㄷ. 익명 클래스 (anonymous class)
        - 일회성 클래스
     */

    // 코틀린에서는 그냥 class로 만들면
    // 권장되는 방법인 static 중첩 클래스로 자동으로 만들어 준다
    // 코틀린에서는 기본적으로 바깥 클래스 참조를 하지 않는다 바깥 클래스를 참조하고 싶다면 inner 키워드를 추가한다
}


class House(
    val address: String,
    val livingRoom: LivingRoom
) {
    // 코틀린에서는 그냥 class로 만들면
    // 권장되는 방법인 static 중첩 클래스로 자동으로 만들어 준다
    class LivingRoom(
        private val area: Double
    )

    // 권장되지 않는 inner class만드는 법
    inner class Inner(
        private val area: Double
    ) {
        val address: String
            // 바깥 클래스 참조를 위해 this@바깥클래스 를 사용한다
            get() = this@House.address
    }
}