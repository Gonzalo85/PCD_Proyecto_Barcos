
public class Reponedor implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//plataformapetroleros.reponer
		for (int i = 0; i < 3; i++) {
			try {
				PlataformaPetrolero.Singleton().reponer();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	

}
