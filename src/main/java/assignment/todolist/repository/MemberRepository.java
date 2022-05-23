package assignment.todolist.repository;

import assignment.todolist.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 회원 저장소 인터페이스
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    // 회원 저장
    void save(Member member) {
        store.put(member.getId(), member);
    }

    // 회원 조회
    Member findMember(Long id) {
        Member member = store.get(id);
        return member;
    }

    // 전체 회원 조회
//    List<Member> findAllMember() {
//
//    }

    // 회원 이메일 중복체크를 위한 이메일 조회
//    List<Member> findEmail(String email) {
//
//    }
}
