package master_mind_pooa;
import java.util.ArrayList;
import java.util.Scanner;

import lib.EasymodeValidator;
import lib.HardmodeValidator;


public class Main {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		ArrayList<Integer> lista = new ArrayList<Integer>();
		EasymodeValidator gv = new EasymodeValidator();
		HardmodeValidator hard = new HardmodeValidator();

		int x;
		int m = 1;

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
			System.out.println(
					"\n(1)MODO FACIL: 5 números e 3 acertos\n(2)MODO HARD: 10 números e 10 acertos e todos em sequência");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
			m = tec.nextInt();
			if(m == 1) {
				for (int i = 0; i <= 4; i++) {
					System.out.println("\nInsira um número para sequência: " + "(" + (i+1)+"/5)");
					x = tec.nextInt();
					lista.add(x);
					System.out.println("-----------------------------------");

				}
			} else {
				for (int i = 0; i <= 9; i++) {
					System.out.println("\nInsira um número para sequência: " + "(" + (i+1)+"/10)");
					x = tec.nextInt();
					lista.add(x);
					System.out.println("-----------------------------------");

				}
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("Nao eh um numero, por favor reinicie o jogo e tente novamente.");
			System.exit(0);
		}

		
		
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("\nHora da verdade, caro jogador!!\n");

		boolean ganhador = false;
		if(m == 1) {
			gv.isValido(lista);
			ganhador = gv.ganhador();
		} else {
			hard.isValido(lista);
			ganhador = hard.ganhador();
		}
		
		if (!ganhador) {
			System.out.println(
					"\nQue pena... Você não obteve a quantidade correta pra ser um MasterMind.\n Mas não desânime! Tente novamente até se tornar um grande MasterMind!!\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		} else {
			System.out.println("\nParábens Jogador, Máximo respeito! Você é um verdadeiro Mastermind!!\n");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}

		System.out.println("\n----------REINICIE O CÓDIGO PARA UMA NOVA TENTATIVA----------");
		{

		}
	}
}

