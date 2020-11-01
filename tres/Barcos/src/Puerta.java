
public class Puerta {
	public static Puerta P=null;
	private int estado;
	private int contEntrada, contSalida;
	
	public Puerta(){
		estado=0;//0->puerta vacia, 1->barcos entrando, 2->barcos saliendo
		contEntrada=0;
		contSalida=0;
	}

	public static synchronized Puerta Singleton() {
		if (P == null)
			return P = new Puerta();
		else
			return P;
	}
	
	public int getEstado(){
		return estado;
	}
	public void setEstado(int e){
		this.estado=e;
	}
	
	public int getContEntrada(){
		return contEntrada;
	}
	public void incContEntrada(){
		this.contEntrada++;
	}
	public void decContEntrada(){
		this.contEntrada--;
	}
	
	public int getContSalida(){
		return contSalida;
	}
	public void incContSalida(){
		this.contSalida++;
	}
	public void decContSalida(){
		this.contSalida--;
	}
	
	public void entrar(int id){
		System.out.println("El barco "+id+" entra");
		System.out.println("El barco "+id+" entra");
		System.out.println("El barco "+id+" entra");
	}
	
	public void salir(int id) {
		System.out.println("El barco "+id+" sale");
		System.out.println("El barco "+id+" sale");
		System.out.println("El barco "+id+" sale");
	}
}
