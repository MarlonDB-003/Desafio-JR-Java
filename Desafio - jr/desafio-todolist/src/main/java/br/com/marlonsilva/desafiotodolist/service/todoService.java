package br.com.marlonsilva.desafiotodolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.marlonsilva.desafiotodolist.entity.todo;
import br.com.marlonsilva.desafiotodolist.repository.todoRepository;

@Service
public class todoService {

    private todoRepository TodoRepository;
    
    public todoService (todoRepository TodoRepository){
        this.TodoRepository = TodoRepository;
    }

    public List<todo> create(todo Todo){
        TodoRepository.save(Todo);
        return list();
    }

    public List<todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return TodoRepository.findAll(sort);
    }

    public List<todo> update(todo Todo){
        TodoRepository.save(Todo);
        return list();
    }

    public List<todo> delete(Long id){
        TodoRepository.deleteById(id);;
        return list();
    }
    
}
