package com.example.arquiteturaspring.montadora.api;
import com.example.arquiteturaspring.montadora.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
//REST CONTROLER,um componente que tambem vai ser scaneado
//restcontroller tambem e o corpo da aplicacao, e o ponto de entrada da aplicacao, e tambem vai ser scaneado pelo springboot
@RestController 
public class TestFabricaController {

    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.DarIgnicao(chave);

    }
    

}
