package infracao;

public class Infracao {
    private String descricao;
    private GravidadeMulta gravidadeMulta;

    public Infracao(String descricao, GravidadeMulta gravidadeMulta) {
        this.descricao = descricao;
        this.gravidadeMulta = gravidadeMulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public GravidadeMulta getGravidadeMulta() {
        return gravidadeMulta;
    }

    public void setGravidadeMulta(GravidadeMulta gravidadeMulta) {
        this.gravidadeMulta = gravidadeMulta;
    }
}