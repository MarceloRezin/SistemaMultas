/*
* Listenner para as telas de cadastro
* */
package commons.listenners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CadastroListenner implements ActionListener {

    private JButton salvar;
    private JButton excluir;
    private JButton voltar;

    public CadastroListenner(JButton salvar, JButton excluir, JButton voltar) {
        this.salvar = salvar;
        this.excluir = excluir;
        this.voltar = voltar;

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

    public abstract void eventoSalvar();
    public abstract void eventoExcluir();
    public abstract void eventoVoltar();
}
