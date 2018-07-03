package cadastros.orgao.telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cadastros.cidade.Cidade;
import cadastros.orgao.Orgao;
import cadastros.orgao.listenner.OrgaoCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.*;

@SuppressWarnings("serial")
public class OrgaoCadastroTela extends CadastroTela<Orgao> {

    private JPanel contentPane;
    private JTextField campoNome;
    private JTextField campoBairro;
    private JTextField campoRua;
    private JTextField campoNumero;

    private JLabel lblCidade;
    private Cidade cidade;
    private JButton btnSelecionarCidade;

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnVoltar;

    public OrgaoCadastroTela(Orgao objeto, ConsultaTela<Orgao> consultaTela) {
        super("Orgão", objeto, consultaTela);
    }

    @Override
    public Orgao telaToObjeto() throws SistemaMultasException {
        Orgao orgao = getObjeto();

        if(orgao == null){
            orgao = new Orgao();
        }

        String nome = campoNome.getText();
        if(Utils.isNulaOuVazia(nome)){
            throw new SistemaMultasException("Você não informou o nome!");
        }
        orgao.setNome(nome);

        String bairro = campoBairro.getText();
        if(Utils.isNulaOuVazia(bairro)){
            throw new SistemaMultasException("Você não informou o bairro!");
        }
        orgao.setBairro(bairro);

        String rua = campoRua.getText();
        if(Utils.isNulaOuVazia(rua)){
            throw new SistemaMultasException("Você não informou a rua!");
        }
        orgao.setRua(rua);

        String numero = campoNumero.getText();
        if(Utils.isNulaOuVazia(numero)){
            throw new SistemaMultasException("Você não informou o número!");
        }
        orgao.setNumero(numero);

        if(cidade == null || cidade.getId() == null){
            throw new SistemaMultasException("Você não informou a cidade!");
        }
        orgao.setCidade(cidade);

        return orgao;
    }

    @Override
    public void objetoToTela() {
        Orgao orgao = getObjeto();

        if(orgao != null){
            campoNome.setText(orgao.getNome());
            campoBairro.setText(orgao.getBairro());
            campoRua.setText(orgao.getRua());
            campoNumero.setText(orgao.getNumero());
            setCidade(orgao.getCidade());
        }
    }

    @Override
    public void initComponentes(){
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblCadastroOrgaos = new JLabel("Cadastro de Orgãos");
        contentPane.add(lblCadastroOrgaos, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(new GridLayout(5, 2, 0, 0));

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblNome);

        campoNome = new JTextField();
        panelCentro.add(campoNome);
        campoNome.setColumns(10);

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

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblNumero);

        campoNumero = new JTextField();
        panelCentro.add(campoNumero);
        campoNumero.setColumns(10);

        lblCidade = new JLabel("Cidade:");
        lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblCidade);

        btnSelecionarCidade = new JButton("Selecionar");
        panelCentro.add(btnSelecionarCidade);

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

        new OrgaoCadastroListenner(this);
    }

    private void setCidade(){
        lblCidade.setText("Cidade:");
        this.cidade = new Cidade();
    }

    @Override
    public void resetCampos() {
        campoNome.setText("");
        campoBairro.setText("");
        campoRua.setText("");
        campoNumero.setText("");
        setCidade();
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

    public JButton getBtnSelecionarCidade() {
        return btnSelecionarCidade;
    }

    public JLabel getLblCidade() {
        return lblCidade;
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
}
