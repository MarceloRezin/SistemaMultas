package cadastros.pessoa.consulta.listenner;


import cadastros.pessoa.Pessoa;
import cadastros.pessoa.juridica.telas.PessoaJuridicaCadastroTela;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import log.Logger;

public class PessoaConsultaListenner extends ConsultaListenner<Pessoa> {

	public PessoaConsultaListenner(ConsultaTela<Pessoa> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Pessoa Listar");
        getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Pessoa Item Selecionado");

        PessoaJuridicaCadastroTela pessoaJuridicaCadastroTela = new PessoaJuridicaCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(pessoaJuridicaCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Pessoa Novo");

        PessoaJuridicaCadastroTela pessoaJuridicaCadastroTela = new PessoaJuridicaCadastroTela(null, getConsultaTela());

        abrirCadastro(pessoaJuridicaCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Pessoa.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}