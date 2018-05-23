package orgao.telas;

import java.util.List;
import javax.swing.JDesktopPane;

import banco.Banco;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import orgao.Orgao;
import orgao.listenner.OrgaoConsultaListenner;

@SuppressWarnings("serial")
public class OrgaoConsultaTela extends ConsultaTela<Orgao> {

	public OrgaoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem orgãos", TipoConsulta.CONSULTA_PARA_CADASTRO);
		
		new OrgaoConsultaListenner(this);
	}

	@Override
	public List<Orgao> getItensBanco() {
		return Banco.select(new Orgao());
	}
}