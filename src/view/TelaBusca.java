package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.Acervo;
import model.Genero;
import model.Manga;
import model.Spec;
import model.matches.MatchesAutorArte;
import model.matches.MatchesAutorHistoria;
import model.matches.MatchesTitulo;
import controller.print.Impressao;

public class TelaBusca implements ActionListener, Observer {
	
	JFrame janela;
	
	JButton btnBuscar;
	
	JRadioButton rdbAutorArte;
	JRadioButton rdbAutorHistoria;
	JRadioButton rdbTitulo;
	
	ButtonGroup btngModoBusca;
	
	JPanel pnlAutorArte;
	JPanel pnlAutorHistoria;
	JPanel pnlTitulo;
	JPanel pnlModoBusca;
	JPanel pnlargumento;
	
	JTextField txtArgumento;
	JTextArea txtResultado;
	JScrollPane scroll;
	
	JComboBox<Genero> cmbGeneros;
	
	private Acervo model;
	private Impressao impressao;
	private List<Manga> mangas;
	private Map<String, Spec> spec;
	
	public TelaBusca(Acervo model, Impressao impressao) {
		mangas = new LinkedList<>();
		this.model = model;
		this.impressao = impressao;
		spec = new HashMap<String,Spec>();
	}
	
	public void createView() {
		cmbGeneros = new JComboBox<Genero>(Genero.values());
		cmbGeneros.setOpaque(false);
		janela = new JFrame("Busca de Mangá");
		janela.setLayout(new FlowLayout());
		janela.getContentPane().setBackground(Color.WHITE);
		
		btngModoBusca = new ButtonGroup();
		
		rdbAutorArte = new JRadioButton("Autor Arte");
		rdbAutorArte.setActionCommand("AutorArte");
		rdbAutorArte.setOpaque(false);
		
		rdbAutorHistoria = new JRadioButton("Autor História");
		rdbAutorHistoria.setActionCommand("AutorHistoria");
		rdbAutorHistoria.setOpaque(false);
		
		rdbTitulo = new JRadioButton("Título");
		rdbTitulo.setActionCommand("Titulo");
		rdbTitulo.setOpaque(false);
		
		btngModoBusca.add(rdbAutorArte);
		btngModoBusca.add(rdbAutorHistoria);
		btngModoBusca.add(rdbTitulo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		
		txtArgumento = new JTextField(25);
		txtResultado = new JTextArea(10, 35);
		txtResultado.setEditable(false);
		txtResultado.setBackground(new Color(250,250,250));
		//txtResultado.setWrapStyleWord(true);  
		//txtResultado.setLineWrap(true);
		scroll= new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		txtResultado.add(scroll);
		pnlAutorArte = new JPanel();
		pnlAutorArte.add(rdbAutorArte);
		pnlAutorArte.setOpaque(false);
		
		pnlAutorHistoria = new JPanel();
		pnlAutorHistoria.add(rdbAutorHistoria);
		pnlAutorHistoria.setOpaque(false);
		
		pnlTitulo = new JPanel();		
		pnlTitulo.add(rdbTitulo);
		pnlTitulo.setOpaque(false);
		
		pnlModoBusca = new JPanel(new GridLayout(1, 3));
		pnlModoBusca.add(pnlAutorArte);
		pnlModoBusca.add(pnlAutorHistoria);
		pnlModoBusca.add(pnlTitulo);
		pnlModoBusca.setOpaque(false);
		
		pnlargumento = new JPanel();
		pnlargumento.add(txtArgumento);
		pnlargumento.add(btnBuscar);
		pnlargumento.setOpaque(false);
		
		janela.add(BorderLayout.NORTH,pnlModoBusca);
		janela.add(BorderLayout.CENTER,pnlargumento);
		janela.add(BorderLayout.SOUTH,txtResultado);
		//janela.add(scroll);
		
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setSize(400, 320);
		janela.setDefaultCloseOperation(3);
		janela.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		spec.put("AutorArte", new Spec("", null, "", txtArgumento.getText(), new MatchesAutorArte()));
		spec.put("AutorHistoria", new Spec("", null, txtArgumento.getText(), "", new MatchesAutorHistoria()));
		spec.put("Titulo", new Spec(txtArgumento.getText(), null, "", "", new MatchesTitulo()));
		if(e.getSource() == btnBuscar) {
			try {
				String g = btngModoBusca.getSelection().getActionCommand();
				impressao.executarBusca(spec.get(g));
			}catch (java.lang.NullPointerException ex) {
				txtResultado.setText("");
				txtResultado.append("Informe o tipo da busca.");
			}
		}
	}
	
	public void updateAdd(String msg) {
		
	}

	public void updateRemove(String msg) {
		
	}

	public void updateNotFound(String msg) {
		txtResultado.setText(msg);
	}
	
	public void updateSearch(List<Manga> l) {
		mangas = l;
		impressao.imprimirResultados();
	}
	
	public void displayParcial() {
		txtResultado.setText("");
		if(!mangas.isEmpty()) {
			for(Manga manga: mangas) {
				txtResultado.append("\n## View de Leitura ##" + manga.getSpec().toString() + "\n##----------------##");
			}
		}else txtResultado.append("Nenhum mangá foi encontrado.");
	}
	
	public void displayCompleto() {
		txtResultado.setText("");
		if(!mangas.isEmpty()) {
			for(Manga manga: mangas) {
				txtResultado.append("\n## View de Compra ##" + manga.toString() + "\n##----------------##");
			}
		}else txtResultado.append("Nenhum mangá foi encontrado.");
	}

}
