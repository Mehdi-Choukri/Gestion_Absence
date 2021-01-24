package interfaces.formateur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import sample.daoAPI.AdministrateurDao;
import sample.daoAPI.ApprenantDao;
import sample.domainClasses.Apprenant;
import sample.helpers.Session;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class GestionAbsense implements Initializable {
    private ArrayList<Apprenant> list_apprenants = new ArrayList<>();
    private ArrayList<Pane> components_apprenants = new ArrayList<>();
    //
    private ArrayList<Pane> selected_apprenants = new ArrayList<>();
    //
    @FXML
    HBox cont_apprenants;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayLearners();
    }

    //
    private void displayLearners() {
        try {
            list_apprenants.clear();
            components_apprenants.clear();
            cont_apprenants.getChildren().clear();
            //
            ApprenantDao apprenantDao = new ApprenantDao();
            list_apprenants = apprenantDao.getAllByFormateur(Session.cin);
            if (list_apprenants != null) {
                if (list_apprenants.size() > 0) {
                    for (Apprenant apprenant : list_apprenants) {
                        cont_apprenants.getChildren().add(make_apprenant(apprenant));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Pane make_apprenant(Apprenant apprenant) {
        Pane container = new Pane();
        container.getStyleClass().add("apprenant_card");
        //
        //
        VBox cont_data = new VBox();
        cont_data.getStyleClass().add("inner_cont");
        //
        Label nom = new Label(String.format("%s %s", apprenant.getNom(), apprenant.getPrenom()));
        nom.getStyleClass().add("nom");
        Label cne = new Label(apprenant.getCne());
        Label grp_niv = new Label(String.format("Groupe: %s | Niveau: %s", apprenant.getGroupe(), apprenant.getNiveau()));
        //
        cont_data.getChildren().addAll(nom, cne, grp_niv);
        //
        //
        Circle indicator = new Circle();
        indicator.setRadius(10);
        indicator.getStyleClass().add("indicator");
        //
        container.getChildren().addAll(cont_data, indicator);
        //
        container.setOnMouseClicked(e -> {
            if (container.getStyleClass().contains("apprenant_card_active")) {
                selected_apprenants.remove(container);
                container.getStyleClass().remove("apprenant_card_active");
            }
            else {
                container.getStyleClass().add("apprenant_card_active");
                selected_apprenants.add(container);
            }
        });
        //
        components_apprenants.add(container);
        return container;
    }
}