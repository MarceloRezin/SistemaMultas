package cadastros.usuario.telas;

import javax.swing.*;

import cadastros.usuario.Usuario;
import cadastros.usuario.listenner.UsuarioCadastroListenner;
import commons.telas.CadastroTela;
import commons.telas.ConsultaTela;
import commons.utils.Utils;
import exception.SistemaMultasException;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UsuarioCadastroTela extends CadastroTela<Usuario> {

    private JPanel contentPane;
    private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JPasswordField campoConfirmarSenha;
	private JCheckBox checkAdmin;

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnVoltar;

    public UsuarioCadastroTela(Usuario objeto, ConsultaTela<Usuario> consultaTela) {
        super("Usuário", objeto, consultaTela);
    }

    @Override
    public Usuario telaToObjeto() throws SistemaMultasException {
        Usuario usuario = getObjeto();

        if(usuario == null){
            usuario = new Usuario();
        }

        String nomeUsuario = campoUsuario.getText();
        if(Utils.isNulaOuVazia(nomeUsuario)){
            throw  new SistemaMultasException("Você não informou o usuário");
        }
        usuario.setUsuario(nomeUsuario);

        String senha = campoSenha.getText();
        if(Utils.isNulaOuVazia(senha)){
            throw  new SistemaMultasException("Você não informou a senha");
        }

        String confirmacaoSenha = campoConfirmarSenha.getText();
        if(Utils.isNulaOuVazia(confirmacaoSenha)){
            throw  new SistemaMultasException("Você não confirmou a senha");
        }

        if(!senha.equals(confirmacaoSenha)){
            throw  new SistemaMultasException("A senha informada é diferente da confirmação!");
        }

        usuario.setSenha(senha);
        usuario.setAdmin(checkAdmin.isSelected());

        return usuario;
    }

    @Override
    public void objetoToTela() {
        Usuario usuario = getObjeto();

        if(usuario != null){
            campoUsuario.setText(usuario.getUsuario());
            campoSenha.setText(usuario.getSenha());
            checkAdmin.setSelected(usuario.isAdmin());
        }
    }

    @Override
    public void initComponentes() {
		setBounds(100, 100, 500, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblCadastroDePessoas = new JLabel("Cadastro de Usuários");
        contentPane.add(lblCadastroDePessoas, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblUsurio);
		
		campoUsuario = new JTextField();
		panelCentro.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblSenha);
		
		campoSenha = new JPasswordField();
		panelCentro.add(campoSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblConfirmarSenha);
		
		campoConfirmarSenha = new JPasswordField();
		panelCentro.add(campoConfirmarSenha);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentro.add(lblAdmin);
		
		checkAdmin = new JCheckBox("");
		panelCentro.add(checkAdmin);
		
		JPanel painelSul = new JPanel();
		getContentPane().add(painelSul, BorderLayout.SOUTH);
		painelSul.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnSalvar = new JButton("Salvar");
		painelSul.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		painelSul.add(btnExcluir);
		
		btnVoltar = new JButton("Voltar");
		painelSul.add(btnVoltar);
		
		new UsuarioCadastroListenner(this);
	}

    @Override
    public void resetCampos() {
        campoUsuario.setText("");
        campoSenha.setText("");
        campoConfirmarSenha.setText("");
        checkAdmin.setSelected(false);
    }

    @Override
    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    @Override
    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    @Override
    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
