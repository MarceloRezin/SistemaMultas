/*
* Listenner para as telas de cadastro
* */
package commons.listenners;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.telas.CadastroTela;
import commons.utils.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroListenner<T extends Cadastro> implements ActionListener {

    private JButton salvar;
    private JButton excluir;
    private JButton voltar;
    private CadastroTela<T> cadastroTela;

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

    public void eventoSalvar(){

        T objeto = cadastroTela.telaToObjeto();

        if(objeto != null){
            Banco.save(objeto);
            Utils.mensagem("Salvo", "Item salvo com sucesso!");

            cadastroTela.setObjeto(objeto);
        }

    }

    public void eventoExcluir(){
        if(Utils.mensagemConfirmacao("Confirmação", "Tem certeza que você deseja excluir o item?")){
            Banco.delete(cadastroTela.telaToObjeto());

            cadastroTela.resetCampos();

            Utils.mensagem("Salvo", "Item excluído com sucesso!");
        }
    }

    public void eventoVoltar(){
        getCadastroTela().getConsultaTela().listarTodosItens();

        cadastroTela.getConsultaTela().setVisible(true);
        cadastroTela.dispose();
    }
}
