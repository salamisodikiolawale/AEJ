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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import models.Activites;
import models.Events;
import models.Plantes;

public class EventControl implements Initializable{
	
	

	    @FXML
	    private ComboBox<String> listeActivite;

	    @FXML
	    private TextArea txtAreaNote;

	    @FXML
	    private Button btnAjouterAcvt;

	    @FXML
	    private Label lbAjout;

	    @FXML
	    private DatePicker datePicker;

	    @FXML
	    private Button btnAnnuler;

	    @FXML
	    private Button btnEnregistrer;

	    @FXML
	    private ComboBox<String> listePlante;
	    
	    @FXML
	    private Button btnAnnlerAjouter;
//	    
//	    @FXML
//	    private RadioButton radioPonctuel;
//
//	    @FXML
//	    private RadioButton radioRecccurent;
	    
	    @FXML
	    private ComboBox<String> listeTypeEvent;
	    
	    

		@SuppressWarnings("unchecked")
		@FXML
	    void Enregistrer() throws IOException, ParseException {
	    	Events event = new Events();
	    	event.setId(event.getLastId()+1);
	    	event.setActivite(listeActivite.getValue());
	    	event.setDate(datePicker.getValue().toString());
	    	event.setNote(txtAreaNote.getText());
	    	event.setTypeEvent(listeTypeEvent.getValue());
	    
	    	 
	    	if(listePlante.getValue()!=null) {
	    		JSONArray eventsPlantes = ReadWriteFileJson.readerFileJson("EventsPlantes");
	    		JSONObject eventP = new JSONObject();
	    		eventP.put("IdEvent", event.getId());
	    		Plantes pl= new Plantes();
	    		eventP.put("IdPlantes", pl.getId(listePlante.getValue()));
	    		
	    		eventsPlantes.add(eventP);
	    		ReadWriteFileJson.writeFileJson("EventsPlantes", eventsPlantes);
	    	}
	    	
			JSONArray liste_events = ReadWriteFileJson.readerFileJson("Events");
			liste_events.add(event.tranformEventToObjectJson());
			ReadWriteFileJson.writeFileJson("Events", liste_events);
			ReadWriteFileJson.showAlertWithHeaderText("Création de l'évènement", "Votre évènement a bien été enregistrer");
	    	
	    }
	    
	    

	

	 
	    
		@SuppressWarnings({ "unchecked", "unused" })
		private void remplirCombListActivite() throws IOException, ParseException {
	    	Activites act = new Activites();
	    	JSONArray jsonArray = act.activiteList();
	    	ObservableList<String> FxclActivite = FXCollections.observableArrayList();
	    	jsonArray.forEach(json -> {
	    		JSONObject js = (JSONObject) json;
	    		FxclActivite.add((String) js.get("libelle"));
	    	});
	    	listeActivite.setItems(FxclActivite);
	    }
	    
	    @SuppressWarnings({ "unused", "unchecked" })
		private void remplirCombListPlante() throws IOException, ParseException {
	    	Plantes  pl = new Plantes();
	    	JSONArray jsonArray  = (JSONArray) pl.getPlanteList();
	    	//System.out.println(jsonArray);
	    	ObservableList<String> FxclActivite = FXCollections.observableArrayList();
	    	jsonArray.forEach(json -> {
	    		JSONObject js = (JSONObject) json;
	    		//System.out.println(js.get("Activite"));
	    		FxclActivite.add((String) js.get("Nom"));
	    	});
	    	listePlante.setItems(FxclActivite);
	    }
	    
	    @SuppressWarnings({ "unused", "unchecked" })
	  		private void remplirCombTypeEvent() throws IOException, ParseException {
	  	    	ObservableList<String> FxclActivite = FXCollections.observableArrayList();
	  	    	FxclActivite.add("Ponctuel");
	  	    	FxclActivite.add("Reccurent");
	  	    	listeTypeEvent.setItems(FxclActivite);
	  	    }
	    
	    
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			remplirCombListActivite();
			remplirCombListPlante();
			remplirCombTypeEvent();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
