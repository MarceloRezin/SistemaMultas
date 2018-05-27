package cadastros.cidade.telas;


import cadastros.cidade.Cidade;
import cadastros.cidade.listenner.CidadeCadastroListenner;
import cadastros.cidade.Estado;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.awt.*;

public class CidadeCadastroTela extends CadastroTela<Cidade> {

	private static final long serialVersionUID = 1L;
	private JTextField campoNome;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JComboBox comboEstado;

	public CidadeCadastroTela(String titulo, Cidade objeto, ConsultaTela<Cidade> consultaTela) {
		super(titulo, objeto, consultaTela);
	}

	@Override
	public Cidade telaToObjeto() throws SistemaMultasException {

        Cidade cidade = getObjeto();

        if(cidade == null){
            cidade = new Cidade();
        }

		String nome = campoNome.getText();
        if(Utils.isNulaOuVazia(nome)){
        	throw new SistemaMultasException("Você nã informou o nome!");
		}
		cidade.setNome(nome);

		cidade.setUf(Estado.values()[comboEstado.getSelectedIndex()]);

		return cidade;

	}

	@Override
	public void objetoToTela() {

		Cidade cidade = getObjeto();

		if(cidade != null){
			comboEstado.setSelectedIndex(cidade.getUf().getIndice());

			campoNome.setText(cidade.getNome());
		}
	}

	@Override
	public void initComponentes() {
		setBounds(100, 100, 431, 223);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblCadastroDeCidade = new JLabel("Cadastro de Cidades");
		getContentPane().add(lblCadastroDeCidade, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lbtEstado = new JLabel("Estado:");
		lbtEstado.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lbtEstado);

		Estado[] estados = Estado.values();

		comboEstado = new JComboBox();
		for(int i=0; i<estados.length; i++){
			comboEstado.addItem(estados[i].getDescricao());
		}
		panelCentro.add(comboEstado);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblNome);

		campoNome = new JTextField();
		panelCentro.add(campoNome);
		campoNome.setColumns(10);

		JPanel panelSul = new JPanel();
		getContentPane().add(panelSul, BorderLayout.SOUTH);
		panelSul.setLayout(new GridLayout(1, 0, 0, 0));

		btnSalvar = new JButton("Salvar");
		panelSul.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		panelSul.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		panelSul.add(btnVoltar);

		new CidadeCadastroListenner(this);
	}

    @Override
    public void resetCampos() {
        comboEstado.setSelectedIndex(0);
        campoNome.setText("");
    }

    @Override
	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	@Override
	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	@Override
	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
