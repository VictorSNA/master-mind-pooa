package lib;

public class Pilha extends ListaLigada{
	// veste a lista peladinha de Pilha (fantasia de Pilha SextaFeira-13)
	private ListaLigada lista = new ListaLigada();
	
	// s� faz de conta, a lista j� est� criada
	public Pilha() { }
	// a fantasia repassa o comando para lista
	public void adicionar(Object valor) {
		lista.adicionar(valor);
	}
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
	// inserir n�o tem na Pilha
	public Object remover() {
		// pilha s� remove do topo
		return lista.remover(lista.comprimento()-1);
	}
}



