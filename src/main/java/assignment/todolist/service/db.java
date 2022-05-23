package assignment.todolist.service;

import assignment.todolist.domain.Member;
import assignment.todolist.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

// test db
@Component
@RequiredArgsConstructor
public class db {
    private final InitService initService;

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit() {
            Member member = createMember("홍길동", "111@111.com", 30);
            em.persist(member); // 엔티티 영구 저장하는 환경, Persistence Context
            ToDo todo = ToDo.createToDo(member, "코딩");
            ToDo todo2 = ToDo.createToDo(member, "코딩2");

            em.persist(todo);
            em.persist(todo2);
            em.flush();
        }

        public void dbInit2() {
            Member member = createMember("아무개", "222@222.com", 100);
            em.persist(member);
            ToDo todo = ToDo.createToDo(member, "코딩3");
            ToDo todo2 = ToDo.createToDo(member, "코딩4");
            em.persist(todo);
            em.persist(todo2);
            em.flush();
        }
        private Member createMember(String name, String email, Integer age) {
            Member member = new Member();
            member.setName(name);
            member.setEmail(email);
            member.setAge(age);
            member.setCreatedAt(LocalDateTime.now());
            return member;
        }
    }

}
