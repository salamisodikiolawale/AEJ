package models;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;

public class Zones {
	
	private int Id;
	private String nom;
	private String type;
	private String nvType;
	private double taille;
	
	public Zones() {
	}
	
	public Zones(int id, String nom, String type, double taille) {
		setId(id);
		setNom(nom);
		setType(type);
		setTaille(taille);
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject tranformZoneToObjectJson() {
		JSONObject jsonZone = new JSONObject();
    	jsonZone.put("IdZone", getId());
    	jsonZone.put("Nom", getNom());
    	jsonZone.put("Taille", getTaille());
    	jsonZone.put("Type", getType());
    	return jsonZone;
	}
	
	
	public int getLastId() throws IOException, ParseException {
		
		JSONArray liste_zone = ReadWriteFileJson.readerFileJson("Zones");
		if(liste_zone.size()<1)
			return 0;
		JSONObject lastZone = (JSONObject) liste_zone.get(liste_zone.size()-1);
		int var = Integer.parseInt(lastZone.get("IdZone").toString());
		return var;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getNvType() {
		return nvType;
	}

	public void setNvType(String nvType) {
		this.nvType = nvType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}


}
