package com.lannstark.lec15

// 코틀린에서 배열과 컬렉션을 다루는 방법
class Lec15MainKT {

    fun main() {
        // 배열
        /*
        자바와 마찬가지로 잘 쓰지 않는다
         */
        val array = arrayOf(100, 200)
        // 배열의 copy 없이 바로 추가가 가능하다
        array.plus(300)

        for (i in array.indices) {
            println("${i}, ${array[i]}")
        }
        // 인덱스와 값을 한번에 가져올 수 있다
        for ((index, value) in array.withIndex()) {
            println("${index}, ${value}")
        }


        // Collection
        // 불변인지, 가변인지 먼저 설정을 해주어야 한다!!
        // tip : 불변으로 만들고 꼭 필요한 경우 가변으로 바꾸자
        /*
        가변 (Mutable) 컬렉션 : 컬렉션에 element추가, 삭제할 수 있음
        불변 컬렉션 : 컬렉션에 element를 추가, 삭제할 수 없음
            ㄴ Collection을 만들자마자 Collections.unmodifiabeList() 등을 붙여준다
            ㄴ 불변이어도 레퍼런스타입의 element의 값은 바꿀 수 있다
         */
        // 불변 리스트 만들기
        val numbers = listOf(100, 200) // setOf
        // empty list는 타입을 명시적으로 적어주어야 한다
        val emptyList = emptyList<Int>()
        // empty list에서 타입 추론이 가능하면 꺽쇄 타입을 생략가능
        fun printNumbers(numbers: List<Int>) {} // 함수 파라미터에 타입이 명시되어 있음
        printNumbers(emptyList())
        // 값 가져오기
        println(numbers[0])
        // for each
        for (number in numbers) {
            println(number)
        }
        // 전통 for문 느낌
        for ((idx, value) in numbers.withIndex()) {
            print(idx)
            print(value)
        }
        // 가변 리스트 만드는 방법
        /*
        기본 구현체는 ArrayList이고 기타 사용법은 자바와 같다
         */
        val numbers2 = mutableListOf(100, 200)
        numbers2.add(300)
        // 기본 구현체는 LinkedHashSet
        val numbers3 = mutableSetOf(100, 200)

        // map
        // 가변
        val oldMap = mutableMapOf<Int, String>()
        // 넣는 방법은 두가지이다
        oldMap[1] = "asdf"
        oldMap[2] = "asdfasdf"
        oldMap.put(3, "asdfasdfasdf")
        // 불변
        // to 를 이용해서 키와 벨류를 구분
        mapOf(1 to "asdf", 2 to "asdfasdf")
        //
        for (key in oldMap.keys) {
            print(key)
            print(oldMap[key])
        }
        for ((key, value) in oldMap.entries) {
            print(key)
            print(value)
        }


        // 컬렉션의 null 가능성, 자바와 함께 사용하기
        /*
        List<Int?> -> list는 null이 들어갈 수 있지만, 리스트는 null이 아님
        List<Int>? -> 리스트에는 null이 들어갈 수 없지만, 리스트는 null일 수 있음
        List<Int?>? -> 리스트에 null이 들어갈 수 있고, 리스트도 null일 수 있음

        물음표 위치에 주의해서 사용해야 한다
         */
        /*
        자바는 읽기전용 컬렉션과 변경 가능 컬렉션을 구분하지 않는다
        - 자바에서 코틀린의 불변 컬렉션을 가져온다
        - 구분이 없으므로 컬렉션에 원소를 추가하거나 없앤다
        - 코틀린에서 다시 가져가면 에러 발생

        자바는 nullable / non-nullable을 구분하지 않는다
        - 자바에서 코틀린의 널이 들어갈 수 없는 리스트를 가져간다
        - 자바에서 널을 추가한다
        - 코틀린에 돌려준다 -> 오류 발생

        => 코틀린쪽의 컬렉션이 자바에서 호출되면 컬렉션 내요이 변할 수 있음을 감안해야 한다
            방어로직 등을 짜야한다
        => 코틀린쪽에선 Collections.unmodifiableXXX()를 활용하면 변경 자체를 막을 수 있다 (자바에도 존재하는 것)

        코틀린에서 자바 컬렉션을 가져다 사용할 때 플랫폼 타입을 신경써야 한다
        - 자바에서 List<Integer> 를 보낸다
        - 코틀린에서는 맨위의 널 가능성 3가지중 어느것인지 모른다
        => 자바 코드를 보며, 맥락을 확인하고 자바 코드를 가져오는 지점을 wrapping해야 한다
         */

    }


}