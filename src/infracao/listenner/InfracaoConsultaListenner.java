package infracao.listenner;

import javax.swing.*;
import commons.listenners.ConsultaListenner;

public class InfracaoConsultaListenner extends ConsultaListenner {
   
    public InfracaoConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta,
			JInternalFrame telaCadastro, JButton consultar, JButton novo, JList<Object> list) {
		super(jDesktopPane, telaConsulta, telaCadastro, consultar, novo, list);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Infracao -> Listar");
    }
}
