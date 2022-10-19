package com.lannstark.lec14

// 앞에 data를 붙이면 data class로 인식을하고 (dto)
// 자동으로 equals, hashCode, toString을 만들어준다 (롬복 필요없음)
// named argument까지 활용을 하면 builder pattern을 쓰는 것과 동일한 효과가 있다
// 따라서 builder, equals, hashCode, toString모두 처리가 되는 것이다
data class PersonDto(
    val name: String,
    val age: Int
) {
}

fun main() {
    val dto1 = PersonDto("asdf", 11)
    val dto2 = PersonDto("asdfasdf", 11)
    println(dto1.equals(dto2))
    println(dto1.toString())
}