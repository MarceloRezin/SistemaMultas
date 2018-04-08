package proprietario.listenner;

import javax.swing.*;
import commons.listenners.ConsultaListenner;

public class ProprietarioConsultaListenner extends ConsultaListenner {

    public ProprietarioConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta,
			JInternalFrame telaCadastro, JButton consultar, JButton novo, JList<Object> list) {
		super(jDesktopPane, telaConsulta, telaCadastro, consultar, novo, list);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Proprietário -> Listar");
	}
}
