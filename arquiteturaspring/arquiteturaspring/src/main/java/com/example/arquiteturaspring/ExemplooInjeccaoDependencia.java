package com.example.arquiteturaspring;

import com.example.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemplooInjeccaoDependencia {
    public static void main(String[] args)throws Exception {
        //ESSAS são as instancias criadas denrto do spring
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager= null;

        //TodoRepository repository= new SimpleJpaRepository<TodoEntity,Integer>();
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();


        TodoService todoService= new TodoService(repository,todoValidator,mailSender);}
}
