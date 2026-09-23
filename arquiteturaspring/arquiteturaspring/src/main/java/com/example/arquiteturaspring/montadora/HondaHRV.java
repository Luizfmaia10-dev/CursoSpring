package com.example.arquiteturaspring.montadora;

import java.awt.Color;

public class HondaHRV extends Carro {
    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("Honda HR-V");
        setCor(Color.BLUE);
        setMontadora(Montadora.HONDA);
    }
}
