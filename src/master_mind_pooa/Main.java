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

		System.out.println(
				"Bem vindo ao MasterMind!\nNeste pequeno e simples jogo você deve acertar a sequência embaralhada de 1 a 5.\n"
						+ "A vitória é consagrada caso você acerte ao menos 3 números em suas respectivas posições! Isto pois há 120 possibilidades de sequências possíveis!\n\n"
						+ "Regras:\n" + "- Você não terá nenhuma dica de qual é a sequência que deve acertar.\n"
						+ "- Após inserir o primeiro número que acha ser o correto, terá oportunidade de repensar em sua escolha e fazer a troca do valor.\n"
						+ "- No fim do jogo será mostrado a sua sequência e a sequência que a sua deveria ser semelhante.\n"
						+ "- Não há segundas tentativas, uma vez inserido todos os valores, sua sequência estará pronta!\n\n"
						+ "										Boa Sorte!\n");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		try {
			for (int i = 0; i <= 4; i++) {

				System.out.println("\nInsira um número para sequência: ");
				x = tec.nextInt();

				if (x > 5 || x <= 0) {

					System.out.println("-----------------------------------");
					System.out.println("\nErro! Número inválido\n");
					break;

				} else {

					pilha.adicionar(x);
					System.out.println("-----------------------------------");
					System.out.println("\nDeseja trocar este número?");
					c = tec.next().charAt(0);

					if (c == 's') {

						pilha.remover();

					} else {

						System.out.println("-----------------------------------");
						System.out.println("\nNúmero mantido!\n");

					}
				}

			}
		} catch (Exception erro) {
			System.out.println("Você cometeu um erro!!" + erro);
		}

		int acertos;

		System.out.println("\nSua sequência é: " + pilha.toString());
		System.out.println("\nA sequência correta é: " + lista.toString());
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("\nHora da verdade, caro jogador!!\n");
		System.out.println("\nAgora insira a quantidade de acertos que teve: ");
		acertos = tec.nextInt();

		if (acertos < 3) {
			System.out.println(
					"\nQue pena... Você não obteve a quantidade correta pra ser um MasterMind.\n Mas não desânime! Tente novamente até se tornar um grande MasterMind!!\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else if (acertos < 0 || acertos > 5) {
			System.out.println(
					"\nNúmero inválido. Tentativa de Vitória cancelada por motivo de trapaça!\nQue pena, lhe falta sabedoria pra ser um MasterMind.");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else if (acertos > 3) {
			System.out.println("\nParábens Jogador, Máximo respeito! Você é um verdadeiro Mastermind!!\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else {
			System.out.println("\nParábens Jogador, Você está no caminho pra se tornar um verdadeiro MasterMind!\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}

		System.out.println("\n----------REINICIE O CÓDIGO PARA UMA NOVA TENTATIVA----------");

		{

		}
	}
}

