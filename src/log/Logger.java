package log;

import commons.utils.Utils;
import log.arquivo.Arquivo;
import cadastros.usuario.UsuarioContexto;
import java.time.LocalDateTime;

public class Logger {

    public static void log(String conteudo){
        conteudo = UsuarioContexto.getNomeUsuarioLogado() + "\t\t\t" + LocalDateTime.now().format(Utils.FMT_DD_MM_YYYY_HH_MM_SS) +  "\t\t\t" + conteudo;
        new Arquivo(conteudo).gerarLog();
    }

    public static void logErro(String conteudo){
        log("ERRO: " + conteudo);
    }
}
