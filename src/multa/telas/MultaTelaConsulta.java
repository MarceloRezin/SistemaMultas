package multa.telas;

import multa.listenner.MultaConsultaListenner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MultaTelaConsulta extends JInternalFrame {

    private JPanel contentPane;
    private JTextField textField;

    public MultaTelaConsulta(JDesktopPane jDesktopPane) {
        super("Consulta De Multa", false, true, true, false);
        setBounds(100, 100, 256, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JList<Object> list = new JList<Object>();
        list.setBounds(10, 39, 220, 179);
        list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentPane.add(list);

        textField = new JTextField();
        textField.setBounds(10, 8, 131, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnConsultar = new JButton("Listar");
        btnConsultar.setBounds(151, 7, 40, 23);
        contentPane.add(btnConsultar);

        JButton btnNovo = new JButton("+");
        btnNovo.setBounds(191, 7, 40, 23);
        contentPane.add(btnNovo);

        new MultaConsultaListenner(jDesktopPane, this, new MultaTelaCadastro(), btnConsultar, btnNovo, list);
    }
}
