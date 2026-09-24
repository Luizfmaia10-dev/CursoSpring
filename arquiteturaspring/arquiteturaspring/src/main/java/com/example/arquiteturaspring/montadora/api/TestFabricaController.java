package com.example.arquiteturaspring.montadora.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquiteturaspring.montadora.CarroStatus;
import com.example.arquiteturaspring.montadora.Chave;
import com.example.arquiteturaspring.montadora.HondaHRV;
import com.example.arquiteturaspring.montadora.Motor;
//REST CONTROLER,um componente que tambem vai ser scaneado
//restcontroller tambem e o corpo da aplicacao, e o ponto de entrada da aplicacao, e tambem vai ser scaneado pelo springboot
//usamos o requestmapping para mapear a url do endpoint, e o postmapping para mapear o metodo http post
//ele tambem nesse caso tem a função de mapear a url do endpoint, e o requestbody para mapear o corpo da requisicao, e o autowired para injetar a dependencia do motor
@RestController
@RequestMapping("/carros")
public class TestFabricaController {
    //o autowired vai injetar a dependencia do motor, 
    //e o postmapping vai mapear o metodo http post,
    // e o requestbody vai mapear o corpo da requisicao

    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave) {
        var carro = new HondaHRV(motor);
        return carro.DarIgnicao(chave);
    }
    

}
