package cadastros.veiculo.telas;

import java.util.List;
import javax.swing.*;

import banco.Banco;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import cadastros.veiculo.Veiculo;
import cadastros.veiculo.listenner.VeiculoConsultaListenner;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class VeiculoConsultaTela extends ConsultaTela<Veiculo> {

	public VeiculoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem veiculos", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new VeiculoConsultaListenner(this);
	}

	public VeiculoConsultaTela(CadastroTela<Veiculo> cadastroTela, Veiculo objetoRetorno, JLabel campoRetorno) {
		super("Listagem veiculos", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
		new VeiculoConsultaListenner(this);
	}

	@Override
	public List<Veiculo> getItensBanco()  throws SistemaMultasException {
		String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComPesquisa(new Veiculo(), pesquisa);
		}

		return Banco.select(new Veiculo());
	}
}
