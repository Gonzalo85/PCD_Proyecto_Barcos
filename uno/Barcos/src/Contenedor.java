
public class Contenedor {
	protected int tipo; //1=azucar, 2=sal, 3=harina, 4=agua, 5=gasoil
	
	public Contenedor(int t){
		this.tipo=t;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
