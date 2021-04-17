package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.Plantes;

public class PlantePageControl implements Initializable{
	
    
    /**************************PagePlante***************************************/
	
    @FXML VBox PagePlanteVbox;
    @FXML private Text labTitle;
    @FXML private Label labNom;
    @FXML private Label labVariete;
    @FXML private Label labCouleur;
    @FXML private Label labDate;
    @FXML private Label labHauteur;
    @FXML private Label labLargeur;
    @FXML private Label mesusureH;
    @FXML private Label mesusureL;
    @FXML private Label labPoid;
    @FXML private Label labLFeui;
    @FXML private Label mesureP;
    @FXML private Label mesureF;
    @FXML private Label labNote;
    @FXML private ImageView imgView;
    private String id;
    @SuppressWarnings("unused")
	private String[] tabImage;
  


    /***************************************************************************/

    @SuppressWarnings("unused")
	private Plantes plantes;
	public PlantePageControl() {
		plantes = new Plantes();
	}
	
		public void ShowData(String idShow) throws IOException, ParseException{
	
			if(idShow != null) {

		    	JSONObject jsnObject  = (JSONObject) Plantes.getData(idShow);
		    	JSONObject mesureObj = (JSONObject) jsnObject.get("Mesures");
		    	@SuppressWarnings("unchecked")
				List<String> listeUnite = (List<String>) jsnObject.get("Unite");
		    	this.id = (String) jsnObject.get("Id");
		    	labTitle.setText((String) jsnObject.get("Nom"));
		    	labNom.setText((String) jsnObject.get("Nom"));
		    	labVariete.setText((String) jsnObject.get("Variete"));
		    	labCouleur.setText((String) jsnObject.get("Couleur"));
		    	labDate.setText((String) jsnObject.get("Date"));
		    	labNote.setText((String) jsnObject.get("Note"));
		    	labHauteur.setText(mesureObj.get("Hauteur").toString());
		    	labLargeur .setText(mesureObj.get("Largeur").toString());
		    	labPoid .setText(mesureObj.get("Poids").toString());
		    	labLFeui.setText(mesureObj.get("LongeurFeuille").toString());
		    	
		    	mesusureH.setText(listeUnite.get(0));
		    	mesusureL.setText(listeUnite.get(1));
		    	mesureP.setText(listeUnite.get(2));
		    	mesureF.setText(listeUnite.get(3));
		    	Image i = new Image(getClass().getResourceAsStream((String) jsnObject.get("Url")));
		    	imgView.setImage(i);
		    	//Image i = new Image("test.png");
				//imgView.setImage(i);
		    	//Plantes.setIdShow(null);//remet le idShow a null
			}

	    }
	 
		public static JSONObject lastData() throws IOException, ParseException {
			JSONArray jsA = ReadWriteFileJson.readerFileJson("Plantes");
			return (JSONObject) jsA.get(jsA.size()-1);
		}


	 @FXML void modifier() throws IOException, ParseException {
	    	Plantes.setIdUpdate(this.id);	
		 	Plantes.setIsUpdate(true);
		 	Plantes.setIdShow(this.id);
			Parent fxml = FXMLLoader.load(getClass().getResource("/views/PageFormPlante.fxml"));
			this.PagePlanteVbox.getChildren().removeAll();
			this.PagePlanteVbox.getChildren().setAll(fxml);
	       }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ShowData(Plantes.getIdShow());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
