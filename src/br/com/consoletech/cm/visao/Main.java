package br.com.consoletech.cm.visao;

import br.com.consoletech.cm.modelo.Tabuleiro;

public class Main {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(15, 15, 5);
		
		tabuleiro.registrarObservador(e -> {
			if(e.isGanhou()) {
				System.out.println("Ganhou :)");
			}else {
				System.out.println("Perdeu :(");
			}
		});
		
		tabuleiro.alteraMarcacao(0, 0);
		tabuleiro.alteraMarcacao(0, 1);
		tabuleiro.alteraMarcacao(0, 2);
		tabuleiro.alteraMarcacao(1, 0);
		tabuleiro.alteraMarcacao(1, 1);
		tabuleiro.alteraMarcacao(1, 2);
		tabuleiro.alteraMarcacao(2, 0);
		tabuleiro.alteraMarcacao(2, 1);
		tabuleiro.alteraMarcacao(2, 2);
		
	}

}
