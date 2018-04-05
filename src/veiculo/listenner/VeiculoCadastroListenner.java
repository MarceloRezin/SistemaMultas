package veiculo.listenner;

import commons.listenners.CadastroListenner;
import commons.listenners.ListagemListenner;

import javax.swing.*;

public class VeiculoCadastroListenner extends CadastroListenner {

    public VeiculoCadastroListenner(JButton listar, JButton salvar, JButton excluir, JButton voltar) {
        super(salvar, excluir, voltar);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Veículo -> Salvar");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Veículo -> Excluir");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Veículo -> Voltar");
    }
}
