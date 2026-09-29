package com.example.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }
    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try {
            return this.service.salvar(todo);
        }catch(IllegalArgumentException e){
            var message = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT,message);
        }
    }
    @PostMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer Id,@RequestBody TodoEntity todo){
        todo.setId(Id);
        service.atualizarStatus(todo);
    }
    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
    
}
