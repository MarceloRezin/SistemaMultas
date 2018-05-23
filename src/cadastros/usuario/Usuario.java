package cadastros.usuario;

import commons.cadastros.Cadastro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Cadastro{

    private String usuario;
    private String senha;
    private boolean admin = false;

    public Usuario() {}

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

    @Override
    public String getNomeTabela() {
        return "usuarios";
    }

    @Override
    public String getColunas() {
        return "nome_usuario,senha,`admin`";
    }

    @Override
    public void setStatements(PreparedStatement stmt) throws SQLException {
        stmt.setString(1,getUsuario());
        stmt.setString(2,getSenha());
        stmt.setBoolean(3,isAdmin());
    }

    @Override
    public List resultSetToList(ResultSet rs) throws SQLException{
        List<Cadastro> usuarios = new ArrayList<>();

        while (rs.next()){
            Usuario a = new Usuario();

            a.setId(rs.getInt("id"));
            a.setUsuario(rs.getString("nome_usuario"));
            a.setSenha(rs.getString("senha"));
            a.setAdmin(rs.getBoolean("admin"));

            usuarios.add(a);
        }
        return usuarios;
    }

    @Override
    public String getColunaOrdenacao() {
        return null;
    }
}
