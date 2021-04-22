package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainAppController implements Initializable{
	
	Parent fxml;

	@FXML private Button btnFormEvent;
    @FXML private Button btnFormPlante;
    @FXML private Button btnFormZone;
    @FXML private Button btnPlanning;
    @FXML private Button btnListeProjet;
    @FXML private Button btnListePlantes;
    @FXML private Button btnMeteo;
    @FXML private VBox Vbox;
    @FXML private Button btnListeEvents;
    

    

    
    @FXML void PageListeSuivis() throws IOException {
    	fxml = FXMLLoader.load(getClass().getResource("/views/PageListeSuivis.fxml"));
		this.Vbox.getChildren().removeAll();
		this.Vbox.getChildren().setAll(fxml);
    }
    
    @FXML void PageListePlantes() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageListePlantes.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML void PageListeEvents() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageListeEvents.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML void PageFormZone() { 
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageFormZone.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML void PagePlanning() { 
    
    }
    
    @FXML
    void FormSuivi() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageFormSuivi.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML
    void FormActivite() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageFormActivite.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    @FXML void PageFormEvent() { 
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageFormEvent.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }

    

    @FXML void PageFormPlante() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PageFormPlante.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
			
		} catch (IOException e) { e.printStackTrace(); }
    }	
    
    
	/**
	 * Appel la page d'ajout de mesure
	 * Ajout une mesure a liste des mesure
	 * @throws IOException 
	 */
    @FXML
    void FormMesure() throws IOException {
    	System.out.println("formMesure");
    	fxml = FXMLLoader.load(getClass().getResource("/views/PageFormAjouterMesure.fxml"));
    	//this.FormePlanteVbox.getChildren().removeAll();
		this.Vbox.getChildren().setAll(fxml);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
