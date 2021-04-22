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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.Suivis;

public class PageFormSuiviControl implements Initializable{

	@FXML private VBox FormePlanteVbox;
    @FXML private ImageView imgPlante;
    @FXML private TextField txtHauteur;
    @FXML private TextField txtLargeur;
    @FXML private TextField txtPoids;
    @FXML private ComboBox<String> cmbHauteur;
    @FXML private TextArea txtNote;
    @FXML private TextField txtCouleur;
    @FXML private ComboBox<String> cmbLargeur;
    @FXML private ComboBox<String> cmbPoids;
    @FXML private Button btnEnregistrer;
    @FXML private Button btnAnnuler;
    @FXML private DatePicker datePicker;
    @FXML private Label labUrlImage;
    @FXML private Button btnImporteImage;
    @FXML private Label labConfirAddMesure;
    private static String idPlante;
    private String url;
    
    Parent fxml;
    

    
    @FXML void Annuler() {
		txtCouleur.setText("");
		txtNote.setText("");
		txtHauteur.setText("");
		txtLargeur.setText("");
		txtPoids.setText("");
    }
    
    @FXML void pagePlante() {
    	try {
			fxml = FXMLLoader.load(getClass().getResource("/views/PagePlante.fxml"));
			this.FormePlanteVbox.getChildren().removeAll();
			this.FormePlanteVbox.getChildren().setAll(fxml);
		} catch (IOException e) { e.printStackTrace(); }
    }
    
    public static void setIdPlante(String id) {
    	idPlante = id;
    }
    
    @SuppressWarnings("unchecked")
	@FXML void EnregistreOperation() throws IOException, ParseException {
    	
    	if(datePicker.getValue()!=null) {
    		
    		if(txtLargeur.getText().isEmpty()) {txtLargeur.setText("0.0");}
    		if(txtHauteur.getText().isEmpty()) {txtHauteur.setText("0.0");}
    		if(txtPoids.getText().isEmpty()) {txtPoids.setText("0.0");}
    		if(txtNote.getText().isEmpty()) {txtNote.setText("");}
    		if(cmbHauteur.getValue()==null) {cmbHauteur.setValue("");}
    		if(cmbLargeur.getValue()==null) {cmbLargeur.setValue("");}
    		if(cmbPoids.getValue()==null) {cmbPoids.setValue("");}
    	
	    	Suivis suivis = new Suivis();
	    	suivis.setIdPlante(idPlante);
	    	suivis.setId(suivis.getLastId()+1);
	    	suivis.setCouleur(txtCouleur.getText());
	    	suivis.setNote(txtNote.getText());
	    	suivis.setDate(datePicker.getValue().toString());
	    	suivis.setHauteur(Double.parseDouble(txtHauteur.getText()), (String)cmbHauteur.getValue());
	    	suivis.setPoids(Double.parseDouble(txtPoids.getText()), (String)cmbPoids.getValue());
	    	suivis.setLargeur(Double.parseDouble(txtLargeur.getText()), (String)cmbLargeur.getValue());
	    	suivis.setUrl(this.getUrl());
	    	
	    	JSONArray listesuivis = ReadWriteFileJson.readerFileJson("Suivis");
	    	listesuivis.add(suivis.tranformSuiviToObjectJson());
			ReadWriteFileJson.writeFileJson("Suivis", listesuivis);
			ReadWriteFileJson.showAlertWithHeaderText("Ajout Suivi", "Le suivi a bien été pris en compte");
			Annuler();
    	}
    }
    
    @SuppressWarnings("unchecked")
	public void remplirCombo() throws IOException, ParseException {
    	System.out.println(idPlante+"----");
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
		cmbPoids.setItems(FxclUniteP);
	}

    
    @FXML void cmbHauteur() {

    }

    @FXML void importerImage(MouseEvent event) {

    }

    @FXML void remplirListeUniteHauteur(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			remplirCombo();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
