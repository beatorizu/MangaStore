package view;

import java.util.List;

import model.Manga;

public interface Observer {

	public void updateAdd(String msg);
	public void updateRemove(String msg);
	public void updateSearch(List<Manga> l);
	public void updateNotFound(String msg);
	
}
