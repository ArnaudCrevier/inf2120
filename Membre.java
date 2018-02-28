package ca.uqam.inf2120.tp1.adt.test;

/**
 * Membre : Cette classe correspond � l'�l�ment T et 
 * sera utilis� pour faire les tests unitaires
 *    
 * @author Ismael Doukoure - INF2120 - Groupe 30
 * @version 7 f�vrier 2018
 */
public class Membre {
	
	// D�claration des attributs
	private String identifiant;
	private String nom;
	private String prenom;

	
	/**
	 * Constructeur sans argument.
	 */
	public Membre() {
		super();
	}


	/**
	 * @param identifiant L'identifiant 
	 * @param nom Le nom
	 * @param prenom Le pr�nom
	 */
	public Membre(String identifiant, String nom, String prenom) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
	}


	

	/**
	 * @return l'identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}


	/**
	 * @param identifiant l'identifiant � initialiser
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}


	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom le nom  � initialiser
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return le pr�nom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom le pr�nom � initialiser 
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutreObjet) {
		
		boolean estEgal = false;
		
		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme r�sultat.
	    if (this == unAutreObjet) {
			estEgal = true;
			
		} else if (unAutreObjet != null && 
				   this.getClass() == unAutreObjet.getClass()) {
		
			// Sachant que "unAutreObjet" n'est pas null et que "unAutreObjet"
			// et l'objet courant sont de m�me type, on peut se permettre
			// la conversion de "UnAutreObjet" en Membre
			Membre unMembre = (Membre)unAutreObjet;
			
			// Tester si les deux (2) objets ont le m�me identifiant.
			estEgal = (identifiant.equals(unMembre.identifiant));
		}
	    
	    return estEgal;
	    
	}


}