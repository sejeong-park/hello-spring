package sejeong_park.hellospring.domain;

public class Member {

    private Long id; // 아이디 식별자 -> 시스템이 지정해주는 ID
    private String name; // 고객이 회원 가입 할 때 적는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
