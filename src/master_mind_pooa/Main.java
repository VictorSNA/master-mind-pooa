package master_mind_pooa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import lib.ListaLigada;
import lib.Pilha;


public class Main {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListaLigada lista = new ListaLigada();
		Pilha pilha = new Pilha();
		int x;
		char c, r;
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		Collections.shuffle(list);
		
		lista.adicionar(list);
		
		
		System.out.println("Bem vindo ao MisterMind!\nNeste pequeno e simples jogo voc� deve acertar a sequ�ncia embaralhada de 1 a 5.\n"
				+ "A vit�ria � consagrada caso voc� acerte ao menos 3 n�meros em suas respectivas posi��es! Isto pois h� 120 possibilidades de sequ�ncias poss�veis!\n\n"
				+ "Regras:\n"
				+ "- Voc� n�o ter� nenhuma dica de qual � a sequ�ncia que deve acertar.\n"
				+ "- Ap�s inserir o primeiro n�mero que acha ser o correto, ter� oportunidade de repensar em sua escolha e fazer a troca do valor.\n"
				+ "- No fim do jogo ser� mostrado a sua sequ�ncia e a sequ�ncia que a sua deveria ser semelhante.\n"
				+ "- N�o h� segundas tentativas, uma vez inserido todos os valores, sua sequ�ncia estar� pronta!\n\n"
				+ "										Boa Sorte!\n");
		
		for(int i=0; i<=4; i++) {
			
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("\nInsira um número para sequ�ncia: ");
			x = tec.nextInt();
			
			if(x > 5 || x <= 0) {
				
				System.out.println("-----------------------------------");
				System.out.println("\nErro! N�mero inv�lido\n");
				break;
				
			}else {
				
				pilha.adicionar(x);
				System.out.println("-----------------------------------");
				System.out.println("\nDeseja trocar este n�mero?");
				c = tec.next().charAt(0);
				
				if(c == 's') {
					
					pilha.remover();
					
				}else {
					
					System.out.println("-----------------------------------");
					System.out.println("\nN�mero mantido!\n");
					
				}
			}
			
		}
		
		int acertos;
		
		System.out.println("\nSua sequ�ncia �: "+pilha.toString());
		System.out.println("\nA sequ�ncia correta �: "+lista.toString());
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("\nHora da verdade, caro jogador!!\n");
		System.out.println("\nAgora insira a quantidade de acertos que teve: ");
		acertos = tec.nextInt();
		
		if(acertos < 3) {
			System.out.println("\nQue pena... Voc� n�o obteve a quantidade correta pra ser um MasterMind.\n Mas n�o des�nime! Tente novamente at� se tornar um grande MasterMind!!\n");
			System.out.println("---------------------------------------------------------------------------------------------");
		}else if(acertos < 0 || acertos > 5){
			System.out.println("\nN�mero inv�lido. Tentativa de Vit�ria cancelada por motivo de trapa�a!\nQue pena, lhe falta sabedoria pra ser um MasterMind.");
			System.out.println("---------------------------------------------------------------------------------------------");
		}else if(acertos > 3){
			System.out.println("\nPar�bens Jogador, M�ximo respeito! Voc� � um verdadeiro Mastermind!!\n");
			System.out.println("---------------------------------------------------------------------------------------------");
		}else {
			System.out.println("\nPar�bens Jogador, Voc� est� no caminho pra se tornar um verdadeiro MasterMind!\n");
			System.out.println("---------------------------------------------------------------------------------------------");
		}
		
		System.out.println("\n----------REINICIE O C�DIGO PARA UMA NOVA TENTATIVA----------");
		
	}

}
