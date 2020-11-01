import java.rmi.Naming;

public class Client {
	
	
	public static void main(String args[]){
		try {
			
			Interface obj1=(Interface) Naming.lookup("Barcos");
			Interface obj2=(Interface) Naming.lookup("Contenedores");
			
			System.out.println("--------Barcos---------");
			System.out.println("--Hay "+obj1.cuantos()+" barcos en el puerto");

			
			System.out.println("--------Contenedores---------");
			System.out.println("Se han dejado "+obj2.cuantosContenedores(1)+" contenedores de AZUCAR");
			System.out.println("Se han dejado "+obj2.cuantosContenedores(2)+" contenedores de SAL");
			System.out.println("Se han dejado "+obj2.cuantosContenedores(3)+" contenedores de HARINA");

			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
