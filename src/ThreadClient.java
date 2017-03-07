import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient extends Thread{
	
	ClientG cg;
	
	public ThreadClient(ClientG cg){
		this.cg =cg;
	}
	
	public void run(){
		try {
			 int numeri[] = null ;
			Socket s = new Socket("localhost",9999);
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			InputStreamReader ISR = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(ISR);
			
			for(int i = 0; i<15;i++){
				numeri[i] = in.read();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
