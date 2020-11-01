import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Interface{
	private static final long serialVersionUID=1L;
	private int contador;

	public Server()throws RemoteException{
		contador=0;
		
	}

	@Override
	public synchronized void inc() throws RemoteException {
		contador++;
		
	}

	@Override
	public synchronized void dec() throws RemoteException {
		contador--;
		
	}

	@Override
	public int cuantos() throws RemoteException {
		return contador;
	}
	
	public static void main(String args[]){
		try {
			Server servidorB = new Server();
			Naming.rebind("Barcos", servidorB);
			System.out.println("Server de barcos corriendo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void  incContenedores(int tipo) throws RemoteException {
		
		
	}

	@Override
	public int cuantosContenedores(int tipo) throws RemoteException {
		return 0;
	}
	
}
