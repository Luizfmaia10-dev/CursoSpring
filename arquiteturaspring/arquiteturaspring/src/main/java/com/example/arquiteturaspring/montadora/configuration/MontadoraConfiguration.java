package com.example.arquiteturaspring.montadora.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.arquiteturaspring.montadora.Motor;
import com.example.arquiteturaspring.montadora.TipoMotor;

@Configuration
public class MontadoraConfiguration {
    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
       var motor = new Motor();
       motor.setCavalos(120);
       motor.setCilindros(4);
       motor.setModelo("PULSE");
       motor.setLitragem(1.5);
       motor.setTipo(TipoMotor.ASPIRADO);
       return motor;
    }
    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
       var motor = new Motor();
       motor.setCavalos(100);
       motor.setCilindros(0);
       motor.setModelo("TAYCAN");
       motor.setLitragem(5.0);
       motor.setTipo(TipoMotor.ELETRICO);
       return motor;
    }
    @Bean(name = "motorTurbo")
    @Primary 
    public Motor motorTurbo() {
       var motor = new Motor();
       motor.setCavalos(250);
       motor.setCilindros(6);
       motor.setModelo("Jetta");
       motor.setLitragem(2.0);
       motor.setTipo(TipoMotor.TURBO);
       return motor;
    }
    
}
