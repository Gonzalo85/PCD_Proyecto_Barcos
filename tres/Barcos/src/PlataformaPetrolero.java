import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class PlataformaPetrolero {
	private ContenedorPetrolero contAgua;
	private ArrayList<ContenedorPetrolero> contPetroleo;
	private static PlataformaPetrolero plataforma=null;
	private int vacios=5;//5 contenedores con 1000 litros cada uno en la plataforma
	private int numBarcos;
	
	//semaforos petroleros(uno por cada)
	private Semaphore p0=new Semaphore(1);
	private Semaphore p1=new Semaphore(1);
	private Semaphore p2=new Semaphore(1);
	private Semaphore p3=new Semaphore(1);
	private Semaphore p4=new Semaphore(1);
	
	//semaforo cont agua
	private Semaphore a0=new Semaphore(1);
	
	//semaforo exclusion mutua
	private Semaphore sc=new Semaphore(1);
	private Semaphore vacio=new Semaphore(1);
	private Semaphore reponedor=new Semaphore(0);
	private Semaphore dentro=new Semaphore(0);
	
	
	
	private PlataformaPetrolero(){//constructor
		//creamos los contenedores de la plataforma
		numBarcos=0;
		contPetroleo=new ArrayList<ContenedorPetrolero>();
		for (int i = 0; i < 5; i++) {
			contPetroleo.add(new ContenedorPetrolero(5, 1000));
		}
		setContAgua(new ContenedorPetrolero(4, 50000));
		
	}
	
	public static synchronized PlataformaPetrolero Singleton(){
		if(plataforma==null){
			plataforma=new PlataformaPetrolero();
		}
		return plataforma;
	}
	
	public void repostarA(BarcoPetrolero b) throws InterruptedException{
		//acquire del semaforo de agua
		a0.acquire();
//		b.contAgua.setCantidad(5000);//rellenamos
		for (int i = 0; i < 5; i++) {//rellenamos de 1000 en 1000
			b.contAgua.incCantidad(1000);
			System.out.println("El barco "+ b.getID()+" ha repostado agua (1000 litros)");
		}
		a0.release();//liberamos el semaforo una vez repostado
	}
	
	public void repostarP(BarcoPetrolero b) throws InterruptedException{
		//mutex
		sc.acquire();
		numBarcos++;
		System.out.println("-BARCO PETROLERO ENTRA-");
		sc.release();
		//esperamos a los 5
		if (numBarcos<5){
			dentro.acquire();
		}
		dentro.release();
		
		//mientras no esten llenos
		while(b.getContPetroleo().getCantidad()<3000){
			if(b.getIdPetrolero()==0)
				p0.acquire();//se bloquea en su semaforo
			else if(b.getIdPetrolero()==1)
				p1.acquire();
			else if(b.getIdPetrolero()==2)
				p2.acquire();
			else if(b.getIdPetrolero()==3)
				p3.acquire();
			else if(b.getIdPetrolero()==4)
				p4.acquire();
			
			
			contPetroleo.get(b.getIdPetrolero()).setCantidad(0);//vaciar contenedor
			b.getContPetroleo().incCantidad(1000);//repostar petroleo
			System.out.println("El barco "+b.getID()+" ha repostado petroleo (1000 litros)");
			
			//se ha vaciado un contenedor de la plataforma
			vacio.acquire();
			vacios--;
			vacio.release();
			
			//cuando esten todos vacios liberamos el reponedor
			if(vacios==0){
				reponedor.release();
			}
			
		}
	}
	public void reponer() throws InterruptedException{
		reponedor.acquire();
		System.out.println("El reponedor comienza");
		for (int i = 0; i < 5; i++) {//rellenamos los 5 contenedores
			contPetroleo.get(i).setCantidad(1000);
		}
		vacios=5;
		System.out.println("El reponedor ha terminado");
		p0.release();
		p1.release();
		p2.release();
		p3.release();
		p4.release();
		
	}

	public ContenedorPetrolero getContAgua() {
		return contAgua;
	}

	public void setContAgua(ContenedorPetrolero contAgua) {
		this.contAgua = contAgua;
	}
}

