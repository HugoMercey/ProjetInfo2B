
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hugo
 */
public class LesJoueurs {
        private ArrayList<Joueur> lstJ; //attribut permettant de gérer plusieurs Joueurs
        

        //constructeur par défaut
        public LesJoueurs(){
            lstJ = new ArrayList<Joueur>(); //instaciation de l'attribut lstJ
        }
        
        public Joueur getJoueur(int i){ //Fonction permettant de récupér le i-ème joueur
            if(i<this.getNbJoueur()){ //Si le rang demandé n'est pas plus grand que la liste de Joueur
                return this.lstJ.get(i); //On renvoie le joueur
            }else{
                return null; //Sinon, on ne renvoie qu'une coquille vide
            }
        }
        
        public int getNbJoueur(){ //Fonction permettant de savoir le nombre de Joueur contenu dans la liste
            return this.lstJ.size();
        }
        
        public void ajoutJoueur(Joueur j){ //Fonction permettant de rajouter un Joueur à la liste
            this.lstJ.add(j);
        }
        
        public void supprimeJoueur(Joueur j){ //Fonction permettant de supprimer un Joueur de la liste
            this.lstJ.remove(j);
        }
        
        public Joueur rechercheJoueur(String ps){ //Fonction permettant de rechercher un joueur dans la liste grâce à son pseudo
            for(int i=0; i<lstJ.size(); i++){
                if(lstJ.get(i).getPseudo() == ps){
                    return lstJ.get(i);
                }
            }
            return null;
        }
        
        public String toString(){ //Fonction permettant de connaitre les informations des joueurs sous forme écrite
            String res = "";
            for(int i=0; i<lstJ.size(); i++){
                res += lstJ.get(i).toString() + "\n";
            }
            return res;
        }
}
