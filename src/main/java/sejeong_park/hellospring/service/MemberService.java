package sejeong_park.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sejeong_park.hellospring.domain.Member;
import sejeong_park.hellospring.repository.MemberRepository;
import sejeong_park.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService (MemberRepository memberRepository){ // 외부에서 넣어주도록
        this.memberRepository = memberRepository;
    }


    /** 회원 가입 **/
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 X
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId(); // 아이디 반환
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름이 있는 중복 회원 찾기
        memberRepository.findByName(member.getName())
        .ifPresent(m ->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            }); // 멤버에 값이 있으면, 이미 존재하는 회원이라고 동작하기
    }
    /**전체 회원 조회**/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
