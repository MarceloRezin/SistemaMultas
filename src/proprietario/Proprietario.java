package proprietario;

import commons.cadastros.Cadastro;
import commons.enuns.Estado;
import condutor.Condutor;
import pessoa.Pessoa;

public class Proprietario extends Cadastro{

    private Pessoa pessoa;
    private Condutor condutor;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    @Override
	public String toString() {
		return getPessoa().getNomeRazaoSocial() + " / " + getPessoa().getCpfCnpj();
	}
}
