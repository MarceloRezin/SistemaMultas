package cadastros.gravidademulta.listenner;

import banco.Banco;
import cadastros.gravidademulta.telas.GravidadeMultaCadastroTela;
import commons.utils.Utils;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import exception.SistemaMultasException;
import cadastros.gravidademulta.GravidadeMulta;
import log.Logger;

import java.util.List;

public class GravidadeMultaConsultaListenner extends ConsultaListenner<GravidadeMulta> {

	public GravidadeMultaConsultaListenner(ConsultaTela<GravidadeMulta> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Gravidade Multa Listar");
        String pesquisa = getConsultaTela().getCampoPesquisa().getText();

        List<GravidadeMulta> gravidadeMultas;

        try {
			if(!Utils.isNulaOuVazia(pesquisa)){
				gravidadeMultas = Banco.selectComPesquisa(new GravidadeMulta(), pesquisa);
			}else{
				gravidadeMultas = Banco.select(new GravidadeMulta());
			}

			getConsultaTela().listarTodosItens(gravidadeMultas);
		}catch (SistemaMultasException e){
        	Utils.mensagemErro(e.getMessage());
		}
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Gravidade Multa Item Selecionado");

		GravidadeMultaCadastroTela gravidadeMultaCadastroTela = new GravidadeMultaCadastroTela("Gravidade Multa", getItemListSelecionado(), getConsultaTela());

		abrirCadastro(gravidadeMultaCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Gravidade Multa Novo");

		GravidadeMultaCadastroTela gravidadeMultaCadastroTela = new GravidadeMultaCadastroTela("Gravidade Multa", null, getConsultaTela());
		
		abrirCadastro(gravidadeMultaCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		GravidadeMulta.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}
