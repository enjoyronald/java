import java.net.Socket;

/**
 * 
 */

/**
 * @author ronald
 *
 */
public class Esclave implements Runnable{
	protected Socket cs;
	
	public Esclave(Socket clientSocket){
		this.cs = clientSocket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
