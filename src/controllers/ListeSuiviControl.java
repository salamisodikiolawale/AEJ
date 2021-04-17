package controllers;

import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Events;
import models.Plantes;

public class ListeSuiviControl implements Initializable {

	
    @FXML
    private HBox HBox;

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private GridPane GradPane;

    @FXML
    private Label lblNom;
    private Plantes plantes = new Plantes();
    private Events event = new Events();
    
    
    
    ArrayList<Object[]> listEventPlante = new ArrayList<Object[]>();
    Object[] tabEventPlante;
    	
    
	@SuppressWarnings({ "unchecked", "static-access" })
	private ArrayList<Object[]> getData() throws IOException, ParseException{
    	
		ArrayList<Object[]> plEv = new ArrayList<Object[]>();
    	JSONArray eventPlante = ReadWriteFileJson.readerFileJson("EventsPlantes");
    	
    	eventPlante.forEach(eventplante ->{
    		
			JSONObject ep = (JSONObject) eventplante;
			
			if(!ep.isEmpty()) {
				int idEvent = Integer.parseInt(ep.get("IdEvent").toString());
				String idPlante = ep.get("IdPlantes").toString();
				
				JSONObject jsonObjPlante = null;
				JSONObject jsonObjEvent = null;
				try {
					
					//Recuperation des couples (Event,Plante)
					jsonObjPlante = plantes.getData(idPlante);
					jsonObjEvent = event.getData(idEvent);
					
				} catch (IOException | ParseException e) {
					
					e.printStackTrace();
				}
				if((!jsonObjPlante.isEmpty()) && (!jsonObjEvent.isEmpty())){
					//Initialisation des couples d'objet(Event et plante)
					jsonObjEvent = (JSONObject)jsonObjEvent;
					jsonObjPlante = (JSONObject) jsonObjPlante;
					event = new Events();
					System.out.println(jsonObjEvent.get("IdEvent").toString());
					event.setId(Integer.parseInt(jsonObjEvent.get("IdEvent").toString()));
					event.setActivite(jsonObjEvent.get("Activite").toString());
					event.setDate(jsonObjEvent.get("Date").toString());
					event.setNote(jsonObjEvent.get("Note").toString());
					
					plantes = new Plantes();
					plantes.setId("Id");
					plantes.setNom(jsonObjPlante.get("Nom").toString());
					plantes.setVariete(jsonObjPlante.get("Variete").toString());
					plantes.setCouleur(jsonObjPlante.get("Couleur").toString());
					plantes.setNote(jsonObjEvent.get("Note").toString());
					plantes.setDate(jsonObjEvent.get("Date").toString());
					//JSONObject jsonMesure = (JSONObject) jsonObjPlante.get("Mesures"); 
					//plantes.setMesures(jsonMesure.get(arg0), value);
					plantes.setUrl(jsonObjPlante.get("Url").toString());
					JSONObject jsonMesure = (JSONObject) jsonObjPlante.get("Mesures");
					plantes.setHauteur(Double.parseDouble(jsonMesure.get("Hauteur").toString()));
					plantes.setLargeur(Double.parseDouble(jsonMesure.get("Largeur").toString()));
					plantes.setPoids(Double.parseDouble(jsonMesure.get("Poids").toString()));
					plantes.setUrl(jsonObjPlante.get("Url").toString());
					
					tabEventPlante = new Object[2];
					tabEventPlante[0] = event;
					tabEventPlante[1] = plantes;
					plEv.add(tabEventPlante);
				}else {
					System.out.println("[jsonObjEvent,jsonObjPlante]");
				}
				
			}else {
				System.out.println("event et plante sont vide");
			}
			
		});
    	
		return plEv;
    	
    	
    	
    	
    }
    
    public void remplirGrid() {
    	try {
    		System.out.println("gztData()"+getData());
			listEventPlante.addAll(getData());
			
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			int column =0;
			int row = 0;
			
			for(int i=listEventPlante.size()-1; i>=0; i--) {
				FXMLLoader fxl = new FXMLLoader();
				fxl.setLocation(getClass().getResource("/views/ItemSuivi.fxml"));
				
				AnchorPane anchorpane = fxl.load();
				
				ItemSuiviControl itemSuiviControl = fxl.getController();
				System.out.println("class"+((Events)listEventPlante.get(0)[0]));
				itemSuiviControl.setData(((Events)listEventPlante.get(i)[0]), ((Plantes)listEventPlante.get(i)[1]));
					if(column==4) {
						column=0;
						row++;
					}
					
				
				//System.out.println(anchorpane.getChildren());
				GradPane.add(anchorpane, ++column, row);
				//GridPane.setMargin(anchorpane, new Insets(10, 10, 10, 10));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		remplirGrid();
	}

}
