package infracao.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import infracao.Infracao;

public class InfracaoConsultaListenner extends ConsultaListenner<Infracao> {
	
   
	public InfracaoConsultaListenner(ConsultaTela<Infracao> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Infracao -> Listar");
    }

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Infracao -> Item Selecionado:" + getItemListSelecionado());
	}
}
