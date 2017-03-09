import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver extends Thread {
	private Socket s;
	private ClientG c;
	//deve essere inizializzato con il socket e il riferimento della grafica
	public ClientReceiver(Socket s, ClientG c){
		this.s=s;
		this.c=c;
	}
	
	public void run(){
		super.run();
		//all'infinito in ascolto di nuovi messaggi nel socket
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){
				//legge il messaggio
				//comunica alla grafica il nuovo messaggio
				String message = in.readLine();
				
				c.addMessage(message);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
