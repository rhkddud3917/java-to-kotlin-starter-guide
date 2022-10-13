package com.lannstark.lec08

// 코틀린에서 함수를 다루는 방법
class Lec08MainKT {
    fun main() {
        this.repeat("hello world")
    }

    // 함수 선언 문법
    /*
    public은 생략 가능하다
    함수가 하나의 결과 값이면 block 대신 = 사용이 가능하다
    = 을 쓰면 반환형 생략이 가능하다
    block을 사용하는 경우에는 반환 타입이 Unit이 아니면 명시적으로 작성해주어야 한다
    한줄작성이 가능하다
    함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 있다 또한 한파일 안에 여러 함수가 있을 수 있다
     */
    public fun max(a: Int, b: Int): Int {
        if (a > b) {
            return a
        }
        return b
    }
    // ->
    // 함수가 하나의 결과 값이면 block 대신 = 사용이 가능하다
    fun max2(a: Int, b: Int): Int =
        if (a > b) {
            a
        } else {
            b
        }
    // ->
    // 타입 추론이 가능하기 때문에 반환형을 생략 가능하고 -> 중괄호(block)가 아닌 = 을 썼기에 가능하다
    // 한줄로 작성도 가능하고
    // 중괄호도 생략 가능하다
    fun max3(a: Int, b: Int) = if (a > b) a else b


    // default parameter
    /*
    대부분의 경우가 특정 파라미터를 똑같은 값을 사용하는 경우
    java에서는 오버로딩을 통해 해당 파라미터를 디폴트로 넣어주는 똑같은 이름의 함수를 만들었다. -> java 코드 참고 (메서들르 여러개 만들어야 한다)
    코틀린에서는 파라미터에 = 을 붙여서 디폴트 값을 설정할 수 있다
    밖에서 파라미터를 넣어주지 않을 경우에만 기본 값을 사용한다
    물론 코틀린에도 오버로딩 기능은 있다
     */
    fun repeat(
        str: String,
        num: Int = 3,
        useNewLine: Boolean = true
    ) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            } else {
                print(str)
            }
        }
    }


    // named argument
    /*
    여러개의 default parameter가 존재할 때 특정 파라미터에만 값을 넣어주고 싶을 때 사용
    repeat 함수를 참고
    매개변수를 이름을 통해 직접 지정, 지정되지 않은 매개변수는 기본값 사용
    builder를 직접 만들지 않고 builder의 장접을 가지게 된다
    주의점 : 코틀린에서 자바 함수를 가져다 사용할 경우에는 사용할 수 없다
    -> 코틀린에서 java 코드를 쓸 때 jvm상에서 java가 바이트코드로 변환될 때 파라미터 이름을 보존하지 않기 때문
     */
    fun namedArgument() {
        this.repeat("hello world", useNewLine = false)
        // builder를 직접 만들지 않고 builder의 장접을 가지게 된다
        // 함수에서 같은 자료형일 경우 파라미터의 순서를 헷갈릴 일이 없어지게 된다
        this.printNameAndGender(name = "eddie", gender = "male")
    }
    fun printNameAndGender(name: String, gender: String) {
        println(name)
        println(gender)
    }


    // 같은 타입의 여러 파라미터 받기 (가변인자)
    /*
    자바에서는 ...을 사용했고 사용하는 쪽에서는 배열을 작접 넣거나 ,(콤마)를 이용해 여러 파라미터를 넣었다
    코틀린에서는 vararg를 앞에 써준다
     */
    // vararg를 써줘야 한다
    fun printAll(vararg strings: String) {
        for (str in strings) {
            println(str)
        }
    }
    fun usePrintAll() {
        // 콤마를 사용할 때는 자바와 동일
        this.printAll("A", "B", "C")

        // 배열을 만들어서 넣으려면 앞에 *(spread 연산자)를 붙여서 넣어줘야 한다
        // 배열안에 있는 것들을 ,를 쓰는 것처럼 꺼내준다는 의미
        val array = arrayOf("A", "B", "C")
        this.printAll(*array)
    }

}

// 함수는 파일 최상단에 있을 수 있다 (kt파일안에 있다)
fun fileFunction(a: Int) = a