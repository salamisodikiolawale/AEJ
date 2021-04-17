package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.Plantes;
import models.Suivis;

public class ListeSuiviControl implements Initializable {

	
	@FXML
	private VBox Vbox;
	    
	   
    @FXML
    private HBox HBox;
    
 
    Parent fxml;

    @FXML
    private ScrollPane ScrollPane;

    @FXML
    private GridPane GradPane;

    @FXML
    private Label lblNom;
    
    
    //private Plantes plante = new Plantes();
    public static String idplante;
    private String url;
    private Suivis Suiv;
    private Plantes plante;
    
    @FXML
    void pagePlante() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PagePlante.fxml"));
			this.Vbox.getChildren().removeAll();
			this.Vbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }

    }
    
    
    
    ArrayList<Suivis> PlanteSuivi = new ArrayList<Suivis>();

    	
    
	@SuppressWarnings({ "unchecked", "static-access" })
	private ArrayList<Suivis> getData() throws IOException, ParseException{
		ArrayList<Suivis> listPlanteSuivi = new ArrayList<Suivis>();
    	JSONArray suivis = ReadWriteFileJson.readerFileJson("Suivis");
    	
    	
    	suivis.forEach(suiv ->{
			JSONObject s = (JSONObject) suiv;
			String nomPl = "";
			String varietePl = "";
			JSONObject planteJsonOb;
			if(!s.isEmpty()) {
				
				if(s.get("IdPLante").toString().equals(this.getIdplante())) {
					System.out.println("------s---->"+s.get("IdPLante")+" __ "+this.getIdplante());
					try {
						planteJsonOb = this.plante.getData(this.getIdplante());
						JSONObject plJsonObject = (JSONObject)planteJsonOb;
						nomPl = planteJsonOb.get("Nom").toString();
						varietePl=planteJsonOb.get("Variete").toString();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Suiv = new Suivis();
					lblNom.setText(nomPl);
					Suiv.setNomPl(nomPl);
					Suiv.setVariete(varietePl);
					Suiv.setCouleur(s.get("Couleur").toString());
					Suiv.setDate(s.get("Date").toString());
					Suiv.setHauteur(Double.parseDouble(s.get("Hauteur").toString()));
					Suiv.setLargeur(Double.parseDouble(s.get("Largeur").toString()));
					Suiv.setPoids(Double.parseDouble(s.get("Poids").toString()));
					Suiv.setIdPlante(s.get("IdPLante").toString());
					Suiv.setNote(s.get("Note").toString());
					Suiv.setUniteH(s.get("UniteH").toString());
					Suiv.setUniteL(s.get("UniteL").toString());
					Suiv.setUniteP(s.get("UniteP").toString());
					Suiv.setUrl(s.get("Url").toString());
					listPlanteSuivi.add(Suiv);
				}
			}else {System.out.println("[jsonObjEvent,jsonObjPlante]");}
				
			
		});
    	
 
    	

		//Recuperation 
//		JSONObject jsonObjPlante = plante.getData(this.getIdplante());
//
//		if((!jsonObjPlante.isEmpty())){
//			jsonObjPlante = (JSONObject) jsonObjPlante;
//			
//			plante = new Plantes();
//			plante.setId("Id");
//			lblNom.setText(jsonObjPlante.get("Nom").toString());
//			plante.setNom(jsonObjPlante.get("Nom").toString());
//			plante.setVariete(jsonObjPlante.get("Variete").toString());
//			plante.setCouleur(jsonObjPlante.get("Couleur").toString());
//			plante.setNote(jsonObjPlante.get("Note").toString());
//			plante.setDate(jsonObjPlante.get("Date").toString());
//			plante.setUrl(jsonObjPlante.get("Url").toString());
//			JSONObject jsonMesure = (JSONObject) jsonObjPlante.get("Mesures");
//			plante.setHauteur(Double.parseDouble(jsonMesure.get("Hauteur").toString()));
//			plante.setLargeur(Double.parseDouble(jsonMesure.get("Largeur").toString()));
//			plante.setPoids(Double.parseDouble(jsonMesure.get("Poids").toString()));
//			plante.setUrl(jsonObjPlante.get("Url").toString());
//		}
    	
    	
		return listPlanteSuivi;
    }
    
    public void remplirGrid() {
    	try {
    		System.out.println(getData());
    		PlanteSuivi.addAll(getData());
			
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			int column =0;
			int row = 0;
			
			for(int i=PlanteSuivi.size()-1; i>=0; i--) {
				System.out.println("Je rentre dans la boucle");
				FXMLLoader fxl = new FXMLLoader();
				fxl.setLocation(getClass().getResource("/views/ItemSuivi.fxml"));
				
				AnchorPane anchorpane = fxl.load();
				
				ItemSuiviControl itemSuiviControl = fxl.getController();
				//System.out.println("class"+((Events)listEventPlante.get(0)[0]));
				itemSuiviControl.setData(PlanteSuivi.get(i));
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
    


	public String getIdplante() {
		return idplante;
	}

	public static void setIdplante(String idplante) {
		ListeSuiviControl.idplante = idplante;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		remplirGrid();
	}

}
