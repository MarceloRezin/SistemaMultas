package gravidademulta.telas;


import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import gravidademulta.GravidadeMulta;
import gravidademulta.TipoMulta;
import gravidademulta.listenner.GravidadeMultaCadastroListenner;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GravidadeMultaCadastroTela extends CadastroTela<GravidadeMulta> {

	private static final long serialVersionUID = 1L;
	private JTextField campoValor;
	private JTextField campoNumPontos;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JComboBox comboGravidade;

	public GravidadeMultaCadastroTela(String titulo, GravidadeMulta objeto, ConsultaTela<GravidadeMulta> consultaTela) {
		super(titulo, objeto, consultaTela);
	}

	@Override
	public GravidadeMulta telaToObjeto() {
        GravidadeMulta gravidadeMulta = getObjeto();

        if(gravidadeMulta == null){
            gravidadeMulta = new GravidadeMulta();
        }

        gravidadeMulta.setTipoMulta(TipoMulta.values()[comboGravidade.getSelectedIndex()]);
        gravidadeMulta.setValor(new BigDecimal(campoValor.getText()));
        gravidadeMulta.setPontos(Integer.parseInt(campoNumPontos.getText()));

		return gravidadeMulta;
	}

	@Override
	public void objetoToTela() {

		GravidadeMulta gravidadeMulta = getObjeto();

		if(gravidadeMulta != null){
			comboGravidade.setSelectedIndex(gravidadeMulta.getTipoMulta().getIndice());

			campoNumPontos.setText(gravidadeMulta.getPontos() + "");

			campoValor.setText(gravidadeMulta.getValor().toString());
		}
	}

	@Override
	public void initComponentes() {
		setBounds(100, 100, 431, 223);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JLabel lblCadastroDeGravidade = new JLabel("Cadastro de Gravidade de Multas");
		getContentPane().add(lblCadastroDeGravidade, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lbtGravidade = new JLabel("Gravidade:");
		lbtGravidade.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lbtGravidade);

		TipoMulta[] tipoMultas = TipoMulta.values();

		comboGravidade = new JComboBox();
		for(int i=0; i<tipoMultas.length; i++){
			comboGravidade.addItem(tipoMultas[i].getDescricao());
		}
		panelCentro.add(comboGravidade);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblValor);

		campoValor = new JTextField();
		panelCentro.add(campoValor);
		campoValor.setColumns(10);

		JLabel lblNmeroDePontos = new JLabel("Número de Pontos:");
		lblNmeroDePontos.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblNmeroDePontos);

		campoNumPontos = new JTextField();
		panelCentro.add(campoNumPontos);
		campoNumPontos.setColumns(10);

		JPanel panelSul = new JPanel();
		getContentPane().add(panelSul, BorderLayout.SOUTH);
		panelSul.setLayout(new GridLayout(1, 0, 0, 0));

		btnSalvar = new JButton("Salvar");
		panelSul.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		panelSul.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		panelSul.add(btnVoltar);

		new GravidadeMultaCadastroListenner(this);
	}

    @Override
    public void resetCampos() {
        comboGravidade.setSelectedIndex(0);
        campoValor.setText("");
        campoNumPontos.setText("");
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
