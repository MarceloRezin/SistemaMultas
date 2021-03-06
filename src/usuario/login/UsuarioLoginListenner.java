package usuario.login;

import log.Logger;
import principal.PrincipalTela;

import javax.swing.*;

import log.LogUsuario;
import usuario.Usuario;
import usuario.UsuarioContexto;

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
                Usuario u = new Usuario(telaLogin.getCampoUsuario().getText(), telaLogin.getCampoSenha().getText(), false);
				log.SalvarUsuario(u.getUsuario());
                UsuarioContexto.setUsuarioLogado(u);

                Logger.log("Usuário Logou");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				 e.printStackTrace();
				 Logger.log(e.getStackTrace().toString());
			}
            new PrincipalTela().setVisible(true);

            telaLogin.dispose();
        }
    }
}
