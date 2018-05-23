package cadastros.usuario.telas;

import java.util.List;

import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import cadastros.usuario.Usuario;
import cadastros.usuario.listenner.UsuarioConsultaListenner;

@SuppressWarnings("serial")
public class UsuarioConsultaTela extends ConsultaTela<Usuario> {

	public UsuarioConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta Usuários", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new UsuarioConsultaListenner(this);
	}

	@Override
	public List<Usuario> getItensBanco() {
		return null;
	}
}
