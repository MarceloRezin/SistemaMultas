package commons.enuns.telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CrudJFrame implements ActionListener {

    private JButton listar;
    private JButton novo;
    private JButton salvar;
    private JButton excluir;

    public CrudJFrame(JButton listar, JButton novo, JButton salvar, JButton excluir) {
        this.listar = listar;
        this.novo = novo;
        this.salvar = salvar;
        this.excluir = excluir;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == listar){
            executarListar();
        }else if(evento.getSource() == novo){
            executaNovo();
        }else if(evento.getSource() == salvar){
            executaSalvar();
        }else if(evento.getSource() == excluir){
            executarExcluir();
        }
    }

    public abstract void executarListar();
    public abstract void executaNovo();
    public abstract void executaSalvar();
    public abstract void executarExcluir();
}
