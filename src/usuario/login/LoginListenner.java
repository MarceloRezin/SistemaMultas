package usuario.login;

import principal.PrincipalTela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;

public class LoginListenner implements ActionListener{
    private JButton btnLogar;
    private JFrame tela;

    public LoginListenner(JButton btnLogar, JFrame tela) {
        this.btnLogar = btnLogar;
        this.tela=tela;
        this.btnLogar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnLogar){
            new PrincipalTela().setVisible(true);

            tela.dispose();
        }
    }
}
