package com.lannstark.lec17

// 코틀린에서 람다를 다루는 방법
// 강의노트 참고!!!!!!!!!!!!!!!!
class Lec17MainKT {
    // java에서 람다를 다루기 위한 노력
    /*
    자바에서 함수는 변수에 할당되거나 파라미터로 전달할 수 없다 (2급시민)
    자바에서는 함수를 넘기는 것처럼 보여지지 근본적으로 넘길 수 없다
     */


}

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 코틀린에서의 람다
    /*
    코틀린에서는 함수가 그 자체로 값이 될 수 있다.
    변수에 할당할수도, 파라미터로 넘길 수도 있다

    함수의 타입: (파라미터 타입...) -> 반환 타입
     */
    // 함수 이름이 없고 바로 파라미터를 적는다
    // 람다를 만드는 방법 1
    // isApple의 타입은 Fruit를 받아서 Boolean을 반환하는 함수라는 뜻이다
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    // 람다를 만드는 방법 2
    // 이 방법이 더 많이 쓰인다
    val isApple2: (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}
    // 람다를 직접 호출하는 방법 1
    isApple(fruits[0])
    // 람다를 직접 호출하는 방법 2
    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple)
    // 바로 함수 블록을 넣어주는 것도 가능하다
    filterFruits(fruits, {fruit: Fruit -> fruit.name == "사과"})
    // 가장 마지막 파라미터가 함수일 때 중괄호를 소괄호 밖으로 빼면 자동으로 마지막 파라미터로 들어간다
    filterFruits(fruits) {fruit: Fruit -> fruit.name == "사과"}
    // 타입을 추론 가능하면 생략가능하다
    filterFruits(fruits) {fruit -> fruit.name == "사과"}
    // 파라미터가 1개이면 파라미터를 it으로 쓸 수있다 -> 이 방식은 비추한다 위의 방법 사용하라 사용하는 곳에서 무엇인지 모르기 때문
    filterFruits(fruits) {it.name == "사과"}
    // 람다를 여러 줄 작성할 경우에는 return을 따로 명시하지 않더라고 마지막 줄의 결과가 람다의 반환값이다
    filterFruits(fruits) {fruit ->
        println("asdf")
        fruit.name == "사과"
    }


    // Closure
    /*
    자바에서는 람다를 쓸 때 람다 밖에 있는 변수를 사용하는 경우 제약이 있다
    final인 변수 혹은 실질적으로 final인 변수만 사용할 수 있다
    Lec17Main.java 참고
    */
    /*
    코틀린에서는 가능하다 (non - final
    코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있는다
    이렇게 해야만, 람다를 진정한 일급 시민으로 간주할 수 있다
    이 데이터 구조를 Clusure이라고 부른다
    */
    var target = "asdf"
    target = "asdfasdf"
    filterFruits(fruits) {it.name == target}


    // try with resources -> use 코드 분석 (7강 참고)
    /*
    Closeable을 구현한 T에 대한 확장함수이고
    inline 함수이다
    람다를 받게 만들어진 함수이다
     */


    // 필터와 맵
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    val apples2 = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }
    val applePrices = apples.map { fruit -> fruit.price }
    val applePrices2 = apples2.mapIndexed { idx, fruit ->
        println(idx)
        fruit.price
    }
    // mapping의 결과가 null이 아닌 것만 가져오고 싶을 때
    val values = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> null }
    // all : 조건을 모두 만족하면 true 아니면 false
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }
    // none : all과 반대
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }
    // any : 조건을 하나라도 만족하면 true 아니면 false
    val isAnyApple = fruits.any { fruit -> fruit.name == "사과" }
    // 수
    val fruitCount = fruits.count()
    // 오름차순 정렬
    val fruitOrdered = fruits.sortedBy { fruit -> fruit.price }
    // 내림차순 정렬
    val fruitOrdered2 = fruits.sortedByDescending { fruit -> fruit.price }
    // 변형된 값을 기준으로 중복을 제거
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }
    // first : 첫번째 값 가져온다 (무조건 Null 이 아니어야함) 빈 리스트면 exception 발생
    fruits.first()
    // firstOrNull : 첫번째 값 또는 null을 가져온다
    fruits.firstOrNull()
    // last, lastOrNull
    // list를 map으로 (이름을 기준으로)
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    // price -> 과일 map
    // value에 list가 아닌 단일객체가 들어간다
    // 중복되지 않은 key로 map을 만들 때 사용한다
    val map2: Map<Int, Fruit> = fruits.associateBy { fruit -> fruit.price }
    // key와 value를 동시에 처리
    // 함수(중괄호)가 하나인 경우는 () 밖으로 뺄 수 있지만 2개 이상인 경우는 () 안에 넣어주는것이 컨벤션이다
    val map3: Map<String, List<Int>> = fruits.groupBy({ fruit -> fruit.name}, {fruit -> fruit.price})
    val map4: Map<String, Int> = fruits.associateBy({ fruit -> fruit.name}, {fruit -> fruit.price})
    // map에서도 앞에 나온 기능들을 대부분 사용할 수 있다
    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }
    // 중첩된 컬렉션 처리 (List<List<Fruit>>)
    // flatMap을 쓰면 list<list>가 단일 list로 바뀌게 되고 그 과정에서 조건을 걸 수도 있다
//    val samePriceFruits = fruitsInList.flatMap { list ->
//        list.filter { fruit -> fruits.factoryPrice == fruit.currentPrice }
//    }
    // 아래와 같이 확장함수를 이용해서 리팩토링도 가능
//    val List<Fruit>.samePriceFilter: List<Fruit>
//        get() this.filter(Fruit::isSamePrice)
//    val samePriceFruits = fruitsInList.flatMap { list -> list.samePriceFilter }
    // List<List<Fruit>>를 List<Fruit>로 그냥 바꿀때
    // flatten을 사용하면 중첩된 컬렉션이 단순히 평탄하게 바뀐다
//    fruitsInList.flattten()


}

// 함수 인터페이스를 사용하는 것이 아니라 함수 자체를 넘길 수 있다
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
//    val results = mutableListOf<Fruit>()
//    for (fruit in fruits) {
//        if (filter(fruit)) {
//            results.add(fruit)
//        }
//    }
//    return results

    return fruits.filter(filter)
}


