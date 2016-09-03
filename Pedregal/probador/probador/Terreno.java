package probador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Terreno 
{
	private int[][] terreno;
	private int cantPeniascos;
	private int filas;
	private int cols;
	
	public Terreno(String path) throws FileNotFoundException, IOException
	{
		Scanner sc = new Scanner(new File(path));
		
		this.filas = sc.nextInt();
		this.cols = sc.nextInt();
		this.terreno = new int[this.filas][this.cols];
		sc.nextLine(); // Dimensiones Casa
		this.cantPeniascos = sc.nextInt();
		
		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.cols; j++)
				terreno[i][j] = 0;
		
		for(int k = 0; k < this.cantPeniascos; k++)
			this.terreno[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
				
		sc.close();
		
		System.out.println(this.filas + "  " + this.cols + " " + this.cantPeniascos);
		System.out.println(this.filas+" "+this.cols);
		for (int i=0; i<this.filas;i++)
			for(int j=0; j<this.cols;j++)
				System.out.println(i+" "+j+" "+this.terreno[i][j]);
		
		/*
		if (contPenReal != this.cantPeniascos)
		{
			String pathOut = "./salida.out";
			
			PrintWriter salida = new PrintWriter(new FileWriter(pathOut));
			salida.println("NO"); 
			salida.close();
		}
		*/
		
	}
	
	public boolean comprobarUbicacion(Casa casa)
	{
		int x, y;
		
		if (casa.getOrientacion() == "N" || casa.getOrientacion() == "S")
		{
			x = casa.getFrente();
			y = casa.getProf();
		}
		else
		{
			x = casa.getProf();
			y = casa.getFrente();
		}
		
		for (int i = casa.getxInic() - 1; i < x; i++)
			for (int j = casa.getyInic() - 1; j < y; j++)
			{
				if (this.terreno[i][j] == 1)
					return false;
			}
		
		return true;
	}
}
