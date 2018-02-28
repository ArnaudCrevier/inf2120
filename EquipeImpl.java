package ca.uqam.inf2120.tp1.adt.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import ca.uqam.inf2120.tp1.adt.*;

public class EquipeImpl<T> implements EquipeTda<T> {
	
	private ArrayList<T> equipeList = new ArrayList<>();
	
	public ArrayList<T> getEquipeList() {
		return equipeList;
	}

	public void setEquipeList(ArrayList<T> equipeList) {
		this.equipeList = equipeList;
	}	
	
	
	
	/**
     * Ajoute un membre dans l'équipe courante à la première position vide.
     * 
     * Si le membre n'est pas null, il n'existe pas dans l'équipe courante, il est ajouté
     * et la méthode retourne vrai, sinon elle retourne faux. 
     *   
     * @param membre Le membre à ajouter
     * @return true si le membre n'est pas null, il n'existe pas dans l'équipe et qu'il a 
     *         été ajouté, sinon false
     */
     public boolean ajouter(T membre) {
    	boolean rep;
    	if(membre != null && !equipeList.contains(membre)) {
    		rep = equipeList.add(membre);
    	} else {
    		rep = false;
    	}    	
    	return rep;
     }
    
    /**
     * Ajoute un membre dans l'équipe courante à une position donnée .
     * 
     * Si la position est dans le bon intervalle (position est supérieure ou égale à 0 et inférieure 
     * ou égale à la taille de l'équipe courante), le membre n'est pas null, il n'existe pas 
     * dans l'équipe courante, il est ajouté dans l'équipe courante et la méthode retourne vrai,
     * sinon elle retourne faux. Le membre doit être ajouté à la position identifiée en déplaçant 
     * l'ancien membre à la position suivante. La position du premier membre de l'équipe est 
     * considéré comme 0. 
     *   
     * @param position où le membre doit être ajouté
     * @param membre Le membre à ajouter
     * @throws PositionException si la position n'est pas dans le bon intervalle 
     * @return true si la position est bonne, le membre n'est pas null, il n'existe pas dans l'équipe et 
     *         qu'il est ajouté, sinon false
     */
     public boolean ajouter(int position, T element) throws PositionException {
    	 if (position < 0 || position > equipeList.size() - 1) {
    		 throw new PositionException("L'indice de position n'est pas dans le bon intervalle. Veuyez enter un chiffre entre 0 et " + equipeList.size() + ".");
    	 }
    	boolean rep;
    	
    	if(position >= 0 && position <= equipeList.size() && element != null && !equipeList.contains(element)) {
    		equipeList.add(position, element);
    		rep = true;
    	} else {
    		rep = false;
    	}    	
    	return rep;
     }
     
    /**
     * Ajoute les membres de l'équipe passée en paramètre dans l'équipe courante. Les membres sont
     * ajoutés aux prochaines positions vides de l'équipe courante.
     * 
     * Tous les membres de l'équipe passée en paramètre sont ajoutés dans l'équipe courante et retourne 
     * un tableau liste des membres de l'équipe passée en paramètre qui n'ont pas été ajoutés, car ils 
     * existent déjà. 
     *   
     * @param equipe L'équipe dont les membres doivent être ajoutés
     * @return Le tableau liste (ArrayList<T>) des membres de l'équipe passée en paramètre qui n'ont pas 
     * été ajoutés, null si tous les membres ont été ajoutés ou si l'équipe passée en paramètre est nulle 
     * ou vide 
     */
     public List<T> ajouter(EquipeTda<T> equipe) {
    	List<T> membreRef = new ArrayList<>();
    	
    	if (!equipe.estVide() && equipe != null) {
	    	while(equipe.iterateur().hasNext()) {
	    		if(!equipeList.contains(equipe.iterateur().next())) {
	    			equipeList.add(equipe.iterateur().next());
	    		}
	    		else {
	    			membreRef.add(equipe.iterateur().next());
	    		}
	    	}
    	}
    	return membreRef;
     }
    
     /**
     * Compare l'équipe courante à celle passée en paramètre. 
     * 
     * Si l'équipe courante contient tous les membres de celle passée en paramètre, la méthode retourne 
     * null, sinon un tableau liste  (ArrayList<T>) est retourné avec les membres de l'équipe passée en
     * paramètre qui n'existent pas dans l'équipe courante.
     *
     * @param equipe  L'équipe à comparer à l'équipe courante
     * @return null si l'équipe courante contient tous les membres de l'équipe passée en paramétre, 
     *         sinon un tableau liste (ArrayList<T>) des membres qui n'existent pas dans l'équipe courante
     *         est retourné
     */
     @SuppressWarnings("null")
	public List<T> comparer(EquipeTda<T> equipe) {
    	 List<T> membreAbs = new ArrayList<>();
    	 membreAbs = null;
    	 while(equipe.iterateur().hasNext()) {
    		 if(!equipeList.contains(equipe.iterateur().next())) {
    			 membreAbs.add(equipe.iterateur().next());
    		 }
    	 }
    	 	 
    	 return membreAbs;
     }    
    
     /**
     * Vérifie si l'équipe courante contient le membre passé en paramètre.
     * 
     * Si l'équipe courante contient le membre passé en paramètre, la methode retourne 
     * vrai, sinon elle retourne faux.
     * 
     * @param membre Le membre dont l'existence doit être vérifiée
     * @return vrai si le membre existe, sinon faux
     */
     public boolean estMembre(T membre) {
    	 return equipeList.contains(membre);
     }
     
     /**
     * Retourne le nombre de membres de l'équipe courante.
     * 
     * Le nombre total des membres dans l'équipe courante doit être retourné.
     * 
     * @return Le nombre total des membres de l'équipe courante
     */
     public int nbMembres() {
    	  return equipeList.size();
      }      
    
    /**
     * Retire le membre passé en paramètre de l'équipe courante.
     * 
     * Le membre passé en paramètre doit être retiré s'il existe dans l'équipe courante.
     * 
     * @param le membre Le membre à retirer
     * @return vrai si le membre est retiré, sinon faux 
     */      
     public boolean retirer(T element) {
    	 return equipeList.remove(element);
     }
    
    /**
     * Retire tous les membres de l'équipe passée en paramètre de l'équipe courante.
     * 
     * Tous les membres de l'équipe passée en paramètre doivent être retirés de l'équipe courante
     * s'ils existent.     
     *  
     * @param equipe L'équipe dont les membres doivent être retirés
     * @return Le tableau (ArrayList<T>) des membres de l'équipe passée en paramètre qui n'ont 
     * pas été retirés, null si tous les membres ont été retirés ou si l'équipe passée en paramètre
     * est nulle ou vide
     */
     @SuppressWarnings("null")
	public List<T> retirer(EquipeTda<T> equipe) {
    	 ArrayList<T> membreAbs = new ArrayList<>();
    	 membreAbs = null;
    	 while(equipe.iterateur().hasNext()) {
    		 if(!equipeList.contains(equipe.iterateur().next())) {
    			 membreAbs.remove(equipe.iterateur().next());
    		 }
    	 }
    	 return membreAbs;
     }
    
    /**
     * Remplace un membre par un autre dans l'équipe courante. Le membre à remplacer doit 
     * exister et le nouveau membre ne doit pas être null. Aucun remplacement si l'équipe
     * courante contient déjà le nouveau membre.
     * 
     * @param membreARemplacer Le membre de l'équipe courante à remplacer
     * @param nouveauMembre Le nouveau membre à ajouter
     * @return vrai si le remplacement a été fait, sinon faux
     */
     public boolean remplacer(T membreARemplacer, T nouveauMembre) {
    	 boolean rep = false;
    	 
    	 if (equipeList.contains(membreARemplacer) && !equipeList.contains(nouveauMembre) && nouveauMembre != null) {
    		 int position = equipeList.indexOf(membreARemplacer);
    		 equipeList.set(position, membreARemplacer);
    		 rep = true;
    	 }
    	 return rep;
     }
    
     /**
     * Retourne tous les membres de l'équipe courante et leurs positions dans un HashMap<K,T>
     * (HashMap Clé = position de type Integer, HashMap valeur = membre de type T). 
     *
     * @return Le HashMap de tous les membres de l'équipe courante et leurs positions,
     * 		null, si l'équipe courante est vide.
     */
     @SuppressWarnings("null")
	public Map<Integer, T> membres() {
    	  HashMap<Integer, T> equipeMap = new HashMap<>();
    	  equipeMap = null;
    	  if (!equipeList.isEmpty() && equipeList != null) {
    		  for (T i : equipeList) {
    			  equipeMap.put(equipeList.indexOf(i), i);
    		  }
    	  }
    	  return equipeMap;
      }
    
	 /**
     * Vérifie si l'équipe courante est vide.
     * 
     * @return vrai si l'équipe courante est vide, sinon faux.
     */
     public boolean estVide() {
    	 return equipeList.isEmpty();
     }

    /**
     * Vide l'équipe courante.
     */
     public void vider() {
    	 equipeList.clear();
     }
    
     /**
     * Retourne un itérateur sur l'équipe courante.
     *
     * @return Iterateur sur l'équipe courante.
     */
     public Iterator<T> iterateur() {
    	 Iterator<T> iterEquipe = equipeList.iterator();
    	 return iterEquipe;
     }
        
}
