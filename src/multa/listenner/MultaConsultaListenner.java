package multa.listenner;

import javax.swing.*;
import commons.listenners.ConsultaListenner;

public class MultaConsultaListenner extends ConsultaListenner {

    public MultaConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta, JInternalFrame telaCadastro,
			JButton consultar, JButton novo, JList<Object> list) {
		super(jDesktopPane, telaConsulta, telaCadastro, consultar, novo, list);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Multa -> Listar");
    }

}
