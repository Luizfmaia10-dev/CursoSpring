package com.example.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);

    }
    public void atualizarStatus(TodoEntity todo){
     repository.save(todo);
     String status = todo.isConcluido() ?"Concluido":"Não Concluido";
     mailSender.enviar("Todo"+ todo.getDescricao()+ "foi atualizado para"+ status);
    }
    public TodoEntity buscarPorId(Integer Id){
        return repository.findById(Id).orElse(null);
    }

}
