import java.util.Arrays;

public class Parking {
	Coche[] coches;

	public Parking() {
		coches = new Coche[0];
	}

	/**
	 * Función que nos indica si un coche está en nuestro Parking buscando por
	 * matrícula y bastidor
	 * 
	 * @param id Matrícula o Bastidor
	 * @return True si lo encuentra, False si no.
	 */
	public boolean estaCoche(String id) {
		boolean result = false;
		int i = 0;
		while (i < coches.length && !result) {
			if (coches[i].getMatricula().equals(id) || coches[i].getBastidor().equals(id)) {
				result = true;
			}
			i++;
		}
		return result;
	}

	/**
	 * Función que añade un coche a nuestro Parking
	 * 
	 * @param nuevo Coche a insertar
	 */
	public void addCoche(Coche nuevo) {
		if (nuevo != null && !estaCoche(nuevo.getMatricula())) {
			// Calculo en nuevo tama�o
			int nuevoTam = this.coches.length + 1;
			// Creo un parking temporal del nuevo tama�o
			Coche[] tmp = new Coche[nuevoTam];
			// Copio todos los coches al nuevo parking
			for (int i = 0; i < coches.length; i++) {
				tmp[i] = coches[i];
			}
			// Me queda libre el �ltimo hueco , donde meto al nuevo coche
			tmp[nuevoTam - 1] = nuevo;
			// Actualizo mi parking para que apunte al nuevo parking
			coches = tmp;
		}
	}

	/**
	 * Función que elimina un coche de nuestro Parking, identificándolo por su
	 * matrícula o su bastidor
	 * 
	 * @param id matrícula o bastidor
	 * @return Coche eliminado
	 */
	public Coche removeCoche(String id) {
		Coche result = null;
		int pos = searchCoche(id);
		if (pos >= 0) {
			int nuevoTam = coches.length - 1;
			Coche[] tmp = new Coche[nuevoTam];
			result = coches[pos];
			for (int i = 0, j = 0; i < coches.length; i++) {
				if (i != pos) {
					tmp[j++] = coches[i]; // j++;
				}
			}
			this.coches = tmp;
		}
		return result;
	}

	/**
	 * Busca en el Parking un coche por su matrícula o bastidor y devuelve su
	 * posición.
	 * 
	 * @param id Matrícula o Bastidor
	 * @return Posición del coche buscado, devuelve -1 si no lo encuentra.
	 */
	public int searchCoche(String id) {
		int result = -1;
		int i = 0;
		while (i < coches.length && result == -1) {
			if (coches[i].getMatricula().equals(id) || coches[i].getBastidor().equals(id)) {
				result = i;
				// i=coches.length;
			}
			i++;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Parking [coches=" + Arrays.toString(coches) + "]";
	}

}
