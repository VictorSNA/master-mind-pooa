package lib;

public class Deque {
	// veste a lista peladinha de Deque (de Michel Myears)
	private ListaLigada lista = new ListaLigada();
	
	// s� faz de conta, a lista j� est� criada
	public Deque() { }
	// Deque insere nas duas pontas: in�cio e fim
	public void adicionarFim(Object valor) {
		lista.adicionar(valor);
	}
	public void adicionarInicio(Object valor) {
		lista.inserir(0, valor);
	}
	// a fantasia repassa o comando para lista
	public int comprimento() {
		return lista.comprimento();
	}
	public Object elemento(int posicao) {
		return lista.elemento(posicao);
	}
	public String toString() {
		return lista.toString();
	}
	public boolean vazia() {
		return lista.vazia();
	}
	// inserir n�o tem na Deque
	// Deque remove das duas pontas: in�cio e fim
	public Object removerInicio() {
		return lista.remover(0);
	}
	public Object removerFim() {
		return lista.remover(lista.comprimento()-1);
	}
}



