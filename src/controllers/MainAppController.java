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
    @FXML private Button btnListeSuivis;
    @FXML private VBox Vbox;
    
    @FXML void PageFormZone() { }
    @FXML void PageListePlantes() { }
    @FXML void PageListeProjet() { }
    @FXML void PageListeSuivis() { }
    @FXML void PageMeteo() { }
    @FXML void PagePlanning() { }
    @FXML void PageFormEvent() { }

    

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
