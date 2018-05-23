package gravidademulta.telas;

import banco.Banco;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import gravidademulta.GravidadeMulta;
import gravidademulta.listenner.GravidadeMultaConsultaListenner;
import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class GravidadeMultaConsultaTela extends ConsultaTela<GravidadeMulta>{

	public GravidadeMultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Gravidade de Multas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new GravidadeMultaConsultaListenner(this);
	}

	@Override
	public List<GravidadeMulta> getItensBanco() {
		return Banco.select(new GravidadeMulta());
	}
}
