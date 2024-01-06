import javax.swing.JFrame;

class Cliente extends JFrame{
	
	public Cliente(){
		
		setBounds(800,300,280,350);
				
		LaminaCliente milamina=new LaminaCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}