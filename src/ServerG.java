import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

public class ServerG {

	protected Shell shell;
	private Table table;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerG window = new ServerG();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(527, 279);
		shell.setText("Server");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 491, 221);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		int n = 1;
		for(int i=0;i<10;i++){
			TableColumn colum = new TableColumn(table, SWT.NULL);
			colum.setWidth(50);
			colum.setText(" ");
			
		}
		
		for (int loopIndex = 0; loopIndex < 9; loopIndex++) {
			
			 
		      TableItem item = new TableItem(table, SWT.NULL);
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      item.setText(String.valueOf(n));
		      n = n+10;
		      
		    }

		Thread t = new Thread(new ThreadServer(this));
		t.start();

	}
	
	public void AggiornaGraficaS(){
		Display.getDefault().syncExec(new Runnable(){

			@Override
			public void run() {
				
				for(int i=0;i<15;i++){
					String message=in.readLine();
					System.out.println(message);
				}
				
				
			}
			
		});
	}
}
