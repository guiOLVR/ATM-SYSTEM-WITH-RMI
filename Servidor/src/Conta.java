
public class Conta {
	private int codigo;
	private int senha;
	private int saldo;
	
	
	public Conta(int codigo, int senha) {
		this.codigo = codigo;
		this.senha = senha;
		this.saldo = 0;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
