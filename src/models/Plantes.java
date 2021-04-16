package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;

public class Plantes{
	
	private String id;
	private String nom;
	private String variete;
	private String couleur;
	private String date;
	private String note;
	private Double hauteur;
	private Double largeur;
	private Double LongeurFeuille;
	private Double poids;
	private String url;
	private HashMap<String, Double> mesures =  new HashMap<String, Double>();
	private List<String> HauteurLargeurPoid = new ArrayList<String>();
	private JSONArray planteList = new JSONArray();
	private JSONObject PlanteJson;
	private static boolean isUpdate = false;
	private static String idUpdate;
	private static String idShow;
	
	
	public Plantes() {
	}
	
//	public Plantes(String id,String nom, String variete, String couleur, String date, 
//			String note, HashMap<String, Double> mesures, List<String> hauteurLargeurPoid, String LongeurFeuille) {
//		this.setId(id);
//		this.setNom(nom);
//		this.setVariete(variete);
//		this.setCouleur(couleur);
//		this.setDate(date);
//		this.setNote(note);
//		this.setMesures(mesures);
//		this.setHauteurLargeurPoid(hauteurLargeurPoid);
//		this.setLongeurFeuille(LongeurFeuille);
//	}
//	

	
	
	public static JSONObject getData(String id) throws IOException, ParseException {
		JSONArray jsonArray = ReadWriteFileJson.readerFileJson("Plantes");
		JSONObject data;
		for(int i=0; i<jsonArray.size(); i++) {
			data = (JSONObject) jsonArray.get(i);
			
			if(!data.isEmpty())
				if(data.get("Id").toString().equals(id))
					return data;
		};
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject tranformPlanteToObjectJson() {
		PlanteJson = new JSONObject();
		PlanteJson.put("Id", getId());
		PlanteJson.put("Nom", getNom());
		PlanteJson.put("Variete", getVariete());
		PlanteJson.put("Couleur", getCouleur());
		PlanteJson.put("Date", getDate());
		PlanteJson.put("Note", getNote());
		PlanteJson.put("Mesures", getMesures());
		PlanteJson.put("Unite", getHauteurLargeurPoid());
		PlanteJson.put("Url", getUrl());
		return PlanteJson;
	}

	public String getId() {
		return id;
	}
	String i="";
	@SuppressWarnings("unchecked")
	public String getId(String nom) throws IOException, ParseException {
		JSONArray js = ReadWriteFileJson.readerFileJson("Plantes");
		
		js.forEach(p -> {
			JSONObject pl = (JSONObject) p;
			if(!pl.isEmpty())
				if(pl.get("Nom").toString().equals(nom)) {
					i = pl.get("Id").toString();
					return;
				}
		});
		return i;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Plantes getLastData() {
		return null;
			//System.out.println("lastData");
			//return planteList.get(Plantes.planteList.size()-1);
	
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVariete() {
		return variete;
	}

	public void setVariete(String variete) {
		this.variete = variete;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) { this.note = note; }

	public HashMap<String,Double> getMesures() { return mesures; }

	public void setMesures(String KeyName, Double value) { this.mesures.put(KeyName, value); }
	


	public List<String> getHauteurLargeurPoid() { return HauteurLargeurPoid; }

	public void setHauteurLargeurPoid(String mesureName) { this.HauteurLargeurPoid.add(mesureName); }

	public Double getHauteur() {return hauteur;}
	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
		setMesures("Hauteur", hauteur);
	}

	public Double getLargeur() {return largeur;}

	public void setLargeur(Double largeur) {
		this.largeur = largeur;
		setMesures("Largeur", largeur);
	}

	public Double getPoids() {return poids;}
	
	public void setPoids(Double poids) {
		this.poids = poids;
		setMesures("Poids", poids);
	}
	
	public Double getLongeurFeuille() {return LongeurFeuille;}
	public void setLongeurFeuille(Double longeurFeuille) {
		LongeurFeuille = longeurFeuille;
		setMesures("LongeurFeuille", LongeurFeuille);
	}
	
	public String getUrl() { return url; }

	public void setUrl(String fInputS) { this.url = fInputS; }

	public JSONArray getPlanteList() throws IOException, ParseException {
		return  ReadWriteFileJson.readerFileJson("Plantes");
	}

	public void addPlanteList(Plantes plante) { /*Plantes.planteList.add(plante);*/ }

	public static boolean isUpdate() {
		return isUpdate;
	}

	public static void setIsUpdate(boolean isUpdate) {
		Plantes.isUpdate = isUpdate;
	}

	public static String getIdUpdate() {
		return idUpdate;
	}

	public static void setIdUpdate(String idUpdate) {
		Plantes.idUpdate = idUpdate;
	}

	public static String getIdShow() {
		return idShow;
	}

	public static void setIdShow(String idShow) {
		Plantes.idShow = idShow;
	}

}
