package cadastros.pessoa.juridica.listenner;


import cadastros.pessoa.Pessoa;
import cadastros.pessoa.juridica.telas.PessoaJuridicaCadastroTela;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import log.Logger;

public class PessoaJuridicaConsultaListenner extends ConsultaListenner<Pessoa> {

	public PessoaJuridicaConsultaListenner(ConsultaTela<Pessoa> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Pessoa Jurídica Listar");
        getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Pessoa Jurídica Item Selecionado");

        PessoaJuridicaCadastroTela pessoaJuridicaCadastroTela = new PessoaJuridicaCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(pessoaJuridicaCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Pessoa Jurídica Novo");

        PessoaJuridicaCadastroTela pessoaJuridicaCadastroTela = new PessoaJuridicaCadastroTela(null, getConsultaTela());

        abrirCadastro(pessoaJuridicaCadastroTela);
	}
}