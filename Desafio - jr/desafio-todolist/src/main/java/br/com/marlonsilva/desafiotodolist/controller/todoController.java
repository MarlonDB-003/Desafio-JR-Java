package br.com.marlonsilva.desafiotodolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marlonsilva.desafiotodolist.entity.todo;
import br.com.marlonsilva.desafiotodolist.service.todoService;

@RestController
@RequestMapping("/todos")
public class todoController {
    private todoService TodoService;

    public todoController(todoService TodoService) {
        this.TodoService = TodoService;
    }

    @PostMapping
    List<todo> create(@RequestBody todo Todo){
        return TodoService.create(Todo);
    }

    @GetMapping
    List<todo> list(){
        return TodoService.list();
    }

    @PutMapping
    List<todo> update(@RequestBody todo Todo){
        return TodoService.update(Todo);
    }
    
    @DeleteMapping("{id}")
    List<todo> delete(@PathVariable("id") Long id){
        return TodoService.delete(id);
    }
    
}
