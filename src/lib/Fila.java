package lib;

public class Fila {
	// veste a lista peladinha de Fila (de Bruxa de Blair)
	private ListaLigada lista = new ListaLigada();
	
	// s� faz de conta, a lista j� est� criada
	public Fila() { }
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
	// inserir n�o tem na Fila
	public Object remover() {
		// fila s� remove do in�cio
		return lista.remover(0);
	}
}



