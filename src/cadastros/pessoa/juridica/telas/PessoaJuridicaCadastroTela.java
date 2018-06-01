package cadastros.pessoa.juridica.telas;

import cadastros.cidade.Cidade;
import cadastros.pessoa.Pessoa;
import cadastros.pessoa.TipoPessoa;
import cadastros.pessoa.juridica.listenner.PessoaJuridicaCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PessoaJuridicaCadastroTela extends CadastroTela<Pessoa> {

	private JPanel contentPane;
	private JTextField campoRazaoSocial;
	private JTextField campoIe;
	private JTextField campoEmail;
	private JTextField campoBairro;
	private JTextField campoRua;
	private JTextField campoNumero;
	private JFormattedTextField campoCnpj;
	private JFormattedTextField campoTelefone;
	private JButton btnSelecionarCidade;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JLabel lblCidade;
    private JFormattedTextField campoCep;

	private Cidade cidade;

	public PessoaJuridicaCadastroTela(Pessoa objeto, ConsultaTela<Pessoa> consultaTela) {
		super("Pessoa Jurídica", objeto, consultaTela);
	}


	@Override
	public Pessoa telaToObjeto() throws SistemaMultasException {
		Pessoa pessoa = getObjeto();

		if(pessoa == null){
			pessoa = new Pessoa();
		}

        pessoa.setTipoPessoa(TipoPessoa.PESSOA_JURIDICA);

        String cpf = campoCnpj.getText();
        if(!cpf.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")){
            throw new SistemaMultasException("Você não informou um CNPJ válido!");
        }
		pessoa.setCpfCnpj(cpf);

        String nome = campoRazaoSocial.getText();
        if(Utils.isNulaOuVazia(nome)){
            throw new SistemaMultasException("Você não informou a razão social!");
        }
        pessoa.setNomeRazaoSocial(nome);

        String rg = campoIe.getText();
        if(Utils.isNulaOuVazia(rg)){
            throw new SistemaMultasException("Você não informou o IE!");
        }
        pessoa.setRgInscricaoEstadual(rg);

        String telefone = campoTelefone.getText();
        if(!telefone.matches("\\(\\d{2}\\)\\s\\d\\s\\d{4}-\\d{4}")){
            throw new SistemaMultasException("Você não informou um telefone válido!");
        }
        pessoa.setTelefone(telefone);

        String cep = campoCep.getText();
        if(!cep.matches("\\d{5}-\\d{3}")){
            throw new SistemaMultasException("Você não informou um cep válido!");
        }
        pessoa.setCep(cep);

        String email = campoEmail.getText();
        if(!email.matches(".+@.+\\..+")){
            throw new SistemaMultasException("Você não informou um email válido!");
        }
        pessoa.setEmail(email);

        String bairro = campoBairro.getText();
        if(Utils.isNulaOuVazia(bairro)){
            throw new SistemaMultasException("Você não informou o bairro!");
        }
        pessoa.setBairro(bairro);

        String rua = campoRua.getText();
        if(Utils.isNulaOuVazia(rua)){
            throw new SistemaMultasException("Você não informou a rua!");
        }
        pessoa.setRua(rua);

        String numero = campoNumero.getText();
        if(Utils.isNulaOuVazia(numero)){
            throw new SistemaMultasException("Você não informou o número!");
        }
        pessoa.setNumero(numero);

        if(cidade == null || cidade.getId() == null){
            throw new SistemaMultasException("Você não informou a cidade!");
        }
        pessoa.setCidade(cidade);

		return pessoa;
	}

	@Override
	public void objetoToTela() {
        Pessoa pessoa = getObjeto();

        if(pessoa != null){
            campoCnpj.setText(pessoa.getCpfCnpj());
            campoRazaoSocial.setText(pessoa.getNomeRazaoSocial());
            campoIe.setText(pessoa.getRgInscricaoEstadual());
            campoTelefone.setText(pessoa.getTelefone());
            campoEmail.setText(pessoa.getEmail());
            campoCep.setText(pessoa.getCep());
            setCidade(pessoa.getCidade());
            campoBairro.setText(pessoa.getBairro());
            campoRua.setText(pessoa.getRua());
            campoNumero.setText(pessoa.getNumero());
        }
	}

	@Override
	public void initComponentes() {
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Pessoas Jurídicas");
		contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(10, 2, 0, 0));

		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCpf);

		campoCnpj = new JFormattedTextField(Utils.mascara("##.###.###/####-##"));
		panelCentro.add(campoCnpj);

		JLabel lblNome = new JLabel("Razão Social:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblNome);

		campoRazaoSocial = new JTextField();
		panelCentro.add(campoRazaoSocial);
		campoRazaoSocial.setColumns(10);

		JLabel lblRg = new JLabel("Inscrição Estadual:");
		lblRg.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblRg);

		campoIe = new JTextField();
		panelCentro.add(campoIe);
		campoIe.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblTelefone);

		campoTelefone = new JFormattedTextField(Utils.mascara("(##) # ####-####"));
		panelCentro.add(campoTelefone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblEmail);

		campoEmail = new JTextField();
		panelCentro.add(campoEmail);
		campoEmail.setColumns(10);

        JLabel lblCep = new JLabel("CEP:");
        lblCep.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblCep);

        campoCep = new JFormattedTextField(Utils.mascara("#####-###"));
        panelCentro.add(campoCep);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCidade);

		btnSelecionarCidade = new JButton("Selecionar");
		panelCentro.add(btnSelecionarCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblBairro);

		campoBairro = new JTextField();
		panelCentro.add(campoBairro);
		campoBairro.setColumns(10);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblRua);

		campoRua = new JTextField();
		panelCentro.add(campoRua);
		campoRua.setColumns(10);

		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblNmero);

		campoNumero = new JTextField();
		panelCentro.add(campoNumero);
		campoNumero.setColumns(10);

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

		new PessoaJuridicaCadastroListenner(this);
	}

	@Override
	public void resetCampos() {
        campoCnpj.setText("");
        campoRazaoSocial.setText("");
        campoIe.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
        setCidade();
        campoCep.setText("");
        campoBairro.setText("");
        campoRua.setText("");
        campoNumero.setText("");
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

    public Cidade getCidade() {
        return cidade;
    }

    private void setCidade(Cidade cidade){
	    lblCidade.setText("Cidade: " + cidade.getNome());
	    if(this.cidade == null){
	        this.cidade = cidade;
        }else{
            Cidade.mesclar(cidade, this.cidade);
        }
    }

    private void setCidade(){
	    lblCidade.setText("Cidade:");
	    this.cidade = new Cidade();
    }

    public JButton getBtnSelecionarCidade() {
        return btnSelecionarCidade;
    }

    public JLabel getLblCidade() {
        return lblCidade;
    }
}
