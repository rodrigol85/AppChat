
import java.time.LocalDateTime;
import java.util.LinkedHashMap;


public class Cliente {
	
	private String nome;
	private String cognome;
	private double saldo;
	LinkedHashMap<LocalDateTime, Double> movimento;
	
	public Cliente(String nome, String cognome, double saldo) {
		this.nome=nome;
		this.cognome=cognome;
		this.saldo=saldo;
		
		
	}
	
	
	
	public Cliente(String nome, String cognome, double saldo, LinkedHashMap movimento) {
		this.nome=nome;
		this.cognome=cognome;
		this.saldo=saldo;
		
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	
	public String toString() {
		return this.nome + " " + this.cognome + " \n" + "Saldo attuale: " + this.saldo;
	}

}



