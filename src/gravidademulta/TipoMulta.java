package gravidademulta;

public enum TipoMulta {
    LEVE("Leve"),
    MEDIA("Média"),
    GRAVE("Grave"),
    GRAVISSIMA("Gravíssima");

    private String descricao;

    TipoMulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
