package cadastros.infracao.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.infracao.Infracao;
import cadastros.infracao.telas.InfracaoCadastroTela;
import log.Logger;

public class InfracaoConsultaListenner extends ConsultaListenner<Infracao> {
	
	public InfracaoConsultaListenner(ConsultaTela<Infracao> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Infração Listar");
        getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoNovo() {
        Logger.log("Infração Novo");

        InfracaoCadastroTela infracaoCadastroTela = new InfracaoCadastroTela(null, getConsultaTela());

        abrirCadastro(infracaoCadastroTela);
	}

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Infração Item Selecionado");

        InfracaoCadastroTela infracaoCadastroTela = new InfracaoCadastroTela(getItemListSelecionado(), getConsultaTela());

        abrirCadastro(infracaoCadastroTela);
	}

    @Override
    public void setObjetoRetorno() {
        Infracao.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
    }
}
