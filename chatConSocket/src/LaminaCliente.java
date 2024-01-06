import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class LaminaCliente extends JPanel{
	
	public LaminaCliente(){
		
		nick = new JTextField(5);
		
		add(nick);
	
		JLabel texto=new JLabel("-Chat-");
		
		add(texto);
		
		ip =new JTextField(8);
		
		add(ip);
		
		campochat = new JTextArea(13,20);
		
		add(campochat);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		InviaText myevent = new InviaText();
		miboton.addActionListener(myevent);
		
		add(miboton);	
		
	}
	
	
	private class InviaText implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(campo1.getText());
			
			try {
				Socket mysocket = new Socket("192.168.1.4", 9999);
				
				PaccoDaInviare  dati = new PaccoDaInviare();
				
				dati.setNick(nick.getText());
				
				dati.setIp(ip.getText());
				
				dati.setMessaggio(campo1.getText());
				
				ObjectOutputStream paccodati = new ObjectOutputStream(mysocket.getOutputStream());
				
				paccodati.writeObject(dati);
				
				mysocket.close();
				
				
				
				
				
			/*	DataOutputStream flujo_salida = new DataOutputStream(mysocket.getOutputStream());
				
				flujo_salida.writeUTF(campo1.getText());
				
				flujo_salida.close();		*/
				
				
				
			} catch (UnknownHostException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
				
			}
			
			
		}
		
	}
	
		
		
		
	private JTextField campo1;
	
	private JTextField nick;
	
	private JTextField ip;
	
	private JTextArea campochat;
	
	private JButton miboton;
	
}
