package controller.print;

import model.Acervo;
import model.Spec;
import view.TelaBusca;

public class ImpressaoParcial implements Impressao {
	
	private TelaBusca tela;
	private Acervo model;
	
	public ImpressaoParcial(Acervo model) {
		this.model = model;
		tela = new TelaBusca(model, this);
		tela.createView();
	}
	
	public void executarBusca(Spec spec) {
		model.addObserver(tela);
		model.searchManga(spec);
		model.removeObserver(tela);
	}
	
	public void imprimirResultados() {
		tela.displayParcial();
	}

}
