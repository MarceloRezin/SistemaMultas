package cadastros.multa.telas;

import banco.Banco;
import commons.telas.TipoConsulta;
import cadastros.multa.Multa;
import cadastros.multa.listenner.MultaConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class MultaConsultaTela extends ConsultaTela<Multa> {

	public MultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem multas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new MultaConsultaListenner(this);
	}

	@Override
	public List<Multa> getItensBanco()  throws SistemaMultasException {
		String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComWhere(new Multa(), "INNER JOIN veiculos v ON multas.veiculo_id = v.id AND (upper(v.placa) LIKE '%" + pesquisa.toUpperCase() + "%')");
		}else{
			return Banco.selectComPesquisa(new Multa(), "");
		}
	}
}
