package usuario.login;

import principal.PrincipalTela;

import javax.swing.*;

import log.LogUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UsuarioLoginListenner implements ActionListener{
    private JButton btnEntrar;
    private UsuarioLoginTela telaLogin;
    private LogUsuario log = new LogUsuario();
    

    public UsuarioLoginListenner(JButton btnEntrar, UsuarioLoginTela telaLogin) {
        this.btnEntrar = btnEntrar;
        this.telaLogin=telaLogin;
        this.btnEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == btnEntrar){
        	try {
				log.SalvarUsuario(telaLogin.getCampoUsuario().getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            new PrincipalTela().setVisible(true);

            telaLogin.dispose();
        }
    }
}
