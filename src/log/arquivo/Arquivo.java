package log.arquivo;

import log.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Arquivo{
    private static final String diretorio = "log.log";
    private String conteudo;

    public Arquivo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void gerarLog(){
        new Thread(){

            @Override
            public void run() {
                try {
                    gravar();
                } catch (Exception e) {
                    e.printStackTrace();
                    Logger.log(e.getStackTrace().toString());
                }
            }
        }.start();
    }


    private synchronized void gravar() throws Exception {
        FileWriter fileWriter = new FileWriter(diretorio, true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write(conteudo);
        writer.newLine();
        writer.flush();
        writer.close();
    }
}
