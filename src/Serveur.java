import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 */

/**
 * Class pour le serveur principal
 * @author ronald
 *
 */
public class Serveur implements Runnable{
	protected ServerSocket ss=null;
	protected final int ssPort=2016;
	protected ExecutorService pool;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ouvrirServeur();
		pool = Executors.newFixedThreadPool(10);
		//lancer la boucle d'écoute
		while(true){
			try{
				Socket cs= ss.accept();
				pool.execute(new Esclave(cs));
			}
			catch(IOException e){
				pool.shutdown();
				e.printStackTrace();
			}
		}
		
	}
	
	protected void ouvrirServeur(){
		try{
			this.ss=new ServerSocket(ssPort);
		}
		catch(IOException e){
			throw new RuntimeException("impossible d'ouvrir le port 2016", e);
		}
	}
}
