package usuario.login;

import principal.PrincipalTela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioLoginListenner implements ActionListener{
    private JButton btnEntrar;
    private JFrame telaLogin;

    public UsuarioLoginListenner(JButton btnEntrar, JFrame telaLogin) {
        this.btnEntrar = btnEntrar;
        this.telaLogin=telaLogin;
        this.btnEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnEntrar){
            new PrincipalTela().setVisible(true);

            telaLogin.dispose();
        }
    }
}
