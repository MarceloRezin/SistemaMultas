/*
* Listenner para as telas de consulta
* */

package commons.listenners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import commons.cadastros.Cadastro;
import commons.telas.ConsultaTela;

public abstract class ConsultaListenner<T extends Cadastro> implements ActionListener, ListSelectionListener {

    private JButton btnConsultar;
    private JButton btnNovo;
    private JList<T> list;
    private DefaultListModel<T> model;

    public ConsultaListenner(ConsultaTela<T> consultaTela) {
    	this.btnConsultar = consultaTela.getBtnConsulta();
        this.btnNovo = consultaTela.getBtnNovo();
        this.list = consultaTela.getList();
        this.model = consultaTela.getModel();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnConsultar){
            eventoConsultar();
        }else if(evento.getSource() == btnNovo){
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
    
    public abstract void eventoNovo();
    
	public abstract void eventoConsultar();
}
