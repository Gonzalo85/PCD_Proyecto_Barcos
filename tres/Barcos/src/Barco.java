import java.rmi.RemoteException;

public class Barco implements Runnable {
	int direccion;
	int id;
    Interface objeto;
	

	public Barco(Puerta p, int _id, int dir,Interface _objeto){
		this.objeto=_objeto;
		direccion=dir;
		id=_id;
		if(dir==1){
			try {
				objeto.inc();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		
		
		
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
			try {
				objeto.inc();
			} catch (Exception e) {
				e.printStackTrace();
			}
			TorreControl.Singleton().finEntrada();
		}else{//direccion==1 es salir
			TorreControl.Singleton().permisoSalida(this);
			Puerta.Singleton().salir(this.id);
			try {
				this.objeto.dec();
			} catch (Exception e) {
				e.printStackTrace();
			}
			TorreControl.Singleton().finSalida();
		}
	}
}
