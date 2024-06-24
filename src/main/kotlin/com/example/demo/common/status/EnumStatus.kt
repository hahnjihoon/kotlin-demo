package com.example.demo.common.status

enum class Gender(val desc:String) {
    MAN("남"),
    WOMAN("여")
}

enum class ResultCode(val msg: String){
    SUCCESS("정상 처리 되었씁니다."),
    ERROR("에러 발생")
}