package lib;

/** 
 * ListaLigada � uma estrutura de dados linear livre, isto �, que permite
 * a adi��o e a remo��o de elementos em qualquer posi��o v�lida, utilizando
 * armazenamento sequencial.
 * Os elementos ficam encadeados, de modo que todos tenham um 
 * anterior e um pr�ximo (exceto o primeiro e �ltimo elementos).
 * Esta lista armazena valores de qualquer tipo.
 * 
 * @author pjandl
 */
public class ListaLigada {
	// Sentinela que "vigia" o in�cio da lista
	// Facilita percorrer a lista do in�cio ao fim
	private NodoLigado inicio = null;
	// Sentinela que "vigia" o final da lista
	// Facilita adi��o de elementos na lista (por padr�o, ocorre no fim)
	private NodoLigado fim = null;
	// Contador de elementos
	private int comprimento = 0;
	
	/**
	 *  Construtor default (padr�o) cria uma lista vazia.
	 *  
	 */
	public ListaLigada() {
		// sentinelas e contador j� inicializados
	}
	
	/**
	 * Adiciona um elemento no final da lista
	 * @param valor elemento de qualquer tipo a ser adicionado na lista.
	 */
	public void adicionar(Object valor) {
		// Forma alternativa, mais enxuta de realizar adi��o de elemento
		// inserir(0, valor);
		
		// Cria nodo para conter NOVO elemento
		NodoLigado novo = new NodoLigado(valor);
		// Encadear o NOVO nodo no final
		if (fim != null) { // fim n�o � null, fila n�o est� vazia
			fim.proximo = novo; // NOVO entra depois do �ltimo
		} else { // fim � null, fila est� vazia
			inicio = novo;
		}
		fim = novo;
		comprimento++;
	}

	/**
	 * Comprimento de uma estrutura de dados representa quantos elementos 
	 * ela cont�m (ocupa��o).
	 * @return n�mero inteiro de elementos presentes na estrutura
	 */
	public int comprimento() {
		return comprimento;
	}

	/**
	 * Consulta o valor existente numa posi��o dada da estrutura,
	 * sem que ocorra sua remo��o. 
	 * @param posicao inteiro entre 0 e comprimento()-1
	 * @return objeto contido na posi��o indicada
	 */
	public Object elemento(int posicao) {
		// obt�m refer�ncia para posi��o dada
		NodoLigado aux = referenciaElemento(posicao);
		// aux aponta para elemento da posi��o dada
		return aux.dado;
	}

	/**
	 * Insere um novo elemento na lista, na posi��o indicada.
	 * @param posicao inteiro entre 0 e comprimento()-1
	 * @param valor elemento de qualquer tipo a ser inserido na lista.
	 */
	public void inserir(int posicao, Object valor) {
		// Cria nodo para conter NOVO elemento
		NodoLigado novo = new NodoLigado(valor);
		if (posicao == 0) { // inser��o no in�cio da lista
			// Liga NOVO ao elemento da posi��o
			novo.proximo = inicio;
			// Fa�o NOVO como in�cio
			inicio = novo;
			if (comprimento == 0) {
				// lista vazia: NOVO ocupa fim e in�cio ao mesmo tempo
				fim = novo;
			}
		} else if (posicao == comprimento) { // inser��o no final da lista
			if (fim != null) {
				// Encadeia NOVO ap�s o fim
				fim.proximo = novo;
			} else {
				// lista vazia: NOVO ocupa fim e in�cio ao mesmo tempo
				fim = novo;
				inicio = novo;
			}
		} else { // inser��o em posi��es intermedi�rias da lista
			// obter refer�ncia para o nodo anterior
			NodoLigado anterior = referenciaElemento(posicao - 1);
			// Liga NOVO ao elemento da posi��o
			novo.proximo = anterior.proximo;
			// Liga ANTERIOR ao NOVO
			anterior.proximo = novo;
		}
		// atualiza comprimento da lista
		comprimento++;
	}
	
	/**
	 * Remove o elemento da posi��o indicada na lista.
	 * @param posicao inteiro entre 0 e comprimento()-1
	 * @return objeto contido na posi��o indicada
	 */
	public Object remover(int posicao) {
		if (comprimento == 0) { // lista vazia, remo��o imposs�vel
			throw new IllegalArgumentException("lista vazia");
		}
		NodoLigado aux = null; // refer�ncia para o elemento a ser removido
		if (posicao == 0) { // remo��o do elemento inicial
			aux = inicio;
			inicio = inicio.proximo; // atualizo a sentinela de inicio
			aux.proximo = null; // para desconectar o nodo aux da lista
			if (comprimento == 1) {
				fim = inicio; // fim = null;
			}
		} else if (posicao == comprimento - 1) { // remo��o do elemento final
			aux = fim;
			fim = referenciaElemento(posicao - 1); // atualizo a sentinela de fim
			fim.proximo = null; // para desconectar o nodo aux da lista
			if (comprimento == 1) {
				inicio = fim; // inicio = null;
			}
		} else if (posicao > 0 && posicao < comprimento - 1) { // remo��o de elemento intermediario
			NodoLigado ant = referenciaElemento(posicao - 1); // refer�ncia do elemento anterior
			aux = ant.proximo; // elemento a ser removido
			ant.proximo = aux.proximo; // desconecta ant de aux, pulando para pr�ximo
			aux.proximo = null; // desconectar aux da lista
		} else {
			throw new IllegalArgumentException("posi��o inv�lida: " + posicao);
		}
		comprimento--;
		return aux.dado;
	}
	
	/**
	 * Representa��o textual da estrutura.
	 * @return String com representa��o de texto da estrutura.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		// la�o para percorrer os elementos presentes na lista
		NodoLigado aux = inicio; // copia da sentinela de in�cio
		while (aux != null) {
			sb.append(aux.dado);
			if (aux.proximo != null) {
				sb.append(",");
			}
			aux = aux.proximo;
		}
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * Verifica se fila est� vazia.
	 * @return true se fila est� cheia, false caso contr�rio
	 */
	public boolean vazia() { // verificando se fila vazia
		return comprimento == 0;
	}

	private NodoLigado referenciaElemento(int posicao) {
		// validar posi��o dada
		validaPosicao(posicao);
		NodoLigado aux = inicio; // copia da sentinela de in�cio
		for(int p = 0; p < posicao; p++) {
			aux = aux.proximo;
		}
		return aux;
	}

	private void validaPosicao(int posicao) {
		if (posicao < 0 || posicao >= comprimento) {
			throw new IllegalArgumentException("posi��o invalida: " + posicao);
		}
	}
	
}
