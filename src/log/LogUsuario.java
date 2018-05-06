package log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LogUsuario {
	
	public void SalvarUsuario(String usuario) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("src/log/Usuario.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(usuario);       
        oos.flush();
        oos.close();
	}
	
	public String LerUsuario() throws IOException, ClassNotFoundException {
		File file = new File("src/log/Usuario.dat");
		String usuario;
				if(!file.exists()){
					new File("src/log/Usuario.dat").createNewFile();
					usuario = new String();
					SalvarUsuario(usuario); //Garante que o arquivo em disco é legivel
					return usuario;
	        }
		
		FileInputStream fis = new FileInputStream("src/log/Usuario.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object objeto = ois.readObject();
		fis.close();
		return (String)objeto;
	}

}

