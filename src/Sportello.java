import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Sportello {
	
	Cliente cliente;
	LocalDateTime data = LocalDateTime.now();
	boolean operazioni = false;
	boolean prelevato =false;
	boolean versamento = false;
	double prelievo;
	double versato;
	File file = new File("movimentazione.txt");
	private String movimento;
	
	public Sportello(Cliente cliente) {
		this.cliente=cliente;
		
	}
	
	public Sportello(Cliente cliente, LocalDateTime data, double  prelievo, double versato, String movimento) {
		this.cliente=cliente;
		this.data=data;
		this.prelievo = prelievo;
		this.versato = versato;
		setMovimento(movimento);
		
	}
	public Sportello() {}
	
	public String getMovimento() {
		return movimento;
	}
	public void setMovimento (String movimento) {
		this.movimento=movimento;
	}
	
	
	public void prelevare(double importoPrelevato) {
		if(cliente.getSaldo() >= importoPrelevato) {
			cliente.setSaldo(cliente.getSaldo()- importoPrelevato);
			
			 movimento =" (-) " + importoPrelevato +
					 " Data " + data.getHour() + ":" + data.getMinute() + " " + data.getDayOfMonth() +
					 "/" + data.getMonth() + "/" + data.getYear();
			System.out.println("L'operazione è andata a buen fine: " + movimento);
			
			
		}else {
			System.out.println("Suo saldo è inferiore all'importo che vuole prelevare ");
		}
	
		
		
	}
	
	public void versamento(double importoVersato) {
		cliente.setSaldo(cliente.getSaldo() + importoVersato);
		versato = importoVersato;
		
		movimento = " (+)" + importoVersato + " Data " + data.getHour() + ":" + data.getMinute() + 
				" " + data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear();
		
		System.out.println("L'operazione è andata a buen fine: " + movimento);
		
	}
	
	
	public void opzioni() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 = saldo, 2= prelievo, 3 =versamento, 9 exit");
		int opzione = scanner.nextInt();
		
		switch (opzione) {
		case 1:
			System.out.println("Il suo saldo attuale è : " + cliente.getSaldo());
			break;
		case 2 :
			System.out.println("Inserisca l'importo");
			prelievo = scanner.nextDouble();
			prelevare(prelievo);
			operazioni = true;
			prelevato = true;
			break;
		case 3 :
			System.out.println("Inserisca importo");
			versamento(scanner.nextDouble());
			operazioni = true;
			versamento = true;
			break;
		case 9 :
			System.out.println("Grazie! Arrivederci");
			scanner.close();
			break;
		 default :
			 System.out.println("Scenta non trovata");
			 scanner.close();
			
			
		}
		
	}
	
	public void ultimiCinqueOperazioni() {
		String[]movimento = new String[5];
		String movi = " ";
		int counter=0;
		if(operazioni == true && prelevato == true) {
			movi = "(-) " +  this.prelievo + " Data " + data.getHour() + ":" + data.getMinute() + " " + data.getDayOfMonth() + 
					"/" + data.getMonth() + "/" + data.getYear();

		}else if ( operazioni == true && versamento == true) {
			movi = "(+)" + this.versato + " Data " + data.getHour() + ":" + data.getMinute() + " " + data.getDayOfMonth() + 
					"/" + data.getMonth() + "/" + data.getYear();
			counter++;
		}
		movimento[counter] = movi;
		System.out.println("Le sue utime 5 operazioni");
			for(String m : movimento) {
				
				System.out.println(m);
			}
			
			System.out.println("Il suo saldo attuale è: " + cliente.getSaldo());
		}
}