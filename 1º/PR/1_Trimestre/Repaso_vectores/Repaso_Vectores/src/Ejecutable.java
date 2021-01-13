import java.util.Arrays;

public class Ejecutable {

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 5, 6 };
		int[] subtest;
		try {
			subtest = subVector(test, 2, 0);
			// 1,2,3
			System.out.println(Arrays.toString(subtest));
		} catch (Exception e) {

			e.printStackTrace();
		}

		int[] test2 = { -2, -1, -9 };
		System.out.println(Arrays.toString(filter(test2, 2)));
		String[] test3 = { "asdf", "asdf", "asdf", "2", "2", "3" };
		System.out.println(Arrays.toString(filter(test3, "asdf")));
		int[] conditions = { -2, -1, -9 };
		System.out.println(Arrays.toString(filter(test2, conditions)));
		System.out.println(indexOf(test2, 2));
		System.out.println(max(test2));
		System.out.println(avg(test));
		System.out.println(Arrays.toString(map(test, '*', 1)));
		System.out.println(Arrays.toString(test));
	}

	/**
	 * Genera un vector con el contenido de un vector que se le pasa por par�metro,
	 * pasandolo un inicio y un final.
	 * 
	 * @param t   Array original
	 * @param ini punto de inicio
	 * @param end punto de fin
	 * @return Array con el contenido.
	 * @throws Exception
	 */
	static int[] subVector(int[] t, int ini, int end) throws Exception {
		int[] result = null;
		if (ini < end) {
			if (t != null && ini >= 0 && end < t.length && ini <= end) {
				// ini y end son v�lidos

				result = new int[end - ini + 1];
				for (int i = 0; i < result.length; i++) {
					result[i] = t[ini + i];
				}
			}
		} else if (ini > end) {
			if (t != null && end >= 0 && ini < t.length && end <= ini) {
				// ini y end son v�lidos

				result = new int[ini - end + 1];
				for (int i = 0; i < result.length; i++) {
					result[i] = t[ini - i];
				}
			}
		} else {
			// vamos a lanzar una exception
			throw new Exception("subvector no v�lido");
		}
		return result;
	}

	/**
	 * Genera un nuevo array de enteros con los elementos que cumplan la condicion
	 * 
	 * @param t         Array original
	 * @param condition Condicion a cumplir para los nuevos elementos
	 * @return Array filtrado
	 */
	static int[] filter(int[] t, int condition) {
		int[] resultado = null;
		int contador = 0;

		if (t != null) {
			for (int i = 0; i < t.length; i++) {
				if (t[i] == condition) {
					contador++;
				}
			}
			if (contador != 0) {
				resultado = new int[contador];
				for (int i = 0, j = 0; i < t.length; i++) {
					if (t[i] == condition) {
						resultado[j] = t[i];
						j++;
					}
				}
			}
		}
		return resultado;
	}

	/**
	 * Genera un nuevo array de Strings con los elementos que cumplan la condicion
	 * 
	 * @param t         Array original
	 * @param condition Condicion a cumplir para los nuevos elementos
	 * @return Array filtrado
	 */
	static String[] filter(String[] t, String condition) {
		String[] resultado = null;
		int contador = 0;

		if (t != null) {
			for (int i = 0; i < t.length; i++) {
				if (t[i].equals(condition)) {
					contador++;
				}
			}
			if (contador != 0) {
				resultado = new String[contador];
				for (int i = 0, j = 0; i < t.length; i++) {
					if (t[i].equals(condition)) {
						resultado[j] = t[i];
						j++;
					}
				}
			}
		}
		return resultado;
	}

	/**
	 * Genera un nuevo array de enteros con los elementos que cumplan la condicion
	 * 
	 * @param t         Array original
	 * @param condition Array de Condiciones a cumplir para los nuevos elementos
	 * @return Array filtrado
	 */
	static int[] filter(int[] t, int[] condition) {
		int[] resultado = null;
		int contador = 0;

		if (condition != null) {
			if (t != null) {
				for (int i = 0; i < t.length; i++) {
					for (int j = 0; j < condition.length; j++) {
						if (t[i] == condition[j]) {
							contador++;
						}
					}
				}
				if (contador != 0) {
					resultado = new int[contador];
					int x = 0;
					for (int i = 0; i < t.length; i++) {
						for (int j = 0; j < condition.length; j++) {
							if (t[i] == condition[j]) {
								resultado[x] = t[i];
								x++;
							}
						}
					}
				}
			}
		}
		return resultado;
	}

	/*
	 * static int[] order(int[] t);
	 * 
	 * ordenar en creciente
	 */

	/**
	 * Devuelve la posicion de la primera coincidencia o -1
	 * 
	 * @param t
	 * @param ele
	 * @return
	 */
	static int indexOf(int[] t, int ele) {
		int resultado = -1;
		boolean encontrado = false;
		if (t != null) {
			for (int i = 0; i < t.length && !encontrado; i++) {
				if (t[i] == ele) {
					resultado = i;
					encontrado = true;
				}
			}
		}

		return resultado;
	}

	/**
	 * Dado un vector de entero, devuelve el maximo
	 * 
	 * @param t vector que se le pasa
	 * @return valor maximo
	 */
	static int max(int[] t) {
		int result = Integer.MIN_VALUE;

		if (t != null) {
			for (int numero : t) {
				if (numero > result) {
					result = numero;
				}
			}
		}

		return result;
	}

	/**
	 * Dado un vector de enteros, devuelve el minimo
	 * 
	 * @param t vector que se le pasa
	 * @return valor minimo
	 */
	static int min(int[] t) {
		int result = Integer.MAX_VALUE;

		if (t != null) {
			for (int numero : t) {
				if (numero < result) {
					result = numero;
				}
			}
		}

		return result;
	}

	/**
	 * Dado un vector, devuelve su media
	 * 
	 * @param t vector que se le pasa
	 * @return media
	 */
	static double avg(int[] t) {
		double mean = 0;
		double aux = 0;

		if (t != null && t.length > 0) {
			for (int numero : t) {
				aux += numero;
			}
			mean = aux / t.length;
		}
		return mean;
	}

	/**
	 * t{-1,2,8} op= '+' n=2 --> {1,4,10}
	 * 
	 * @param t
	 * @param op = '*','/','+','-'
	 * @param n
	 * @return vector con la operacion realizada.
	 */
	static int[] map(int[] t, char op, int n) {
		int[] map = null;
		
		if (t != null && (op == '*' || op == '/' || op == '+' || op == '-')) {
			map = t;
			
			switch (op) {
			case '*': {
				for (int i = 0; i < t.length; i++) {
					map[i] *= n;
				}
				break;
			}
			case '/': {
				if (n != 0) {
					for (int i = 0; i < t.length; i++) {
						map[i] /= n;
					}
				}
				break;
			}
			case '+': {
				for (int i = 0; i < t.length; i++) {
					map[i] += n;
				}
				break;
			}
			case '-': {
				for (int i = 0; i < t.length; i++) {
					map[i] -= n;
				}
				break;
			}

			default:
				break;
			}
		}

		return map;
	}
}