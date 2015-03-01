package model;

import model.matches.Matches;

public class Spec {
	
	private String titulo;
	private Genero genero;
	private String autorHistoria;
	private String autorArte;
	private Matches matches;
	
	public Spec(String titulo, Genero genero, String autorHistoria, String autorArte, Matches matches) {
		this.autorArte = autorArte;
		this.autorHistoria = autorHistoria;
		this.genero = genero;
		this.matches = matches;
		this.titulo = titulo;
	}
	
	public Spec(String titulo, Genero genero, String autorHistoria, String autorArte) {
		this.autorArte = autorArte;
		this.autorHistoria = autorHistoria;
		this.genero = genero;
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getAutorHistoria() {
		return autorHistoria;
	}
	public void setAutorHistoria(String autorHistoria) {
		this.autorHistoria = autorHistoria;
	}
	public String getAutorArte() {
		return autorArte;
	}
	public void setAutorArte(String autorArte) {
		this.autorArte = autorArte;
	}
	
	public void setMatches(Matches matches) {
		this.matches = matches;
	}
	
	public boolean matches(Spec spec) {
		if(matches.matches(this, spec)) return true;
		return false;
	}
	public String toString() {
		return "\nTítulo: " + titulo+"\nGênero: "+genero+"\nAutor História: "+autorHistoria+"\nAutor Arte: "+autorArte;
	}

}
