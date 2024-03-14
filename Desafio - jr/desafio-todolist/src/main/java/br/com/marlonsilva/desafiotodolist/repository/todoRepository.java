package br.com.marlonsilva.desafiotodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marlonsilva.desafiotodolist.entity.todo;

public interface todoRepository extends JpaRepository<todo, Long>{

    
    
}
