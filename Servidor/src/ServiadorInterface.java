import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gui_m
 */
public interface ServiadorInterface extends Remote{
    public String getMensagem() throws RemoteException;
    public void setMensagem(String msg) throws RemoteException;
    public void menu() throws RemoteException;
    public void criaConta() throws RemoteException;
    public void listaContas() throws RemoteException;
    public void listaSaldo() throws RemoteException;
    public void depositar() throws RemoteException;
    public void sacar() throws RemoteException;
}
