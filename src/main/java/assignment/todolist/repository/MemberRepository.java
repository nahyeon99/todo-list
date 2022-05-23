package assignment.todolist.repository;

import assignment.todolist.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 조회
    public Member findMember(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // 회원 이메일 중복체크를 위한 이메일 조회
    public List<Member> findEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class).setParameter("email", email).getResultList();
    }
}
