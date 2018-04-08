package veiculo.listenner;

import javax.swing.*;

import commons.listenners.ConsultaListenner;

public class VeiculoConsultaListenner extends ConsultaListenner {


    public VeiculoConsultaListenner(JDesktopPane jDesktopPane, JInternalFrame telaConsulta, JInternalFrame telaCadastro,
			JButton consultar, JButton novo, JList<Object> list) {
		super(jDesktopPane, telaConsulta, telaCadastro, consultar, novo, list);
	}

	@Override
    public void eventoConsultar() {
        System.out.println("Veículo -> Listar");
    }
}
