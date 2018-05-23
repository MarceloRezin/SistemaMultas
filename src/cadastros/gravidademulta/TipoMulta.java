package cadastros.gravidademulta;

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

    public int getIndice(){
        TipoMulta[] tipoMultas = TipoMulta.values();

        for(int i=0; i<tipoMultas.length; i++){
            if(this == tipoMultas[i]){
                return i;
            }
        }

        return -1;
    }
}
