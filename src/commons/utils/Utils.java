package commons.utils;

import commons.cadastros.Cadastro;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class Utils {

    public static final DateTimeFormatter FMT_DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FMT_DD_MM_YYYY_HH_MM_SS = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", new Locale("pt", "BR"));

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

    public static MaskFormatter mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara);
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        }
        return F_Mascara;
    }

    public static boolean cadastroIsNull(Cadastro cadastro){
        if(cadastro == null || cadastro.isNovo()){
            return true;
        }

        return false;
    }

}
