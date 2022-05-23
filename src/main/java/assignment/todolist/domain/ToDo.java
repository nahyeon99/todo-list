package assignment.todolist.domain;

import java.time.LocalDateTime;

// ToDo entity
public class ToDo {
    private Long id; // 식별자
    private String content; // 내용
    private boolean isCompleted; // 완료 여부 (or String)
    private LocalDateTime createdAt; // 생성날짜
    private LocalDateTime updatedAt; // 수정날짜
    private Member member; // 회원

    // getter, setter
    public void setMember(Member member) {
        this.member = member;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Member getMember() {
        return member;
    }

    // 생성 메서드
    public ToDo createToDo(Member member, String content) {
        ToDo todo = new ToDo();

        todo.setMember(member);
        todo.setContent(content);
        todo.setIsCompleted(false);
        todo.setCreatedAt(LocalDateTime.now());

        return todo;
    }
}
