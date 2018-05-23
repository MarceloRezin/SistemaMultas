package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import banco.Banco;
import log.Logger;
import cadastros.usuario.login.UsuarioLoginTela;


public class Main {

    public static void main(String[] args) {
    	
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			Logger.log(e.getStackTrace().toString());
		}

        Banco.iniciarConexao();

		new UsuarioLoginTela().setVisible(true);
    }
}
