package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import banco.Banco;
import principal.PrincipalTela;
import usuario.login.UsuarioLoginTela;


public class Main {

    public static void main(String[] args) {
    	
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

        Banco.iniciarConexao();

		new PrincipalTela().setVisible(true);
    }
}
