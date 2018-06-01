package cadastros.pessoa.juridica.telas;

import banco.Banco;
import cadastros.pessoa.Pessoa;
import cadastros.pessoa.TipoPessoa;
import cadastros.pessoa.juridica.listenner.PessoaJuridicaConsultaListenner;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class PessoaJuridicaConsultaTela extends ConsultaTela<Pessoa>{

	public PessoaJuridicaConsultaTela(JDesktopPane jDesktopPane) {
		super(jDesktopPane, "Consulta de Pessoas Jurídicas", TipoConsulta.CONSULTA_PARA_CADASTRO);
		new PessoaJuridicaConsultaListenner(this);
	}

	@Override
	public List<Pessoa> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComWhere(new Pessoa(), "WHERE (upper(nome_razao_social) LIKE '%" + pesquisa.toUpperCase() + "%' OR cpf_cnpj LIKE '%" +pesquisa + "%') AND tipo_pessoa = '" + TipoPessoa.PESSOA_JURIDICA + "'");
		}else{
			return Banco.selectComWhere(new Pessoa(), "WHERE tipo_pessoa = '" + TipoPessoa.PESSOA_JURIDICA + "'");
		}
	}
}