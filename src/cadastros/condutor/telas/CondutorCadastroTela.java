package cadastros.condutor.telas;

import cadastros.condutor.Condutor;
import cadastros.condutor.listenner.CondutorCadastroListenner;
import cadastros.pessoa.Pessoa;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CondutorCadastroTela extends CadastroTela<Condutor> {

	private JPanel contentPane;
	private JFormattedTextField campoCodigoHabilitacao;
	private JButton btnSelecionarPessoa;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private JLabel lblPessoa;

	private Pessoa pessoa;

	public CondutorCadastroTela(Condutor objeto, ConsultaTela<Condutor> consultaTela) {
		super("Condutor", objeto, consultaTela);
	}


	@Override
	public Condutor telaToObjeto() throws SistemaMultasException {
		Condutor condutor = getObjeto();

		if(condutor == null){
			condutor = new Condutor();
		}

        String codigoHabilitacao = campoCodigoHabilitacao.getText();
        if(!codigoHabilitacao.matches("\\d{11}")){
            throw new SistemaMultasException("Você não informou um código de habilitação válido!");
        }
		condutor.setCodHabilitacao(codigoHabilitacao);


        if(pessoa == null || pessoa.getId() == null){
            throw new SistemaMultasException("Você não definiu o condutor!");
        }
        condutor.setPessoa(pessoa);

		return condutor;
	}

	@Override
	public void objetoToTela() {
        Condutor condutor = getObjeto();

        if(condutor != null){
            campoCodigoHabilitacao.setText(condutor.getCodHabilitacao());
            setPessoa(condutor.getPessoa());
        }
	}

	@Override
	public void initComponentes() {
		setBounds(100, 100, 550, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Condutores");
		contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 2, 0, 0));

		JLabel lblCpf = new JLabel("Código da Habilitação:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblCpf);

		campoCodigoHabilitacao = new JFormattedTextField(Utils.mascara("###########"));
		panelCentro.add(campoCodigoHabilitacao);

		lblPessoa = new JLabel("Condutor:");
		lblPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblPessoa);

		btnSelecionarPessoa = new JButton("Selecionar");
		panelCentro.add(btnSelecionarPessoa);

		JPanel panelSul = new JPanel();
		contentPane.add(panelSul, BorderLayout.SOUTH);
		panelSul.setLayout(new GridLayout(1, 0, 0, 0));

		btnSalvar = new JButton("Salvar");
		panelSul.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		panelSul.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		panelSul.add(btnVoltar);

		if(pessoa == null){
		    pessoa = new Pessoa();
        }

		new CondutorCadastroListenner(this);
	}

	@Override
	public void resetCampos() {
        campoCodigoHabilitacao.setText("");
        setPessoa();
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    private void setPessoa(Pessoa pessoa){
	    lblPessoa.setText("Condutor: " + pessoa.getNomeRazaoSocial());
	    if(this.pessoa == null){
	        this.pessoa = pessoa;
        }else{
            Pessoa.mesclar(pessoa, this.pessoa);
        }
    }

    private void setPessoa(){
	    lblPessoa.setText("Condutor:");
	    this.pessoa = new Pessoa();
    }

    public JButton getBtnSelecionarPessoa() {
        return btnSelecionarPessoa;
    }

    public JLabel getLblPessoa() {
        return lblPessoa;
    }
}
