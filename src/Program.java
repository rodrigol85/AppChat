
import java.time.LocalDateTime;

import java.util.LinkedHashMap;
import java.util.Map;


public class Program {

	public static void main(String[] args) {
		/*
		 * Conto Corrente/Bancomat 
		Scrivere un programma che simuli il funzionamento di uno sportello bancomat basico. 
		- Dovrà essere possibile scegliere dal menù 3 operazioni: saldo conto, versamento, prelievo 
		- Ogni operazione dovrà movimentare un conto corrente registrando data e ora dell'operazione, 
		tipo dell'operazione (solo se versamento o prelievo), importo dell'operazione. 
		- La stampa del saldo dovrà essere in grado di restituire le ultime 5 operazioni effettuate, 
		visualizzandole in modo comprensibile. 
		Non è necessario usare la persistenza dei dati. E' sufficiente fare uso delle collezioni adatte.
		 */
		
		Cliente c1 = new Cliente("Mario", "Rossi", 30150);
		Sportello sp1 = new Sportello(c1);
		LocalDateTime oggi = LocalDateTime.now();
		
		
		
		Map<LocalDateTime, Double> data = new LinkedHashMap<LocalDateTime, Double>();
	
		
		
		//sp1.prelevare(1500);
		//sp1.prelevare(500);
		
		sp1.opzioni();
		sp1.ultimiCinqueOperazioni();
		//System.out.println("====" + c1.getSaldo());
		
		
	

	}

}
