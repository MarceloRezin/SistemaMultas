package veiculo.telas;

import java.util.List;
import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import veiculo.Veiculo;
import veiculo.listenner.VeiculoConsultaListenner;

@SuppressWarnings("serial")
public class VeiculoConsultaTela extends ConsultaTela<Veiculo> {

	public VeiculoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem veiculos", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new VeiculoConsultaListenner(this);
	}

	@Override
	public List<Veiculo> getItensBanco() {
		return null;
	}
}
