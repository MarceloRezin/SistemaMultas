package commons.utils;

import javax.swing.*;

public final class Utils {

    public static boolean isNulaOuVazia(String string){
        if(string == null){
            return true;
        }

        if(string.trim().isEmpty()){
            return true;
        }

        return false;
    }

    public static void mensagem(String titulo, String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean mensagemConfirmacao(String titulo, String mensagem){
        return JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public static void mensagemErro(String titulo, String mensagem){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensagemErro(String mensagem){
        mensagemErro("Erro", mensagem);
    }
}
