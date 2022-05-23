package assignment.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id; // 식별자

    private String email; // 이메일
    private int age; // 나이
    private String name; // 이름
    LocalDateTime createdAt; // 생성날짜
    LocalDateTime updatedAt; // 수정날짜

    @OneToMany(mappedBy = "member")
    List<ToDo> todoList = new ArrayList<>();

}
