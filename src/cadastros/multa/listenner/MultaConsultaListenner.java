package cadastros.multa.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.multa.Multa;
import cadastros.multa.telas.MultaCadastroTela;

public class MultaConsultaListenner extends ConsultaListenner<Multa> {

	public MultaConsultaListenner(ConsultaTela<Multa> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Multa -> Listar");
    }

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Multa -> Item Selecionado:" + getItemListSelecionado());
	}

	@Override
	public void eventoNovo() {
		System.out.println("Multa -> Novo");
		getTela().dispose();
		MultaCadastroTela multaCadastroTela = new MultaCadastroTela(null);
		getConsultaTela().getjDesktopPane().add(multaCadastroTela);
		
		multaCadastroTela.setVisible(true);
	}
}
