package infracao;

import commons.cadastros.Cadastro;

public class Infracao extends Cadastro{
    private String descricao;
    private TipoMulta tipoMulta;

    public Infracao(String descricao, TipoMulta tipoMulta) {
        this.descricao = descricao;
        this.tipoMulta = tipoMulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMulta getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(TipoMulta tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

	@Override
	public String toString() {
		return getDescricao();
	}
}
