package cadastros.orgao.telas;

import java.util.List;
import javax.swing.*;

import banco.Banco;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import cadastros.orgao.Orgao;
import cadastros.orgao.listenner.OrgaoConsultaListenner;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class OrgaoConsultaTela extends ConsultaTela<Orgao> {

	public OrgaoConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem de Orgãos", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new OrgaoConsultaListenner(this);
	}

    public OrgaoConsultaTela(CadastroTela<Orgao> cadastroTela, Orgao objetoRetorno, JLabel campoRetorno) {
        super("Listagem de Orgãos", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
        new OrgaoConsultaListenner(this);
    }

    @Override
	public List<Orgao> getItensBanco() throws SistemaMultasException {
		String pesquisa = getCampoPesquisa().getText();

		if(Utils.isNulaOuVazia(pesquisa)){
		    return Banco.select(new Orgao());
        }
		return Banco.selectComPesquisa(new Orgao(), pesquisa);
	}
}