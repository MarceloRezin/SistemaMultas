package usuario.telas;

import javax.swing.JInternalFrame;

import usuario.Usuario;
import usuario.listenner.UsuarioCadastroListenner;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class UsuarioCadastroTela extends JInternalFrame {
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JPasswordField campoConfirmarSenha;

	public UsuarioCadastroTela(Usuario item) {
		super("Cadastro de Usuário", false, true, true, false);
		setBounds(100, 100, 407, 417);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblCacastroDeUsurio = new JLabel("Cacastro de Usuário");
		getContentPane().add(lblCacastroDeUsurio, BorderLayout.NORTH);
		
		JPanel painelCentro = new JPanel();
		getContentPane().add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblUsurio = new JLabel("Usuário");
		painelCentro.add(lblUsurio);
		
		campoUsuario = new JTextField();
		painelCentro.add(campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		painelCentro.add(lblSenha);
		
		campoSenha = new JPasswordField();
		painelCentro.add(campoSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		painelCentro.add(lblConfirmarSenha);
		
		campoConfirmarSenha = new JPasswordField();
		painelCentro.add(campoConfirmarSenha);
		
		JLabel lblAdmin = new JLabel("Admin");
		painelCentro.add(lblAdmin);
		
		JCheckBox checkAdmin = new JCheckBox("");
		painelCentro.add(checkAdmin);
		
		JPanel painelSul = new JPanel();
		getContentPane().add(painelSul, BorderLayout.SOUTH);
		painelSul.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSalvar = new JButton("Salvar");
		painelSul.add(btnSalvar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		painelSul.add(horizontalStrut);
		
		JButton btnExcluir = new JButton("Excluir");
		painelSul.add(btnExcluir);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		painelSul.add(horizontalStrut_1);
		
		JButton btnVoltar = new JButton("Voltar");
		painelSul.add(btnVoltar);
		
		new UsuarioCadastroListenner(null);
	}

}
