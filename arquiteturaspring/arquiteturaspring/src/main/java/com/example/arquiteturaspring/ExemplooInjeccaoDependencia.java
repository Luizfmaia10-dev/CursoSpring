package com.example.arquiteturaspring;

import com.example.arquiteturaspring.todos.TodoEntity;
import com.example.arquiteturaspring.todos.TodoRepository;
import com.example.arquiteturaspring.todos.TodoService;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemplooInjeccaoDependencia {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        Connection connection = dataSource.getConnection();
        EntityManager entityManager= null;
        TodoRepository repository= new SimpleJpaRepository<TodoEntity,Integer>();
        TodoService service= new TodoService(repository,connection);
        TodoRepository
    }
}
