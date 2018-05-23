package cadastros.veiculo.listenner;

import commons.listenners.ConsultaListenner;
import commons.telas.ConsultaTela;
import cadastros.veiculo.Veiculo;
import cadastros.veiculo.telas.VeiculoCadastroTela;

public class VeiculoConsultaListenner extends ConsultaListenner<Veiculo> {

	public VeiculoConsultaListenner(ConsultaTela<Veiculo> consultaTela) {
		super(consultaTela);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Veículo -> Listar");
    }

	@Override
	public void eventoNovo() {
		System.out.println("Multa -> Novo");
		getTela().dispose();
		VeiculoCadastroTela veiculoTelaCadastro = new VeiculoCadastroTela(null);
		getConsultaTela().getjDesktopPane().add(veiculoTelaCadastro);
		
		veiculoTelaCadastro.setVisible(true);
		
	}

	@Override
	public void eventoItemSelecionado() {
		System.out.println("Veiculo -> Item Selecionado:" + getItemListSelecionado());
	}
}
