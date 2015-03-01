package model.matches;

import model.Spec;

public class MatchesAutorHistoria implements Matches {

	public boolean matches(Spec spec1, Spec spec2) {
		if(!spec1.getAutorHistoria().equals(spec2.getAutorHistoria())) return false;
		return true;
	}
	
}
