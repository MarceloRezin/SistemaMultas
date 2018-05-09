package gravidademulta.telas;

import banco.Banco;
import commons.telas.ConsultaTela;
import gravidademulta.GravidadeMulta;
import gravidademulta.listenner.GravidadeMultaConsultaListenner;
import javax.swing.*;

@SuppressWarnings("serial")
public class GravidadeMultaConsultaTela extends ConsultaTela<GravidadeMulta>{

	public GravidadeMultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Gravidade de Multas", Banco.select(new GravidadeMulta()));
		new GravidadeMultaConsultaListenner(this);
	}
}
