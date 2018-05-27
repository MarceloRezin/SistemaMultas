package cadastros.pessoa.fisica.telas;

import banco.Banco;
import cadastros.pessoa.Pessoa;
import cadastros.pessoa.TipoPessoa;
import cadastros.pessoa.fisica.listenner.PessoaFisicaConsultaListenner;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class PessoaFisicaConsultaTela extends ConsultaTela<Pessoa>{

	public PessoaFisicaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Pessoas Físicas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new PessoaFisicaConsultaListenner(this);
	}

	@Override
	public List<Pessoa> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComWhere(new Pessoa(), "WHERE (upper(nome_razao_social) LIKE '%" + pesquisa.toUpperCase() + "%' OR cpf_cnpj LIKE '%" +pesquisa + "%') AND tipo_pessoa = '" + TipoPessoa.PESSOA_FISICA + "'");
		}else{
			return Banco.selectComWhere(new Pessoa(), "WHERE tipo_pessoa = '" + TipoPessoa.PESSOA_FISICA + "'");
		}
	}
}