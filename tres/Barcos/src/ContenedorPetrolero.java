
public class ContenedorPetrolero extends Contenedor{

	int cantidad;
	
	public ContenedorPetrolero(int t, int c){
		super(t);
		this.cantidad=c;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getTipo(){
		return this.tipo;
	}
	
	public void setTipo(int t){
		this.tipo=t;
	}
	
	public void incCantidad(int i){
		this.cantidad+=i;
	}
}
