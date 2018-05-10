package multa.telas;

import multa.Multa;
import multa.listenner.MultaConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;

@SuppressWarnings("serial")
public class MultaConsultaTela extends ConsultaTela<Multa> {

	public MultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem multas");
		new MultaConsultaListenner(this);
	}

	@Override
	public List<Multa> getItensBanco() {
		return null;
	}
}
