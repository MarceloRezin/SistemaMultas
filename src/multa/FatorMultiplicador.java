package multa;

import java.math.BigDecimal;

public enum FatorMultiplicador {

    X0(0),
    X2(2),
    X3(3),
    X5(5),
    X10(10),
    X20(10),
    X60(60);

    private int valor;

    FatorMultiplicador(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
