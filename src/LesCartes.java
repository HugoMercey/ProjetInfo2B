/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author hugo
 */
public class LesCartes {
    private ArrayList<CarteLoto> lst; //attributs permettant de gérer plusieurs cartes de loto
    
    
    //constructeur par défaut
    public LesCartes(){
        initLesCartes(1, 9, 15);
    }
    
    //constructeur standard
    public LesCartes(int nbCartes, int nbCol, int nbVal){
        initLesCartes(nbCartes, nbCol, nbVal);
    }
    
    
    //accesseurs
    public int getTaille(){
        return this.lst.size();
    }
    public CarteLoto getCarte(int i){
        return this.lst.get(i);
    }
    
    
    public void ajouteCarte(CarteLoto c){ //Fonction permettant de rajouter une carte à la liste
        lst.add(c);
    }
    
    public void retireCarte(CarteLoto c){ //Fonction permettant d'enlever une carte de la liste
        lst.remove(c);
    }
    public void retireCarte(){ //Fonction permettant d'enlever toutes les cartes de la liste
        lst.removeAll(lst);
    }
    
    public LesCartes rechCartes(int num){ //Fonctions recherchant toutes les cartes contenants la valeur "num"
        LesCartes lc = new LesCartes(); //création d'une nouvelle collection de carte
        for(int i=0; i<this.getTaille(); i++){ //Parcours de toute les cartes de la première collection
            if(lst.get(i).estDans(num)){
                lc.ajouteCarte(lst.get(i)); //ajout de la carte à la deuxième collection si la valeur recherchée est dedans
            }
        }
        return lc; //renvoie de la collection de carte
    }
    
    public void initLesCartes(int n, int nbCol, int nbVal){  //Fonction initialisant les cartes de loto
        for(int i=0; i<n; i++){
            this.ajouteCarte(new CarteLoto(nbCol, nbVal));
        }
    }
}
