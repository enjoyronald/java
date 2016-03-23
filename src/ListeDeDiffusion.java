import java.util.ArrayList;

/**
 * 
 */


/**
 * @author ronald
 *
 */
public class ListeDeDiffusion {
	protected String nom;
	protected Theme theme;
	protected Personne diffuseur;
	protected String mdp;
	protected volatile ArrayList<Personne> abonnes;

	public ListeDeDiffusion(String nom, Theme theme, Personne diffuseur,
			String mdp) {
		super();
		this.nom = nom;
		this.theme = theme;
		this.diffuseur = diffuseur;
		this.mdp = mdp;
		abonnes = new ArrayList<Personne>();
	}

	
	//gestion des abonnement 
	public synchronized void ajouterAbonnes(Personne p){
		abonnes.add(p);
	}
	public synchronized void retirerAbonnes(Personne p){
		abonnes.remove(p);
	}
	
	public String getNom() {
		return nom;
	}

	public synchronized ArrayList<Personne> getAbonnes() {
		return abonnes;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Personne getDiffuseur() {
		return diffuseur;
	}
	


}
