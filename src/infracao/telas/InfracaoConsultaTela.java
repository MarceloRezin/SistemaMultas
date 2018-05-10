package infracao.telas;

import infracao.Infracao;
import infracao.listenner.InfracaoConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;

@SuppressWarnings("serial")
public class InfracaoConsultaTela extends ConsultaTela<Infracao>{
	
	public InfracaoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Infrações");
		new InfracaoConsultaListenner(this);
	}

	@Override
	public List<Infracao> getItensBanco() {
		return null;
	}
}
