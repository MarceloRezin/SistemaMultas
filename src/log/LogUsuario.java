package log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LogUsuario {

	private static final String diretorio = "cadastros.usuario.dat";

	public void SalvarUsuario(String usuario) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(diretorio);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(usuario);       
        oos.flush();
        oos.close();
	}
	
	public String LerUsuario() throws IOException, ClassNotFoundException {
		File file = new File(diretorio);
		String usuario;
				if(!file.exists()){
					new File(diretorio).createNewFile();
					usuario = new String();
					SalvarUsuario(usuario); //Garante que o arquivo em disco é legivel
					return usuario;
	        }
		
		FileInputStream fis = new FileInputStream(diretorio);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object objeto = ois.readObject();
		fis.close();
		return (String)objeto;
	}

}

