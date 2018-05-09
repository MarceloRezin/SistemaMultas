package gravidademulta.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import gravidademulta.GravidadeMulta;
import gravidademulta.telas.GravidadeMultaCadastroTela;

public class GravidadeMultaConsultaListenner extends ConsultaListenner<GravidadeMulta> {

	public GravidadeMultaConsultaListenner(ConsultaTela<GravidadeMulta> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        System.out.println("Gravidade Multa -> Listar");
    }

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Gravidade Multa -> Item Selecionado:" + getItemListSelecionado());

		GravidadeMultaCadastroTela gravidadeMultaCadastroTela = new GravidadeMultaCadastroTela("Gravidade Multa", getItemListSelecionado(), getConsultaTela());

		abrirCadastro(gravidadeMultaCadastroTela);
	}

	@Override
	public void eventoNovo() {
		System.out.println("Gravidade Multa -> Novo");

		GravidadeMultaCadastroTela gravidadeMultaCadastroTela = new GravidadeMultaCadastroTela("Gravidade Multa", null, getConsultaTela());
		
		abrirCadastro(gravidadeMultaCadastroTela);
	}
}
