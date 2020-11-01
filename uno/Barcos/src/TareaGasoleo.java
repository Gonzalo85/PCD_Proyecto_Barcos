
public class TareaGasoleo extends Thread {
	private BarcoPetrolero b;

	
	public TareaGasoleo(BarcoPetrolero b){
		this.b=b;
	}
	
	@Override
	public void run(){
		try {
			PlataformaPetrolero.Singleton().repostarP(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
