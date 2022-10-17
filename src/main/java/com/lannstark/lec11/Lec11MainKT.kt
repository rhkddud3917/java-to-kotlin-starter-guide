package com.lannstark.lec11

// 코틀린에서 접근 제어를 다루는 방법
class Lec11MainKT {
    // 코틀린의 가시성 제어
    /*
    public : 모든 곳에서 접근 가능(자바와 동일)
    protected : 선언된 클래스 또는 하위 클래서에서만 접근 가능 (자바에 비해 같은 패키지가 빠졌다)
                ㄴ 이유 : 코틀린에서는 패키지를 영역을 나누기 위한 용도로만 쓰지 가시성 제어에는 사용하지 않는다
    default : 사라짐
    internal : 같은 모듈에서만 접근 가능 (모듈 : 한 번에 컴파일 되는 코틀린 코드)
    private : 선언된 클래스내에서만 접근 가능(자바와 동일)

    기본 접근 지시어
    java : default
    kotlin : public
     */

    // 파일의 접근 제어
    // 코틀린에서는 파일 내에
    // 함수, 변수, 클래스를 만들 수 있다
    /*
    public : 기본값, 어디서든 접근가능
    protected : 파일(최상단)에는 사용 불가능 (클래스가 아니라 파일이므로)
    internal : 같은 모듈에서만 접근 가능
    private : 같은 파일 내에서만 접근 가능 (다른 파일에서는 해당 접근 불가능)
     */


    // 자바와 코틀린을 함께 사용할 때 주의할 점
    /*
    internal은 바이트 코드 상 public이 된다. 때문에 자바코드에서는 코틀린 모듈의 internal 코드를 가져올 수 있다
    코틀린의 protected와 자바의 protected는 다르다. 자바는 같은 패키지의 코틀린 protected멤버에 접근할 수 있다
     */


    // 유틸성 함수를 만들 때
    // 파일 최상단 함수를 이용한다 StringUtilsKT 참고하기
}

// 생성자의 접근 지시자는 public이 생략이 되어 있고 constructor도 생략이 되어 있어서
// 접근 지시자를 붙이려면 constructor 키워드를 꼭 써줘야 한다
class Cat private constructor() {
}

// 프로퍼티에 가시성을 설정하는 경우
class Car(
    // getter와 setter 한 번에 가시성을 설정하는 경우
    internal val name: String,
    private val owner: String,
    _price: Int
) {
    // getter, setter 따로 가시성을 설정하는 경우
    // getter는 public으로, setter는 private으로 설정됨
    var price = _price
        private set
}


