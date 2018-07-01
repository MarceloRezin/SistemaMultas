package cadastros.proprietario.telas;

import java.util.List;
import javax.swing.*;

import banco.Banco;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import cadastros.proprietario.Proprietario;
import cadastros.proprietario.listenner.ProprietarioConsultaListenner;
import commons.utils.Utils;
import exception.SistemaMultasException;

@SuppressWarnings("serial")
public class ProprietarioConsultaTela extends ConsultaTela<Proprietario> {

	public ProprietarioConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Listagem cadastros.proprietario", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new ProprietarioConsultaListenner(this);
	}

	public ProprietarioConsultaTela(CadastroTela<Proprietario> cadastroTela, Proprietario objetoRetorno, JLabel campoRetorno) {
		super("Consulta de Cidades", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
		new ProprietarioConsultaListenner(this);
	}

	@Override
	public List<Proprietario> getItensBanco() throws SistemaMultasException {
		String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComWhere(new Proprietario(), "INNER JOIN pessoas p ON proprietarios.pessoa_id = p.id AND (upper(p.nome_razao_social) LIKE '%" + pesquisa.toUpperCase() + "%' OR p.cpf_cnpj LIKE '%" +pesquisa + "%')");
		}else{
			return Banco.selectComPesquisa(new Proprietario(), "");
		}
	}
}
