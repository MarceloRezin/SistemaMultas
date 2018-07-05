package cadastros.usuario.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.usuario.Usuario;
import cadastros.usuario.telas.UsuarioCadastroTela;
import log.Logger;

public class UsuarioConsultaListenner extends ConsultaListenner<Usuario> {

   
	public UsuarioConsultaListenner(ConsultaTela<Usuario> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
		Logger.log("Usuário Listar");
		getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoNovo() {
		Logger.log("Usuário Novo");

		UsuarioCadastroTela orgaoCadastroTela = new UsuarioCadastroTela(null, getConsultaTela());

		abrirCadastro(orgaoCadastroTela);
	}

	@Override
	public void eventoItemSelecionado() {
		Logger.log("Usuário Item Selecionado");

		UsuarioCadastroTela orgaoCadastroTela = new UsuarioCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(orgaoCadastroTela);
	}
}
