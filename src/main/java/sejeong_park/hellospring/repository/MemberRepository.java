package sejeong_park.hellospring.repository;

import sejeong_park.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // Repository 에 4가지 기능

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    void clearStore();

    Optional<Member> findId(Long memberId);
}
