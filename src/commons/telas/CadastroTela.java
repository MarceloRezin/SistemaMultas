package commons.telas;

import commons.cadastros.Cadastro;

import javax.swing.*;

public abstract class CadastroTela<T extends Cadastro> extends JInternalFrame{
    private T objeto;
    private ConsultaTela<T> consultaTela;

    public CadastroTela(String titulo, T objeto, ConsultaTela<T> consultaTela){
        super(titulo, false, true, true, false);
        this.objeto = objeto;
        this.consultaTela = consultaTela;

        initComponentes();

        objetoToTela();
    }

    public T getObjeto() {
        return objeto;
    }

    public ConsultaTela<T> getConsultaTela() {
        return consultaTela;
    }

    /**
     * Transforma os campos da tela no objeto do cadastro, aqui devem ser feita as validações
     */
    public abstract T telaToObjeto();

    /**
     * Transforma o objeto nos campos da tela
     */
    public abstract void objetoToTela();

    public abstract void initComponentes();

    public abstract  JButton getBtnSalvar();
    public abstract  JButton getBtnExcluir();
    public abstract  JButton getBtnVoltar();
}
