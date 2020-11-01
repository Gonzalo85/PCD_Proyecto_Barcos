
public class Grua implements Runnable {
	private int tipo;

	
	public Grua(int t){
		this.tipo=t;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void run(){
		int num=0;
		
		if(tipo==1){
			num=12;
		}else{
			if(tipo==2){
				num=20;
			}else{
				if(tipo==3){
					num=5;
				}
			}
		}
		for(int i=0;i<num;i++){
			try {
			//	objeto.incContenedores();
				Plataforma.getPlat().coger(this);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("grua "+this.getTipo()+" terminada");
		
	}

}
