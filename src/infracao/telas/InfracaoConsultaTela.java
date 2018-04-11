package infracao.telas;

import infracao.Infracao;
import infracao.listenner.InfracaoConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;

@SuppressWarnings("serial")
public class InfracaoConsultaTela extends ConsultaTela<Infracao>{
	
	public InfracaoConsultaTela(JDesktopPane jDesktopPane, List<Infracao> itens) {
		super(jDesktopPane, "Consulta de Infrações", itens);
		new InfracaoConsultaListenner(this);
	}
}
