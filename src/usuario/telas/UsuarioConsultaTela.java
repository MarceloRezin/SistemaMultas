package usuario.telas;

import java.util.List;

import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import usuario.Usuario;
import usuario.listenner.UsuarioConsultaListenner;

@SuppressWarnings("serial")
public class UsuarioConsultaTela extends ConsultaTela<Usuario> {

	public UsuarioConsultaTela(JDesktopPane jDesktopPane, List<Usuario> itens) {
		super(jDesktopPane, "Consulta Usuários", itens);
		new UsuarioConsultaListenner(this);
	}

	
}
