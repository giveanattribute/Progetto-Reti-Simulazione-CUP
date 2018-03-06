
public class Ricetta {
	String reparto;
	String prestazione;
	String codice_ricetta;
	
	
	public Ricetta(String reparto, String prestazione, String codice_ricetta) {
		super();
		this.reparto = reparto;
		this.prestazione = prestazione;
		this.codice_ricetta = codice_ricetta;
	}
	
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public String getPrestazione() {
		return prestazione;
	}
	public void setPrestazione(String prestazione) {
		this.prestazione = prestazione;
	}
	public String getCodice_ricetta() {
		return codice_ricetta;
	}
	public void setCodice_ricetta(String codice_ricetta) {
		this.codice_ricetta = codice_ricetta;
	}
}
