import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.*;

/**
 *
 * @author gui_m
 */
public class ServidorImplementacao extends UnicastRemoteObject implements ServiadorInterface{
    private ArrayList<Conta> contas = new ArrayList();
    private Integer numero = 1;
    private String mensagem = "1 Realizar saque | 2 Realizar deposito | 3 Verificar saldo | 4 Criar conta | 5 Listar todos os cliente | 6 Finalizar";
    
    public ServidorImplementacao() throws RemoteException{}
    
    
    public String getMensagem() throws RemoteException {
        return mensagem;
    }

    public void setMensagem(String msg) throws RemoteException {
        numero ++;
        mensagem = msg + numero;
    }


	public void menu() throws RemoteException {
		//System.out.println("1 Realizar saque\n2 Realizar deposito\n3 Verificar saldo\n4 Criar conta\n5 Listar todos os cliente\n6 Finalizar");
	}
	
	public boolean verificaConta(int conta) {
		for(int i=0; i<contas.size(); i++) {
			if(conta == contas.get(i).getCodigo()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void criaConta() throws RemoteException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o codigo um para a conta: ");
		int codigo = scan.nextInt();
		System.out.println("Digite a senha: ");
		int senha = scan.nextInt();
		
		if(verificaConta(codigo) == false) {
			System.out.println("Conta criada");
			Conta cont = new Conta(codigo,senha);
			contas.add(cont);
		}
		else {
			System.out.println("Conta já existe!");
		}
	}

	@Override
	public void listaContas() throws RemoteException {
		Scanner scan = new Scanner(System.in);
		int codigo, saldo, senha;
		System.out.println("Digite a senha de ADMIN para continuar: ");
		senha = scan.nextInt();
		if(senha == 1234) {
			for(int i=0; i<contas.size();i++) {
				codigo = contas.get(i).getCodigo();
				saldo = contas.get(i).getSaldo();
				System.out.println("Código: " + codigo + " | Saldo: " + saldo);
			}
		}
		else {
			System.out.println("Senha incorreta!");
		}
		System.out.println("Digite 0 para continuar...");
		int aguardando = scan.nextInt();
	}


	@Override
	public void listaSaldo() throws RemoteException {
		System.out.println("Digite o código da conta: ");
		Scanner scan = new Scanner(System.in);
		int codigo = scan.nextInt();
		
		for(int i=0; i<contas.size(); i++) {
			if(contas.get(i).getCodigo() == codigo) {
				System.out.println("Seu saldo é de: "+ contas.get(i).getSaldo());
			}
		}
		System.out.println("Digite 0 para continuar...");
		int sair = scan.nextInt();
	}


	@Override
	public void depositar() throws RemoteException {
		System.out.println("Digite o código da conta: ");
		Scanner scan = new Scanner(System.in);
		int codigo = scan.nextInt();
		int valor=0;
		for(int i=0; i<contas.size(); i++){
			if(contas.get(i).getCodigo() == codigo) {
				System.out.println("Digite o valor a ser depositado: ");
				valor = scan.nextInt();
				if(valor > 0) {
					contas.get(i).setSaldo(valor);
					System.out.println("Deposito efetuado com sucesso!");
				}
				else {
					System.out.println("Valor inválido!");
				}
			}
		}
		System.out.println("Digite 0 para continuar...");
		int sair = scan.nextInt();
	}


	@Override
	public void sacar() throws RemoteException {
		System.out.println("Digite o código da conta: ");
		Scanner scan = new Scanner(System.in);
		int codigo = scan.nextInt();
		int valor=0;
		for(int i=0; i<contas.size(); i++){
			if(contas.get(i).getCodigo() == codigo) {
				int total = contas.get(i).getSaldo();
				System.out.println("Digite o valor a ser sacado: ");
				valor = scan.nextInt();
				if(valor < total) {
					contas.get(i).setSaldo(total - valor);
					System.out.println("Saque efetuado com sucesso!"+"\n Total disponivel: "+ contas.get(i).getSaldo());
				}
				else {
					System.out.println("Valor inválido!");
				}
			}
		}
		System.out.println("Digite 0 para continuar...");
		int sair = scan.nextInt();
	}	   
}
	
	
	
	
	
	