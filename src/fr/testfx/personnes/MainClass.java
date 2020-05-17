package fr.testfx.personnes;

import java.io.IOException;

import fr.testfx.personnes.model.Personne;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// private ObservableList<Personne> listDePersonne = FXCollections.observableArrayList();

public class MainClass extends Application {

//	listDePersonne.add(new Personne("Proviste", "Alain", LocalDate.of(1970, 1, 1), Sexe.MASCULIN));
//	listDePersonne.add(new Personne("D'Arc", "Jeanne", LocalDate.of(1431, 5, 30), Sexe.FEMININ));
//	listDePersonne.add(new Personne("Caisse", "Jean", LocalDate.of(1950, 3, 3), Sexe.MASCULIN));
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("Application de gestion de personnes");
		
		initialisationConteneurPrincipal();
		initialisationContenu();
	}

	private void initialisationConteneurPrincipal() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/ConteneurPrincipal.fxml"));
		try {
			conteneurPrincipal = (BorderPane) loader.load();
			Scene scene = new Scene(conteneurPrincipal);
			stagePrincipal.setScene(scene);
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/PersonView.fxml"));
		try {
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(conteneurPersonne);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
//	public ObservableList<Personne> getListDePersonne(){
//		return listDePersonne;
//		}
}
