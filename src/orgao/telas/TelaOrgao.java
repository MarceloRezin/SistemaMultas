package orgao.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaOrgao extends JInternalFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtCidade;
    private JTextField txtEndereco;


    public TelaOrgao() {
        super("Cadastro de Orgão", false, true, true, false);
        setBounds(100, 100, 256, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 33, 14);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 8, 130, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(10, 42, 58, 14);
        contentPane.add(lblEndereco);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(9, 70, 38, 14);
        contentPane.add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(99, 67, 130, 20);
        contentPane.add(txtCidade);
        txtCidade.setColumns(10);

        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(10, 101, 46, 14);
        contentPane.add(lblEstado);

        JComboBox boxEstado = new JComboBox();
        boxEstado.setBounds(100, 98, 131, 20);
        contentPane.add(boxEstado);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 39, 130, 20);
        contentPane.add(txtEndereco);
        txtEndereco.setColumns(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 226, 68, 23);
        contentPane.add(btnSalvar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(88, 226, 68, 23);
        contentPane.add(btnExcluir);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(166, 226, 68, 23);
        contentPane.add(btnSair);
    }
}
