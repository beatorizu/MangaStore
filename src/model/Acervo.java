package model;

import model.Manga;

import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import view.Observer;

public class Acervo implements Subject {

	private static Acervo uniqueInstance;
	
	public static Acervo getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Acervo();
		}
		return uniqueInstance;
	}
	
	private List<Observer> observers;
	ObjectContainer mangas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "./db/mangas.db4o");
	
	public Acervo() {
		observers = new LinkedList<Observer>();
	}
	
	public void addManga(Manga manga) {
		mangas.store(manga);
		mangas.commit();
		notifyObserversAdd();
	}
	
	public void searchManga(Spec spec) {
		List<Manga> matchingMangas = new LinkedList<Manga>();
		ObjectSet<Manga> acervo = mangas.query(Manga.class);
		for(Manga m: acervo) {
			if(spec.matches(m.getSpec())) matchingMangas.add(m);
		}
		notifyObserversSearch(matchingMangas);
	}
	
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notifyObserversAdd() {
		for(Observer ob: observers) {
			ob.updateAdd("Mangá cadastrado com sucesso.");
		}
	}
	
	public void notifyObserversSearch(List<Manga> l) {
		for(Observer ob: observers) {
			ob.updateSearch(l);
		}
	}
	
	public void notifyObserversRemove() {
		for(Observer ob: observers) {
			ob.updateRemove("Mangá removido com sucesso.");
		}
	}
	
	public void notifyObserversNotFound() {
		for(Observer ob: observers) {
			ob.updateNotFound("Nenhum mangá foi encontrado.");
		}
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
}
