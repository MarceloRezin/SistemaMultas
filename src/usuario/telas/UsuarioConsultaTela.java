package usuario.telas;

import java.util.List;

import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import usuario.Usuario;
import usuario.listenner.UsuarioConsultaListenner;

@SuppressWarnings("serial")
public class UsuarioConsultaTela extends ConsultaTela<Usuario> {

	public UsuarioConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta Usuários");
		new UsuarioConsultaListenner(this);
	}

	@Override
	public List<Usuario> getItensBanco() {
		return null;
	}
}
