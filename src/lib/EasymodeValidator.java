package lib;
import java.util.ArrayList;
import java.util.Collections;

public class EasymodeValidator extends Validator{
	@Override
	public void isValido(ArrayList<Integer> numeros) {
		ArrayList<Integer> numerosPremiados = new ArrayList<Integer>();

		for (int j = 1; j<6; j++)
        {
            numerosPremiados.add(j);
        }

		Collections.shuffle(numerosPremiados);

		int proximoNumero = 0;
	    for(int numero : numeros) {
	    	System.out.println("Rodada " + (proximoNumero + 1) + ":  \nseu numero ---> numero correto       \n   " + numero + "       --->    " + numerosPremiados.get(proximoNumero));
	      if(numerosPremiados.get(proximoNumero) == numero) {
	    	  acertou();
	      }
	      proximoNumero++;
	    }
	
	    System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.println("Seus acertos: \n");
		System.out.println(getAcertos());
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	    if(getAcertos() >= 3) {
	    	valido();
	    }
	}
}
