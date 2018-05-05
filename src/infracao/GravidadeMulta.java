package infracao;

import commons.cadastros.Cadastro;

import java.math.BigDecimal;

/**
 * Leve: 88.38, 3
 * Média: 130.16, 4
 * Grave: 195.23, 5
 * Gravíssima, 293.47, 7

 */

public class GravidadeMulta extends Cadastro{
    private TipoMulta tipoMulta;
    private BigDecimal valor;
    private int pontos;

    public TipoMulta getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(TipoMulta tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return getTipoMulta().getDescricao();
    }
}
