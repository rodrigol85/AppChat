
import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Server extends JFrame implements Runnable{

    public Server(){

        setBounds(1200,300,280,350);

        JPanel milamina= new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto=new JTextArea();

        milamina.add(areatexto,BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread mihilo = new Thread(this);

        mihilo.start();

    }

    private	JTextArea areatexto;

    @Override
    public void run() {

        //System.out.println("estoajflsk");

        try {
            ServerSocket myServerSocket = new ServerSocket(9999);

            String nick, ip, messaggioricevuto;

            PaccoDaInviare paccoRicevuto;

            while(true) {

                Socket mysocket = myServerSocket.accept();

                ObjectInputStream paccoDati = new ObjectInputStream(mysocket.getInputStream());

                paccoRicevuto = (PaccoDaInviare) paccoDati.readObject();

                nick = paccoRicevuto.getNick();
                ip = paccoRicevuto.getIp();
                messaggioricevuto = paccoRicevuto.getMessaggio();


                areatexto.append("\n" + nick + ": " +  messaggioricevuto + " para " + ip);

                Socket inviaDestinatario = new Socket(ip, 9090);

                ObjectOutputStream paccoDaRinviare = new ObjectOutputStream(inviaDestinatario.getOutputStream());

                paccoDaRinviare.writeObject(paccoRicevuto);

                paccoDaRinviare.close();

                inviaDestinatario.close();



                mysocket.close();


		/*		DataInputStream flujo_entrada = new DataInputStream(mysocket.getInputStream());

				String messaggio = flujo_entrada.readUTF();

				areatexto.append("\n" + messaggio);

				mysocket.close();			*/

            }



        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
