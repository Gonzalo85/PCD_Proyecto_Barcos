import java.util.LinkedList;

public class TorreControl {
	private static TorreControl T=null;
	LinkedList<Barco> entrada;
	LinkedList<Barco> salida;
	
	public TorreControl(){
		entrada= new LinkedList<Barco>();
		salida= new LinkedList<Barco>();
	}
	
	public static synchronized TorreControl Singleton() {
		if (T == null)
			return T = new TorreControl();
		else
			return T;
	}
public synchronized void permisoEntrada(Barco b){
	System.out.println("El barco "+b.getID()+" solicita entrada");
	entrada.addLast(b);//añadimos el barco a la lista de entrada
	
	
	while(!this.salida.isEmpty() || this.entrada.getFirst().getID()!=b.getID() || Puerta.Singleton().getEstado()==2){
		try{
//			System.out.println("El barco "+b.getID()+" se queda a la espera para ENTRAR");
			wait();
		}
		 catch(Exception e){
			 //TODO: handle exception
		 }
		
	}
	
	System.out.println("El barco "+b.getID()+" tiene permiso de entrada");
	Puerta.Singleton().setEstado(1);//ponemos estado de puerta a barcos entrando
	entrada.remove(b);//quitamos el barco de la lista de entrada
	Puerta.Singleton().incContEntrada();//aumentamos contador entrada de la puerta
	
}

public synchronized void finEntrada(){
	Puerta.Singleton().decContEntrada();
	if(Puerta.Singleton().getContEntrada()==0){
		Puerta.Singleton().setEstado(0);//si no hay barcos entrando ponemos el estado de la puerta a vacia(0)
	}
	notifyAll();
}


public synchronized void permisoSalida(Barco b){
	System.out.println("El barco "+b.getID()+" solicita salida");
	salida.addLast(b);
	
	
	while(this.salida.getFirst().getID()!=b.getID() || Puerta.Singleton().getEstado()==1){
		try{
//			System.out.println("El barco "+b.getID()+" se queda a la espera para SALIR");
			wait();
		}
		 catch(Exception e){
			 //TODO: handle exception
		 }
		
	}
	System.out.println("El barco "+b.getID()+" tiene permiso de salida");
	Puerta.Singleton().setEstado(2);//ponemos estado puerta a barcos saliendo
	salida.remove(b);
	Puerta.Singleton().incContSalida();
}

public synchronized void finSalida(){
	Puerta.Singleton().decContSalida();
	if(Puerta.Singleton().getContSalida()==0){
		Puerta.Singleton().setEstado(0);
	}
	
	notifyAll();
}

}
