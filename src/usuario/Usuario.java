package usuario;

import commons.cadastros.Cadastro;

public class Usuario extends Cadastro{

    private String usuario;
    private String senha;
    private boolean admin = false;

    public Usuario(String usuario, String senha, boolean admin) {
        this.usuario = usuario;
        this.senha = senha;
        this.admin = admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

	@Override
	public String toString() {
		return getUsuario();
	}
}
