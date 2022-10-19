package com.lannstark.lec14

// enum class 특징 (java, kotlin)
// 추가적인 클래스를 상속받을 수 없고 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤이다
// 앞에 enum만 붙이면 된다
enum class Country(
    private val code: String
) {
    KOREA("ko"),
    AMERICA("us"),
    ADD("...")
}

// when은 Sealed class와 함께 쓸때 더욱 효과가 좋다
fun handelCountry(country: Country) {
    // enum에 어떤것이 있는지 컴파일타임에 다 알고 있으므로 else를 쓰지 않아도 된다!!
    // enum값이 추가가 되면 when에 노란박스가 뜨면서 항목이 추가되어야 함을 알려준다
    // return을 하는 경우에는 새로 추가된 ADD가 누락될 경우 배제되었다고 알림을 준다
    // 조금더 읽기 쉽고 enum에 변화가 있어도 안전하게 처리가 가능하다
//    return when (country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }

}