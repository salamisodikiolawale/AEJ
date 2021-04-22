package models;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import application.ReadWriteFileJson;

public class Events{
	
	private int id;
	private String date;
	private String note;
	private String activite;
	@SuppressWarnings("unused")
	private String typeEvent;
	private ArrayList<Plantes> listePlante;
	
	

	public Events() {
	}
	
	public Events(String activite, String date, String note) {
		this.activite = activite;
		this.date = date;
		this.note = note;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject tranformEventToObjectJson() {
		JSONObject events = new JSONObject();
		events.put("IdEvent", getId());
		events.put("Activite", getActivite());
		events.put("Date", getDate());
		events.put("Note", getNote());
		events.put("TypeEvent", getTypeEvent());
		return events;
	}
	
	public int getLastId() throws IOException, ParseException {
		int var = 0;
		JSONArray liste_event = ReadWriteFileJson.readerFileJson("Events");
		JSONObject lastEvent ;
		if(liste_event!=null) {
			System.out.println("hhhh");
			lastEvent = (JSONObject) liste_event.get(liste_event.size()-1);
			var = Integer.parseInt(lastEvent.get("IdEvent").toString());
			return var;
		}
		System.out.println("Ici");
		return var;
	}
	
	public JSONObject getData(int id) throws IOException, ParseException {
		
		JSONArray jsonArray = ReadWriteFileJson.readerFileJson("Events");
		JSONObject data;
		for(int i=0; i<jsonArray.size(); i++) {
			data = (JSONObject) jsonArray.get(i);
			
			if(!data.isEmpty())
				if(Integer.parseInt(data.get("IdEvent").toString()) ==id)
					return data;
		};
		return null;
		
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}
	
	public JSONArray getActiviteList() throws IOException, ParseException {
		
		return  ReadWriteFileJson.readerFileJson("Activites");
		//return planteList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		this.typeEvent = typeEvent;
	}
	
	public ArrayList<Plantes> getListePlante() {
		return listePlante;
	}

	public void setListePlante(ArrayList<Plantes> listePlante) {
		this.listePlante = listePlante;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

}
