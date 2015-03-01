import model.Acervo;

public class Teste {
	
	static Acervo a;
	
	public static void main(String[] args) {
		a = a.getInstance();
		Facade f = new Facade();
		f.iniciarAdicao(a);
	}
	
}
