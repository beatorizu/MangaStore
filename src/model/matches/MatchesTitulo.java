package model.matches;

import model.Spec;

public class MatchesTitulo implements Matches {

	public boolean matches(Spec spec1, Spec spec2) {
		if(!spec1.getTitulo().equals(spec2.getTitulo())) return false;
		return true;
	}
	
}
