package cadastros.veiculo.telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cadastros.cidade.Cidade;
import cadastros.proprietario.Proprietario;
import cadastros.veiculo.Veiculo;
import cadastros.veiculo.listenner.VeiculoCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.*;

@SuppressWarnings("serial")
public class VeiculoCadastroTela extends CadastroTela<Veiculo> {

	private JPanel contentPane;

	private JButton btnSelecionarCidade;
	private Cidade cidade;
	private JLabel lblCidade;

	private JButton btnSelecionarProprietario;
	private Proprietario proprietario;
	private JLabel lblProprietario;

	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	private JFormattedTextField campoPlaca;
	private JTextField campoMarca;
	private JTextField campoModelo;
	private JFormattedTextField campoAno;
	private JFormattedTextField campoRenavam;
	private JTextField campoCorPredominante;

	public VeiculoCadastroTela(Veiculo objeto, ConsultaTela<Veiculo> consultaTela) {
		super("Veículo", objeto, consultaTela);
	}

	@Override
	public void initComponentes() {
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Veículos");
		contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(9, 2, 0, 0));

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblPlaca);

		campoPlaca = new JFormattedTextField(Utils.mascara("UUU-####"));
		panelCentro.add(campoPlaca);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblMarca);

		campoMarca = new JTextField();
		panelCentro.add(campoMarca);
		campoMarca.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblModelo);

		campoModelo = new JTextField();
		panelCentro.add(campoModelo);
		campoModelo.setColumns(10);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblAno);

		campoAno = new JFormattedTextField(Utils.mascara("####"));
		panelCentro.add(campoAno);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCidade);

		btnSelecionarCidade = new JButton("Selecionar");
		panelCentro.add(btnSelecionarCidade);

		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblRenavam);

		campoRenavam = new JFormattedTextField(Utils.mascara("####.######-#"));
		panelCentro.add(campoRenavam);

		JLabel lblCorPredominante = new JLabel("Cor Predominante:");
		lblCorPredominante.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCorPredominante);

		campoCorPredominante = new JTextField();
		panelCentro.add(campoCorPredominante);
		campoCorPredominante.setColumns(10);

		lblProprietario = new JLabel("Proprietário:");
		lblProprietario.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblProprietario);

		btnSelecionarProprietario = new JButton("Selecionar");
		panelCentro.add(btnSelecionarProprietario);

		JPanel panelSul = new JPanel();
		contentPane.add(panelSul, BorderLayout.SOUTH);
		panelSul.setLayout(new GridLayout(1, 0, 0, 0));

		btnSalvar = new JButton("Salvar");
		panelSul.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		panelSul.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		panelSul.add(btnVoltar);

		if(cidade == null){
		    cidade = new Cidade();
        }

        if(proprietario == null){
		    proprietario = new Proprietario();
        }

		new VeiculoCadastroListenner(this);
	}

	@Override
	public void resetCampos() {
		campoPlaca.setText("");
		campoCorPredominante.setText("");
		campoRenavam.setText("");
		campoModelo.setText("");
		campoAno.setText("");
		campoMarca.setText("");
		setCidade();
		setProprietario();
	}

	private void setCidade(){
		lblCidade.setText("Cidade:");
		this.cidade = new Cidade();
	}

	private void setProprietario(){
		lblProprietario.setText("Proprietário:");
		this.proprietario = new Proprietario();
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

	public JButton getBtnSelecionarProprietario() {
		return btnSelecionarProprietario;
	}

	public JButton getBtnSelecionarCidade() {
		return btnSelecionarCidade;
	}

	private void setProprietario(Proprietario proprietario){
		if(Utils.cadastroIsNull(proprietario)){
			setProprietario();
		}else{
			lblProprietario.setText("Proprietário: " + proprietario.getPessoa().getNomeRazaoSocial());
			if(Utils.cadastroIsNull(this.proprietario)){
				this.proprietario = proprietario;
			}else{
				proprietario.mesclar(proprietario, this.proprietario);
			}
		}
	}

	private void setCidade(Cidade cidade){
		if(Utils.cadastroIsNull(cidade)){
			setCidade();
		}else{
			lblCidade.setText("Cidade: " + cidade.getNome());
			if(Utils.cadastroIsNull(this.cidade)){
				this.cidade = cidade;
			}else{
				cidade.mesclar(cidade, this.cidade);
			}
		}
	}

	public JLabel getLblCidade() {
		return lblCidade;
	}

	public JLabel getLblProprietario() {
		return lblProprietario;
	}

	@Override
	public Veiculo telaToObjeto() throws SistemaMultasException {
		Veiculo veiculo = getObjeto();

		if(veiculo == null){
			veiculo = new Veiculo();
		}

		String placa = campoPlaca.getText();
		if(!placa.matches("[a-zA-Z]{3}-\\d{4}")){
			throw new SistemaMultasException("Você não informou uma placa válida!");
		}
		veiculo.setPlaca(placa);

		String marca = campoMarca.getText();
		if(Utils.isNulaOuVazia(marca)){
			throw new SistemaMultasException("Você não informou a marca");
		}
		veiculo.setMarca(marca);

		String modelo = campoModelo.getText();
		if(Utils.isNulaOuVazia(modelo)){
			throw new SistemaMultasException("Você não informou o modelo");
		}
		veiculo.setModelo(modelo);

		String ano = campoAno.getText();
		if(!ano.matches("\\d{4}")){
			throw new SistemaMultasException("Você não informou um ano válido");
		}
		veiculo.setAno(ano);

		if(Utils.cadastroIsNull(cidade)){
			throw new SistemaMultasException("Você não informou a cidade!");
		}
		veiculo.setCidade(cidade);

		String renavam = campoRenavam.getText();
		if(!renavam.matches("\\d{4}\\.\\d{6}-\\d")){
			throw new SistemaMultasException("Você não informou um renavam válido!");
		}
		veiculo.setRenavam(renavam);

		String corPredominante = campoCorPredominante.getText();
		if(Utils.isNulaOuVazia(corPredominante)){
			throw new SistemaMultasException("Você não informou a cor predominante");
		}
		veiculo.setCorPredominante(corPredominante);

		if(Utils.cadastroIsNull(proprietario)){
			throw new SistemaMultasException("Você não informou o proprietário!");
		}
		veiculo.setProprietario(proprietario);

		return veiculo;
	}

	@Override
	public void objetoToTela() {
		Veiculo veiculo = getObjeto();

		if(veiculo != null){
			campoPlaca.setText(veiculo.getPlaca());
			campoMarca.setText(veiculo.getMarca());
			campoModelo.setText(veiculo.getModelo());
			campoAno.setText(veiculo.getAno() + "");
			setCidade(veiculo.getCidade());
			campoRenavam.setText(veiculo.getRenavam());
			campoCorPredominante.setText(veiculo.getCorPredominante());
			setProprietario(veiculo.getProprietario());
		}
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}
}
