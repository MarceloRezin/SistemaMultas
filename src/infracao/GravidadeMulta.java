package infracao;

import java.math.BigDecimal;

public enum GravidadeMulta {
    LEVE("Leve", new BigDecimal(88.38), 3),
    MEDIA("Média", new BigDecimal(130.16), 4),
    GRAVE("Grave", new BigDecimal(195.23), 5),
    GRAVISSIMA("Gravíssima", new BigDecimal(293.47), 7);


    private String descricao;
    private BigDecimal valor;
    private int numeroPontos;

    GravidadeMulta(String descricao, BigDecimal valor, int numeroPontos) {
        this.descricao = descricao;
        this.valor = valor;
        this.numeroPontos = numeroPontos;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getNumeroPontos() {
        return numeroPontos;
    }
}
