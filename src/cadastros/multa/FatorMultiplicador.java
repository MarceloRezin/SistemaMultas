package cadastros.multa;

public enum FatorMultiplicador {

    X0(0),
    X2(2),
    X3(3),
    X5(5),
    X10(10),
    X20(20),
    X60(60);

    private int valor;

    FatorMultiplicador(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public int getIndice(){
        FatorMultiplicador[] fatorMultiplicadors = FatorMultiplicador.values();

        for(int i=0; i<fatorMultiplicadors.length; i++){
            if(this == fatorMultiplicadors[i]){
                return i;
            }
        }

        return -1;
    }
}
