package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import log.Logger;
import usuario.login.UsuarioLoginTela;

public class Main {

    public static void main(String[] args) {
    	
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			Logger.log(e.getStackTrace().toString());
		}		

        new UsuarioLoginTela().setVisible(true);
    }
}
