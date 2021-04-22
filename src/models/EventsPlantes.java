package models;

public  class EventsPlantes {
	
	private int idEvent;
	private String Activite;
	private String DateEvent;
	private String NoteEvent;
	private String TypeEvent;
	private String idPlante;
	private String nomPlante;
	private String varietePlante;
	private String couleurPlante;
	private String datePlante;
	private String notePlante;
	private Double hauteur;
	private Double largeur;
	private Double poids;
	private String url;
	
	public EventsPlantes(int idEvent, String Activite, String DateEvent, String NoteEvent, String idPlante,
			String nomPlante, String varietePlante, String couleurPlante, String datePlante, String notePlante,
			Double hauteur, Double largeur, Double poids, String url, String TypeEvent) 
	{
	
		this.idEvent = idEvent;
		this.Activite = Activite;
		this.DateEvent = DateEvent;
		this.NoteEvent = NoteEvent;
		this.TypeEvent = TypeEvent;
		this.idPlante = idPlante;
		this.nomPlante = nomPlante;
		this.varietePlante = varietePlante;
		this.couleurPlante = couleurPlante;
		this.datePlante = datePlante;
		this.notePlante = notePlante;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.poids = poids;
		this.url = url;
		
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getActivite() {
		return Activite;
	}

	public void setActivite(String activite) {
		Activite = activite;
	}

	public String getDateEvent() {
		return DateEvent;
	}

	public void setDateEvent(String dateEvent) {
		DateEvent = dateEvent;
	}

	public String getNoteEvent() {
		return NoteEvent;
	}

	public void setNoteEvent(String noteEvent) {
		NoteEvent = noteEvent;
	}

	public String getIdPlante() {
		return idPlante;
	}

	public void setIdPlante(String idPlante) {
		this.idPlante = idPlante;
	}

	public String getNomPlante() {
		return nomPlante;
	}

	public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
	}

	public String getVarietePlante() {
		return varietePlante;
	}

	public void setVarietePlante(String varietePlante) {
		this.varietePlante = varietePlante;
	}

	public String getCouleurPlante() {
		return couleurPlante;
	}

	public void setCouleurPlante(String couleurPlante) {
		this.couleurPlante = couleurPlante;
	}

	public String getDatePlante() {
		return datePlante;
	}

	public void setDatePlante(String datePlante) {
		this.datePlante = datePlante;
	}

	public String getNotePlante() {
		return notePlante;
	}

	public void setNotePlante(String notePlante) {
		this.notePlante = notePlante;
	}

	public Double getHauteur() {
		return hauteur;
	}

	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
	}

	public Double getLargeur() {
		return largeur;
	}

	public void setLargeur(Double largeur) {
		this.largeur = largeur;
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTypeEvent() {
		return TypeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		TypeEvent = typeEvent;
	}
	
	
	
}
