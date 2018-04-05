package javafxcalculette;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author nico
 */
public class calculetteController {

    @FXML
    TextField affichage;

    private int operande;

    private String operateur;

    public void onClick(ActionEvent event) {

        //Récupération 
        Button boutonClic = (Button) event.getSource();

        //Test
        //System.out.println(boutonClic.getText());
        //Texte du bouton cliqué
        String boutonText = boutonClic.getText();

        //Affichage existant
        String affichageExistant = affichage.getText();

        //Mise à jour de l'affichage
        affichage.setText(affichageExistant + boutonText);
    }

    public void onClicOperateur(ActionEvent event) {

        //Mémorisation de l'opérande
        operande = Integer.valueOf(affichage.getText());

        //Mémorisation de l'opérateur
        //Récupérateur d'une référence au bouton cliqué
        Button boutonClic = (Button) event.getSource();

        //Texte du bouton cliqué
        String boutonText = boutonClic.getText();
        operateur = boutonText;

        //Mise à zéro de l'affichage
        affichage.setText("");
    }

    public void onCalcul(ActionEvent event) {
        
        if (operateur.equals("+")) {
            //Calcul
            int resultat = operande + Integer.valueOf(affichage.getText());
            //Mise à zéro de l'opérateur et de l'opérande
            operateur = null;
            operande = 0;
            //Affichage du résultat
            affichage.setText(String.valueOf(resultat));
        } else if (operateur.equals("-")) {
            int resultat = operande - Integer.valueOf(affichage.getText());
            operateur = null;
            operande = 0;
            affichage.setText(String.valueOf(resultat));
        } else if (operateur.equals("*")) {
            int resultat = operande * Integer.valueOf(affichage.getText());
            operateur = null;
            operande = 0;
            affichage.setText(String.valueOf(resultat));
        } else if (operateur.equals("/")) {
            try {
                int resultat = operande / Integer.valueOf(affichage.getText());
                operateur = null;
                operande = 0;
                affichage.setText(String.valueOf(resultat));
            } catch (ArithmeticException e) {
                affichage.setText("Erreur");
            }
        }
    }

    public void onClear(ActionEvent event) {

        //Mise à zéro de l'affichage
        affichage.setText("");
    }
}
