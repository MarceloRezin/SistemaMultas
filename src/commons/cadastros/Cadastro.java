package commons.cadastros;

public abstract class Cadastro {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public abstract String toString();
}
