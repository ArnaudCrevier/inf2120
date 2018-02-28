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
     * Ajoute un membre dans l'�quipe courante � la premi�re position vide.
     * 
     * Si le membre n'est pas null, il n'existe pas dans l'�quipe courante, il est ajout�
     * et la m�thode retourne vrai, sinon elle retourne faux. 
     *   
     * @param membre Le membre � ajouter
     * @return true si le membre n'est pas null, il n'existe pas dans l'�quipe et qu'il a 
     *         �t� ajout�, sinon false
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
     * Ajoute un membre dans l'�quipe courante � une position donn�e .
     * 
     * Si la position est dans le bon intervalle (position est sup�rieure ou �gale � 0 et inf�rieure 
     * ou �gale � la taille de l'�quipe courante), le membre n'est pas null, il n'existe pas 
     * dans l'�quipe courante, il est ajout� dans l'�quipe courante et la m�thode retourne vrai,
     * sinon elle retourne faux. Le membre doit �tre ajout� � la position identifi�e en d�pla�ant 
     * l'ancien membre � la position suivante. La position du premier membre de l'�quipe est 
     * consid�r� comme 0. 
     *   
     * @param position o� le membre doit �tre ajout�
     * @param membre Le membre � ajouter
     * @throws PositionException si la position n'est pas dans le bon intervalle 
     * @return true si la position est bonne, le membre n'est pas null, il n'existe pas dans l'�quipe et 
     *         qu'il est ajout�, sinon false
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
     * Ajoute les membres de l'�quipe pass�e en param�tre dans l'�quipe courante. Les membres sont
     * ajout�s aux prochaines positions vides de l'�quipe courante.
     * 
     * Tous les membres de l'�quipe pass�e en param�tre sont ajout�s dans l'�quipe courante et retourne 
     * un tableau liste des membres de l'�quipe pass�e en param�tre qui n'ont pas �t� ajout�s, car ils 
     * existent d�j�. 
     *   
     * @param equipe L'�quipe dont les membres doivent �tre ajout�s
     * @return Le tableau liste (ArrayList<T>) des membres de l'�quipe pass�e en param�tre qui n'ont pas 
     * �t� ajout�s, null si tous les membres ont �t� ajout�s ou si l'�quipe pass�e en param�tre est nulle 
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
     * Compare l'�quipe courante � celle pass�e en param�tre. 
     * 
     * Si l'�quipe courante contient tous les membres de celle pass�e en param�tre, la m�thode retourne 
     * null, sinon un tableau liste  (ArrayList<T>) est retourn� avec les membres de l'�quipe pass�e en
     * param�tre qui n'existent pas dans l'�quipe courante.
     *
     * @param equipe  L'�quipe � comparer � l'�quipe courante
     * @return null si l'�quipe courante contient tous les membres de l'�quipe pass�e en param�tre, 
     *         sinon un tableau liste (ArrayList<T>) des membres qui n'existent pas dans l'�quipe courante
     *         est retourn�
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
     * V�rifie si l'�quipe courante contient le membre pass� en param�tre.
     * 
     * Si l'�quipe courante contient le membre pass� en param�tre, la methode retourne 
     * vrai, sinon elle retourne faux.
     * 
     * @param membre Le membre dont l'existence doit �tre v�rifi�e
     * @return vrai si le membre existe, sinon faux
     */
     public boolean estMembre(T membre) {
    	 return equipeList.contains(membre);
     }
     
     /**
     * Retourne le nombre de membres de l'�quipe courante.
     * 
     * Le nombre total des membres dans l'�quipe courante doit �tre retourn�.
     * 
     * @return Le nombre total des membres de l'�quipe courante
     */
     public int nbMembres() {
    	  return equipeList.size();
      }      
    
    /**
     * Retire le membre pass� en param�tre de l'�quipe courante.
     * 
     * Le membre pass� en param�tre doit �tre retir� s'il existe dans l'�quipe courante.
     * 
     * @param le membre Le membre � retirer
     * @return vrai si le membre est retir�, sinon faux 
     */      
     public boolean retirer(T element) {
    	 return equipeList.remove(element);
     }
    
    /**
     * Retire tous les membres de l'�quipe pass�e en param�tre de l'�quipe courante.
     * 
     * Tous les membres de l'�quipe pass�e en param�tre doivent �tre retir�s de l'�quipe courante
     * s'ils existent.     
     *  
     * @param equipe L'�quipe dont les membres doivent �tre retir�s
     * @return Le tableau (ArrayList<T>) des membres de l'�quipe pass�e en param�tre qui n'ont 
     * pas �t� retir�s, null si tous les membres ont �t� retir�s ou si l'�quipe pass�e en param�tre
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
     * Remplace un membre par un autre dans l'�quipe courante. Le membre � remplacer doit 
     * exister et le nouveau membre ne doit pas �tre null. Aucun remplacement si l'�quipe
     * courante contient d�j� le nouveau membre.
     * 
     * @param membreARemplacer Le membre de l'�quipe courante � remplacer
     * @param nouveauMembre Le nouveau membre � ajouter
     * @return vrai si le remplacement a �t� fait, sinon faux
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
     * Retourne tous les membres de l'�quipe courante et leurs positions dans un HashMap<K,T>
     * (HashMap Cl� = position de type Integer, HashMap valeur = membre de type T). 
     *
     * @return Le HashMap de tous les membres de l'�quipe courante et leurs positions,
     * 		null, si l'�quipe courante est vide.
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
     * V�rifie si l'�quipe courante est vide.
     * 
     * @return vrai si l'�quipe courante est vide, sinon faux.
     */
     public boolean estVide() {
    	 return equipeList.isEmpty();
     }

    /**
     * Vide l'�quipe courante.
     */
     public void vider() {
    	 equipeList.clear();
     }
    
     /**
     * Retourne un it�rateur sur l'�quipe courante.
     *
     * @return Iterateur sur l'�quipe courante.
     */
     public Iterator<T> iterateur() {
    	 Iterator<T> iterEquipe = equipeList.iterator();
    	 return iterEquipe;
     }
        
}
