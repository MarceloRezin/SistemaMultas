package proprietario.telas;

import java.util.List;

import javax.swing.JDesktopPane;

import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import proprietario.Proprietario;
import proprietario.listenner.ProprietarioConsultaListenner;

@SuppressWarnings("serial")
public class ProprietarioConsultaTela extends ConsultaTela<Proprietario> {

	public ProprietarioConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem proprietario", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new ProprietarioConsultaListenner(this);
	}

	@Override
	public List<Proprietario> getItensBanco() {
		return null;
	}
}
