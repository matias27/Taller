package probador;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		String pathIn = "04 – Muchas ubicaciones posibles.IN";
		String pathOut = "04 – Muchas ubicaciones posibles.OUT";
		
		Terreno terreno = new Terreno(pathIn);
		Casa casa = new Casa(pathIn, pathOut);
		
		System.out.println(terreno.comprobarUbicacion(casa));
	}

}
