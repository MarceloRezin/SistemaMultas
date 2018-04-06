package proprietario.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaProprietario extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_5;


    public TelaProprietario() {
        setTitle("Cadastro de Proprietario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 256, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 11, 33, 14);
        contentPane.add(lblNome);

        textField = new JTextField();
        textField.setBounds(100, 8, 130, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(10, 42, 38, 14);
        contentPane.add(lblCPF);

        textField_1 = new JTextField();
        textField_1.setBounds(100, 39, 130, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(10, 73, 66, 14);
        contentPane.add(lblEndereco);

        textField_2 = new JTextField();
        textField_2.setBounds(100, 70, 130, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setBounds(10, 101, 46, 14);
        contentPane.add(lblEstado);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(99, 98, 131, 20);
        contentPane.add(comboBox);

        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(10, 126, 38, 14);
        contentPane.add(lblCidade);

        textField_3 = new JTextField();
        textField_3.setBounds(100, 123, 130, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblCodHabilitacao = new JLabel("Cod. Habilitação:");
        lblCodHabilitacao.setBounds(10, 151, 115, 14);
        contentPane.add(lblCodHabilitacao);

        textField_5 = new JTextField();
        textField_5.setBounds(100, 148, 130, 20);
        contentPane.add(textField_5);
        textField_5.setColumns(10);

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
