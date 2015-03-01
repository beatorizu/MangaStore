package model;

public class Manga {
	
	private int quantidade;
	private double preco;
	private Spec spec;
	
	public Manga(int quantidade, double preco, Spec spec) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.spec = spec;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Spec getSpec() {
		return spec;
	}
	public void setSpec(Spec spec) {
		this.spec = spec;
	}
	
	public String toString() {
		return spec+"\nQuantidade: "+quantidade+"\nPreço: "+preco;
	}

}
