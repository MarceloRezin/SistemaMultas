package gravidademulta.listenner;

import banco.Banco;
import commons.Utils;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import gravidademulta.GravidadeMulta;
import gravidademulta.telas.GravidadeMultaCadastroTela;

import java.util.List;

public class GravidadeMultaConsultaListenner extends ConsultaListenner<GravidadeMulta> {

	public GravidadeMultaConsultaListenner(ConsultaTela<GravidadeMulta> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        System.out.println("Gravidade Multa -> Listar");

        String pesquisa = getConsultaTela().getCampoPesquisa().getText();

        List<GravidadeMulta> gravidadeMultas;

        if(!Utils.isNulaOuVazia(pesquisa)){
            gravidadeMultas = Banco.selectComWhere(new GravidadeMulta(), "WHERE tipo LIKE '%" + pesquisa + "%'");
        }else{
            gravidadeMultas = Banco.select(new GravidadeMulta());
        }

        getConsultaTela().listarTodosItens(gravidadeMultas);
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
