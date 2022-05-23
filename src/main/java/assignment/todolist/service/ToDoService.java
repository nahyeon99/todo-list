package assignment.todolist.service;

import assignment.todolist.domain.ToDo;
import assignment.todolist.repository.ToDoRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ToDoService {

    private final ToDoRepository todoRepository;

    // 생성자로 객체 주입
    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // 추가
    Long addTodo(ToDo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    // 수정 (완료여부만 수정 가능)
    void updateTodo(Long id, boolean isCompleted) {
        ToDo todo = todoRepository.findOneTodo(id);
        todo.setIsCompleted(true);
        todo.setUpdatedAt(LocalDateTime.now());
    }

    // 삭제
    void deleteTodo(Long id) {
        todoRepository.deleteTodo(id);
    }

    // 조회
    // todo 1건 조회
    ToDo findOneTodo(Long id) {
        return todoRepository.findOneTodo(id);
    }

    // 회원까지 전체 조회
    List<ToDo> findAllTodoWithMember() {
        return todoRepository.findAllTodo();
    }

    // todo id 조회
    ToDo findId(Long id) {
        return todoRepository.findTodoById(id);
    }

}
