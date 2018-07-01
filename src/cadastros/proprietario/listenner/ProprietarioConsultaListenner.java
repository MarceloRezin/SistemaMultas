package cadastros.proprietario.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.proprietario.Proprietario;
import cadastros.proprietario.telas.ProprietarioCadastroTela;
import log.Logger;

public class ProprietarioConsultaListenner extends ConsultaListenner<Proprietario>{

	public ProprietarioConsultaListenner(ConsultaTela<Proprietario> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
		Logger.log("Proprietário Listar");
		getConsultaTela().listarTodosItens();
	}

	@Override
	public void eventoNovo() {
		Logger.log("Proprietário Novo");
		getTela().dispose();
		ProprietarioCadastroTela proprietarioCadastroTela = new ProprietarioCadastroTela(null, getConsultaTela());
		getConsultaTela().getjDesktopPane().add(proprietarioCadastroTela);
		
		proprietarioCadastroTela.setVisible(true);
	}

	@Override
	public void eventoItemSelecionado() {
		Logger.log("Proprietário Item Selecionado");

        ProprietarioCadastroTela proprietarioCadastroTela = new ProprietarioCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(proprietarioCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Proprietario.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}
