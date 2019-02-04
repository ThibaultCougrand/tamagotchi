package tamagochi;

import java.util.Scanner;

/**
 *
 * @author thibault
 */
public class Tama {
    
        /**Atributs**/
    
    private String name;
    private int age;
    private String color;
    private String sex;
    
        /*Status*/
    
    private int faim = 0;
    private int fatigue = 0;
    private int poid = 0;
    private int proprete = 0;
    private int bonheur = 0;
    
        /*Getters,Setter*/
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getFaim() {
        return faim;
    }
    public void setFaim(int faim) {
        this.faim = faim;
    }
    public int getFatigue() {
        return fatigue;
    }
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
    public int getPoid() {
        return poid;
    }
    public void setPoid(int poid) {
        this.poid = poid;
    }
    public int getProprete() {
        return proprete;
    }
    public void setProprete(int proprete) {
        this.proprete = proprete;
    }
    public int getBonheur() {
        return bonheur;
    }
    public void setBonheur(int bonheur) {
        this.bonheur = bonheur;
    }
    
        /**Methodes du tamagotchi**/
    
        /*Naissance*/
    
    /**
     * permet de faire éclore un nouveau tamagochi va définir une couleur et un sex et
     * initialiser son age. va enssuite vous demander de lui donner un nom.
     */
    public void eclore() {
        Scanner sc        = new Scanner(System.in);
        boolean verifName = true;
        age = 1;
        selectColor();
        selectSex();
        System.out.println("Félicitation votre nouveau né est " + sex + " de couleur " + color + ".");
        while (verifName) {
            System.out.println("Comment souhaitez vous l'appeler ?");
            name = sc.nextLine();
            String reponse = ouiNon("Etes vous sur de vouloir l'appeler " + name + " ?");
            if (reponse.equals("oui")) {
                verifName = false;
            }
        }
    }
    /**
     * Choisi la couleur de votre tamagotchi.
     * @return la couleur.
     */
    public String selectColor() {
        int randColor = (int) (Math.random() * 3);
        switch (randColor) {
            case 0 : color = "bleu";
            break;
            case 1 : color = "noir";
            break;
            case 2 : color = "blanc";
            break;
            case 3 : color = "rouge";
            break;
        }
        return color;
    }
    /**
     * Choisi le sexe de votre tamagotchi
     * @return le sexe.
     */
    public String selectSex() {
        int selectSex   = (int) (Math.random()*2);
        switch (selectSex) {
            case 0 : sex = "un male";
            break;
            case 1 : sex = "une femelle";
            break;
        }
        return sex;
    }
    
        /*Activitées*/
    
    /**
     * Methode qui permet de choisir une activité à faire au tamagotchi
     */
    void choixActivitees() {
        Scanner sc    = new Scanner(System.in);
        boolean verif = true;
        while (verif) {
            System.out.println("Que voulez vous faire avec "+name+" ?\n"
                              + "Voici les choix : manger, sport, douche, jeux, dormir.");
            String saisie = sc.nextLine().toLowerCase();
            switch (saisie) {
                case "manger" : manger(); verif = false;
                break;
                case "sport" : sport(); verif = false;
                break;
                case "douche" : douche(); verif = false;
                break;
                case "jeux" : jeux(); verif = false;
                break;
                case "dormir" : dormir(); verif = false;
                break;
                default : System.out.println("Votre saisie n'est pas bonne.");
                break;
            }
        }
    }
    /**
     * Fait manger le tamagotchi et ajuste ces stats.
     */
    public void manger() {
        choixManger();
        faim--;
        poid++;
        bonheur++;
    }
    /**
     * 
     */
    public void choixManger() {
        
    }
    /**
     * Fait faire du sport au tamagotchi et ajuste ces stats.
     */
    public void sport() {
        choixSport();
        faim++;
        fatigue++;
        poid--;
        proprete--;
        bonheur--;
    }
    public void choixSport() {
        
    }
    /**
     * Fait prendre la douche au tamagotchi et ajuste ces stats.
     */
    public void douche() {
        System.out.println(name+" a pris une bonne douche chaude");
        proprete++;
        bonheur--;
    }
    /**
     * Fait jouer le tamagotchi et ajuste ces stats.
     */
    public void jeux() {
        choixJeux();
        fatigue++;
        proprete--;
        bonheur++;
    }
    /**
     * 
     */
    public void choixJeux() {
        
    }
    /**
     * Fait dormir le tamagotchi et ajuste ces stats.
     */
    public void dormir() {
        System.out.println(name+" a bien dormi, il est temps pour "+ilElle()+" de commencer une nouvelle journée.");
        fatigue = 0;
        faim+=2;
    }
    
        /*Fin de tour*/
    
    /**
     * Actions se déroulant au bout de 3min de jeu.
     */
    public void finDeTour() {
        System.out.println("Il commence à se faire tard, ça va être l'heure pour "+name+" d'aller se coucher.");
        fatigue = 4;
    }

        /*Affichage*/
    
    /**
     * Methode qui affiche l'état de tous les status du tamagotchi
     */
    public void afficheStatus() {
        System.out.println("Voici l'etat de " + name);
        afficheFaim();
        afficheFatigue();
        affichePoid();
        afficheProprete();
        afficheBonheur();
    }
    /**
     * Methode qui affiche l'etat de faim du tamagotchi.
     */
    public void afficheFaim() {
        switch (faim) {
            case 0 : System.out.println(ilElle() + " n'a pas particulièrement faim.");
            break;
            case 1 :case 2 : System.out.println(ilElle() + " a faim.");
            break;
            case 3 :case 4 : System.out.println(ilElle() + " a vraiment très faim.");
            break;
            case -1 : System.out.println(ilElle()+" a bien mangé.");
            break;
            case -2 : System.out.println(ilElle() + " a trop mangé.");
            break;
            case -3 :case -4 : System.out.println(ilElle() + " a vraiment trop mangé.");
            break;
        }
    }
    /**
     * Methode qui affiche l'etat de fatigue du tamagotchi.
     */
    public void afficheFatigue() {
        switch (fatigue) {
            case 0 :case 1 : System.out.println(ilElle() + " est en forme.");
            break;
            case 2 :case 3 : System.out.println(ilElle() + " est fatigué.");
            break;
            case 4 : System.out.println("Attention " + name + " est très fatigué.");
            break;
        }
    }
    /**
     * Methode qui affiche l'etat de poid du tamagotchi.
     */
    public void affichePoid() {
        switch (poid) {
            case -2 :case -1 :case 0 :case 1 :case 2 : System.out.println(ilElle() + " a la ligne.");
            break;
            case 3 :case 4 : System.out.println("C'est pas bien de traiter les gens de gros mais " + name + " ...");
            break;
            case -3 :case -4 : System.out.println(ilElle() + " commence à être trop maigre, il faut penser à le nourir.");
            break;
        }  
    }
    /**
     * Methode qui affiche l'etat de proprete du tamagotchi.
     */
    public void afficheProprete() {
        switch (proprete) {
            case 0 :case 1 : System.out.println(ilElle() + " est propre.");
            break;
            case 2 :case 3 : case 4: System.out.println("Vous voulez qu'"+ilElle()+" brille ou quoi ?");
            break;
            case -1 :case -2 : System.out.println(ilElle() + " commence à être un peu sale.");
            break;
            case -3 :case -4 : System.out.println("Une odeur pestilentiel se dégage de " + name);
            break;
        }
    }
    /**
     * Methode qui affiche l'etat de bonheur du tamagotchi.
     */
    public void afficheBonheur() {
        switch (bonheur) {
            case 0 :case 1 : System.out.println(ilElle() + " va bien.");
            break;
            case 2 :case 3 : System.out.println(ilElle() + " est vraiment content");
            break;
            case 4: System.out.println(ilElle()+" est très très content mais attention son petit coeur palpite.");
            break;
            case -1 :case -2 : System.out.println(ilElle() + " commence à se sentir triste, donnez lui un peu d'attention.");
            break;
            case -3 :case -4 : System.out.println(ilElle() + " est vraiment déprimé, va faloir lui donner son prozac");
        }
    }

        /*Morts*/
    
    /**
     * Methode qui verifie toutes les façons dont le tamagotchi peut mourir.
     * @param mort boolean qui passe à vrai si le tamagotchi est mort.
     * @return le boolean après les checks.
     */
    public boolean checkMort(boolean mort) {
        if (checkMortFaim(mort) == true || checkMortFatigue(mort) == true || checkMortPoid(mort) == true || checkMortProprete(mort) == true || checkMortBonheur(mort) == true ) {
            mort = true;
        }  
        return mort;
    }
    /**
     * Methode qui fait mourir de faim le tamagotchi.
     * @param mort le boolean qui arrète le jeu si le tamagotchi est mort.
     * @return le même boolean qui est pris en paramètre.
     */
    public boolean checkMortFaim(boolean mort) {
        switch (faim) {
            case 5: case -5: mort = true;
        }
        return mort;
    }
    /**
     * Methode qui fait mourir de fatigue le tamagotchi.
     * @param mort le boolean qui arrète le jeu si le tamagotchi est mort.
     * @return le même boolean qui est pris en paramètre.
     */
    public boolean checkMortFatigue(boolean mort) {
        switch (fatigue) {
            case 5: mort = true;
        }
        return mort;
    }
    /**
     * Methode qui fait mourir le tamagotchi à cause de son poid.
     * @param mort le boolean qui arrète le jeu si le tamagotchi est mort.
     * @return le même boolean qui est pris en paramètre.
     */
    public boolean checkMortPoid(boolean mort) {
        switch (poid) {
            case 5: case -5: mort = true;
        }
        return mort;
    }
    /**
     * Methode qui fait mourir le tamagotchi à cause de son igiène.
     * @param mort le boolean qui arrète le jeu si le tamagotchi est mort.
     * @return le même boolean qui est pris en paramètre.
     */
    public boolean checkMortProprete(boolean mort) {
        switch (proprete) {
            case 5: case -5: mort = true;
        }
        return mort;
    }
    /**
     * Methode qui fait mourir de malheur le tamagotchi.
     * @param mort le boolean qui arrète le jeu si le tamagotchi est mort.
     * @return le même boolean qui est pris en paramètre.
     */
    public boolean checkMortBonheur(boolean mort) {
        switch (bonheur) {
            case 5: case -5: mort = true;
        }
        return mort;
    }
    
        /*Autres*/
    
    /**
     * Methode qui permet de proposer à l'utilisateur de choisir entre oui et non.
     *
     * @param phrase phrase à l'aquelle répondre oui ou non.
     * @return retour du oui ou non sous forme de String.
     */
    public static String ouiNon(String phrase) {
        Scanner sc = new Scanner(System.in);
        boolean verifOuiNon = true;
        String choix = "";
        System.out.println(phrase);
        while (verifOuiNon) {
            System.out.println("Saisissez 'oui' ou 'non'.");
            choix = sc.nextLine().toLowerCase();
            if (choix.equals("oui") || choix.equals("non")) {
                verifOuiNon = false;
            } else {
                System.out.println("Votre saisi n'est pas valide.");
            }
        }
        return choix;
    }
    /**
     * Methode pour afficher il ou elle suivant si c'est un mâle ou une femelle.
     * @return il ou elle sous forme de string.
     */
    public String ilElle() {
        String genre = "";
        if (sex.equals("une femelle")) {
            genre = "Elle";
        } else {
            genre = "Il";
        }
        return genre;
    }
}