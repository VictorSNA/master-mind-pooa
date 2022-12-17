package lib;

import java.util.ArrayList;
import java.util.Collections;

public class HardmodeValidator extends Validator{
	@Override
	public void isValido(ArrayList<Integer> numeros) {
		ArrayList<Integer> numerosPremiados = new ArrayList<Integer>();

		for (int j = 1; j<11; j++)
        {
            numerosPremiados.add(j);
        }

		Collections.shuffle(numerosPremiados);

		int proximoNumero = 0;
	    for(int numero : numeros) {
	      if(numerosPremiados.get(proximoNumero) == numero) {
	    	  acertou();
	      } else {
	    	  break;
	      }

	      proximoNumero++;
	    }
	
	    System.out.println(
				"---------------------------------------------------------------------------------------------");
	    System.out.println("Sua sequência: \n" + numeros.toString());
	    System.out.println("\nSequência correta: \n" + numerosPremiados.toString());
		System.out.println("Seus acertos: \n");
		System.out.println(getAcertos());
		System.out.println(
				"---------------------------------------------------------------------------------------------");
	    if(getAcertos() == 10) {
	    	valido();
	    }
	}
}
