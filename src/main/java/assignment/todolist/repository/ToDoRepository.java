package assignment.todolist.repository;

import assignment.todolist.domain.ToDo;

import java.util.List;

// ToDo List 저장소 인터페이스
public interface ToDoRepository {

    void save(ToDo todo); // 저장
    ToDo findOneTodo(Long id); // todo 단건 조회
    List<ToDo> findAllTodo(); // todo 전체 조회
    ToDo findTodoById(Long id); // id로 todo 조회
    void deleteTodo(Long id); // todo 삭제
}
