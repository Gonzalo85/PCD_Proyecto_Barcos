import java.util.ArrayList;

public class BarcoMercante extends Barco {
	ArrayList<Contenedor> Contenedores;//lista de contenedores del barco mercante
	Interface numC;
	
	public BarcoMercante(Puerta p, int id, int dir,int az,int sal, int har,Interface objeto,Interface objeto2){
		super(p,id,dir,objeto);
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
		this.numC=objeto2;
		
	}
	
	public void run(){
		TorreControl.Singleton().permisoEntrada(this);
		Puerta.Singleton().entrar(this.id);
		try {
			objeto.inc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		TorreControl.Singleton().finEntrada();
		
		while(!Contenedores.isEmpty()){
			
			try {
				int i=(int) (Math.random()*Contenedores.size());
				Plataforma.getPlat().dejar(Contenedores.get(i),numC);
				Contenedores.remove(i);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		TorreControl.Singleton().permisoSalida(this);
		try {
			objeto.dec();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Puerta.Singleton().salir(this.id);
		TorreControl.Singleton().finEntrada();
		
	}

}

