import java.util.Random;

public class Main {
	/*
	 * A) Dado um vetor com números pares e ímpares, escreva um método int[]
	 * separaParImpar(int[] vet); para colocar todos os números pares à frente no
	 * vetor e os ímpares ao final. Escreva o método em duas versões: Usando um
	 * vetor auxiliar para fazer a movimentação Sem usar outro vetor (in place) B)
	 * Analise a complexidade de cada implementação (Oh(), Omega() e Theta(), melhor
	 * e pior caso) e diga quantas iterações cada uma executa, em função do tamanho
	 * da entrada;
	 * 
	 * C) Execute ambas as implementações para entradas com a seguinte configuração:
	 * 100 elementos, 50 pares e 50 ímpares; 100 elementos, 20 pares e 80 ímpares;
	 * 100 elementos, 80 pares e 20 ímpares; 500.000 elementos, 250.000 pares e
	 * 250.000 ímpares; 500.000 elementos, 100.000 pares e 400.000 ímpares; 500.000
	 * elementos, 400.000 pares e 100.000 ímpares; Compararemos resultados na
	 * próxima aula.
	 */
	public static int[] parImpar2Vet(int[] v) {
		int[] vAux = new int[v.length];
		int pImp = v.length - 1;
		int pPar = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[i] % 2 == 0)
				vAux[pPar++] = v[i];
			else
				vAux[pImp--] = v[i];
		}

		return vAux;
	}

	public static int[] parImpar(int[] v) {
		int aux = 0;
		int pImp = v.length - 1;
		int pPar = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[i] % 2 == 0) {
				aux = v[pPar];
				v[pPar++] = v[i];
				v[i] = aux;
			} else {
				aux = v[pImp];
				v[pImp--] = v[i];
				v[i] = aux;
			}
		}

		for (int i = 0; i < v.length; i++) {
			if (v[i] % 2 == 0) {

			}
		}

		return v;
	}

	public static boolean isOdd(int number) {
		return number % 2 != 0;

	}

	public static void remapVector(int[] vec) {
		int initial_pos = 0;
		int final_pos = vec.length - 1;

		do {
			int current_value = vec[initial_pos];
			int opossite_value = vec[final_pos];
			boolean isCurrentOdd = isOdd(current_value);
			boolean isOpossiteOdd = isOdd(opossite_value);

			if (isCurrentOdd && !isOpossiteOdd) {
				vec[initial_pos] = opossite_value;
				vec[final_pos] = current_value;
				initial_pos++;
				final_pos--;
			} else if (isCurrentOdd && isOpossiteOdd) {
				int aux = vec[final_pos - 1];
				vec[initial_pos] = aux;
				vec[final_pos - 1] = current_value;
				final_pos = final_pos - 2;
			} else if (!isCurrentOdd && isOpossiteOdd) {
				initial_pos++;
				final_pos--;
			} else if (!isCurrentOdd && !isOpossiteOdd) {
				int aux = vec[initial_pos + 1];
				vec[initial_pos + 1] = opossite_value;
				vec[final_pos] = aux;
				initial_pos = initial_pos + 2;
			}
		} while (final_pos >= initial_pos);
	}

	public static void main(String[] args) {
		int totalOfNumbers = Integer.parseInt(args[0]); // 100
		int totalOfEven = Integer.parseInt(args[1]); // 20
		int totalOfOdd = Integer.parseInt(args[2]); // 80
		System.out.println("pares " + totalOfEven);
		System.out.println("impares " + totalOfOdd);
		System.out.println("total " + totalOfNumbers);
		int[] v = new int[totalOfNumbers];
		int number;
		int pos = 0;
		Random r = new Random();

		while (pos < v.length) {
			number = (r.nextInt(100) + 1);
			if (number % 2 != 0) {
				if (totalOfOdd > 0) {
					v[pos] = number;
					totalOfOdd--;
					pos++;
				}
			} else if (number % 2 == 0) {
				if (totalOfEven > 0) {
					v[pos] = number;
					totalOfEven--;
					pos++;
				}
			}
		}
		// System.out.printf("valor index %d = v[pos-1] =%d \n", pos, v[pos - 1]);

		// System.out.println("\nVetor 1 ");
		// for (int i = 0; i < v.length; i++) {
		// System.out.printf("valor index v[%d] = %d \n", i, v[i]);
		// }
		remapVector(v);

		System.out.println(
				"\n================================================================================================================================================");
		System.out.println("\nVetor 1 ORDENADO");
		for (int i = 0; i < v.length; i++) {
			System.out.printf("valor index v[%d] = %d \n", i, v[i]);
		}

	}
}
