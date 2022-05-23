package assignment.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import assignment.todolist.domain.ToDo;
import assignment.todolist.repository.ToDoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    //추가
    @Transactional
    public Long join(ToDo toDo){
        toDoRepository.save(toDo);
        return toDo.getId();
    }
    //수정
    @Transactional
    public void update(Long id,Boolean isCompleted){
        ToDo toDo =toDoRepository.findOne(id);
        toDo.setIsCompleted(isCompleted);
        toDo.setUpdatedAt(LocalDateTime.now());
    }

    //삭제
    @Transactional
    public  void deleteToDo(Long todoId){
        toDoRepository.deleteToDo(todoId);
    }
    //조회
    public ToDo findOne(Long id){return toDoRepository.findOne(id);}
    public List<ToDo> findAllWIthMemberToDo() {return toDoRepository.findAllWIthMemberToDo();}
    public ToDo findId(Long id){return toDoRepository.findIdWithMember(id);}
}
