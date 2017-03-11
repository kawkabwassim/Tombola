import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class Client {

	protected Shell shlCartella;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private ArrayList<Label> Caselle = new ArrayList<Label>();
	private Button btnTombola;
	private int j = 0;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCartella.open();
		shlCartella.layout();
		while (!shlCartella.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCartella = new Shell();
		shlCartella.setText("Cartella");
		shlCartella.setSize(234, 224);

		Button btnConnessione = new Button(shlCartella, SWT.NONE);
		btnConnessione.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// si connette al server
				try {
					// crea un thread di ascolto dei messaggi
					s = new Socket("localhost", 9999);
					ClientReceiver tc = new ClientReceiver(s, Client.this);
					// il socket
					out = new PrintWriter(s.getOutputStream(), true);
					// la classe grafica
					tc.start();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnessione.setBounds(10, 151, 58, 25);
		btnConnessione.setText("Connetti");

		Label lblNewLabel_1 = new Label(shlCartella, SWT.NONE);
		lblNewLabel_1.setBounds(10, 10, 28, 15);
		Caselle.add(lblNewLabel_1);

		Label lblNewLabel_2 = new Label(shlCartella, SWT.NONE);
		lblNewLabel_2.setBounds(44, 10, 28, 15);
		Caselle.add(lblNewLabel_2);

		Label lblNewLabel_3 = new Label(shlCartella, SWT.NONE);
		lblNewLabel_3.setBounds(73, 10, 28, 15);
		Caselle.add(lblNewLabel_3);

		Label lblNewLabel_4 = new Label(shlCartella, SWT.NONE);
		lblNewLabel_4.setBounds(107, 10, 28, 15);
		Caselle.add(lblNewLabel_4);

		Label lblNewLabel_5 = new Label(shlCartella, SWT.NONE);
		lblNewLabel_5.setBounds(141, 10, 28, 15);
		Caselle.add(lblNewLabel_5);

		Label label = new Label(shlCartella, SWT.NONE);
		label.setBounds(10, 44, 28, 15);
		Caselle.add(label);

		Label label_1 = new Label(shlCartella, SWT.NONE);
		label_1.setBounds(44, 44, 28, 15);
		Caselle.add(label_1);

		Label label_2 = new Label(shlCartella, SWT.NONE);
		label_2.setBounds(73, 44, 28, 15);
		Caselle.add(label_2);

		Label label_3 = new Label(shlCartella, SWT.NONE);
		label_3.setBounds(107, 44, 28, 15);
		Caselle.add(label_3);

		Label label_4 = new Label(shlCartella, SWT.NONE);
		label_4.setBounds(141, 44, 28, 15);
		Caselle.add(label_4);

		Label label_5 = new Label(shlCartella, SWT.NONE);
		label_5.setBounds(10, 80, 28, 15);
		Caselle.add(label_5);

		Label label_6 = new Label(shlCartella, SWT.NONE);
		label_6.setBounds(44, 80, 28, 15);
		Caselle.add(label_6);

		Label label_7 = new Label(shlCartella, SWT.NONE);
		label_7.setBounds(78, 80, 28, 15);
		Caselle.add(label_7);

		Label label_8 = new Label(shlCartella, SWT.NONE);
		label_8.setBounds(107, 80, 28, 15);
		Caselle.add(label_8);

		Label label_9 = new Label(shlCartella, SWT.NONE);
		label_9.setBounds(141, 80, 28, 15);
		Caselle.add(label_9);
		
		btnTombola = new Button(shlCartella, SWT.NONE);
		btnTombola.setEnabled(false);
		btnTombola.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JOptionPane.showMessageDialog(null, "Hai vinto", "Tombola", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnTombola.setBounds(154, 151, 54, 25);
		btnTombola.setText("Tombola");

	}

	public void addMessage(String message) {
		Display.getDefault().asyncExec(new Runnable() {
			// TODO Auto-generated method stub
			public void run() {
				
				if(message.contains("&")){
					// recupero numeri
					String[] Stringnumeri = message.split("&");
					int[] numeri = new int[Stringnumeri.length];
					for (int i = 0; i < Stringnumeri.length; i++) {
						// converto in interi
						numeri[i] = Integer.parseInt(Stringnumeri[i]);
					}
					for (int i = 0; i < numeri.length; i++) {
						Caselle.get(i).setText(numeri[i] + "");
					}
				}else{
					//controlla numeri sulla cartella
					for (int i = 0; i < Caselle.size(); i++) {
						
						if(Caselle.get(i).getText().equals(message)){
							Caselle.get(i).setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
							j = j+1;
							if(j == 5){
								btnTombola.setEnabled(true);
							}
						}
					}
				}
			}
		});
	}
}