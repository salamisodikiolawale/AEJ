package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Events;
import models.EventsPlantes;
import models.Plantes;

public class ListeEventControl implements Initializable{

	 
		@FXML
	    private VBox Vbox;
		
		@FXML
		private TableView<EventsPlantes> TabView;

	    @FXML
	    private TableColumn<EventsPlantes, Integer> idTabView;

	    @FXML
	    private TableColumn<EventsPlantes, String> PlanteTabView;

	    @FXML
	    private TableColumn<EventsPlantes, String> ActiviteTabView;

	    @FXML
	    private TableColumn<EventsPlantes, String> dateTabView;

	    @FXML
	    private TableColumn<EventsPlantes, String> noteTabView;
	    @FXML
	    private TableColumn<EventsPlantes, String> TypeEventView;
	    
	    
	    
	private Plantes plantes = new Plantes();
	private Events event = new Events();
	private EventsPlantes eventsPlantes;
	
	int IdEvent;
	String Activite;
	String DateEvent;
	String NoteEvent;
	String TypeEvent;
	
	String idP;
	String nomPlante;
	String varietePlante;
	String couleurPlante;
	String notePlante;
	String datePlante;
	String url;
	JSONObject jsonMesure;
	Double hauteur;
	Double largeur;
	Double poids;
	 
	    
	    
//	ArrayList<Object[]> listEventPlante = new ArrayList<Object[]>();
//	Object[] tabEventPlante;
//	    	
//	    
//		@SuppressWarnings({ "unchecked", "static-access", "unused" })
//		private ArrayList<Object[]> getData() throws IOException, ParseException{
//	    	
//			ArrayList<Object[]> plEv = new ArrayList<Object[]>();
//	    	JSONArray eventPlante = ReadWriteFileJson.readerFileJson("EventsPlantes");
//	    	
//	    	eventPlante.forEach(eventplante ->{
//	    		
//				JSONObject ep = (JSONObject) eventplante;
//				
//				if(!ep.isEmpty()) {
//					int idEvent = Integer.parseInt(ep.get("IdEvent").toString());
//					String idPlante = ep.get("IdPlantes").toString();
//					
//					JSONObject jsonObjPlante = null;
//					JSONObject jsonObjEvent = null;
//					try {
//						
//						//Recuperation des couples (Event,Plante)
//						jsonObjPlante = plantes.getData(idPlante);
//						jsonObjEvent = event.getData(idEvent);
//						
//					} catch (IOException | ParseException e) {
//						
//						e.printStackTrace();
//					}
//					if((!jsonObjPlante.isEmpty()) && (!jsonObjEvent.isEmpty())){
//						//Initialisation des couples d'objet(Event et plante)
//						jsonObjEvent = (JSONObject)jsonObjEvent;
//						jsonObjPlante = (JSONObject) jsonObjPlante;
//						event = new Events();
//						System.out.println(jsonObjEvent.get("IdEvent").toString());
//						event.setId(Integer.parseInt(jsonObjEvent.get("IdEvent").toString()));
//						event.setActivite(jsonObjEvent.get("Activite").toString());
//						event.setDate(jsonObjEvent.get("Date").toString());
//						event.setNote(jsonObjEvent.get("Note").toString());
//						
//						plantes = new Plantes();
//						plantes.setId("Id");
//						//lblNom.setText(jsonObjPlante.get("Nom").toString());
//						plantes.setNom(jsonObjPlante.get("Nom").toString());
//						plantes.setVariete(jsonObjPlante.get("Variete").toString());
//						plantes.setCouleur(jsonObjPlante.get("Couleur").toString());
//						plantes.setNote(jsonObjEvent.get("Note").toString());
//						plantes.setDate(jsonObjEvent.get("Date").toString());
//						//JSONObject jsonMesure = (JSONObject) jsonObjPlante.get("Mesures"); 
//						//plantes.setMesures(jsonMesure.get(arg0), value);
//						plantes.setUrl(jsonObjPlante.get("Url").toString());
//						JSONObject jsonMesure = (JSONObject) jsonObjPlante.get("Mesures");
//						plantes.setHauteur(Double.parseDouble(jsonMesure.get("Hauteur").toString()));
//						plantes.setLargeur(Double.parseDouble(jsonMesure.get("Largeur").toString()));
//						plantes.setPoids(Double.parseDouble(jsonMesure.get("Poids").toString()));
//						plantes.setUrl(jsonObjPlante.get("Url").toString());
//						
//						tabEventPlante = new Object[2];
//						tabEventPlante[0] = event;
//						tabEventPlante[1] = plantes;
//						plEv.add(tabEventPlante);
//					}else {
//						System.out.println("[jsonObjEvent,jsonObjPlante]");
//					}
//					
//				}else {
//					System.out.println("event et plante sont vide");
//				}
//				
//			});
//	    	
//			return plEv;
//	    }

	
	
	//Object[] tabEventPlante;
	    	
	    
		
		@SuppressWarnings("static-access")
		private ObservableList<EventsPlantes>  getData() throws IOException, ParseException{
			
			ObservableList<EventsPlantes> eventPlanteFxc = FXCollections.observableArrayList();
	    	JSONArray eventPlante = ReadWriteFileJson.readerFileJson("EventsPlantes");
	    	
	    	JSONObject ep;
	    	int idEv;
	    	for(int i=0; i<eventPlante.size(); i++) {
	    		System.out.println("FFF"+eventPlante.get(i));
				ep = (JSONObject) eventPlante.get(i);
				idEv = Integer.parseInt(ep.get("IdEvent").toString());
				
				String idPlante = ep.get("IdPlantes").toString();
				if(!ep.isEmpty()) {
					
					
					JSONObject jsonObjPlante = null;
					JSONObject jsonObjEvent = null;
					try {
						
						//Recuperation des couples (Event,Plante)
						jsonObjPlante = plantes.getData(idPlante);
						jsonObjEvent = event.getData(idEv);
						
					} catch (IOException | ParseException e) {
						
						e.printStackTrace();
					}
					if((!jsonObjPlante.isEmpty()) && (!jsonObjEvent.isEmpty())){
						
						jsonObjEvent = (JSONObject)jsonObjEvent;
						jsonObjPlante = (JSONObject) jsonObjPlante;
						
						//System.out.println(jsonObjEvent.get("IdEvent").toString());
						IdEvent = Integer.parseInt(jsonObjEvent.get("IdEvent").toString());
						Activite = jsonObjEvent.get("Activite").toString();
						DateEvent = jsonObjEvent.get("Date").toString();
						NoteEvent = jsonObjEvent.get("Note").toString();
						TypeEvent = jsonObjEvent.get("TypeEvent").toString();
						
						idP = idPlante;
						nomPlante = jsonObjPlante.get("Nom").toString();
						varietePlante = jsonObjPlante.get("Variete").toString();
						couleurPlante = jsonObjPlante.get("Couleur").toString();
						notePlante = jsonObjEvent.get("Note").toString();
						datePlante = jsonObjEvent.get("Date").toString();
						url =jsonObjPlante.get("Url").toString();
						jsonMesure = (JSONObject) jsonObjPlante.get("Mesures");
						hauteur = Double.parseDouble(jsonMesure.get("Hauteur").toString());
						largeur = Double.parseDouble(jsonMesure.get("Largeur").toString());
						poids = Double.parseDouble(jsonMesure.get("Poids").toString());
						
						eventsPlantes = new EventsPlantes(IdEvent, Activite, DateEvent, NoteEvent, 
								idP, nomPlante, varietePlante, 
								couleurPlante, datePlante, notePlante, 
								hauteur, largeur, poids, url, TypeEvent);
						
						eventPlanteFxc.add(eventsPlantes);
					}else {
						System.out.println("[jsonObjEvent,jsonObjPlante] vide");
					}
					
				}else {
					System.out.println("event et plante sont vide");
				}
				
	    	}
	    	
			return eventPlanteFxc;
	    }
		

		@SuppressWarnings("unused")
		private void remplirTabView() {
			idTabView.setCellValueFactory(new PropertyValueFactory<>("idEvent"));
			PlanteTabView.setCellValueFactory(new PropertyValueFactory<>("nomPlante"));
			ActiviteTabView.setCellValueFactory(new PropertyValueFactory<>("Activite"));
			dateTabView.setCellValueFactory(new PropertyValueFactory<>("datePlante"));
			noteTabView.setCellValueFactory(new PropertyValueFactory<>("notePlante"));
			TypeEventView.setCellValueFactory(new PropertyValueFactory<>("TypeEvent"));
			
			try {
				TabView.setItems(getData());
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			remplirTabView();
		}

	

	

}
