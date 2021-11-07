package models;

import java.util.List;

public class Katedra {

	public int sifra;
	public String naziv;
	public Profesor sef;
	public List<Profesor> profesori;
	
	public Katedra(int sifra, String naziv, Profesor sef) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.sef = sef;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Profesor getSef() {
		return sef;
	}

	public void setSef(Profesor sef) {
		this.sef = sef;
	}
}
