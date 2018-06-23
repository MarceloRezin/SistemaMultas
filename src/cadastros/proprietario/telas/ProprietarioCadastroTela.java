package cadastros.proprietario.telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import cadastros.condutor.Condutor;
import cadastros.pessoa.Pessoa;
import cadastros.proprietario.Proprietario;
import cadastros.proprietario.listenner.ProprietarioCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.*;

@SuppressWarnings("serial")
public class ProprietarioCadastroTela extends CadastroTela<Proprietario> {

    private JPanel contentPane;
    private JButton btnSelecionarPessoa;
    private JButton btnSelecionarCondutor;

    private Condutor condutor;
    private JLabel lblCondutor;

    private Pessoa pessoa;
    private JLabel lblPessoa;

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnVoltar;

    public ProprietarioCadastroTela(Proprietario objeto, ConsultaTela<Proprietario> consultaTela) {
        super("Condutor", objeto, consultaTela);
    }

    @Override
    public Proprietario telaToObjeto() throws SistemaMultasException {
        Proprietario proprietario = getObjeto();

        if(proprietario == null){
            proprietario = new Proprietario();
        }

        if(pessoa == null || pessoa.getId() == null){
            throw new SistemaMultasException("Você não informou a pessoa!");
        }

        proprietario.setPessoa(pessoa);
        proprietario.setCondutor(condutor);

        return proprietario;
    }

    @Override
    public void objetoToTela() {
        Proprietario proprietario = getObjeto();

        if(proprietario != null){
            setPessoa(proprietario.getPessoa());
            setCondutor(proprietario.getCondutor());
        }
    }

    @Override
    public void initComponentes() {
        setBounds(100, 100, 700, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblCadastroDePessoas = new JLabel("Cadastro de Proprietários");
        contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(new GridLayout(2, 2, 0, 0));

        lblPessoa = new JLabel("Pessoa:");
        lblPessoa.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblPessoa);

        btnSelecionarPessoa = new JButton("Selecionar");
        panelCentro.add(btnSelecionarPessoa);

        lblCondutor = new JLabel("Condutor:");
        lblCondutor.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblCondutor);

        btnSelecionarCondutor = new JButton("Selecionar");
        panelCentro.add(btnSelecionarCondutor);

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

        if(condutor == null){
            condutor = new Condutor();
        }

        new ProprietarioCadastroListenner(this);
    }

    @Override
    public void resetCampos() {
        setPessoa();
        setCondutor();
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

    public JButton getBtnSelecionarPessoa() {
        return btnSelecionarPessoa;
    }

    public void setBtnSelecionarPessoa(JButton btnSelecionarPessoa) {
        this.btnSelecionarPessoa = btnSelecionarPessoa;
    }

    public JButton getBtnSelecionarCondutor() {
        return btnSelecionarCondutor;
    }

    public void setBtnSelecionarCondutor(JButton btnSelecionarCondutor) {
        this.btnSelecionarCondutor = btnSelecionarCondutor;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    private void setCondutor(Condutor condutor){
        if(Utils.cadastroIsNull(condutor)){
            setCondutor();
        }else{
            lblCondutor.setText("Condutor: " + condutor.getPessoa().getNomeRazaoSocial());
            if(Utils.cadastroIsNull(this.condutor)){
                this.condutor = condutor;
            }else{
                Condutor.mesclar(condutor, this.condutor);
            }
        }
    }

    private void setCondutor(){
        lblCondutor.setText("Condutor:");
        this.condutor = new Condutor();
    }

    private void setPessoa(Pessoa pessoa){
        lblPessoa.setText("Pessoa: " + pessoa);
        if(this.pessoa == null){
            this.pessoa = pessoa;
        }else{
            Pessoa.mesclar(pessoa, this.pessoa);
        }
    }

    private void setPessoa(){
        lblPessoa.setText("Pessoa:");
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public JLabel getLblCondutor() {
        return lblCondutor;
    }

    public void setLblCondutor(JLabel lblCondutor) {
        this.lblCondutor = lblCondutor;
    }

    public JLabel getLblPessoa() {
        return lblPessoa;
    }

    public void setLblPessoa(JLabel lblPessoa) {
        this.lblPessoa = lblPessoa;
    }
}
