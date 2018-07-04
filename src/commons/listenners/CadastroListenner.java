/*
* Listenner para as telas de cadastro
* */
package commons.listenners;

import banco.Banco;
import commons.cadastros.Cadastro;
import commons.telas.CadastroTela;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

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

        try {
            T objeto = cadastroTela.telaToObjeto();
            Banco.save(objeto);
            Logger.log(cadastroTela.getTitle() + " Salvar");

            Utils.mensagem("Salvo", "Item salvo com sucesso!");

            cadastroTela.setObjeto(objeto);
        } catch (SistemaMultasException e) {
            Utils.mensagemErro(e.getMessage());
        } catch (Exception e2){
            Utils.mensagemErro("Ocorreu um erro ao salvar o registro");
        }
    }

    public void eventoExcluir(){
        if(cadastroTela.getObjeto() == null || cadastroTela.getObjeto().isNovo()){
            cadastroTela.resetCampos();
        }else if(Utils.mensagemConfirmacao("Confirmação", "Tem certeza que você deseja excluir o item?")){

            try {
                Banco.delete(cadastroTela.telaToObjeto());
                cadastroTela.resetCampos();
                cadastroTela.setObjeto(null);
                Logger.log(cadastroTela.getTitle() + " Excluir");

                Utils.mensagem("Excluído", "Item excluído com sucesso!");
            }catch (SistemaMultasException e){
                Utils.mensagemErro(e.getMessage());
            }
        }
    }

    public void eventoVoltar(){
        Logger.log(cadastroTela.getTitle() + " Voltar");
        getCadastroTela().getConsultaTela().listarTodosItens();

        cadastroTela.getConsultaTela().setVisible(true);
        cadastroTela.dispose();
    }
}
