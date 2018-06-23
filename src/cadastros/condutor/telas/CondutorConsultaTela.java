package cadastros.condutor.telas;

import banco.Banco;
import cadastros.condutor.Condutor;
import cadastros.condutor.listenner.CondutorConsultaListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class CondutorConsultaTela extends ConsultaTela<Condutor>{

	public CondutorConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Condutores", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new CondutorConsultaListenner(this);
	}

    public CondutorConsultaTela(CadastroTela<Condutor> cadastroTela, Condutor objetoRetorno, JLabel campoRetorno) {
        super("Consulta de Cidades", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
        new CondutorConsultaListenner(this);
    }

	@Override
	public List<Condutor> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComPesquisa(new Condutor(), pesquisa);
		}else{
			return Banco.select(new Condutor());
		}
	}
}