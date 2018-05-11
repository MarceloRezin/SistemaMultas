package usuario.login;

import banco.Banco;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import log.LogUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.TextField;
import java.io.IOException;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;

@SuppressWarnings("serial")
public class UsuarioLoginTela extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario;
	private JPasswordField campoSenha;
	private JButton btnEntrar;
	private LogUsuario log = new LogUsuario();


	public UsuarioLoginTela() {
		setTitle("Gerenciador de Multas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Gerenciador de Multas - Login");
		panelTitulo.add(lblTitulo);
		
		JPanel panelEspaco = new JPanel();
		panelTitulo.add(panelEspaco, BorderLayout.WEST);
		
		Component espaco = Box.createHorizontalStrut(20);
		panelEspaco.add(espaco);
		
		Component espaco1 = Box.createHorizontalStrut(20);
		panelEspaco.add(espaco1);
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new GridLayout(6, 1, 0, 0));
		
		JLabel lblUsurio = new JLabel("Usuário:");
		panelPrincipal.add(lblUsurio);
		
		campoUsuario = new JTextField();
		panelPrincipal.add(campoUsuario);
		campoUsuario.setColumns(10);
		try {
			campoUsuario.setText(log.LerUsuario());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblSenha = new JLabel("Senha:");
		panelPrincipal.add(lblSenha);
		
		campoSenha = new JPasswordField();
		panelPrincipal.add(campoSenha);
		
		Component espaco2 = Box.createHorizontalStrut(20);
		contentPane.add(espaco2, BorderLayout.WEST);
		
		JPanel panelEspacoSul = new JPanel();
		contentPane.add(panelEspacoSul, BorderLayout.SOUTH);
		panelEspacoSul.setLayout(new BorderLayout(0, 0));
		
		btnEntrar = new JButton("Entrar");
		panelEspacoSul.add(btnEntrar, BorderLayout.CENTER);
		
		Component espaco3 = Box.createHorizontalStrut(20);
		panelEspacoSul.add(espaco3, BorderLayout.EAST);
		
		Component espaco4 = Box.createHorizontalStrut(20);
		panelEspacoSul.add(espaco4, BorderLayout.WEST);
		
		Component espaco5 = Box.createHorizontalStrut(20);
		contentPane.add(espaco5, BorderLayout.EAST);

		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Banco.fecharConexao();
                super.windowClosing(e);
            }
        });
		
		new UsuarioLoginListenner(btnEntrar, this);
	}
	
	public JTextField getCampoUsuario() {
		
		return campoUsuario;
	}
	
	public void setCampoUsuario(JTextField campoUsuario){
	
		this.campoUsuario = campoUsuario;
	}
}
