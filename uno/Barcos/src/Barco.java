
public class Barco implements Runnable {
	int direccion;
	int id;
	

	public Barco(Puerta p, int _id, int dir){
		direccion=dir;
		id=_id;
		
	}
	public int getID(){
		return this.id;
	}
//	public void mover(){
//		Puerta P=Puerta.Singleton();
//		TorreControl T=TorreControl.Singleton();
//		
//
//		if(direccion==0){
//			T.permisoEntrada(this);
//			P.entrar(this.id);
//			T.finEntrada(this);
//		}if(direccion==1){
//			T.permisoSalida(this);
//			P.salir(this.id);
//			T.finSalida(this);
//		}
//	}
	@Override
	public void run(){
		if(direccion==0){//direccion==0 es entrar
			TorreControl.Singleton().permisoEntrada(this);
			Puerta.Singleton().entrar(this.id);
			TorreControl.Singleton().finEntrada();
		}else{//direccion==1 es salir
			TorreControl.Singleton().permisoSalida(this);
			Puerta.Singleton().salir(this.id);
			TorreControl.Singleton().finSalida();
		}
	}
}
