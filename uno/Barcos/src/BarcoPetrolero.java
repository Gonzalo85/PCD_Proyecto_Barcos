import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BarcoPetrolero extends Barco {
	
	public ContenedorPetrolero contAgua;
	public ContenedorPetrolero contPetroleo;
	
	public int idPetrolero;
	
	public ThreadPoolExecutor ex;
	
	public BarcoPetrolero(Puerta p, int id, int dir, int idP){
		super(p,id,dir);
		this.contAgua=new ContenedorPetrolero(4, 0);
		this.contPetroleo=new ContenedorPetrolero(5, 0);
		this.idPetrolero=idP;
		this.ex= (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
	}
	
	public ContenedorPetrolero getContPetroleo(){
		return this.contPetroleo;
	}
	public int getIdPetrolero(){
		return this.idPetrolero;
	}
	@Override 
	public void run(){
		//permiso entrada
		TorreControl.Singleton().permisoEntrada(this);
		Puerta.Singleton().entrar(this.idPetrolero);
		TorreControl.Singleton().finEntrada();
		
		//intentar repostar petroleo
		TareaGasoleo gas=new TareaGasoleo(this);
		TareaAgua agua= new TareaAgua(this);
		
		ex.execute(gas);
		ex.execute(agua);
		
		ex.shutdown();
		
		//intentar salir
		TorreControl.Singleton().permisoSalida(this);
		Puerta.Singleton().salir(this.idPetrolero);
		TorreControl.Singleton().finEntrada();
		
	}

}
