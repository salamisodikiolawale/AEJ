package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Plantes;

public class ListePlanteControl implements Initializable{

    @FXML
    private HBox HBox;

    @FXML private ScrollPane ScrollPane;

    @FXML private GridPane GradPane;
    
    @FXML private TextField txtRecherche;
      
    @FXML void btnRecherche() throws IOException, ParseException {
    
    	if(txtRecherche.getText().equals("")) {
    		GradPane.getChildren().clear();
    		remplirGrid();
    	}else {
    		GradPane.getChildren().clear();
        	remplirGrid(txtRecherche.getText());
    	}
    	
    }
    
    @FXML
    void txtRechche() throws IOException, ParseException {

    	if(txtRecherche.getText().equals("")) {
    		GradPane.getChildren().clear();
    		listPlante.clear();
    		remplirGrid();
    	}else {
    		GradPane.getChildren().clear();
    		listPlante.clear();
        	remplirGrid(txtRecherche.getText());
    	}
    }
    
    ArrayList<Plantes> listPlante = new ArrayList<Plantes>();
    
    
	private List<Plantes> getData() throws IOException, ParseException{
    	
		ArrayList<Plantes> pl = new ArrayList<Plantes>();
    	
    	Plantes plant = new Plantes();
    	JSONArray jsonArray = new JSONArray();
    	jsonArray = plant.getPlanteList();
    	
    	Plantes plante;
    	JSONObject jsObj;
    	JSONArray js;
    	for(int i=0; i<jsonArray.size(); i++) {
    		jsObj = (JSONObject) jsonArray.get(i);
    		jsObj = (JSONObject) jsObj;
    		
    		plante = new Plantes();
    		if(!jsObj.isEmpty()) {
	    		plante.setNom(jsObj.get("Nom").toString());
	    		plante.setVariete(jsObj.get("Variete").toString());
	    		plante.setPoids(Double.parseDouble(((JSONObject)jsObj.get("Mesures")).get("Poids").toString()));
	    		js = (JSONArray)jsObj.get("Unite");
	    		if(js.get(2)!=null) {
	    			plante.setHauteurLargeurPoid(js.get(2).toString());
	    		}
	    		plante.setUrl(jsObj.get("Url").toString());
	    		pl.add(plante);
    		}
    		
    	}
		return pl;
    	
    	
    }
    
    public void remplirGrid() {
    	try {
			listPlante.addAll(getData());
		} catch (IOException | ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			
			int column =0;
			int row = 0;
			
			for(int i=listPlante.size()-1; i>=0; i--) {
				FXMLLoader fxl = new FXMLLoader();
				fxl.setLocation(getClass().getResource("/views/ItemPlante.fxml"));
				
				AnchorPane anchorpane = fxl.load();
				
				ItemPlanteControl itemPlanteCtr = fxl.getController();
				itemPlanteCtr.setData(listPlante.get(i));
					if(column==4) {
						column=0;
						row++;
					}
					
				
				//System.out.println(anchorpane.getChildren());
				GradPane.add(anchorpane, ++column, row);
				GridPane.setMargin(anchorpane, new Insets(10));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   
    
    
    public void remplirGrid(String nom) throws IOException, ParseException {
    	Plantes pl = new Plantes();
    	String Id = pl.getId(nom);
    	@SuppressWarnings("static-access")
		JSONObject planteJsOb = pl.getData(Id);
    	System.out.println(planteJsOb);
    	pl.setNom(planteJsOb.get("Nom").toString());
    	pl.setVariete(planteJsOb.get("Variete").toString());
    	pl.setPoids(Double.parseDouble(((JSONObject)planteJsOb.get("Mesures")).get("Poids").toString()));
    	listPlante.clear();
    	GradPane.getChildren().clear();
    	listPlante.add(pl);
    	
    	FXMLLoader fxl = new FXMLLoader();
		fxl.setLocation(getClass().getResource("/views/ItemPlante.fxml"));
		AnchorPane anchorpane = fxl.load();
		ItemPlanteControl itemPlanteCtr = fxl.getController();
		itemPlanteCtr.setData(listPlante.get(0));
		
		GradPane.add(anchorpane, 0, 0);
		GridPane.setMargin(anchorpane, new Insets(10));
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		remplirGrid();
	}

	

}
