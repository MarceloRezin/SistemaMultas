package cadastros.multa.telas;

import cadastros.cidade.Cidade;
import cadastros.condutor.Condutor;
import cadastros.infracao.Infracao;
import cadastros.multa.FatorMultiplicador;
import cadastros.multa.Multa;
import cadastros.multa.listenner.MultaCadastroListenner;
import cadastros.orgao.Orgao;
import cadastros.proprietario.Proprietario;
import cadastros.veiculo.Veiculo;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class MultaCadastroTela extends CadastroTela<Multa> {

    private JPanel contentPane;
    private JFormattedTextField campoDataVencimento;
    private JTextField campoBairro;
    private JTextField campoRua;
    private JTextField campoNumero;
    private JTextField campoValorFinal;
    private JTextField campoDataHoraEmissao;
    private JComboBox comboFatorMultiplicador;

    private JLabel lblVeiculo;
    private JButton btnSelecionarVeiculo;
    private Veiculo veiculo;

    private JLabel lblOrgao;
    private JButton btnSelecionarOrgao;
    private Orgao orgao;

    private JLabel lblInfracao;
    private JButton btnSelecionarInfracao;
    private Infracao infracao;

    private JLabel lblCidade;
    private JButton btnSelecionarCidade;
    private Cidade cidade;

    private JLabel lblCondutor;
    private JButton btnSelecionarCondutor;
    private Condutor condutor;

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnVoltar;

    public MultaCadastroTela(Multa objeto, ConsultaTela<Multa> consultaTela) {
        super("Multa", objeto, consultaTela);
    }

    @Override
    public Multa telaToObjeto() throws SistemaMultasException {
        Multa multa = getObjeto();

        if(multa == null){
            multa = new Multa();
        }

        if(Utils.cadastroIsNull(veiculo)){
            throw new SistemaMultasException("Você não informou o veículo!");
        }
        multa.setVeiculo(veiculo);

        if(Utils.cadastroIsNull(orgao)){
            throw new SistemaMultasException("Você não informou o orgão!");
        }
        multa.setOrgao(orgao);

        if(Utils.cadastroIsNull(infracao)){
            throw new SistemaMultasException("Você não informou a infração!");
        }
        multa.setInfracao(infracao);

        if(Utils.cadastroIsNull(cidade)){
            throw new SistemaMultasException("Você não informou a cidade!");
        }
        multa.setCidade(cidade);

        if(!Utils.cadastroIsNull(condutor)){
            multa.setCondutor(condutor);
        }

        String dataVencimento = campoDataVencimento.getText();
        if(!dataVencimento.matches("\\d{2}/\\d{2}/\\d{4}")){
            throw new SistemaMultasException("Você não informou uma data de vencimento válida!");
        }
        try{
            multa.setDataVencimento(LocalDate.parse(dataVencimento, Utils.FMT_DD_MM_YYYY));
        }catch (DateTimeException e){
            throw new SistemaMultasException("Você não informou uma data de vencimento válida!");
        }

        String bairro = campoBairro.getText();
        if(!Utils.isNulaOuVazia(bairro)){
            multa.setBairro(bairro);
        }

        String rua = campoRua.getText();
        if(!Utils.isNulaOuVazia(rua)){
            multa.setRua(rua);
        }

        String numero = campoNumero.getText();
        if(!Utils.isNulaOuVazia(numero)){
            multa.setNumero(numero);
        }

        multa.setFatorMultiplicador(FatorMultiplicador.values()[comboFatorMultiplicador.getSelectedIndex()]);

        multa.setDataHoraEmissao(LocalDateTime.now());

        BigDecimal valorFinalCalculado = multa.getInfracao().getGravidadeMulta().getValor();

        if(multa.getFatorMultiplicador() != FatorMultiplicador.X0){
            valorFinalCalculado = valorFinalCalculado.multiply(new BigDecimal(multa.getFatorMultiplicador().getValor()));
        }
        multa.setValorFinal(valorFinalCalculado);

        campoValorFinal.setText("R$" + multa.getValorFinal().toString().replaceAll("\\.", ","));
        campoDataHoraEmissao.setText(multa.getDataHoraEmissao().format(Utils.FMT_DD_MM_YYYY_HH_MM_SS));

        return multa;
    }

    @Override
    public void objetoToTela() {
        Multa multa = getObjeto();

        if(multa != null){
            setVeiculo(multa.getVeiculo());
            setOrgao(multa.getOrgao());
            setInfracao(multa.getInfracao());
            setCondutor(multa.getCondutor());
            setCidade(multa.getCidade());
            campoDataVencimento.setText(multa.getDataVencimento().format(Utils.FMT_DD_MM_YYYY));
            campoBairro.setText(multa.getBairro());
            campoRua.setText(multa.getRua());
            campoNumero.setText(multa.getRua());
            campoValorFinal.setText("R$" + multa.getValorFinal().toString().replaceAll("\\.", ","));
            campoDataHoraEmissao.setText(multa.getDataHoraEmissao().format(Utils.FMT_DD_MM_YYYY_HH_MM_SS));
            comboFatorMultiplicador.setSelectedIndex(multa.getFatorMultiplicador().getIndice());
        }
    }

    @Override
    public void initComponentes() {
        setBounds(100, 100, 600, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblCadastroDePessoas = new JLabel("Cadastro de Multas");
        contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(new GridLayout(12, 2, 0, 0));

        lblOrgao = new JLabel("Orgão*:");
        lblOrgao.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblOrgao);

        btnSelecionarOrgao = new JButton("Selecionar");
        panelCentro.add(btnSelecionarOrgao);

        lblVeiculo = new JLabel("Veículo*:");
        lblVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblVeiculo);

        btnSelecionarVeiculo = new JButton("Selecionar");
        panelCentro.add(btnSelecionarVeiculo);

        lblCondutor = new JLabel("Condutor:");
        lblCondutor.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblCondutor);

        btnSelecionarCondutor = new JButton("Selecionar");
        panelCentro.add(btnSelecionarCondutor);

        lblInfracao = new JLabel("Infração*:");
        lblInfracao.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblInfracao);

        btnSelecionarInfracao = new JButton("Selecionar");
        panelCentro.add(btnSelecionarInfracao);

        JLabel lblFatorMultiplicador = new JLabel("Fator Multiplicador:");
        lblFatorMultiplicador.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblFatorMultiplicador);

        FatorMultiplicador[] fatorMultiplicadors = FatorMultiplicador.values();

        comboFatorMultiplicador = new JComboBox();
        for(int i=0; i<fatorMultiplicadors.length; i++){
            comboFatorMultiplicador.addItem(fatorMultiplicadors[i].getValor());
        }
        panelCentro.add(comboFatorMultiplicador);

        lblCidade = new JLabel("Cidade*:");
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

        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblNumero);

        campoNumero = new JTextField();
        panelCentro.add(campoNumero);
        campoNumero.setColumns(10);

        JLabel lblValorFinal = new JLabel("Valor Final:");
        lblValorFinal.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblValorFinal);

        campoValorFinal = new JTextField();
        campoValorFinal.setEnabled(false);
        panelCentro.add(campoValorFinal);
        campoValorFinal.setColumns(10);

        JLabel lblDataHoraEmissao = new JLabel("Data de emissão:");
        lblDataHoraEmissao.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblDataHoraEmissao);

        campoDataHoraEmissao = new JTextField();
        campoDataHoraEmissao.setEnabled(false);
        panelCentro.add(campoDataHoraEmissao);
        campoDataHoraEmissao.setColumns(10);

        JLabel lblDataVencimento = new JLabel("Data de Vencimento:");
        lblDataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblDataVencimento);

        campoDataVencimento = new JFormattedTextField(Utils.mascara("##/##/####"));;
        panelCentro.add(campoDataVencimento);
        campoDataVencimento.setColumns(10);

        if(veiculo == null){
            veiculo = new Veiculo();
        }

        if(orgao == null){
            orgao = new Orgao();
        }

        if(infracao == null){
            infracao = new Infracao();
        }

        if(cidade == null){
            cidade = new Cidade();
        }

        if(condutor == null){
            condutor = new Condutor();
        }

        JPanel panelSul = new JPanel();
        getContentPane().add(panelSul, BorderLayout.SOUTH);
        panelSul.setLayout(new GridLayout(1, 0, 0, 0));

        btnSalvar = new JButton("Salvar");
        panelSul.add(btnSalvar);

        btnExcluir = new JButton("Excluir");
        panelSul.add(btnExcluir);

        btnVoltar = new JButton("Voltar");
        panelSul.add(btnVoltar);

        new MultaCadastroListenner(this);
    }

    @Override
    public void resetCampos() {
        setOrgao();
        setVeiculo();
        setCondutor();
        setInfracao();
        comboFatorMultiplicador.setSelectedIndex(0);
        setCidade();
        campoBairro.setText("");
        campoRua.setText("");
        campoNumero.setText("");
        campoValorFinal.setText("");
        campoDataHoraEmissao.setText("");
        campoDataVencimento.setText("");
    }

    private void setCidade(Cidade cidade){
        lblCidade.setText("Cidade*: " + cidade.getNome());
        if(this.cidade == null){
            this.cidade = cidade;
        }else{
            Cidade.mesclar(cidade, this.cidade);
        }
    }

    private void setCidade(){
        lblCidade.setText("Cidade*:");
        this.cidade = new Cidade();
    }

    public JLabel getLblCidade() {
        return lblCidade;
    }

    public JButton getBtnSelecionarCidade() {
        return btnSelecionarCidade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    private void setVeiculo(Veiculo veiculo){
        lblVeiculo.setText("Veículo*: " + veiculo.getPlaca());
        if(this.veiculo == null){
            this.veiculo = veiculo;
        }else{
            Veiculo.mesclar(veiculo, this.veiculo);
        }
    }

    private void setVeiculo(){
        lblVeiculo.setText("Veículo*:");
        this.veiculo = new Veiculo();
    }

    public JLabel getLblVeiculo() {
        return lblVeiculo;
    }

    public JButton getBtnSelecionarVeiculo() {
        return btnSelecionarVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    private void setOrgao(Orgao orgao){
        lblOrgao.setText("Orgão*: " + orgao.getNome());
        if(this.orgao == null){
            this.orgao = orgao;
        }else{
            Orgao.mesclar(orgao, this.orgao);
        }
    }

    private void setOrgao(){
        lblOrgao.setText("Orgão*:");
        this.orgao = new Orgao();
    }

    public JLabel getLblOrgao() {
        return lblOrgao;
    }

    public JButton getBtnSelecionarOrgao() {
        return btnSelecionarOrgao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    private void setInfracao(Infracao infracao){
        lblInfracao.setText("Infração*: " + infracao.getDescricao());
        if(this.infracao == null){
            this.infracao = infracao;
        }else{
            Infracao.mesclar(infracao, this.infracao);
        }
    }

    private void setInfracao(){
        lblInfracao.setText("Infração*:");
        this.infracao = new Infracao();
    }

    public JLabel getLblInfracao() {
        return lblInfracao;
    }

    public JButton getBtnSelecionarInfracao() {
        return btnSelecionarInfracao;
    }

    public Infracao getInfracao() {
        return infracao;
    }

    private void setCondutor(Condutor condutor){
        if(condutor != null){
            lblCondutor.setText("Condutor: " + condutor.getPessoa().getNomeRazaoSocial());
            if(this.condutor == null){
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

    public JLabel getLblCondutor() {
        return lblCondutor;
    }

    public JButton getBtnSelecionarCondutor() {
        return btnSelecionarCondutor;
    }

    public Condutor getCondutor() {
        return condutor;
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
