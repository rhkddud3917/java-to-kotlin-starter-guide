package com.lannstark.lec20

import com.lannstark.lec19.Person

class Lec20MainKT {
}

// scope function
/*
일시적인 영역을 형성하는 함수
람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaining 에 활용하는 함수를 scope function이라고 한다
let, run, also, apply, with 가 있다 사용법은 찾아보면서 익히는 것을 추천
with : 확장함수 아님
let, run -> 람다의 결과를 반환
also, apply -> 객체 그 자체를 반환
let, also -> it 사용 (it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다)
run, apply -> this 사용 (this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다)
with : with(파라미터, 람다) : this를 사용해 접근하고, this는 생략 가능

꼭 scope function을 쓴다고 좋은 코드는 아니다
읽기 어렵고 디버깅도 더 어려워진다
사용빈도가 적은 관용구는 코드를 더 복잡하게 만들고 이런 관용구들을 한 문장 내에서 조합해 사용하면 복잡성이 훨씬 증가한다

적절한 컨벤션을 적용하면 유용하게 사용할 수 있다
 */
fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }
}
// ->
fun printPerson2(person: Person?) {
    // let을 통해서 람다를 넣어줌으로서 일시적인 영역이 생긴다
    person?.let {
        println(person.name)
        println(person.age)
    }
}

fun main() {
    val person = Person("asdf", 100)

    // age가 들어간다
    val value1 = person.let {
        it.age
    }
    // (it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다)
    // let은 일반함수를 받는다 (T) 일반함수는 파라미터를 받아서 파라미터를 함수 내부에서 호출
    // 그래서 파라미터에 대한 이름을 직접 넣어줄 수 있다
    val value12 = person.let { p ->
        p.age
    }
    // 하나 이상의 함수를 call chain 결과로 호출할 때 사용
    val strings = listOf("asdf", "asdfasdf")
    strings.map { it.length }
        .filter { it > 3 }
//        .let(::println)
            // 위와 동일한 코드 리스트 전체에 대해서 호출이 된다
        .let { lengths -> println(lengths)}
    // non-null 값에 대해서만 코드 블럭을 실행시킬 때
    // 제일 많이 사용되는 경우
    val str = "asdf"
    val length = str?.let {
        println(it.toUpperCase())
        it.length
    }
    // 일회성으로 제한된 영역에 지역변수를 만들 때 그 과정에서 추가적인 변수를 쓰고 싶지 않을 때
    // 주로 안씀 private 함수로 빼는게 좋음

    // age가 들어간다
    val value2 = person.run {
        this.age
    }
    // (this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다)
    // run은 확장함수를 받는다 T.() 확장함수는 본인 자신을 this로 호출하고, 생략할수 있었다
    val value22 = person.run {
        age
    }
    // 객체 초기화와 반환 값의 계산을 동시에 해야 할 때
    // 디비에 저장하고 반환을 동시에 함
    // db에 저장되는 person이 반환된다
    // 개인적으로는 잘 사용하지 않는다고 함, 반복되는 생성 후처리는 생성자, 프로퍼티, init block으로 넣는 것이 좋다
//    val person = Person("asdf", 100).run(personRepository::save)

    // person이 들어간다
    val value3 = person.also {
        it.age
    }
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때 사용
    mutableListOf("one", "two", "three")
        .also { println("four 추가 이전 지금 값: $it") }
        .add("four")

    // person이 들어간다
    val value4 = person.apply {
        this.age
    }
    // 객체 그 자체가 반환된다
    // 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때 사용
    // Test Fixture를 만들 때
//    fun createPerson(
//        name: String,
//        age: Int,
//        hobby: String,
//    ) : Person {
//        return Person(
//            name = name,
//            age = age,
//        ).apply {
//            this.hobby = hobby
//        }
//    }

    with(person) {
        println(name)
        println(this.age)
    }
    // 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때
    // this를 생략할 수 있어 필드가 많아도 코드가 간결해진다
//    return with(person) {
//        PersonDto(
//            name = name, -> name = person.name
//            age = age,
//        )
//    }

}