package assignment.todolist.domain;

import java.time.LocalDateTime;
import java.util.List;

// 회원 엔티티
public class Member {
    private Long id; // 식별자
    private String email; // 이메일
    private int age; // 나이
    private String name; // 이름
    LocalDateTime createdAt; // 생성날짜
    LocalDateTime updatedAt; // 수정날짜
    List<ToDo> todoList; // TODO 리스트


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<ToDo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<ToDo> todoList) {
        this.todoList = todoList;
    }
}
