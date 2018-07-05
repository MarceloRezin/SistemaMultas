package cadastros.usuario;

public class UsuarioContexto {

    public static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static String getNomeUsuarioLogado() {
        if(usuarioLogado == null){
            return "Usuário não logado";
        }
        return usuarioLogado.getUsuario();
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        UsuarioContexto.usuarioLogado = usuarioLogado;
    }
}
