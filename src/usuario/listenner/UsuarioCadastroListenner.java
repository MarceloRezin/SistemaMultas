package usuario.listenner;
import commons.listenners.CadastroListenner;
import commons.telas.CadastroTela;
import log.Logger;

public class UsuarioCadastroListenner extends CadastroListenner {

    public UsuarioCadastroListenner(CadastroTela cadastroTela) {
        super(cadastroTela);
    }

    @Override
    public void eventoSalvar() {
        System.out.println("Usuário -> Salvar");
        Logger.log("Usuario, Salvou");
    }

    @Override
    public void eventoExcluir() {
        System.out.println("Usuário -> Excluir");
        Logger.log("Usuario, Excluiu");
    }

    @Override
    public void eventoVoltar() {
        System.out.println("Usuário -> Voltar");
    }
}
