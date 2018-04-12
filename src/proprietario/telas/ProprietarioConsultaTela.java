package proprietario.telas;

import java.util.List;

import javax.swing.JDesktopPane;

import commons.telas.ConsultaTela;
import proprietario.Proprietario;
import proprietario.listenner.ProprietarioConsultaListenner;

@SuppressWarnings("serial")
public class ProprietarioConsultaTela extends ConsultaTela<Proprietario> {

	public ProprietarioConsultaTela(JDesktopPane jDesktopPane, List<Proprietario> itens) {
		super(jDesktopPane, "Listagem proprietario", itens);
		new ProprietarioConsultaListenner(this);
	}

	
}
