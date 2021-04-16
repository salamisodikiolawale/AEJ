package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import models.Plantes;

public class ItemPlanteControl implements Initializable{

	 @FXML private ImageView img;

	 @FXML private VBox infosImage;

	 @FXML private Label lblNom;

	 @FXML private Label lblPoids;

	 @FXML private Label lblVariete;
	 
	 private Plantes plante;
	 Parent fxml;
	 
	 private ArrayList<String> urlList = new ArrayList<String>();
	 
	 
	 
	 @FXML void detailPlante() throws IOException, ParseException{
		 Plantes pl = new Plantes();
//		 FXMLLoader fxl = new FXMLLoader();
//		 fxl.setLocation(getClass().getResource("/views/PagePlante.fxml"));
//		 //VBox vbox = fxl.load();
//		 PlantePageControl plantePageControl = new PlantePageControl();
//		 plantePageControl = fxl.getController();
//		 //plantePageControl.PagePlanteVbox.set = fxl.load();
//		 plantePageControl.PagePlanteVbox.getChildren().removeAll();
//		 plantePageControl.PagePlanteVbox.getChildren().setAll(fxml);
//		 
//		 String id = pl.getId(lblNom.getText());
//		 //Mise à jour de idShow
//		 Plantes.setIdShow(id);

		 //this.infosImage.getChildren().removeAll();
		 //this.infosImage.getChildren().setAll(fxml);
	 }
	 
	 public void setData(Plantes plante) {
		 this.plante = plante;
		 
		 lblNom.setText(this.plante.getNom());
		 lblPoids.setText(this.plante.getPoids().toString()+" "+this.plante.getHauteurLargeurPoid());
		 lblVariete.setText(this.plante.getVariete());
		 Random random = new Random();
		 int nb;
		 nb = random.nextInt(6);
		 shuffleUrlList();
		 this.plante.setUrl("/images/"+this.urlList.get(nb)+".jpg");
		 Image i = new Image(getClass().getResourceAsStream(plante.getUrl()));
		 img.setImage(i);
	 }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void shuffleUrlList() {
		for(int i=1; i<=7; i++) {
			urlList.add("img"+i);
		}
		
	}


}
