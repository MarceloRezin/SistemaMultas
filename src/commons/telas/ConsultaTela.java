package commons.telas;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import commons.cadastros.Cadastro;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

@SuppressWarnings("serial")
public abstract class ConsultaTela<T extends Cadastro> extends JInternalFrame {

    private List<T> itens;
    private DefaultListModel<T> model = new DefaultListModel<>();
    private JButton btnConsulta;
    private JButton btnNovo;
    private JList<T> list;
    private JTextField campoPesquisa;
    private JDesktopPane jDesktopPane;
    private TipoConsulta tipoConsulta;
    private T objetoRetorno;
    private JLabel campoRetorno;
    private CadastroTela<T> cadastroTela;

    public ConsultaTela(JDesktopPane jDesktopPane, String titulo, TipoConsulta tipoConsulta) {
        this.jDesktopPane = jDesktopPane;
        this.tipoConsulta = tipoConsulta;

        initComponentes(titulo);
    }

    public ConsultaTela(String titulo, TipoConsulta tipoConsulta, CadastroTela<T> cadastroTela, T objetoRetorno, JLabel campoRetorno) {
        this.tipoConsulta = tipoConsulta;
        this.objetoRetorno = objetoRetorno;
        this.campoRetorno = campoRetorno;
        this.cadastroTela = cadastroTela;

        getCadastroTela().setVisible(false);

        initComponentes(titulo);
    }

    private void initComponentes(String titulo){
        setClosable(true);
        setTitle(titulo);
        setResizable(true);
        setBounds(100, 100, 392, 423);

        JPanel panelNorte = new JPanel();
        getContentPane().add(panelNorte, BorderLayout.NORTH);
        panelNorte.setLayout(new BorderLayout(0, 0));

        campoPesquisa = new JTextField();
        panelNorte.add(campoPesquisa, BorderLayout.CENTER);
        campoPesquisa.setColumns(10);

        JPanel panelNorteLeste = new JPanel();
        panelNorte.add(panelNorteLeste, BorderLayout.EAST);
        panelNorteLeste.setLayout(new GridLayout(1, 0, 0, 0));

        btnConsulta = new JButton("");
        btnConsulta.setIcon(new ImageIcon(ConsultaTela.class.getResource("/imagens/pesquisar.png")));
        panelNorteLeste.add(btnConsulta);

        if(tipoConsulta == TipoConsulta.CONSULTA_PARA_CADASTRO){
            btnNovo = new JButton("Novo");
            panelNorteLeste.add(btnNovo);
        }

        JPanel panelCentro = new JPanel();
        getContentPane().add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(new BorderLayout(0, 0));

        list = new JList<T>(model);
        panelCentro.add(list);

        getRootPane().setDefaultButton(btnConsulta);

        addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
                if(tipoConsulta == TipoConsulta.CADASTRO_PARA_CONSULTA){
                    getCadastroTela().setVisible(true);
                }
            }
        });

        listarTodosItens();
    }

    private void adiconarItens() {
        if(itens == null || itens.isEmpty()){
            Utils.mensagem("Nada encontrado", "Não foram encontrados itens!");
        }

        if(itens != null) {
            model.removeAllElements();

            itens.forEach( i -> {
                model.add(model.getSize(), i);
            });
        }
    }

    public void listarTodosItens(List<T> novosItens){
        this.itens = novosItens;
        adiconarItens();
    }

    public void listarTodosItens(){
        try {
            this.itens = getItensBanco();
            adiconarItens();
        } catch (SistemaMultasException e) {
            Utils.mensagemErro(e.getMessage());
        }
    }

    public List<T> getItens() {
        return itens;
    }

    public DefaultListModel<T> getModel() {
        return model;
    }

    public JButton getBtnConsulta() {
        return btnConsulta;
    }

    public JButton getBtnNovo() {
        return btnNovo;
    }

    public JList<T> getList() {
        return list;
    }

    public JTextField getCampoPesquisa() {
        return campoPesquisa;
    }

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public T getObjetoRetorno() {
        return objetoRetorno;
    }

    public void setObjetoRetorno(T objetoRetorno) {
        this.objetoRetorno = objetoRetorno;
    }

    public JLabel getCampoRetorno() {
        return campoRetorno;
    }

    public void setCampoRetorno(JLabel campoRetorno) {
        this.campoRetorno = campoRetorno;
    }

    public CadastroTela<T> getCadastroTela() {
        return cadastroTela;
    }

    public abstract List<T> getItensBanco() throws SistemaMultasException;
}
