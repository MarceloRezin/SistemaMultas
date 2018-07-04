package cadastros.infracao.telas;

import banco.Banco;
import commons.telas.CadastroTela;
import commons.telas.TipoConsulta;
import cadastros.infracao.Infracao;
import cadastros.infracao.listenner.InfracaoConsultaListenner;
import java.util.List;
import javax.swing.*;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class InfracaoConsultaTela extends ConsultaTela<Infracao>{
	
	public InfracaoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Infrações", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new InfracaoConsultaListenner(this);
	}

    public InfracaoConsultaTela(CadastroTela<Infracao> cadastroTela, Infracao objetoRetorno, JLabel campoRetorno) {
        super("Consulta de Infrações", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
        new InfracaoConsultaListenner(this);
    }

    @Override
	public List<Infracao> getItensBanco() throws SistemaMultasException {
		String pesquisa = getCampoPesquisa().getText();

		if(Utils.isNulaOuVazia(pesquisa)){
		    return Banco.select(new Infracao());
        }

		return Banco.selectComPesquisa(new Infracao(), pesquisa);
	}
}
