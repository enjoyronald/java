import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class representant une personne
 */

/**
 * @author ronald
 *
 */
public class Personne {
	protected String email;
	public Personne(){
		super();
	}

	public String getEmail(){
		return this.email;
	}
	/**
	 * Permet de definir un email, tout en vérifiant le format
	 * @param mail email à assigner
	 */
	public void setEmail(String mail) throws EmailException{
		/*
		 * Verfication du format. nom@serveur.domaine
		 */
		char at='@';
		int indiceAt= mail.indexOf(at);
		// test presence @

		if(indiceAt== -1 || indiceAt==(mail.length()-1) || indiceAt==0 || indiceAt != mail.lastIndexOf(at))
			throw new EmailException();	
		//verification pas @ dans serveur.domaine
		String sd=mail.substring(indiceAt+1, mail.length());
		char point = '.';
		int indicePoint=sd.indexOf(point);
		System.out.println("lkjfkljkje      "+sd.length());
		if(indicePoint == -1 || indicePoint == 0 || indicePoint == (sd.length()-1) || indicePoint != sd.lastIndexOf(point))
			throw new EmailException();

		this.email =mail;

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne p=new Personne();
		System.out.println("Entrez votre email : ");
		try{
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			String mail=in.readLine();
			p.setEmail(mail);
			System.out.println("Votre email:"+p.getEmail());
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(EmailException e){

		}


	}

	public class EmailException extends Exception{
		public EmailException(){
			System.out.println("Format d'email incorrect.");
		}
	}
}

