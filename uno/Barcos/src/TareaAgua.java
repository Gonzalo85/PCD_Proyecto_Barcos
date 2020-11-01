
public class TareaAgua extends Thread {
	private BarcoPetrolero b;

	
	public TareaAgua(BarcoPetrolero b){
		this.b=b;
	}
	
	@Override
	public void run(){
		try {
			PlataformaPetrolero.Singleton().repostarA(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

