import java.rmi.Naming;
import java.rmi.RemoteException;
/**
 *
 * @author gui_m
 */
public class ServidorMain {
    public static void main(String [] args) throws RemoteException{
        ServiadorInterface mens = new ServidorImplementacao();
               
        try{
            Naming.rebind("mensagem", mens);
            System.out.println("Resposta do servidor : Nome do objeto do servidor : mensagem (Ex. 127.0.0.1/mensagem)");
        }catch(Exception ex){
            System.out.println("Erro no try catch");
        }
    }
}
