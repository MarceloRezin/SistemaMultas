package multa.telas;

import multa.Multa;
import multa.listenner.MultaConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;

@SuppressWarnings("serial")
public class MultaConsultaTela extends ConsultaTela<Multa> {

	public MultaConsultaTela(JDesktopPane jDesktopPane, List<Multa> itens) {
		super(jDesktopPane, "Listagem multas", itens);
		new MultaConsultaListenner(this);
	}
}
