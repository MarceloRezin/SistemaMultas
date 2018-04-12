package veiculo.telas;

import java.util.List;
import javax.swing.JDesktopPane;
import commons.telas.ConsultaTela;
import veiculo.Veiculo;
import veiculo.listenner.VeiculoConsultaListenner;

@SuppressWarnings("serial")
public class VeiculoConsultaTela extends ConsultaTela<Veiculo> {

	public VeiculoConsultaTela(JDesktopPane jDesktopPane, List<Veiculo> itens) {
		super(jDesktopPane, "Listagem veiculos", itens);
		new VeiculoConsultaListenner(this);
	}

}
