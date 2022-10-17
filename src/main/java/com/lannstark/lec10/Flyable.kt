package com.lannstark.lec10

interface Flyable {

    // defalut를 쓰지 않아도 자동으로 적용해준다
    fun act() {
        println("파닥 파닥")
    }

    // 추상 메서드
//    fun fly()
}