package br.com.consoletech.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.consoletech.cm.modelo.Campo;
import br.com.consoletech.cm.modelo.CampoEvento;
import br.com.consoletech.cm.modelo.CampoObservador;


@SuppressWarnings("serial")
public class BotaoCampo extends JButton 
   implements 	CampoObservador, MouseListener {
	
	private final Color BG_PADRAO = new Color(184,184,184);
	private final Color BG_MARCAR = new Color(8,179,247);
	private final Color BG_EXPLODIR = new Color(189,66,68);
	private final Color TEXTO_VERDE = new Color(0,100,0);
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
	    this.campo = campo;
	    setBackground(BG_PADRAO);
	    setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this); // registrando a função criada a baixo
		campo.registrador(this); // registrando campo
	}
	
	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		switch (evento) {
		case ABRIR:
			aplicarEstilAbrir();
			break;
		case MARCAR:
			aplicarEstilMarcar();
			break;
		case EXPLODIR:
			aplicarEstilExplodir();
			break;	
		default:
			aplicarEstiloPadrao();
		}
		
	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createBevelBorder(0));
		setText("");
	}

	private void aplicarEstilExplodir() {
		setBackground(BG_EXPLODIR);
		setForeground(Color.white);
		setText("X");
		
	}

	private void aplicarEstilMarcar() {
		setBackground(BG_MARCAR);
		setForeground(Color.BLACK);
		setText("M");
	}

	private void aplicarEstilAbrir() {
		
		if(campo.isMinado()) {
			setBackground(BG_EXPLODIR);	
			return;
		}
		
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		switch (campo.minasNaVizinhaca()) {
		case 1:	
			setForeground(TEXTO_VERDE);
			break;
		case 2:	
			setForeground(Color.BLUE);
			break;
		case 3:	
			setForeground(Color.YELLOW);
			break;
		case 4:case 5: case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
		}
		String valor = !campo.vizinhacaSegura() ? campo.minasNaVizinhaca() +
				"" : "";	
		setText(valor);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			System.out.println("Botão Esquerdo");
			campo.abrir();
		}else {
			System.out.println("Batão Direito");
			campo.alternarMarcacao();
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

}
