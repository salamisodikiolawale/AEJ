package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class AjouterMesureController implements Initializable{

	
	@FXML private AnchorPane anchor;
    @FXML private Label lbTitle;
    @FXML private Button btnAjouter;
    @FXML private Button btnAnnuler;
    @FXML private TextField txtUnite;
    @FXML private ComboBox<String> cbLibelle;
    Parent fxml;

    @SuppressWarnings("unchecked")
	@FXML
    void Ajouter() throws IOException, ParseException {
    	
		JSONArray UnitesArray = ReadWriteFileJson.readerFileJson("Unites");
    	if(this.cbLibelle.getValue() != null && this.txtUnite.getText()!="") {
    		JSONObject jsonObj = new JSONObject();
    		
    		if(this.cbLibelle.getValue() == "Poids") {
    			jsonObj.put("Poids", txtUnite.getText());
    			UnitesArray.add(jsonObj);
    			ReadWriteFileJson.writeFileJson("Unites", UnitesArray);
    		}
    		else {
    			jsonObj.put("UniteHauteurLargeur", txtUnite.getText());
    			UnitesArray.add(jsonObj);
    			ReadWriteFileJson.writeFileJson("Unites", UnitesArray);
    		}
    		fxml = FXMLLoader.load(getClass().getResource("/views/PagePlante.fxml"));
        	showAlertWithHeaderText("Ajout Unité", "L\'unité de mesure à bien été ajouter");
        	Annuler();
    	}else {
    		showAlertWithHeaderText("Champs Obligatoires", "Libéllé et la valeur de l\'unité");
    	}
    	
    	
    	
    }
    
    private void showAlertWithHeaderText(String title, String msg) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("");
        alert.setContentText(msg);
 
        alert.showAndWait();
    }

	@FXML void Annuler() {
		cbLibelle.setPromptText("Choix Libéllé");
		txtUnite.setText("");
		txtUnite.setPromptText("Ex : cm");
	}
    
	private void remplirCombo() {
    	ObservableList<String> FxObs = FXCollections.observableArrayList();
    	FxObs.add("Poids");
    	FxObs.add("Autres");
    	this.cbLibelle.setItems(FxObs);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		remplirCombo();
	}

}
