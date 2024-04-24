

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hugo
 */
public class CarteLoto {
    private int tab[][];
    private int jetons[][]; 
    private int nbCol;
    private int nbLig;
    private int nbNumeros; 
    private double prix;
    private final int valMax=90;
    
    //constructeur par défaut
    public CarteLoto(){
        this.nbNumeros=15;
        this.nbCol = 9;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol]; 
        this.jetons = new int[nbLig][nbCol]; 
        this.prix=5;
        initValeursCarte();
    }
    //constructeur standard
    public CarteLoto(int nbc, int nbVal) { 
        this.nbNumeros =nbVal;
        this.nbCol = nbc;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol]; 
        this.jetons = new int[nbLig][nbCol]; 
        this.prix=5;
        initValeursCarte();
    }
    
    //accesseurs
    public double getPrix() { 
        return this.prix; 
    }
    public double getNbCarte(){
        return this.nbNumeros;
    }
    public double getNbLigne(){
        return this.nbLig;
    }
    public double getNbColonne(){
        return this.nbCol;
    }
    public int getVal(int lig, int col){ //Fonction renvoyant la valeur se trouvant aux coordonées (lig, col)
        return this.tab[lig][col];
    }
    
    
    public String toString() { //Fonction renvoyant la carte de Loto sous forme de texte
        String res="";
        for(int i=0; i<this.nbLig; i++) { //parcours de toute les lignes du tableau
            for(int j=0; j<this.nbCol; j++){ //parcours de chaque case de la ligne
                if(tab[i][j]>=10){ //Si la case de coordonnée (i, j) n'est pas vide:
                    res+=" " +tab[i][j]; res+="\n";
                }else{ //Si la case est vide
                    res+="  "+tab[i][j]; res+="\n";
                }
            }
        }
        return res; 
    }


    public boolean estDans(int val) {  //Fonction vérifiant si une valeur val se trouve ou non dans cette carte de loto
        boolean res=false;
        for(int i=0; i<this.nbLig; i++){ //parcours de toute les lignes du tableau
            for(int j=0; j<this.nbCol; j++){ //parcours de chaque case de la ligne
                if (tab[i][j]==val){
                    res=true;
                }
            }
        }
        return res;       
    }
    
    
    public void initValeursCarte() { //Fonction permettant de créer une carte de loto de façon aléatoire
        int choixRandomNum;
        int choixRandomCase;
        tab = new int[this.nbCol][this.nbLig]; //Instanciation du tableau qui va contenir toute les valeurs
        //Création de deux tableau
        int nbCase[] = new int[this.nbCol*this.nbLig]; //Ce tableau contiendra le numéro de la case qui va être choisie
        int num[] = new int[90]; //Ce tableau contiendra la valeur de la case qui va être choisie.
        //Remplissage de ces deux tableaux
        for(int i=0; i<nbCase.length; i++){
            nbCase[i] = i+1;
        }
        for(int i=0; i<num.length; i++){
            num[i] = i+1;
        }
        
        for(int i=0; i<this.nbNumeros; i++){ //Répété le même nombre de fois qu'il y a des case non vides sur la carte de Loto
            do{
                choixRandomNum = (int)(Math.random())*num.length + 1;
            }while(num[choixRandomNum]==0); //tant que la valeur séléctionnée n'a pas déjà été choisie, on en regénère une autre aléatoirement
            
            do{
                choixRandomCase = (int)(Math.random())*nbCase.length + 1;
            }while(nbCase[choixRandomCase]==0); //tant que la case séléctionnée n'a pas déjà été choisie, on en regénère une autre aléatoirement
            
            nbCase[choixRandomCase] = 0; //Ceci signifie que cette case à déjà été choisie
            num[choixRandomNum] = 0; //Ceci signifie que cette valeur à déà été choisie
            
            int col = choixRandomCase/this.nbCol;
            int lig = choixRandomCase%this.nbCol;
            
            tab[col][lig] = choixRandomNum; //Assignation de la valeur choisie à la case choisie
        }
        
    }
    
    public boolean placePion(int val) { //Fonction servant à placer un pion sur une case à partir d'une certaine valeur
        boolean res=false;
        for(int i=0; i<this.nbLig; i++) for(int j=0; j<this.nbCol; j++){
            if (tab[i][j]==val){
                res=true; 
                jetons[i][j]=val;
            } 
        }
        return res;
    }

    public boolean estLignePleine(int lig) { //Fonction vérifiant qu'une ligne entière est pleine
        boolean res=true;
        for(int j=0; j<this.nbCol; j++){
            if (jetons[lig][j]!=tab[lig][j]){
                res=false;
            }
        }
        return res; 
    }
    
    
    public int getNbLignesPleines () { //Fonction servant à compter le nombre de ligne pleine sur une carte de loto
        int nbPleine = 0;
        for(int i=0; i<this.nbLig; i++){
            if(this.estLignePleine(i)){
                nbPleine+=1;
            }
        }
        return nbPleine;
    }
    
    
    public boolean cartonGagnant(int option) { //Fonction servant à dire si le carton est gagnant en fonction de si on joue en Quine, Double Quine ou en Carton Plein
        boolean res=false;
        switch (option){
            case 1 : res=getNbLignesPleines ( )==1 ;break;
            case 2 : res= getNbLignesPleines( )==2;break;
            case 3 : res= getNbLignesPleines( )==3; 
        }
        return res; 
    }
}
