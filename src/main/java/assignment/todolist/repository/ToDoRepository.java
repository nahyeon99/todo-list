package assignment.todolist.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import assignment.todolist.domain.ToDo;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {
    private final EntityManager em;
    //저장
    public void save(ToDo todo) {
        em.persist(todo);
    }
    //단건조회
    public ToDo findOne(Long id){return em.find(ToDo.class,id);}

    //조회
    public List<ToDo> findAllWIthMemberToDo() {

        return em.createQuery(
                "select o from ToDo o" +
                        " join fetch o.member m"
                ,ToDo.class
        ).getResultList();
    }
    public ToDo findIdWithMember(Long id){
        return em.createQuery(
                "select o from ToDo o" +
                        " join fetch o.member m"+
                        " where o.id = :id"
                ,ToDo.class
        ).setParameter("id",id)
                .getSingleResult();
    }
    //삭제
    public void deleteToDo(Long todoId){
        em.remove(findOne(todoId));
    }

}
