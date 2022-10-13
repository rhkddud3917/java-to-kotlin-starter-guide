package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

// 코틀린에서 예외를 다루는 방법
class Lec07MainKT {
    fun main() {


    }

    // try catch finally
    /*
    아래 사항들을 제외하면 자바와 완전히 동일하다
    하나의 expression으로 인식한다
     */
    fun parseIntOrThrow(str: String): Int {
        try {
            // String도 기본타입이라서 to형변환을 사용한다
            return str.toInt()
        } catch (e: NumberFormatException) { // 자료형이 뒤에 쓰인다
            throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다")
        }
    }
    // try catch도 하나의 expression으로 인식해서 최종결과물 하나를 추출한다고 여겨 아래와 같이 사용할 수 있다
    fun parseIntOrThrowV2(str: String): Int? {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }


    // checked exception, unchecked exception
    // JavaFilePrinter참고해서 비교하기
    /*
    java와 비교하면 throws구문이 없다
    코틀린에서는 checked exception과 unckecked exception을 구분하지 않는다 모두 unchecked exception이다
     */
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }


    // try with resources
    // JavaFilePrinter참고해서 비교하기
    /*
    코틀린에서는 try with resources가 사라지고 use이라는 inline 확장함수를 사용한다
    자세한 것은 뒤에서 추가 설명이 나온다
     */
    fun readFile2(path: String) {
        BufferedReader(FileReader(path)).use { reader ->
            println(reader.readLine())
        }
    }

}

