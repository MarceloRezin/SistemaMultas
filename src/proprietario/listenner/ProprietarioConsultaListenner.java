package proprietario.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import proprietario.Proprietario;
import proprietario.telas.ProprietarioCadastroTela;

public class ProprietarioConsultaListenner extends ConsultaListenner<Proprietario>{

	public ProprietarioConsultaListenner(ConsultaTela<Proprietario> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Proprietário -> Listar");
	}

	@Override
	public void eventoNovo() {
		System.out.println("Proprietario -> Novo");
		getTela().dispose();
		ProprietarioCadastroTela proprietarioCadastroTela = new ProprietarioCadastroTela(null);
		getConsultaTela().getjDesktopPane().add(proprietarioCadastroTela);
		
		proprietarioCadastroTela.setVisible(true);
	}

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Proprietário -> Item Selecionado:" + getItemListSelecionado());
	}
}
