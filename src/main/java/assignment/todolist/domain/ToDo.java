package assignment.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id; // 식별자

    @Column(nullable = false)
    private String content; // 내용
    private boolean isCompleted; // 완료 여부 (or String)
    private LocalDateTime createdAt; // 생성날짜
    private LocalDateTime updatedAt; // 수정날짜

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; // 회원

    public void setMember(Member member) {
        this.member = member;
        member.getTodoList().add(this);
    }

    // 생성 메서드
    public ToDo createToDo(Member member, String content) {
        ToDo todo = new ToDo();

        todo.setMember(member);
        todo.setContent(content);
        todo.setCompleted(false);
        todo.setCreatedAt(LocalDateTime.now());

        return todo;
    }
}
