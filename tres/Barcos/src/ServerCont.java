import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerCont extends UnicastRemoteObject implements Interface{
	private static final long serialVersionUID=1L;
	private int contAz;
	private int contSal;
	private int contHar;
	
	public ServerCont() throws RemoteException{
		contAz=0;
		contSal=0;
		contHar=0;
		
	}

	@Override
	public void inc() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dec() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public synchronized void  incContenedores(int tipo) throws RemoteException {
		if(tipo==1){
			contAz++;
		}else if(tipo==2){
			contSal++;
		}else if(tipo==3){
			contHar++;
		}
		
	}

	@Override
	public int cuantosContenedores(int tipo) throws RemoteException {
		int res=0;
		if(tipo==1){
			res=contAz;
		}else if(tipo==2){
			res=contSal;
		}else if(tipo==3){
			res=contHar;
		}
		return res;
	}

	@Override
	public int cuantos() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String args[]){
		try {
			ServerCont servidorC = new ServerCont();
			Naming.rebind("Contenedores", servidorC);
			System.out.println("Server de contenedores corriendo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
