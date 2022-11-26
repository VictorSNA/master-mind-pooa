package lib;

public class NodoLigado {
	public Object dado = null;		   // conte�do do nodo (elemento da lista)
	public NodoLigado proximo = null; // refer�ncia para o pr�ximo elemento da lista
	
	// construtor default (n�o faz nada)
	public NodoLigado() {
	}

	// construtor parametrizado com dado
	public NodoLigado(Object dado) {
		this.dado = dado;
	}

	// construtor parametrizado com dado e com a liga��o para o proximo
	public NodoLigado(Object dado, NodoLigado proximo) {
		this.dado = dado;
		this.proximo = proximo;
	}

	@Override
	public String toString() {
		String resultado = dado.toString();
		if (proximo != null) resultado += "," + proximo.toString();
		return resultado;
//		return "NodoLigado [dado=" + dado + ", proximo=" + proximo + "]";
	}

}
