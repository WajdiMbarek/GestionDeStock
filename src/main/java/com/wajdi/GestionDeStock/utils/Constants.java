package com.wajdi.GestionDeStock.utils;

public interface Constants {
    String APP_ROOT = "gestiondestock/v1";

    //Commande Fournisseur API Constant
    String COMMANDE_FOURNISSEUR_END_POINT = APP_ROOT + "/commandesfournisseurs";
    String CREATE_COMMANDE_FOURNISSEUR_END_POINT = COMMANDE_FOURNISSEUR_END_POINT + "/create";
    String FIND_COMMANDE_FOURNISSEUR_BY_ID_END_POINT = COMMANDE_FOURNISSEUR_END_POINT + "/{idCommandeFournisseur}";
    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_END_POINT = COMMANDE_FOURNISSEUR_END_POINT + "/{codeCommandeFournisseur}";
    String FIND_ALL_COMMANDE_FOURNISSEUR_END_POINT = COMMANDE_FOURNISSEUR_END_POINT + "/all";
    String DELETE_COMMANDE_FOURNISSEUR_BY_ID_END_POINT = COMMANDE_FOURNISSEUR_END_POINT + "/delete/{idCommandeFournisseur}";

    // ENTREPRISE API CONSTANT
    String ENTREPRISE_END_POINT = APP_ROOT + "/entreprises";
    String CREATE_ENTREPRISE_END_POINT = ENTREPRISE_END_POINT + "/create";
    String FIND_ENTREPRISE_BY_ID_END_POINT = ENTREPRISE_END_POINT + "/{idEntreprise}";
    String FIND_ALL_ENTREPRISE_END_POINT = ENTREPRISE_END_POINT + "/all";
    String DELETE_ENTREPRISE_BY_ID_END_POINT = ENTREPRISE_END_POINT + "/delete/{idEntreprise}";

    // Fournisseur APi Constant
    String FOURNISSEUR_END_POINT = APP_ROOT + "/fournisseurs";
    String CREATE_FOURNISSEUR_END_POINT = FOURNISSEUR_END_POINT + "/create";
    String FIND_FOURNISSEUR_BY_ID_END_POINT = FOURNISSEUR_END_POINT + "/{idFournisseur}";
    String FIND_FOURNISSEUR_BY_NOM_END_POINT = FOURNISSEUR_END_POINT + "/{nomFournisseur}";
    String FIND_FOURNISSEUR_BY_PRENOM_END_POINT = FOURNISSEUR_END_POINT + "/{prenomFournisseur}";
    String FIND_ALL_FOURNISSEUR_END_POINT = FOURNISSEUR_END_POINT + "/all";
    String DELETE_FOURNISSEUR_BY_ID_END_POINT = FOURNISSEUR_END_POINT + "/delete/{idFournisseur}";

    //Utilisateur APi Constant

    String UTILISATEUR_END_POINT = APP_ROOT + "/utilisateurs";
    String CREATE_UTILISATEUR_END_POINT = UTILISATEUR_END_POINT + "/create";
    String FIND_UTILISATEUR_BY_ID_END_POINT = UTILISATEUR_END_POINT + "/{idUtilisateur}";
    String FIND_UTILISATEUR_BY_NOM_END_POINT = UTILISATEUR_END_POINT + "/{nomUtilisateur}";
    String FIND_UTILISATEUR_BY_PRENOM_END_POINT = UTILISATEUR_END_POINT + "/{prenomUtilisateur}";
    String FIND_ALL_UTILISATEUR_END_POINT = UTILISATEUR_END_POINT + "/all";
    String DELETE_UTILISATEUR_BY_ID_END_POINT = UTILISATEUR_END_POINT + "/delete/{idUtilisateur}";

    // Vente Api constant
    String VENTE_END_POINT = APP_ROOT + "/ventes";
    String CREATE_VENTE_END_POINT = VENTE_END_POINT + "/create";
    String FIND_VENTE_BY_ID_END_POINT = VENTE_END_POINT + "/{idVente}";
    String FIND_VENTE_BY_CODE_END_POINT = VENTE_END_POINT + "/{codeVente}";
    String FIND_ALL_VENTE_END_POINT = VENTE_END_POINT + "/all";
    String DELETE_VENTE_BY_ID_END_POINT = VENTE_END_POINT + "/delete/{idVente}";
}
