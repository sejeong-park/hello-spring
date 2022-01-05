package sejeong_park.hellospring.repository;

import org.springframework.stereotype.Repository;
import sejeong_park.hellospring.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;



    @Override
    public Member save(Member member) {
        // save 할 때 메모리에 저장을 해야함
        // store에 넣기 전에 member에 ID 값을 세팅해줌
        member.setId(++sequence); // 멤버를 저장할 때 sequence 값을 올려줌

        store.put(member.getId(), member); // Map에 저장 됨

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // store에서 꺼내면 됨

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // name을 찾는 것
        // store의 value값과 member.getName()과 같은 변수 name값을 찾는 것
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // values가 member들이므로 멤버들을 반환
    }

    @Override
    public void clearStore() {
        store.clear(); //비우기
    }

    @Override
    public Optional<Member> findId(Long memberId) {
        return Optional.empty();
    }
}