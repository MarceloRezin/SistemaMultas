package orgao.telas;

import java.util.List;
import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import orgao.Orgao;
import orgao.listenner.OrgaoConsultaListenner;

@SuppressWarnings("serial")
public class OrgaoConsultaTela extends ConsultaTela<Orgao> {

	public OrgaoConsultaTela(JDesktopPane jDesktopPane, List<Orgao> itens) {
		super(jDesktopPane, "Listagem orgãos", itens);
		
		new OrgaoConsultaListenner(this);
	}
}