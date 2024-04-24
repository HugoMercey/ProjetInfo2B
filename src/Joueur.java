/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author hugo
 */
import java.awt.*; 
import javax.swing.*;


public class Joueur { 
    private String pseudo; 
    private Color couleur; 
    private double solde; 
    private ImageIcon photo;
    private LesCartes mesC;
    
    //accesseurs
    public String getPseudo() { //Fonction permettant d'avoir le pseudo que possède le Joueur
        return this.pseudo; 
    }
    public Color getCouleur() { //Fonction permettant d'avoir la couleur que possède le Joueur
        return this.couleur; 
    } 
    public double getSolde() { //Fonction permettant d'avoir le solde que possède le Joueur
        return this.solde; 
    } 
    public ImageIcon getPhoto() { //Fonction permettant d'avoir la photo de profil que possède le Joueur
        return this.photo;
    }
    public LesCartes getMesCartes(){ //Fonction permettant d'avoir les carte de lotos que possède le Joueur
        return this.mesC;
    }
    
    //setteurs
    public void setPseudo(String p) { 
        this.pseudo=p; 
    } 
    public void setCouleur(Color c) { 
        this.couleur = c; 
    } 
    public void setPhoto(ImageIcon p) { 
        this.photo = p; } 
    
    public void setSolde(double s) { 
        this.solde = s; 
    }
    
    
    public boolean acheter(CarteLoto c){ //Fonction permettant de savoir si le solde du Joueur permet d'acheter une carte de loto
        if(c.getPrix() <= this.getSolde()){
            this.mesC.ajouteCarte(c);
            return true;
        }else{
            return false;
        }
    }
    
    //constructeur par défaut
    public Joueur() {
        this.pseudo = "";
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/joueurDefaut.png"));
    }
    
    //constructeurs standards
    public Joueur(String p, int nbCartes) {
        this.pseudo = p;
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/joueurDefaut.png"));
    }
    public Joueur(String p) {
        this.pseudo = p;
        this.couleur=Color.gray;
        this.solde = 20;
        this.photo = new ImageIcon(getClass().getResource("/joueurDefaut.png"));
    }
    
    public String toString() { //Fonction permettant de connaitre les informations d'un joueurs sous forme écrite
        String res= "\nJoueur " + this.pseudo; res+= "\nCouleur " + this.couleur; res+= "\nSolde " + this.solde + "\nNombres de cartes possédées: " + mesC.getTaille();
        return res;
    } 
}
