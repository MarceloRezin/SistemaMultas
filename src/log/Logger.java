package log;

import log.arquivo.Arquivo;
import usuario.UsuarioContexto;
import java.time.LocalDateTime;

public class Logger {

    public static void log(String conteudo){
        conteudo = UsuarioContexto.getNomeUsuarioLogado() + "\t\t\t" + LocalDateTime.now() +  "\t\t\t" + conteudo;
        new Arquivo(conteudo).gerarLog();
    }

    public static void logErro(String conteudo){
        log("ERRO: " + conteudo);
    }
}
