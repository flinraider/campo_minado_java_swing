package br.com.consoletech.cm.visao;

import javax.swing.JFrame;

import br.com.consoletech.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	
	public 	TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);
		
		/*PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
		add(painelTabuleiro);*/
		
		add(new PainelTabuleiro(tabuleiro));
			 
		
		setTitle("Campo Mindado");
		setSize(690,438);
		setLocationRelativeTo(null); //para aparecer no centro	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new TelaPrincipal();
	}
	
}
