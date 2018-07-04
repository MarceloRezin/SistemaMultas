package cadastros.veiculo.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.veiculo.Veiculo;
import cadastros.veiculo.telas.VeiculoCadastroTela;
import log.Logger;

public class VeiculoConsultaListenner extends ConsultaListenner<Veiculo> {

	public VeiculoConsultaListenner(ConsultaTela<Veiculo> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
		Logger.log("Veículo Listar");
		getConsultaTela().listarTodosItens();
    }

	@Override
	public void eventoNovo() {
		Logger.log("Veículo Novo");
		getTela().dispose();
		VeiculoCadastroTela veiculoTelaCadastro = new VeiculoCadastroTela(null, getConsultaTela());
		getConsultaTela().getjDesktopPane().add(veiculoTelaCadastro);
		
		veiculoTelaCadastro.setVisible(true);
	}

	@Override
	public void eventoItemSelecionado() {
		Logger.log("Veículo Item Selecionado");

		VeiculoCadastroTela veiculoCadastroTela = new VeiculoCadastroTela(getItemListSelecionado(), getConsultaTela());

		abrirCadastro(veiculoCadastroTela);
	}

	@Override
	public void setObjetoRetorno() {
		Veiculo.mesclar(getItemListSelecionado(), getConsultaTela().getObjetoRetorno());
	}
}
