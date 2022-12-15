package lib;

import java.util.ArrayList;

public class Validator {
	private boolean valido = false;
	private int acertos = 0;

	public void isValido(ArrayList<Integer> numeros) {
		return;
	}

	public void isValido(Integer[] numeros) {
		return;
	}

	public int getAcertos() {
		return acertos;
	}
	
	protected void acertou() {
		this.acertos++;
	}
	
	public boolean ganhador() {
		return valido;
	}
	
	protected void valido() {
		this.valido = true;
	}
}
