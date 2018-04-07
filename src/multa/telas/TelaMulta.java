package multa.telas;

import multa.listenner.MultaCadastroListenner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaMulta extends JInternalFrame {

    private JPanel contentPane;
    private JTextField txtVeiculo;
    private JTextField txtOrgao;
    private JTextField textField_5;
    private JTextField txtDataHora;
    private JTextField txtVencimento;
    private JTextField txtEndereco;
    private JTextField textField;


    public TelaMulta() {
        super("Cadastro de Multa", false, true, true, false);
        setBounds(100, 100, 256, 398);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblVeiculo = new JLabel("Veiculo:");
        lblVeiculo.setBounds(10, 11, 46, 14);
        contentPane.add(lblVeiculo);

        txtVeiculo = new JTextField();
        txtVeiculo.setBounds(100, 8, 130, 20);
        contentPane.add(txtVeiculo);
        txtVeiculo.setColumns(10);

        JLabel lblInfracao = new JLabel("Infra\u00E7\u00E3o");
        lblInfracao.setBounds(10, 42, 54, 14);
        contentPane.add(lblInfracao);

        JLabel lblOrgao = new JLabel("Org\u00E3o");
        lblOrgao.setBounds(10, 73, 46, 14);
        contentPane.add(lblOrgao);

        txtOrgao = new JTextField();
        txtOrgao.setBounds(100, 70, 130, 20);
        contentPane.add(txtOrgao);
        txtOrgao.setColumns(10);

        JComboBox boxCidade = new JComboBox();
        boxCidade.setBounds(100, 225, 131, 20);
        contentPane.add(boxCidade);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(10, 228, 54, 14);
        contentPane.add(lblEstado);

        textField_5 = new JTextField();
        textField_5.setBounds(100, 194, 130, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 324, 68, 23);
        contentPane.add(btnSalvar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(88, 324, 68, 23);
        contentPane.add(btnExcluir);

        JLabel lblDataHora = new JLabel("Data e Hora:");
        lblDataHora.setBounds(10, 104, 64, 14);
        contentPane.add(lblDataHora);

        txtDataHora = new JTextField();
        txtDataHora.setBounds(100, 101, 130, 20);
        contentPane.add(txtDataHora);
        txtDataHora.setColumns(10);

        JLabel lblVencimento = new JLabel("Vencimento:");
        lblVencimento.setBounds(10, 135, 64, 14);
        contentPane.add(lblVencimento);

        txtVencimento = new JTextField();
        txtVencimento.setBounds(100, 132, 130, 20);
        contentPane.add(txtVencimento);
        txtVencimento.setColumns(10);

        JLabel lblEndereo = new JLabel("Endere\u00E7o:");
        lblEndereo.setBounds(10, 166, 54, 14);
        contentPane.add(lblEndereo);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 163, 130, 20);
        contentPane.add(txtEndereco);
        txtEndereco.setColumns(10);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(10, 197, 46, 14);
        contentPane.add(lblCidade);

        JComboBox boxInfracao = new JComboBox();
        boxInfracao.setBounds(100, 39, 130, 20);
        contentPane.add(boxInfracao);

        JLabel lblFatorMultiplicador = new JLabel("Fator Multiplicador:");
        lblFatorMultiplicador.setBounds(10, 259, 96, 14);
        contentPane.add(lblFatorMultiplicador);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(100, 256, 130, 20);
        contentPane.add(comboBox);

        JLabel lblProprietario = new JLabel("Proprietario:");
        lblProprietario.setBounds(10, 287, 64, 14);
        contentPane.add(lblProprietario);

        textField = new JTextField();
        textField.setBounds(100, 284, 130, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnVoltar = new JButton("Sair");
        btnVoltar.setBounds(166, 324, 68, 23);
        contentPane.add(btnVoltar);

        new MultaCadastroListenner(btnSalvar, btnExcluir, btnVoltar);
    }
}
