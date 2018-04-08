package usuario.listenner;

import javax.swing.*;

import commons.listenners.ConsultaListenner;

public class UsuarioConsultaListenner extends ConsultaListenner {

    public UsuarioConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta, JInternalFrame telaCadastro,
			JButton consultar, JButton novo, JList<Object> list) {
		super(jDesktopPane, telaConsulta, telaCadastro, consultar, novo, list);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Usuário -> Listar");
    }
}
