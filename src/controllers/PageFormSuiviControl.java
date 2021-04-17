package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;

import application.ReadWriteFileJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.Zones;

public class PageFormSuiviControl implements Initializable{

	@FXML private VBox FormePlanteVbox;
    @FXML private ImageView imgPlante;
    @FXML private TextField txtHauteur;
    @FXML private TextField txtLargeur;
    @FXML private TextField txtPoids;
    @FXML private ComboBox<?> cmbHauteur;
    @FXML private TextArea txtNote;
    @FXML private TextField txtCouleur;
    @FXML private ComboBox<?> cmbLargeur;
    @FXML private ComboBox<?> cmbPoids;
    @FXML private Button btnEnregistrer;
    @FXML private Button btnAnnuler;
    @FXML private DatePicker datePicker;
    @FXML private Label labUrlImage;
    @FXML private Button btnImporteImage;
    @FXML private Label labConfirAddMesure;

    
    @FXML void Annuler(ActionEvent event) {

    }
    
    @FXML void EnregistreOperation() {
//    	Zones zone = new Zones();
//    	zone.setId(zone.getLastId()+1);
//    	zone.setNom(txtNom.getText());
//    	zone.setTaille(Double.parseDouble(txtTaille.getText()));
//    	zone.setType((String)cmbType.getValue());
//    	
//    	JSONArray listezones = ReadWriteFileJson.readerFileJson("Zones");
//    	listezones.add(zone.tranformZoneToObjectJson());
//		ReadWriteFileJson.writeFileJson("Zones", listezones);
//		ReadWriteFileJson.showAlertWithHeaderText("Ajout Zone", "La zone a bien été crée");

    }

    @FXML void cmbHauteur(MouseEvent event) {

    }

    @FXML void importerImage(MouseEvent event) {

    }

    @FXML void remplirListeUniteHauteur(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
