package cadastros.gravidademulta.telas;

import banco.Banco;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;
import cadastros.gravidademulta.GravidadeMulta;
import cadastros.gravidademulta.listenner.GravidadeMultaConsultaListenner;
import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class GravidadeMultaConsultaTela extends ConsultaTela<GravidadeMulta>{

	public GravidadeMultaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Gravidade de Multas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new GravidadeMultaConsultaListenner(this);
	}

	public GravidadeMultaConsultaTela(CadastroTela<GravidadeMulta> cadastroTela, GravidadeMulta objetoRetorno, JLabel campoRetorno) {
		super("Consulta de Gravidade de Multas", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
		new GravidadeMultaConsultaListenner(this);
	}

	@Override
	public List<GravidadeMulta> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

	    if(Utils.isNulaOuVazia(pesquisa)){
            return Banco.select(new GravidadeMulta());
        }

        return Banco.selectComPesquisa(new GravidadeMulta(), pesquisa);
	}
}
