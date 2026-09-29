package com.example.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository todoRepository;


    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void validar(TodoEntity todo){
        if(existeTodoComDesc(todo.getDescricao())){
            throw new IllegalArgumentException("ja existe com essa Descrição"+ todo.getDescricao());
        }

    }

    private boolean existeTodoComDesc(String descricao){
        return todoRepository.existsByDescricao(descricao);

    }
}
