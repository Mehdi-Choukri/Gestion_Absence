package sample.domainClasses;

import java.util.Calendar;

public class Apprenant extends Utilisateur {
    private String cne;
    private String promotion;
    private String nomTuteur;
    private String prenomTuteur;
    private int niveau;
    private String groupe;
    private int nivDroit;
    //

    public Apprenant(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, String cne, String promotion, String nomTuteur, String prenomTuteur, int niveau, String groupe, int nivDroit) {
        super(cin, nom, prenom, dateNaissance, user, password);
        this.cne = cne;
        this.promotion = promotion;
        this.nomTuteur = nomTuteur;
        this.prenomTuteur = prenomTuteur;
        this.niveau = niveau;
        this.groupe = groupe;
        this.nivDroit = nivDroit;
    }
    //

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getNomTuteur() {
        return nomTuteur;
    }

    public void setNomTuteur(String nomTuteur) {
        this.nomTuteur = nomTuteur;
    }

    public String getPrenomTuteur() {
        return prenomTuteur;
    }

    public void setPrenomTuteur(String prenomTuteur) {
        this.prenomTuteur = prenomTuteur;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public int getNivDroit() {
        return nivDroit;
    }

    public void setNivDroit(int nivDroit) {
        this.nivDroit = nivDroit;
    }

    @Override
    int getRole() {
        return this.nivDroit;
    }
}