package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Genero;
import model.Manga;
import model.Spec;
import model.Subject;
import controller.add.Adicao;

public class TelaAdicao implements ActionListener, Observer {

	JFrame janela;
	
	JTextField txtTitulo;
	JTextField txtAutorHistoria;
	JTextField txtAutorArte;
	JTextField txtPreco;
	JTextField txtQuantidade;
	JComboBox<Genero> cmbGeneros;
	
	JLabel lblTitulo;
	JLabel lblAutorHistoria;
	JLabel lblAutorArte;
	JLabel lblGenero;
	JLabel lblPreco;
	JLabel lblQuantidade;
	JLabel lblResultado;
	
	JPanel pnlTitulo;
	JPanel pnlAutorHistoria;
	JPanel pnlAutorArte;
	JPanel pnlGenero;
	JPanel pnlPreco;
	JPanel pnlQuantidade;
	JPanel pnlBotao;
	JPanel pnlGeneros;
	
	JPanel pnlComponents;
	
	JButton btnAdicionar;

	private Adicao adicao;
	private Subject model;
	
	public TelaAdicao(Subject model, Adicao adicao) {
		this.model = model;
		this.adicao = adicao;
	}
	
	public void createView() {
		janela = new JFrame("Cadastro de Mangá");
		pnlComponents = new JPanel(new GridLayout(6,1));
		janela.getContentPane().setBackground(Color.WHITE);
		pnlComponents.setBackground(new Color(255,255,255));
		pnlBotao = new JPanel();

		pnlAutorArte = new JPanel();
		lblAutorArte = new JLabel("       Autor Arte: ");
		txtAutorArte = new JTextField(15);
		
		pnlAutorArte.add(BorderLayout.EAST,lblAutorArte);
		pnlAutorArte.add(BorderLayout.WEST,txtAutorArte);
		pnlAutorArte.setOpaque(false);
		
		pnlAutorHistoria = new JPanel();
		lblAutorHistoria = new JLabel("Autor História: ");
		txtAutorHistoria = new JTextField(15);
		
		pnlAutorHistoria.add(BorderLayout.EAST,lblAutorHistoria);
		pnlAutorHistoria.add(BorderLayout.WEST,txtAutorHistoria);
		pnlAutorHistoria.setOpaque(false);
		
		pnlTitulo = new JPanel();
		lblTitulo = new JLabel("               Título: ");
		txtTitulo = new JTextField(15);
		
		pnlTitulo.add(BorderLayout.EAST,lblTitulo);
		pnlTitulo.add(BorderLayout.WEST,txtTitulo);
		pnlTitulo.setOpaque(false);
		
		pnlPreco = new JPanel();
		lblPreco = new JLabel("             Preço: ");
		txtPreco = new JTextField(15);
		
		pnlPreco.add(BorderLayout.EAST,lblPreco);
		pnlPreco.add(BorderLayout.WEST,txtPreco);
		pnlPreco.setOpaque(false);
		
		pnlQuantidade = new JPanel();
		lblQuantidade = new JLabel("   Quantidade: ");
		txtQuantidade = new JTextField(15);
		
		pnlQuantidade.add(BorderLayout.EAST,lblQuantidade);
		pnlQuantidade.add(BorderLayout.WEST,txtQuantidade);
		pnlQuantidade.setOpaque(false);
		
		pnlBotao = new JPanel();
		btnAdicionar = new JButton("Adcionar");
		btnAdicionar.addActionListener(this);
		
		lblResultado = new JLabel("Resultado");
		
		pnlBotao.add(BorderLayout.NORTH,btnAdicionar);
		pnlBotao.add(BorderLayout.SOUTH,lblResultado);
		lblResultado.setOpaque(false);
		pnlBotao.setOpaque(false);
		
		pnlGeneros = new JPanel();
		cmbGeneros = new JComboBox<Genero>(Genero.values());
		lblGenero = new JLabel("Gênero:                 ");
		
		pnlGeneros.add(BorderLayout.EAST,lblGenero);
		pnlGeneros.add(BorderLayout.WEST,cmbGeneros);
		pnlGeneros.setOpaque(false);
		
		pnlComponents.add(pnlTitulo);
		pnlComponents.add(pnlAutorArte);
		pnlComponents.add(pnlAutorHistoria);
		pnlComponents.add(pnlPreco);
		pnlComponents.add(pnlQuantidade);
		pnlComponents.add(pnlGeneros);
		janela.add(BorderLayout.NORTH, pnlComponents);
		janela.add(BorderLayout.CENTER, pnlBotao);
		
		janela.pack();
		janela.setSize(300, 320);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(3);
		janela.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdicionar) {
			try {
				lblResultado.setText("Informe número em Preço e Quantidade.");
				adicao.adicionarManga(new Manga(Integer.parseInt(txtQuantidade.getText()), Double.parseDouble(txtPreco.getText()),new Spec(txtTitulo.getText(), (Genero)cmbGeneros.getSelectedItem(), txtAutorHistoria.getText(), txtAutorArte.getText())));
			}catch (java.lang.NumberFormatException ex) {
				
			}
		}
	}

	public void updateAdd(String msg) {
		lblResultado.setText(msg);
	}

	public void updateRemove(String msg) {
		
	}

	public void updateSearch(List<Manga> l) {
		
	}
	
	public void updateNotFound(String msg) {
		
	}
	
	public void displayAddAceita() {
		lblResultado.setText("Adicionando Mangá...");
	}
	
	public void displayAddProibida() {
		lblResultado.setText("Você não possui permissão para adicionar.");
	}
	
}
