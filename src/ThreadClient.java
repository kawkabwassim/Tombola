import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.eclipse.swt.events.SelectionAdapter;

public class ThreadClient extends Thread{

	SelectionAdapter selectionAdapter;

	public ThreadClient(SelectionAdapter selectionAdapter) {
		this.selectionAdapter = selectionAdapter;
	
	}

	public void run(){
		try {
			double estrazione;
			Socket s = new Socket("localhost",9999);
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			InputStreamReader ISR = new InputStreamReader(s.getInputStream());
			BufferedReader in = new BufferedReader(ISR);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
