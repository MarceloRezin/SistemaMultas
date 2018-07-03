package cadastros.infracao.telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cadastros.gravidademulta.GravidadeMulta;
import cadastros.infracao.Infracao;
import cadastros.infracao.listenner.InfracaoCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.*;

@SuppressWarnings("serial")
public class InfracaoCadastroTela extends CadastroTela<Infracao> {

	private JPanel contentPane;
	private JTextField campoDescricao;

	private JLabel lblGravidadeMulta;
	private JButton btnGravidadeMulta;
	private GravidadeMulta gravidadeMulta;

	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	public InfracaoCadastroTela(Infracao objeto, ConsultaTela<Infracao> consultaTela) {
		super("Infração", objeto, consultaTela);
	}

    @Override
    public Infracao telaToObjeto() throws SistemaMultasException {
        Infracao infracao = getObjeto();

        if(infracao == null){
            infracao = new Infracao();
        }

        String descricao = campoDescricao.getText();
        if(Utils.isNulaOuVazia(descricao)){
            throw new SistemaMultasException("Você não informou a descrição!");
        }
        infracao.setDescricao(descricao);

        if(Utils.cadastroIsNull(gravidadeMulta)){
            throw new SistemaMultasException("Você não informou a gravidade da infração!");
        }
        infracao.setGravidadeMulta(gravidadeMulta);

	    return infracao;
    }

    @Override
    public void objetoToTela() {
        Infracao infracao = getObjeto();

        if(infracao != null){
            campoDescricao.setText(infracao.getDescricao());
            setGravidadeMulta(infracao.getGravidadeMulta());
        }
    }

    @Override
	public void initComponentes() {
		setBounds(100, 100, 500, 200);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCadastroDePessoas = new JLabel("Cadastro de Infrações");
		contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblDescricao);
		
		campoDescricao = new JTextField();
		panelCentro.add(campoDescricao);
		campoDescricao.setColumns(10);
		
		lblGravidadeMulta = new JLabel("Gravidade:");
		lblGravidadeMulta.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblGravidadeMulta);

		btnGravidadeMulta = new JButton("Selecionar");
		panelCentro.add(btnGravidadeMulta);

		JPanel panelSul = new JPanel();
		contentPane.add(panelSul, BorderLayout.SOUTH);
		panelSul.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnSalvar = new JButton("Salvar");
		panelSul.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		panelSul.add(btnExcluir);
		
		btnVoltar = new JButton("Voltar");
		panelSul.add(btnVoltar);

		if(gravidadeMulta == null){
		    gravidadeMulta = new GravidadeMulta();
        }

		new InfracaoCadastroListenner(this);
	}

    private void setGravidadeMulta(){
        lblGravidadeMulta.setText("Gravidade:");
        this.gravidadeMulta = new GravidadeMulta();
    }

    @Override
    public void resetCampos() {
        campoDescricao.setText("");
        setGravidadeMulta();
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

    public JLabel getLblGravidadeMulta() {
        return lblGravidadeMulta;
    }

    public JButton getBtnGravidadeMulta() {
        return btnGravidadeMulta;
    }

    private void setGravidadeMulta(GravidadeMulta gravidadeMulta){
        lblGravidadeMulta.setText("Gravidade: " + gravidadeMulta.getTipoMulta().getDescricao());
        if(this.gravidadeMulta == null){
            this.gravidadeMulta = gravidadeMulta;
        }else{
            GravidadeMulta.mesclar(gravidadeMulta, this.gravidadeMulta);
        }
    }

    public GravidadeMulta getGravidadeMulta() {
        return gravidadeMulta;
    }
}
