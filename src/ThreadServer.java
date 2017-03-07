import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer extends Thread{
	
	ServerG sg;
	
	public ThreadServer(ServerG sg){
		
		this.sg = sg;
	}
	
	public void run(){
		try {
			ServerSocket ss = new ServerSocket(9999);
			while(true){
				int numeri[] = null;
				
				Socket s = ss.accept();
				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
				InputStreamReader ISR = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(ISR);
			
				for(int i = 0; i<15; i++){
					numeri[i] = (int) Math.random() * 90 + 1;
					out.println(numeri[i]);
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
