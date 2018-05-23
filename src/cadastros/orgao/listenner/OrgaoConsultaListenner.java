package cadastros.orgao.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.orgao.Orgao;
import cadastros.orgao.telas.OrgaoCadastroTela;

public class OrgaoConsultaListenner extends ConsultaListenner<Orgao> {

	public OrgaoConsultaListenner(ConsultaTela<Orgao> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Orgão -> Listar");
    }

	@Override
	public void eventoNovo() {
		System.out.println("Orgao -> Novo");
		getTela().dispose();
		OrgaoCadastroTela orgaoCadastroTela = new OrgaoCadastroTela(null);
		getConsultaTela().getjDesktopPane().add(orgaoCadastroTela);
		
		orgaoCadastroTela.setVisible(true);
	}

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Orgao -> Item Selecionado:" + getItemListSelecionado());
	}
}
