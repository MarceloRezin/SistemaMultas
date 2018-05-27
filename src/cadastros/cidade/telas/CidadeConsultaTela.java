package cadastros.cidade.telas;

import banco.Banco;
import cadastros.cidade.Cidade;
import cadastros.cidade.listenner.CidadeConsultaListenner;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class CidadeConsultaTela extends ConsultaTela<Cidade>{

	public CidadeConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Cidades", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new CidadeConsultaListenner(this);
	}

	@Override
	public List<Cidade> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

	    if(Utils.isNulaOuVazia(pesquisa)){
            return Banco.select(new Cidade());
        }

        return Banco.selectComPesquisa(new Cidade(), pesquisa);
	}
}
