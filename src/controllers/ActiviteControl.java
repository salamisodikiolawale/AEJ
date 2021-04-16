package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.Activites;

public class ActiviteControl implements Initializable{


	@FXML
	    private TextField txtAjouterActiviter;
	 
	 @SuppressWarnings("unchecked")
		@FXML
	 void AjouterActivite() throws IOException, ParseException {
	 	JSONArray activite = ReadWriteFileJson.readerFileJson("Activites");
			JSONObject actJsonObj = new JSONObject();
			Activites act= new Activites();
			actJsonObj.put("IdAct", act.getLastId()+1);
			actJsonObj.put("libelle", txtAjouterActiviter.getText());
			activite.add(actJsonObj);
			ReadWriteFileJson.writeFileJson("Activites", activite);
			ReadWriteFileJson.showAlertWithHeaderText("Ajout d'activité", "Votre activité a été ajoutée avec succès");
			txtAjouterActiviter.setText("");
			txtAjouterActiviter.setPromptText("Ex: Arosage");
	 }
	
	 @FXML
	 void AnnlerAjouter() {
	
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
