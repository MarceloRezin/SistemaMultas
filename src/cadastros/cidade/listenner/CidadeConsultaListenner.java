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

	public GravidadeMultaConsultaListenner(ConsultaTela<Cidade> consultaTela) {
		super(consultaTela);
	}
	
	@Override
    public void eventoConsultar() {
        Logger.log("Cidade Listar");
        String pesquisa = getConsultaTela().getCampoPesquisa().getText();

        List<Cidade> cidades;

        try {
			if(!Utils.isNulaOuVazia(pesquisa)){
				cidades = Banco.selectComPesquisa(new Cidade(), pesquisa);
			}else{
				cidades = Banco.select(new Cidade());
			}

			getConsultaTela().listarTodosItens(cidades);
		}catch (SistemaMultasException e){
        	Utils.mensagemErro(e.getMessage());
		}
    }

	@Override
	public void eventoItemSelecionado() {
        Logger.log("Cidade Selecionada");

		GravidadeMultaCadastroTela gravidadeMultaCadastroTela = new GravidadeMultaCadastroTela("Gravidade Multa", getItemListSelecionado(), getConsultaTela());

		abrirCadastro(gravidadeMultaCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Cidade Nova");

		CidadeCadastroTela cidadeaCadastroTela = new CidadeCadastroTela("Cidade", null, getConsultaTela());
		
		abrirCadastro(cidadeaCadastroTela);
	}
}
