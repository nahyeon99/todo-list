package assignment.todolist.controller;

import assignment.todolist.domain.Member;
import assignment.todolist.domain.ToDo;
import assignment.todolist.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 회원 리스트 조회

    @GetMapping("/members")
    public Result findAllMember() {
        List<Member> members = memberService.findMembers();
        List<MemberToDo> collect = members.stream()
                .map(m->new MemberToDo(m))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    // 회원 등록
    @PostMapping("/members")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.name);
        member.setAge(request.age);
        member.setEmail(request.email);
        member.setCreatedAt(LocalDateTime.now());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    // 회원 수정
    @PatchMapping("/members/{id}")
    public UpdateMemberResponse updateMember(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateMemberRequest request
    ) {
        memberService.update(id, request.getName(), request.getAge());
        Member findMember = memberService.findOne(id);

        return new UpdateMemberResponse(findMember.getId(), findMember.getName(), findMember.getAge());
    }

    // 회원 단건 조회
    @GetMapping("/members/{id}")
    public MemberToDo findMember(
            @PathVariable("id") Long id
    ) {
        Member member = memberService.findOne(id);
        return new MemberToDo(member);
    }


    // DTO
    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    static class CreateMemberRequest {
        @NotEmpty
        private String name;
        @NotEmpty
        private String email;
        private Integer age;
    }

    @Data
    static class CreateMemberResponse {
        private Long id;
        public CreateMemberResponse(Long id) {this.id = id;}
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberRequest {
        @NotEmpty
        private String name;

        private Integer age;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
        private Integer age;
    }

    @Data
    @AllArgsConstructor
    private class MemberToDo {
        private Long id;
        private String name;
        private Integer age;
        private String email;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
        private List<TodoListDto> todoList;

        public MemberToDo(Member member) {
            id = member.getId();
            age = member.getAge();
            email = member.getEmail();
            createAt = member.getCreatedAt();
            updateAt = member.getUpdatedAt();
            name = member.getName();
            todoList = member.getTodoList().stream().map(todo -> new TodoListDto(todo)).collect(Collectors.toList());
        }

    }

    @Getter
    static class TodoListDto { // 로직을 가지지 않는 데이터 객체
        private Long todoId;
        private String content;
        private Boolean isCompleted;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;
        public TodoListDto(ToDo todo) {
            todoId = todo.getId();
            content = todo.getContent();
            isCompleted = todo.getIsCompleted();
            createAt = todo.getCreatedAt();
            updateAt = todo.getUpdatedAt();
        }
    }

}
