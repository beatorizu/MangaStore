package controller.add;

import model.Acervo;
import model.Manga;
import view.TelaAdicao;

public class AdicaoProibida implements Adicao {

	private TelaAdicao tela;
	private Acervo model;
	
	public AdicaoProibida(Acervo model) {
		this.model = model;
		tela = new TelaAdicao(model, this);
		tela.createView();	
	}
	
	public void adicionarManga(Manga manga) {
		model.addObserver(tela);
		tela.displayAddProibida();
		model.removeObserver(tela);
	}
	
}
