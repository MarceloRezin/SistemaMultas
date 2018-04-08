/*
* Listenner para as telas de listagem
* */

package commons.listenners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ListagemListenner implements ActionListener {

    private JButton listar;
    private JButton novo;

    public ListagemListenner(JButton listar, JButton novo) {
        this.listar = listar;
        this.novo = novo;

        listar.addActionListener(this);
        novo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == listar){
            eventoListar();
        }else if(evento.getSource() == novo){
            eventoNovo();
        }
    }

    public abstract void eventoListar();
    public abstract void eventoNovo();
}
