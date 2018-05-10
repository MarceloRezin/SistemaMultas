/*
* Listenner para as telas de cadastro
* */
package commons.listenners;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.telas.CadastroTela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroListenner<T extends Cadastro> implements ActionListener {

    private JButton salvar;
    private JButton excluir;
    private JButton voltar;
    private CadastroTela<T> cadastroTela;
    private boolean necessarioAtualizar = false;

    public CadastroListenner(CadastroTela<T> cadastroTela){
        this.cadastroTela = cadastroTela;
        this.salvar = cadastroTela.getBtnSalvar();
        this.excluir = cadastroTela.getBtnExcluir();
        this.voltar = cadastroTela.getBtnVoltar();

        salvar.addActionListener(this);
        excluir.addActionListener(this);
        voltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == salvar){
            eventoSalvar();
        }else if(evento.getSource() == excluir){
            eventoExcluir();
        }else if(evento.getSource() == voltar){
            eventoVoltar();
        }
    }

    public CadastroTela<T> getCadastroTela() {
        return cadastroTela;
    }

    public boolean isNecessarioAtualizar() {
        return necessarioAtualizar;
    }

    public void eventoSalvar(){

        Cadastro c = cadastroTela.telaToObjeto();

        Banco.save(c);

        if (c.isNovo()){
            necessarioAtualizar = true;
        }
    }

    public void eventoExcluir(){
        Banco.delete(cadastroTela.telaToObjeto());

        cadastroTela.resetCampos();

        necessarioAtualizar = true;
    }

    public void eventoVoltar(){
        if(isNecessarioAtualizar()){
            getCadastroTela().getConsultaTela().listarTodosItens();
        }
        cadastroTela.getConsultaTela().setVisible(true);
        cadastroTela.dispose();
    }
}
