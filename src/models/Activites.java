package models;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;

public class Activites {
	
	private int Id;
	private String libelle;

	public Activites() {
		
	}
	public Activites(int id, String libelle) {
		this.setId(id);
		this.setLibelle(libelle);
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public int getLastId() throws IOException, ParseException {
		JSONArray liste_act = ReadWriteFileJson.readerFileJson("Activites");
		JSONObject lastAct = (JSONObject) liste_act.get(liste_act.size()-1);
		int var = Integer.parseInt(lastAct.get("IdAct").toString());
		return var;
	}
	@SuppressWarnings("unchecked")
	public JSONObject tranformActiviteToObjectJson(int id, String libelle) {
		JSONObject activite = new JSONObject();
		activite.put("IdAct", id);
		activite.put("libelle", libelle);
		return activite;
	}
	
	@SuppressWarnings("unchecked")
	public void ajouterActivite(String libelle) throws IOException, ParseException {
		JSONArray liste_act = ReadWriteFileJson.readerFileJson("Activites");
		liste_act.add(this.tranformActiviteToObjectJson(getLastId(), libelle));
		ReadWriteFileJson.writeFileJson("Activites", liste_act);
		ReadWriteFileJson.showAlertWithHeaderText("Création de l'évènement", "Votre évènement a bien été enregistrer");
	}
	
	public JSONArray activiteList() throws IOException, ParseException {
		return ReadWriteFileJson.readerFileJson("Activites");
	}

}
