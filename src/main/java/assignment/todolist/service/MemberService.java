package assignment.todolist.service;

import assignment.todolist.domain.Member;
import assignment.todolist.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;

    // 생성자로 객체 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member) {
        checkMemberDuplicate(member); // 회원 중복체크
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 중복 확인 메서드
    private void checkMemberDuplicate(Member member) {
        List<Member> findMember = memberRepository.findEmail(member.getEmail());

        if(findMember != null) {
            throw new IllegalStateException("중복된 회원이 존재합니다.");
        }
    }

    public List<Member> findAllMember() {
        return memberRepository.findAllMember();
    }

    public Member findOneMember(Long id) {
        return memberRepository.findMember(id);
    }

    public void update(Long id, int age, String name) {
        Member member = memberRepository.findMember(id);
        member.setAge(age);
        member.setName(name);
        member.setUpdatedAt(LocalDateTime.now());
    }
}
