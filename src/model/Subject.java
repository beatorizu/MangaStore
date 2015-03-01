package model;

import java.util.List;
import view.Observer;

public interface Subject {
	
	public void addObserver(Observer observer);
	public void notifyObserversAdd();
	public void notifyObserversRemove();
	public void notifyObserversSearch(List<Manga> l);
	public void notifyObserversNotFound();
	public void removeObserver(Observer observer);

}
