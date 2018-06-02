package cadastros.pessoa.fisica.listenner;

import banco.Banco;
import cadastros.pessoa.Pessoa;
import cadastros.pessoa.TipoPessoa;
import cadastros.pessoa.fisica.telas.PessoaFisicaCadastroTela;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;
import log.Logger;

import java.util.List;

public class PessoaFisicaConsultaListenner extends ConsultaListenner<Pessoa> {

	public PessoaFisicaConsultaListenner(ConsultaTela<Pessoa> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Pessoa Física Listar");
        String pesquisa = getConsultaTela().getCampoPesquisa().getText();

        List<Pessoa> pessoas;

        try {
			if(!Utils.isNulaOuVazia(pesquisa)){
				pessoas = Banco.selectComWhere(new Pessoa(), "WHERE (upper(nome_razao_social) LIKE '%" + pesquisa.toUpperCase() + "%' OR cpf_cnpj LIKE '%" +pesquisa + "%') AND tipo_pessoa = '" + TipoPessoa.PESSOA_FISICA + "'");
			}else{
				pessoas = Banco.selectComWhere(new Pessoa(), "WHERE tipo_pessoa = '" + TipoPessoa.PESSOA_FISICA + "'");
			}

			getConsultaTela().listarTodosItens(pessoas);
		}catch (SistemaMultasException e){
        	Utils.mensagemErro(e.getMessage());
		}
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Pessoa Física Item Selecionado");

        PessoaFisicaCadastroTela pessoaFisicaCadastroTela = new PessoaFisicaCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(pessoaFisicaCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Pessoa Física Novo");

        PessoaFisicaCadastroTela pessoaFisicaCadastroTela = new PessoaFisicaCadastroTela(null, getConsultaTela());

        abrirCadastro(pessoaFisicaCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Pessoa.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}