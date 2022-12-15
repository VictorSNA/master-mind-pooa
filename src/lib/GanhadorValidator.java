package lib;
import java.util.ArrayList;
import java.util.Random;

public class GanhadorValidator extends Validator{
	public void isValido(ArrayList<Integer> numeros) {
		ArrayList<Integer> numerosPremiados = new ArrayList<Integer>();
		Random rand = new Random();

		for (int j = 0; j<5; j++)
        {
            numerosPremiados.add(rand.nextInt(6));
        }


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
