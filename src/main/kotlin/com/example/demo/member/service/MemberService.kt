package com.example.demo.member.service

import com.example.demo.common.exception.InvalidInputException
import com.example.demo.member.dto.MemberDtoRequest
import com.example.demo.member.entity.Member
import com.example.demo.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService (
    private val memberRepository: MemberRepository
) {
    //회원가입
    fun signUp(memberDtoRequest: MemberDtoRequest): String{
        var member: Member? = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if(member != null){
//            return "이미 등록된 id입니다."
            throw InvalidInputException("이미 등록된 id")
        }

//        member = Member(
//            null,
//            memberDtoRequest.loginId,
//            memberDtoRequest.password,
//            memberDtoRequest.name,
//            memberDtoRequest.birthDate,
//            memberDtoRequest.gender,
//            memberDtoRequest.email
//        )
        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        return "회원가입완료"
    }
}