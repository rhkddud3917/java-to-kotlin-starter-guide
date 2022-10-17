package com.lannstark.lec11

// 코틀린에서는 유틸 코드를 직접 파일에 작성하여 사용하는 것이 훨씬 편하다
// 유틸 코드 : 인스턴스화를 막은 것 StringUtils참고
// 이렇게 만들면 java에서 static 함수로 만든것과 동일한 코드가 된다
// 자바에서 이 함수를 사용할 때 StringUtilsKT.isDirectoryPath() 처럼 마치 정적 메소드가 있는 것처럼 사용할 수 있다
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}