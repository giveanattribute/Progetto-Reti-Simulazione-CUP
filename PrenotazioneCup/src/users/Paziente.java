package users;

public class Paziente {
	String nome;
	String cognome;
	String codice_prenotazione;
	
	
	
	
	public Paziente(String nome, String cognome, String codice_prenotazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codice_prenotazione = codice_prenotazione;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodice_prenotazione() {
		return codice_prenotazione;
	}
	public void setCodice_prenotazione(String codice_prenotazione) {
		this.codice_prenotazione = codice_prenotazione;
	}
	
	
	
}
