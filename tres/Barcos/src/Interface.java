import java.rmi.*;

public interface Interface extends Remote{
	public void inc() throws RemoteException;
	public void dec() throws RemoteException;
	public void incContenedores(int tipo) throws RemoteException;
	public int cuantosContenedores(int tipo) throws RemoteException;
	public int cuantos() throws RemoteException;

}
