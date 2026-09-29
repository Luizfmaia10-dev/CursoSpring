package com.example.arquiteturaspring;

import com.example.arquiteturaspring.todos.TodoEntity;
import com.example.arquiteturaspring.todos.TodoRepository;
import com.example.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {
    //Bean=estancia denrto de containers gerenciada pelo spring
    @Autowired
    private TodoValidator validator;

    //TAMBEM PODEMOS INJETAR PELO CONSTRUTOR-MAIS RECOMENDADA-OBRIGATORIO,fundamental para o funcionamento
    public BeanGerenciado(TodoValidator validator){
        this.validator = validator;
    }

//FORMA DE INJETAR,VIA PROPRIEDADE
    public void atualizar(){
        var todo= new TodoEntity();
        validator.validar(todo);
    }
    //OUTRA FORMA DE INJETAR-Menos comum de injetar,nesse caso a injeção é opcional e pudemos mudar ou colocar alguma logica na implementação
    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }

}
