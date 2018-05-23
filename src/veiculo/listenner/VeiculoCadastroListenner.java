package veiculo.listenner;

import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class VeiculoCadastroListenner extends CadastroListenner {

    public VeiculoCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {

        System.out.println("Veículo -> Salvar");
        Logger.log("Veiculo, Salvou");
    }

    @Override
    public void eventoExcluir() {

        System.out.println("Veículo -> Excluir");
        Logger.log("Veiculo, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Veículo -> Voltar");
    }
}
