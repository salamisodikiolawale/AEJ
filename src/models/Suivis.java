package models;

import java.util.HashMap;

public class Suivis {
	
	private String couleur;
	private String date;
	private String note;
	private HashMap<Double, String> map = new HashMap<Double, String>();
	
	public Suivis() {
		
	}
	
	public String getCouleur() { return couleur;}
	public void setCouleur(String couleur) {this.couleur = couleur;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public String getNote() {return note;}
	public void setNote(String note) {this.note = note;}
	public HashMap<Double, String> getMap() {return map;}
	public void setMap(HashMap<Double, String> map) {this.map = map;}
	
	
}
