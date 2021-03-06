package controllers;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Plantes;

public class ItemPlanteControl implements Initializable{

	 @FXML private ImageView img;

	 @FXML private VBox infosImage;

	 @FXML private Label lblNom;

	 @FXML private Label lblPoids;

	 @FXML private Label lblVariete;
	 
	 private Plantes plante;
	 Parent fxml;
	 /**
	  * Permet d'afficher/Cacher le btn de 
	  * retour sur le formulaire de modification
	  * de la plante
	  */
	 @SuppressWarnings("unused")
	 public static boolean activeBtn = false;
	 
	 //private ArrayList<String> urlList = new ArrayList<String>();
	 
	 
	 
	 @SuppressWarnings("static-access")
	@FXML void detailPlante() throws IOException, ParseException{
		 //Affichage du btn
		 activeBtn = true;
		 try {
		 Plantes pl = new Plantes();
		 String id = pl.getId(lblNom.getText());
		 pl.setIdShow(id);
		 Stage stage = new Stage();
		 FXMLLoader fxl = new FXMLLoader();
		 VBox root = fxl.load(getClass().getResource("/views/PagePlante.fxml").openStream());
		 stage.setScene(new Scene(root, 700, 600));
		 stage.showAndWait();
		 } catch(IOException io) {
			 io.printStackTrace();
		 }
		
		 
	 }
	 
	 
	 public void setData(Plantes plante) {
		 this.plante = plante;
		 if(this.plante.getUrl()!=null) {
		 lblNom.setText(this.plante.getNom());
		 lblPoids.setText(this.plante.getPoids().toString()+" "+this.plante.getHauteurLargeurPoid());
		 lblVariete.setText(this.plante.getVariete());
		
		 Image i = new Image(getClass().getResourceAsStream(this.plante.getUrl().toString()));
		 img.setImage(i);
//		 Random random = new Random();
//		 int nb;
//		 nb = random.nextInt(6);
//		 shuffleUrlList();
//		 this.plante.setUrl("/images/"+this.urlList.get(nb)+".jpg");
//		 Image i = new Image(getClass().getResourceAsStream(plante.getUrl()));
//		 img.setImage(i);
		 }else {
			 System.out.println("Image is null");
		 }
	 }
	 
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
