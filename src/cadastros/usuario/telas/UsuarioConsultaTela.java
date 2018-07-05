package cadastros.usuario.telas;

import java.util.List;

import javax.swing.JDesktopPane;

import banco.Banco;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import cadastros.usuario.Usuario;
import cadastros.usuario.listenner.UsuarioConsultaListenner;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class UsuarioConsultaTela extends ConsultaTela<Usuario> {

	public UsuarioConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta Usuários", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new UsuarioConsultaListenner(this);
	}

	@Override
	public List<Usuario> getItensBanco() throws SistemaMultasException{
		String pesquisa = getCampoPesquisa().getText();

		if(Utils.isNulaOuVazia(pesquisa)){
		    return Banco.select(new Usuario());
        }
		return Banco.selectComPesquisa(new Usuario(), pesquisa);
	}
}
