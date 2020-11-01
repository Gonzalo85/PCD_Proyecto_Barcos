import java.util.ArrayList;

public class BarcoMercante extends Barco {
	ArrayList<Contenedor> Contenedores;//lista de contenedores del barco mercante
	
	public BarcoMercante(Puerta p, int id, int dir,int az,int sal, int har){
		super(p,id,dir);
		Contenedores=new ArrayList<Contenedor>();
		
		for (int i = 0; i < az; i++) {
			Contenedores.add(new Contenedor(1));
		}
		
		for (int i = 0; i < sal; i++) {
			Contenedores.add(new Contenedor(2));
		}
		
		for (int i = 0; i < har; i++) {
			Contenedores.add(new Contenedor(3));
		}
		
	}
	
	public void run(){
		TorreControl.Singleton().permisoEntrada(this);
		Puerta.Singleton().entrar(this.id);
		TorreControl.Singleton().finEntrada();
		
		while(!Contenedores.isEmpty()){
			int i=(int) (Math.random()*Contenedores.size());
			try {
				Plataforma.getPlat().dejar(Contenedores.get(i));
				Contenedores.remove(i);
				
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		TorreControl.Singleton().permisoSalida(this);
		Puerta.Singleton().salir(this.id);
		TorreControl.Singleton().finEntrada();
		
	}

}

