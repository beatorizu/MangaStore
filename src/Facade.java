import controller.add.AdicaoPermitida;
import controller.print.ImpressaoParcial;
import model.Acervo;
import model.Genero;
import model.Manga;
import model.Spec;


public class Facade {
	
	public void iniciarAdicao(Acervo a) {
		AdicaoPermitida add = new AdicaoPermitida(a);
	}
	
	public void iniciarBusca(Acervo a) {
		ImpressaoParcial add = new ImpressaoParcial(a);
	}
	
	/*Testar adição com formulário
 		v.realizarAdd(new Manga(20, 15.90, new Spec("Naruto",Genero.SHOUNEN , "Masashi Kishimoto", "Masashi Kishimotto")));
		v.realizarAdd(new Manga(20, 15.90, new Spec("One Piece", Genero.SHOUNEN, "Eiichiro Oda", "Eiichiro Oda")));
		v.realizarAdd(new Manga(20, 15.90, new Spec("Bleach", Genero.SHOUNEN, "Tite Kubo", "Tite Kubo")));
		v.realizarAdd(new Manga(20, 15.90, new Spec("Claymore", Genero.SHOUNEN, "Norihiro Yagi", "Norihiro Yagi")));
	 */
	
	public static void inicializarAcervo(Acervo acervo) {
		acervo.addManga(new Manga(20, 15.90, new Spec("Fairy Tail", Genero.SHOUNEN, "Hiro Mashima", "Hiro Mashima")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Rave Master", Genero.SHOUNEN, "Hiro Mashima", "Hiro Mashima")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Ao no Exorcist", Genero.SHOUNEN, "Kazue Koto", "Kazue Koto")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Kuroko no Basket", Genero.SHOUNEN, "Fujimaki Tadatoshi", "Fujimaki Tadatoshi")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Vampire Knight", Genero.SHOUJOU, "Matsuri Hino", "Matsuri Hino")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Kuroshitsuji", Genero.SHOUNEN, "Toboso Yana", "Toboso Yana")));
		acervo.addManga(new Manga(20, 15.90, new Spec("BTOOOM!", Genero.SEINEN, "Junya Inoue", "Junya Inoue")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Death Note", Genero.SHOUNEN, "Tsugumi Ohba", "Takeshi Obata")));
		acervo.addManga(new Manga(20, 15.90, new Spec("Magico", Genero.SHOUNEN, "Iwamoto Naoki", "Iwamoto Naoki")));
	}
	
}
