import java.util.concurrent.locks.*;

public class Plataforma {
	private static Plataforma plat=null;
	
	private Contenedor contP;// variable para ver si hay un contenedor en la plataforma
	
	final Lock lock=new ReentrantLock(true);//mutex
	
	final Condition merc=lock.newCondition();
	final Condition az=lock.newCondition();
	final Condition sal=lock.newCondition();
	final Condition har=lock.newCondition();
	
	
	
	public Plataforma(){
		this.contP=null;

	}



	public static synchronized Plataforma getPlat() {//singleton
		if(plat==null){
			plat=new Plataforma();
		}
		return plat;
		
	}


	public static void setPlat(Plataforma plat) {
		Plataforma.plat = plat;
	}



	public Contenedor getContP() {
		return contP;
	}



	public void setContP(Contenedor contP) {
		this.contP = contP;
	}
	
	public void coger(Grua g) throws InterruptedException{
		lock.lock();// comienza S.C.
		try{
			try{
				while(g.getTipo()!=this.contP.getTipo()){
					if(g.getTipo()==1){
						az.await();
					}else{
						if(g.getTipo()==2){
							sal.await();
						}else{
							if(g.getTipo()==3){
								har.await();
							}
						}
					}
				}
				}catch(NullPointerException e){
					if(g.getTipo()==1){
						az.await();
					}else{
						if(g.getTipo()==2){
							sal.await();
						}else{
							if(g.getTipo()==3){
								har.await();
							}
						}
					}
			}
			//S.C.
			System.out.println("La grua de tipo " +g.getTipo()+" coge el contenedor de tipo "+contP.getTipo());
			contP=null;//plataforma vacia ya que se ha cogido el contenedor
			System.out.println("Contenedor de tipo "+g.getTipo()+" cogido");
			//signal a la variable de condicion
			merc.signal();//signal al mercante porque la plataforma esta vacia
		}
		//Salida de S.C.
		finally{
			lock.unlock();
		}
	}
	void dejar(Contenedor c,Interface numContenedores) throws InterruptedException{
		//S.C.
		lock.lock();//lock de mutex
		
		try {
			while(contP!=null)
				merc.await();
			
			
			System.out.println("Dejando contenedor de tipo "+c.getTipo()+" en la plataforma");
			contP=c;
			System.out.println("Contenedor de tipo "+c.getTipo()+" dejado");
			
			if(c.getTipo()==1){
				az.signal();
			}else{
				if(c.getTipo()==2){
					sal.signal();
				}else{
					if(c.getTipo()==3){
						har.signal();
					}
					
			}
			
		}
			try {
				numContenedores.incContenedores(contP.getTipo());
			} catch (Exception e) {
				
			}
			
		}
		finally {
			lock.unlock();
		
	}
	}
}