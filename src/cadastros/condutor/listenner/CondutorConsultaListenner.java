package cadastros.condutor.listenner;


import cadastros.condutor.Condutor;
import cadastros.condutor.telas.CondutorCadastroTela;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import log.Logger;

public class CondutorConsultaListenner extends ConsultaListenner<Condutor> {

	public CondutorConsultaListenner(ConsultaTela<Condutor> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Condutor Listar");
        getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Condutor Item Selecionado");

		CondutorCadastroTela condutorCadastroTela = new CondutorCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(condutorCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Condutor Novo");

        CondutorCadastroTela condutorCadastroTela = new CondutorCadastroTela(null, getConsultaTela());

        abrirCadastro(condutorCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Condutor.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}