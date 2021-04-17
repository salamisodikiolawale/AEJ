package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Events;
import models.Plantes;
import models.Suivis;

public class ItemSuiviControl implements Initializable{
	
    @FXML private ImageView img;
    @FXML private VBox infosImage;
    @FXML private Label lblNomEvent;
    @FXML private Label lblDate;
    @FXML private Label lblVariete;
    @FXML private Label lblHauteur;
    @FXML private Label lblLargeur;
    @FXML private Label lblPoids;
    @FXML private Label lblNote;
    @FXML private Label lblCouleur;

    private Suivis suivis;

    
    private ArrayList<String> urlList = new ArrayList<String>();
	 
	 	 
	 @SuppressWarnings("static-access")
	@FXML void detailPlante() throws IOException, ParseException{
//		// try {
//		 Plantes pl = new Plantes();
//		 String id = pl.getId(lblNomEvent.getText());
//		 pl.setIdShow(id);
//		 //Stage stage = new Stage();
//		 //FXMLLoader fxl = new FXMLLoader();
//		 //VBox root = fxl.load(getClass().getResource("/views/PagePlante.fxml").openStream());
//		 //stage.setScene(new Scene(root, 700, 600));
//		 //stage.showAndWait();
//		 //} catch(IOException io) {
//		//	 io.printStackTrace();
//		 //}
//		 
//		 
//		 FXMLLoader fxl = new FXMLLoader();
// 		fxl.setLocation(getClass().getResource("/views/PagePlante.fxml"));
// 		VBox vb= fxl.load();
// 		MainAppController pageformSuivi = fxl.getController();
// 		//pageformSuivi.setUrl(this.myUrl);
// 		pageformSuivi.fxml = vb;
//			//this.PagePlanteVbox.getChildren().setAll(vb);
//		
//		 
	 }
	 
	 public void setData(Suivis suivi) {
		 
		 this.suivis =suivi;
		 
		 //System.out.println("this.plante.getVariete()"+ this.plante.getPoids().toString());
		 //lblNomEvent.setText(this.event.getActivite());
		 lblVariete.setText("Variété : "+this.suivis.getVariete());
		 lblPoids.setText("poids:"+this.suivis.getPoids()+" "+this.suivis.getUniteP());
		 lblCouleur.setText("Couleur: "+this.suivis.getCouleur().toString());
		 lblDate.setText(this.suivis.getDate());
		 lblHauteur.setText("Hauteur:"+this.suivis.getHauteur()+""+this.suivis.getUniteH());
		 lblLargeur.setText("Largeur:"+this.suivis.getLargeur()+""+this.suivis.getUniteL());
		 lblNote.setText("Note:"+this.suivis.getNote());
		 Image i = new Image(getClass().getResourceAsStream(suivis.getUrl()));
		 img.setImage(i);
	 }
	 
	 
//	 public void setData(Events event, Plantes plante) {
//		 
//		 this.event = event;
//		 this.plante =plante;
//		 
//		 System.out.println("this.plante.getVariete()"+ this.plante.getPoids().toString());
//		 lblNomEvent.setText(this.event.getActivite());
//		 lblPoids.setText(this.plante.getPoids().toString()+" "+this.plante.getPoids());
//		 
//		 lblVariete.setText(this.plante.getVariete().toString());
//		 lblDate.setText(this.event.getDate());
//		 lblHauteur.setText(this.plante.getHauteur().toString()+" "+this.plante.getMesures().get("Hauteur"));
//		 lblLargeur.setText(this.plante.getLargeur().toString()+" "+this.plante.getMesures().get("Largeur"));
//		 lblNote.setText(this.plante.getNote());
//		 Image i = new Image(getClass().getResourceAsStream(plante.getUrl()));
//		 img.setImage(i);
////		 Random random = new Random();
//		 int nb;
//		 nb = random.nextInt(6);
//		 shuffleUrlList();
//		 this.plante.setUrl("/images/"+this.urlList.get(nb)+".jpg");
//		 Image i = new Image(getClass().getResourceAsStream(plante.getUrl()));
//		 img.setImage(i);
//	 }
	 
//	 public void shuffleUrlList() {
//			for(int i=1; i<=7; i++) {
//				urlList.add("img"+i);
//			}
//			
//		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
