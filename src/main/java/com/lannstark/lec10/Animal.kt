package com.lannstark.lec10

// 자바와 마찬가지로 코틀린에서도 추상클래스는 인스턴스화 할 수 없다
abstract class Animal (
    protected val species: String,
    // 코틀린에서는 프로퍼티를 override하기 위해서는 반드시 open을 붙여주어야 한다
    // Penguin 클래스 참고
    protected open val legCount: Int,
) {
    abstract fun move()
}