package principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		
		//int[] nros = new int[5];
		ArrayList<Integer> nros =new ArrayList<Integer>();
		//int cantMayores=0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese el n�mero base");
		int base = Integer.parseInt(s.nextLine());
		
		//for (int i = 0; i < nros.length; i++) {
		String rta="";
		do{
			System.out.println("Ingrese un n�mero");
			int num = Integer.parseInt(s.nextLine());
			if (num > base) {
				//nro[cantMayores]=num;
				nros.add(num);
				//cantMayores++;
			}
			
			System.out.println("�Desea continuar? (S/N)");
			rta=s.nextLine();
		} while(!rta.equalsIgnoreCase("N"));
		
		System.out.println("");
		System.out.print("Nros mayores: ");
		
		//for (int i = 0; i < cantMayores; i++) {
		for (int i = 0; i < nros.size(); i++) {
			//System.out.print(nros[i]+" ");
			System.out.print(nros.get(i)+" ");
		}
		
		s.close();
	}
	
}