package usuario;

public class UsuarioContexto {

    public static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static String getNomeUsuarioLogado() {
        return usuarioLogado.getUsuario();
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        UsuarioContexto.usuarioLogado = usuarioLogado;
    }
}
