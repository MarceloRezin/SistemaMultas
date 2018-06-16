package cadastros.pessoa.consulta.tela;

import banco.Banco;
import cadastros.pessoa.Pessoa;
import cadastros.pessoa.consulta.listenner.PessoaConsultaListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.telas.TipoConsulta;
import commons.utils.Utils;
import exception.SistemaMultasException;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class PessoaConsultaTela extends ConsultaTela<Pessoa>{

	public PessoaConsultaTela(CadastroTela<Pessoa> cadastroTela, Pessoa objetoRetorno, JLabel campoRetorno) {
		super("Consulta de Pessoas", TipoConsulta.CADASTRO_PARA_CONSULTA, cadastroTela, objetoRetorno, campoRetorno);
		new PessoaConsultaListenner(this);
	}

	@Override
	public List<Pessoa> getItensBanco() throws SistemaMultasException {
	    String pesquisa = getCampoPesquisa().getText();

		if(!Utils.isNulaOuVazia(pesquisa)){
			return Banco.selectComWhere(new Pessoa(), "WHERE (upper(nome_razao_social) LIKE '%" + pesquisa.toUpperCase() + "%' OR cpf_cnpj LIKE '%" +pesquisa + "%')");
		}else{
			return Banco.selectComPesquisa(new Pessoa(), pesquisa);
		}
	}
}