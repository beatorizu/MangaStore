package model.matches;

import model.Spec;

public class MatchesAutorArte implements Matches {

	public boolean matches(Spec spec1, Spec spec2) {
		if(!spec1.getAutorArte().equals(spec2.getAutorArte())) return false;
		return true;
	}
	
}
