package cadastros.multa.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.multa.Multa;
import cadastros.multa.telas.MultaCadastroTela;
import log.Logger;

public class MultaConsultaListenner extends ConsultaListenner<Multa> {

	public MultaConsultaListenner(ConsultaTela<Multa> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
		Logger.log("Multa Listar");
		getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoItemSelecionado() {
		Logger.log("Multa Item Selecionado");

		MultaCadastroTela multaCadastroTela = new MultaCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(multaCadastroTela);
	}

	@Override
	public void eventoNovo() {
		Logger.log("Multa Novo");
		getTela().dispose();
		MultaCadastroTela multaCadastroTela = new MultaCadastroTela(null, getConsultaTela());
		getConsultaTela().getjDesktopPane().add(multaCadastroTela);

		multaCadastroTela.setVisible(true);
	}
}
