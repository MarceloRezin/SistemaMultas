package multa.telas;

import multa.listenner.MultaListagemListenner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaConsultaMulta extends JInternalFrame {

    private JPanel contentPane;
    private JTextField textField;

    public TelaConsultaMulta(JDesktopPane jDesktopPane) {
        super("Consulta De Multa", false, true, true, false);
        setBounds(100, 100, 256, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JList list = new JList();
        list.setBounds(10, 39, 220, 179);
        list.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentPane.add(list);

        textField = new JTextField();
        textField.setBounds(10, 8, 131, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnP = new JButton("Listar");
        btnP.setBounds(151, 7, 40, 23);
        contentPane.add(btnP);

        JButton button = new JButton("+");
        button.setBounds(191, 7, 40, 23);
        contentPane.add(button);

        new MultaListagemListenner(btnP, button, jDesktopPane, this);
    }
}
