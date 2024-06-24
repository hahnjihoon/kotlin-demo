package com.example.demo.member.controller

import com.example.demo.common.dto.BaseResponse
import com.example.demo.member.dto.MemberDtoRequest
import com.example.demo.member.service.MemberService
import com.fasterxml.jackson.databind.ser.Serializers.Base
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController (
    private val memberService: MemberService
) {
    //회원가입
//    @PostMapping("/signup")
//    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): String {
//        return memberService.signUp(memberDtoRequest)
//    }
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid memberDtoRequest: MemberDtoRequest): BaseResponse<Unit> {
        val resultMsg: String = memberService.signUp(memberDtoRequest)
        return BaseResponse(message = resultMsg)
    }
}