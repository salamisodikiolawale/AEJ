package controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.Zones;

public class ZoneControl implements Initializable{


    @FXML
    private VBox Vbox;

    @FXML
    private TextField txtNom;

    @FXML
    private ComboBox<String> cmbType;

    @FXML
    private TextField txtTaille;

    @FXML
    private Button btnAnnuler;

    @FXML
    private TextField type;

    @FXML
    private Button btnAjouter;
    
    @FXML
    private Button btnEnreOp;
    
    @FXML
    private Button btnAnulOp;


    @FXML
    void Annuler() {
    	txtNom.setText("");
    	txtTaille.setText("");
    	type.setText("");
    	cmbType.setValue("");
    }

    @SuppressWarnings("unchecked")
	@FXML
    void EnregistreOperation() throws IOException, ParseException {
	    	Zones zone = new Zones();
	    	zone.setId(zone.getLastId()+1);
	    	zone.setNom(txtNom.getText());
	    	zone.setTaille(Double.parseDouble(txtTaille.getText()));
	    	zone.setType((String)cmbType.getValue());
	    	
	    	JSONArray listezones = ReadWriteFileJson.readerFileJson("Zones");
	    	listezones.add(zone.tranformZoneToObjectJson());
			ReadWriteFileJson.writeFileJson("Zones", listezones);
			ReadWriteFileJson.showAlertWithHeaderText("Ajout Zone", "La zone a bien été crée");
			Annuler();
    }

    @FXML
    void cmbType() {

    }

	@SuppressWarnings("unchecked")
	@FXML
    void remplirListeType() throws FileNotFoundException, IOException, ParseException {
    	JSONArray json = ReadWriteFileJson.readerFileJson("Types");
    	ObservableList<String> fxc = FXCollections.observableArrayList();
    	json.forEach(j-> {
    		fxc.add((String) j);
    	});
    	cmbType.setItems(fxc);
    }
	
    @FXML
    void remplirListe() throws FileNotFoundException, IOException, ParseException {
    	cmbType.setValue("");
    	remplirListeType();
    }
    
    @SuppressWarnings("unchecked")
	@FXML
    void AjouterType() throws IOException, ParseException {
    	JSONArray listeTypes = ReadWriteFileJson.readerFileJson("Types");
    	listeTypes.add(type.getText().toString());
		ReadWriteFileJson.writeFileJson("Types", listeTypes);
		ReadWriteFileJson.showAlertWithHeaderText("Ajout type Zone", "Le type a bien été crée");
		type.setText("");
		
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			remplirListeType();
			remplirListeType();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
