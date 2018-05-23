package infracao.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import infracao.Infracao;
import infracao.telas.InfracaoCadastroTela;

public class CidadeConsultaListenner extends ConsultaListenner<Cidade> {
	
	public CidadeConsultaListenner(ConsultaTela<Cidade> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        System.out.println("Cidade -> Listar");
    }

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Cidade -> Item Selecionado:" + getItemListSelecionado());
	}



	@Override
	public void eventoNovo() {
		System.out.println("Cidade -> Novo");
		
		getTela().dispose();
		
		CidadeCadastroTela telaCadastroInfracao = new InfracaoCadastroTela(null);
		
		getConsultaTela().getjDesktopPane().add(telaCadastroCidade);
		
		telaCadastroCidade.setVisible(true);
	}
}
