package cadastros.cidade.listenner;

import banco.Banco;
import cadastros.cidade.Cidade;
import cadastros.cidade.telas.CidadeCadastroTela;
import commons.utils.Utils;
import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import exception.SistemaMultasException;
import log.Logger;

import java.util.List;

public class CidadeConsultaListenner extends ConsultaListenner<Cidade> {

	public CidadeConsultaListenner(ConsultaTela<Cidade> consultaTela) {
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

		CidadeCadastroTela cidadeCadastroTela = new CidadeCadastroTela("Cidade", getItemListSelecionado(), getConsultaTela());

		abrirCadastro(cidadeCadastroTela);
	}

	@Override
	public void eventoNovo() {
        Logger.log("Cidade Nova");

		CidadeCadastroTela cidadeCadastroTela = new CidadeCadastroTela("Cidade", null, getConsultaTela());
		
		abrirCadastro(cidadeCadastroTela);
	}
}
