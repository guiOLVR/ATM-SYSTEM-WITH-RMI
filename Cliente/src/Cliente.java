import java.rmi.Naming;
import java.util.Scanner;
/**
 *
 * @author gui_m
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Object obj = Naming.lookup("rmi://127.0.0.1/mensagem");
        ServiadorInterface mens = (ServiadorInterface) obj;
        int sair=0;
        //System.out.println("Mensagemdo servidor: "+mens.getMensagem());
        //mens.setMensagem("Chamando o Servidor = Execução: ");
        while(sair!= 100) {
	        System.out.println("1 Realizar Saque\n2 Realizar Depósito\n3 Verificar Saldo\n4 Criar Conta\n5 Listar todos os clientes\n6 Finalizar");
	        Scanner scan = new Scanner(System.in);
	        int opcao = scan.nextInt();
	        
	        switch(opcao) {
	        	case 1:
	        		mens.sacar();
	        		break;
	        	case 2:
	        		mens.depositar();
	        		break;
	        	case 3:
	        		mens.listaSaldo();
	        		break;
	        	case 4:
	        		mens.criaConta();
	        		break;
	        	case 5:
	        		mens.listaContas();
	        		break;
	        	case 6:
	        		sair = 100;
	        		
	        		break;
	        }
        }
    }
    
}
