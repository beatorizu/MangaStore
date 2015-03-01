package model.matches;

import model.Spec;

public class MatchesGenero implements Matches {

	public boolean matches(Spec spec1, Spec spec2) {
		if(!spec1.getGenero().equals(spec2.getGenero())) return false;
		return true;
	}
	
}
