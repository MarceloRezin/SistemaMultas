package cadastros.multa.telas;

import commons.telas.TipoConsulta;
import cadastros.multa.Multa;
import cadastros.multa.listenner.MultaConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;

@SuppressWarnings("serial")
public class MultaConsultaTela extends ConsultaTela<Multa> {

	public MultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem multas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new MultaConsultaListenner(this);
	}

	@Override
	public List<Multa> getItensBanco() {
		return null;
	}
}