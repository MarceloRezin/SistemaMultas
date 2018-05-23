package cadastros.usuario.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.usuario.Usuario;
import cadastros.usuario.telas.UsuarioCadastroTela;

public class UsuarioConsultaListenner extends ConsultaListenner<Usuario> {

   
	public UsuarioConsultaListenner(ConsultaTela<Usuario> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Usuário -> Listar");
    }

	@Override
	public void eventoNovo() {
		System.out.println("Usuario -> Novo");
		getTela().dispose();
		UsuarioCadastroTela usuarioCadastroTela = new UsuarioCadastroTela(null);
		getConsultaTela().getjDesktopPane().add(usuarioCadastroTela);
		usuarioCadastroTela.setVisible(true);
	}

	@Override
	public void eventoItemSelecionado() {
		getTela().dispose();
		UsuarioCadastroTela usuarioCadastroTela = new UsuarioCadastroTela(getItemListSelecionado());
		getConsultaTela().getjDesktopPane().add(usuarioCadastroTela);
		usuarioCadastroTela.setVisible(true);
//		System.out.println("Usuario -> Item Selecionado:" + getItemListSelecionado());
	}
}
