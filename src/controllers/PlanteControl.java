package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import models.Plantes;
public class PlanteControl implements Initializable{

	/**************************PageFormPlante***************************************/
	@FXML private VBox FormePlanteVbox;
    @FXML private TextField txtNom;
    @FXML private TextField txtVariete;
    @FXML private TextField txtHauteur;
    @FXML private TextField txtLargeur;
    @FXML private TextField txtPoids;
    @FXML private TextField txtFeuille;
    @FXML private ComboBox<String> cmbHauteur;
    @FXML private TextArea txtNote;
    @FXML private TextField txtCouleur;
    @FXML private ComboBox<String> cmbLargeur;
    @FXML private ComboBox<String> cmbPoids;
    @FXML private ComboBox<String> cmbLongeurFeuille;
    @FXML private Button btnAjouterUneMesure;
    @FXML private Button btnEnregistrer;
    @FXML private Button btnAnnuler;
    @FXML private DatePicker datePicker;
    @FXML private Button btnImporteImage;
    @FXML private Label labUrlImage;
    @FXML private Label labNom;  
    @FXML private ImageView imgPlante;
    @FXML private Button pagePlante;
    private String[] tabImage;
    public static boolean isAff = false;
    
    

	
    Parent fxml;
	private Plantes plantes;
	private File url;
	/**
	 * Constructor
	 */
	public PlanteControl() {
		plantes = new Plantes();
	}

    	
	/**
	 * Register the plante and show plante page
	 * @throws IOException
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@FXML
    void EnregistreOperation() throws IOException, ParseException{
		
    	if(!txtNom.getText().isEmpty() && !txtVariete.getText().isEmpty() 
    			&& !txtCouleur.getText().isEmpty() && datePicker.getValue()!=null) {
    		
    		if(txtLargeur.getText().isEmpty()) {txtLargeur.setText("0.0");}
    		if(txtHauteur.getText().isEmpty()) {txtHauteur.setText("0.0");}
    		if(txtPoids.getText().isEmpty()) {txtPoids.setText("0.0");}
    		if(txtFeuille.getText().isEmpty()) {txtFeuille.setText("0.0");}
    		if(txtNote.getText().isEmpty()) {txtNote.setText("");}
    			

			plantes.setId(txtNom.getText()+"_"+datePicker.getValue().toString());
			plantes.setNom(txtNom.getText());
			plantes.setVariete(txtVariete.getText());
			plantes.setCouleur(txtCouleur.getText());
			plantes.setDate(datePicker.getValue().toString());
			plantes.setNote(txtNote.getText());
			plantes.setHauteur(Double.parseDouble(txtHauteur.getText()));
			plantes.setLargeur(Double.parseDouble(txtLargeur.getText()));
			plantes.setPoids(Double.parseDouble(txtPoids.getText()));
			plantes.setLongeurFeuille(Double.parseDouble(txtFeuille.getText()));
			plantes.setHauteurLargeurPoid((String) cmbHauteur.getValue());
			plantes.setHauteurLargeurPoid((String) cmbLargeur.getValue());
			plantes.setHauteurLargeurPoid((String) cmbPoids.getValue());
			plantes.setHauteurLargeurPoid((String) cmbLongeurFeuille.getValue());
			//L'url a revoir
			//plantes.setUrl(labUrlImage.getText());
			tabImage = new String[6];
			for(int i =1; i<tabImage.length; i++) {
				tabImage[i] = "/images/img"+i+".jpg";
			}
			Random r =  new Random();
			int nb = r.nextInt(6);
			
			
			if(url!=null) {
				//plantes.setUrl(url.toString());
				plantes.setUrl(tabImage[nb]);
			}else {
				plantes.setUrl(tabImage[nb]);
				System.out.println("(PlanteControl) : EnregistreOperation url =>"+url);
			}

			
			try {

					
					if(Plantes.isUpdate()) {

						deletePlante(Plantes.getIdUpdate());
					}
					JSONArray liste_plantes = ReadWriteFileJson.readerFileJson("Plantes");
					liste_plantes.add(plantes.tranformPlanteToObjectJson());
					ReadWriteFileJson.writeFileJson("Plantes", liste_plantes);
					ReadWriteFileJson.showAlertWithHeaderText("Création de plante", "Votre plante a bien été enregistrer");
					
					//Actualise le idShow
					Plantes.setIdShow(txtNom.getText()+"_"+datePicker.getValue().toString());
					fxml = FXMLLoader.load(getClass().getResource("/views/PagePlante.fxml"));
					
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.FormePlanteVbox.getChildren().removeAll();
			this.FormePlanteVbox.getChildren().setAll(fxml);
    		
		}else {
			ReadWriteFileJson.showAlertWithHeaderText("Champs Obligatoire", "Nom, Couleur, Variete, Date");
		}
    }
	
	public void chargeImg() {
		Image  img = new Image(getClass().getResourceAsStream("images/test.png"));
		imgPlante.setImage(img);
	}
	
	@SuppressWarnings("unchecked")
	public void deletePlante(String id) throws IOException, ParseException {
		
		JSONArray datas = ReadWriteFileJson.readerFileJson("Plantes");
		JSONArray list = (JSONArray) datas;
		
		list.forEach(d -> {
			
			JSONObject d1 = (JSONObject)d;
			
			if(!d1.isEmpty())
				if(d1.get("Id").toString().equals(id)) {
					d1.remove("Id");
					d1.remove("Unite");
					d1.remove("Variete");
					d1.remove("Couleur");
					d1.remove("Mesures");
					d1.remove("Note");
					d1.remove("Nom");
					d1.remove("Date");
					d1.remove("Url");
					return;
					
				}
		});
		ReadWriteFileJson.writeFileJson("Plantes", list);
	}
	
	public void remplirChamps() throws IOException, ParseException {
		if(Plantes.isUpdate()) {
			JSONObject data = Plantes.getData(Plantes.getIdUpdate());
			txtNom.setText(data.get("Nom").toString());
			txtVariete.setText(data.get("Variete").toString());
			txtCouleur.setText(data.get("Couleur").toString());
			datePicker.setPromptText(data.get("Date").toString());
			txtNote.setText(data.get("Note").toString());
			String date  = data.get("Date").toString();
			String[] dates = date.split("-");
			datePicker.setValue(LocalDate.of(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2])));
			JSONObject mesureObj = (JSONObject) data.get("Mesures");
			
			txtHauteur.setText(mesureObj.get("Hauteur").toString());
			txtLargeur.setText(mesureObj.get("Largeur").toString());
			txtPoids.setText(mesureObj.get("Poids").toString());
			txtFeuille.setText(mesureObj.get("LongeurFeuille").toString());
		}
	}
	


	
		@SuppressWarnings("unchecked")
		public void remplirCombo() throws IOException, ParseException {
			JSONArray jsonArray = ReadWriteFileJson.readerFileJson("Unites");
			ObservableList<String> FxclUniteHauteurLargeur = FXCollections.observableArrayList();
			ObservableList<String> FxclUniteP = FXCollections.observableArrayList();
			jsonArray.forEach(obj -> {
				JSONObject o = (JSONObject) obj;
				FxclUniteHauteurLargeur.add((String) o.get("UniteHauteurLargeur"));
				FxclUniteP.add((String) o.get("Poids"));
			});
			cmbHauteur.setItems(FxclUniteHauteurLargeur);
			cmbLargeur.setItems(FxclUniteHauteurLargeur);
			cmbLongeurFeuille.setItems(FxclUniteHauteurLargeur);
			cmbPoids.setItems(FxclUniteP);
		}
	
	
	@FXML void cmbHauteur() {}	
	@FXML void remplirListeUniteHauteur() {}
	
	@FXML void Annuler() {
		txtNom.setText("");
		txtVariete.setText("");
		txtCouleur.setText("");
		txtNote.setText("");
		txtHauteur.setText("");
		txtLargeur.setText("");
		txtFeuille.setText("");
		txtPoids.setText("");
	}
	
	@FXML void importerImage() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.jpeg"));
		File f = fc.showOpenDialog(null);
		if(f != null ) {
			labUrlImage.setText(f.getAbsolutePath());
			Image img = new Image(f.toURI().toString(), imgPlante.getFitWidth(), imgPlante.getFitHeight(), true, true);
			imgPlante.setImage(img);
			this.url = f;
		}
    }
	
	void importerImage1() {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif","*.jpeg"));
		File f = fc.showOpenDialog(null);
		if(f != null ) {
			labUrlImage.setText(f.getAbsolutePath());
			Image img = new Image(f.toURI().toString(), imgPlante.getFitWidth(), imgPlante.getFitHeight(), true, true);
			imgPlante.setImage(img);
			
		}
    }
	
	@FXML void pagePlante() {
		try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PagePlante.fxml"));
			this.FormePlanteVbox.getChildren().removeAll();
			this.FormePlanteVbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
	}


	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			remplirCombo();
			remplirChamps();
			if(isAff) {
				pagePlante.setVisible(true);
			}else {
				pagePlante.setVisible(false);
			}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	}

}
	
