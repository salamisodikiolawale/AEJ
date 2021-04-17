package models;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;

public class Suivis {
	
	private int id;
	private String couleur;
	private String date;
	private String note;
	private double Hauteur;
	private String UniteH;
	private double Largeur;
	private String UniteL;
	private String UniteP;
	private double Poids;
	private String idPlante;
	private String url;
	private String nomPl;
	private String variete;
	
	public Suivis() {
		
	}
	
	public String getCouleur() { return couleur;}
	public void setCouleur(String couleur) {this.couleur = couleur;}
	public String getDate() {return date;}
	public void setDate(String string) {this.date = string;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}

	@SuppressWarnings("unchecked")
	public JSONObject tranformSuiviToObjectJson() {
		JSONObject jsonSuivs = new JSONObject();
		jsonSuivs.put("IdPLante", getIdPlante());
		jsonSuivs.put("IdSuivi", getId());
		jsonSuivs.put("Couleur", getCouleur());
		jsonSuivs.put("Hauteur", getHauteur());
		jsonSuivs.put("Largeur", getLargeur());
		jsonSuivs.put("Poids", getPoids());
		jsonSuivs.put("Note", getNote());
		jsonSuivs.put("UniteH", getUniteH());
		jsonSuivs.put("UniteL", getUniteL());
		jsonSuivs.put("UniteP", getUniteP());
		jsonSuivs.put("Date", getDate());
		jsonSuivs.put("Url", getUrl());
    	return jsonSuivs;
	}
	
	public int getLastId() throws IOException, ParseException {
		
		JSONArray liste_suivis = ReadWriteFileJson.readerFileJson("Suivis");
		if(liste_suivis.size()<1)
			return 0;
		JSONObject lastSuivis = (JSONObject) liste_suivis.get(liste_suivis.size()-1);
		int var = Integer.parseInt(lastSuivis.get("IdSuivi").toString());
		return var;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdPlante() {
		return idPlante;
	}

	public void setIdPlante(String idPlante2) {
		this.idPlante = idPlante2;
	}

	public double getHauteur() {
		return Hauteur;
	}

	public void setHauteur(double hauteur) {
		Hauteur = hauteur;
	}
	
	public void setHauteur(double hauteur, String unite) {
		Hauteur = hauteur;
		UniteH = unite;
	}

	public double getPoids() {
		return Poids;
	}

	public void setPoids(double poids) {
		Poids = poids;
	}
	
	public void setPoids(double poids, String unite) {
		Poids = poids;
		UniteP = unite;
	}

	public double getLargeur() {
		return Largeur;
	}

	public void setLargeur(double largeur) {
		Largeur = largeur;
	}
	
	public void setLargeur(double largeur, String unite) {
		Largeur = largeur;
		UniteL = unite;
	}

	public String getUniteH() {
		return UniteH;
	}

	public void setUniteH(String uniteH) {
		UniteH = uniteH;
	}

	public String getUniteL() {
		return UniteL;
	}

	public void setUniteL(String uniteL) {
		UniteL = uniteL;
	}

	public String getUniteP() {
		return UniteP;
	}

	public void setUniteP(String uniteP) {
		UniteP = uniteP;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String string) {
		this.url = string;
	}

	public String getNomPl() {
		return nomPl;
	}

	public void setNomPl(String nomPl) {
		this.nomPl = nomPl;
	}

	public String getVariete() {
		return variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	
	
}
