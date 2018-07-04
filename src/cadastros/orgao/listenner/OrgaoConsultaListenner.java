package cadastros.orgao.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.orgao.Orgao;
import cadastros.orgao.telas.OrgaoCadastroTela;
import log.Logger;

public class OrgaoConsultaListenner extends ConsultaListenner<Orgao> {

	public OrgaoConsultaListenner(ConsultaTela<Orgao> consultaTela) {
		super(consultaTela);
	}

	@Override
	public void eventoConsultar() {
		Logger.log("Orgão Listar");
		getConsultaTela().listarTodosItens();
	}

	@Override
	public void eventoNovo() {
		Logger.log("Orgão Novo");

		OrgaoCadastroTela orgaoCadastroTela = new OrgaoCadastroTela(null, getConsultaTela());

		abrirCadastro(orgaoCadastroTela);
	}

	@Override
	public void eventoItemSelecionado() {
		Logger.log("Orgão Item Selecionado");

		OrgaoCadastroTela orgaoCadastroTela = new OrgaoCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(orgaoCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Orgao.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}
