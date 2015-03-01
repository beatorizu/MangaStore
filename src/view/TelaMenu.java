package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.add.AdicaoPermitida;
import model.Acervo;
import model.Manga;

public class TelaMenu implements ActionListener, Observer {

	static Acervo a;
	
	JFrame janela;
	
	JButton btnAdicionar;
	JButton btnBuscar;
	
	public void createView() {
		janela = new JFrame("Menu");
		
		btnAdicionar = new JButton("Adicionar");
		btnBuscar = new JButton("Buscar");
		
		janela.add(BorderLayout.NORTH, btnAdicionar);
		janela.add(BorderLayout.SOUTH, btnBuscar);
		
		janela.setVisible(true);
		janela.setSize(500, 350);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(3);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionar) {
			AdicaoPermitida add = new AdicaoPermitida(a);
		}
		if(e.getSource() == btnBuscar) {
			
		}
	}

	public void updateAdd(String msg) {
		
	}

	public void updateRemove(String msg) {
		
	}

	public void updateSearch(List<Manga> l) {
		
	}

	public void updateNotFound(String msg) {
		
	}
	
}
