package sejeong_park.hellospring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sejeong_park.hellospring.repository.MemberRepository;
import sejeong_park.hellospring.repository.MemoryMemberRepository;
import sejeong_park.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberServie(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


}
