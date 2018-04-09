package commons.telas;

import javax.swing.JInternalFrame;
import commons.cadastros.Cadastro;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;

@SuppressWarnings("serial")
public class ConsultaTela<T extends Cadastro> extends JInternalFrame {
	
	private List<T> itens;
	private DefaultListModel<T> model = new DefaultListModel<>();
	private JButton btnConsulta;
	private JButton btnNovo;
	private JList<T> list;
	private JTextField campoPesquisa;
	
	public ConsultaTela(String titulo, List<T> itens) {
		this.itens = itens;
		setTitle(titulo);
		setResizable(true);
		setBounds(100, 100, 392, 423);
		
		JPanel panelNorte = new JPanel();
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		
		campoPesquisa = new JTextField();
		panelNorte.add(campoPesquisa, BorderLayout.CENTER);
		campoPesquisa.setColumns(10);
		
		JPanel panelNorteLeste = new JPanel();
		panelNorte.add(panelNorteLeste, BorderLayout.EAST);
		panelNorteLeste.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnConsulta = new JButton("");
		btnConsulta.setIcon(new ImageIcon(ConsultaTela.class.getResource("/imagens/pesquisar.png")));
		panelNorteLeste.add(btnConsulta);
		
		btnNovo = new JButton("Novo");
		panelNorteLeste.add(btnNovo);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		list = new JList<T>(model);
		panelCentro.add(list);
		
		adicionarItens();
	}
	
	private void adicionarItens() {
		itens.forEach( i -> {
			model.add(model.getSize(), i);
		});
	}

	public List<T> getItens() {
		return itens;
	}

	public DefaultListModel<T> getModel() {
		return model;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public JButton getBtnNovo() {
		return btnNovo;
	}

	public JList<T> getList() {
		return list;
	}

	public JTextField getCampoPesquisa() {
		return campoPesquisa;
	}
}
