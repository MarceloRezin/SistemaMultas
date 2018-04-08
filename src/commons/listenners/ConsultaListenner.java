/*
* Listenner para as telas de consulta
* */

package commons.listenners;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ConsultaListenner implements ActionListener, ListSelectionListener {

    private JButton consultar;
    private JButton novo;
    private JList<Object> list;
    private JDesktopPane jDesktopPane;
    private JInternalFrame telaCadastro;
    private JInternalFrame telaConsulta;
    private DefaultListModel<Object> model = new DefaultListModel<>();

    public ConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta, JInternalFrame telaCadastro, JButton consultar, JButton novo, JList<Object> list) {
        this.jDesktopPane = jDesktopPane;
        this.telaConsulta = telaConsulta;
        this.telaCadastro = telaCadastro;
    	this.consultar = consultar;
        this.novo = novo;
        this.list = list;

        consultar.addActionListener(this);
        novo.addActionListener(this);
        list.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == consultar){
            eventoConsultar();
        }else if(evento.getSource() == novo){
            eventoNovo();
        }
    }
    
    @Override
	public void valueChanged(ListSelectionEvent evento) {
		if(evento.getSource() == list) {
			if (evento.getValueIsAdjusting()){
                System.out.println("Consulta ->" + model.get(list.getSelectedIndex()));
            }
		}
	}
    
    private void eventoNovo() {
    	telaConsulta.dispose();
        System.out.println("Consulta -> Novo");
        jDesktopPane.add(telaCadastro);
        telaCadastro.setVisible(true);
    }
    
	public abstract void eventoConsultar();
}
