
import java.util.Arrays;

public class Ejecutable {

  public static void main(String[] args) {

    Videojuego[] coleccionVideojuegos = new Videojuego[5];
    Serie[] coleccionSeries = new Serie[5];

    coleccionVideojuegos[0] = new Videojuego();
    coleccionVideojuegos[1] = new Videojuego("Oblivion", 100);
    coleccionVideojuegos[2] = new Videojuego("Skyrim", 150, "rol", "Bethesda");
    coleccionVideojuegos[3] = new Videojuego("Final Fantasy", 50, "rpg", "Square Enix");
    coleccionVideojuegos[4] = new Videojuego("Mario Bros", 25);

    coleccionSeries[0] = new Serie();
    coleccionSeries[1] = new Serie("Lost", "J.J Abrams");
    coleccionSeries[2] = new Serie("The Wire", 5, "Thriller", "David Simos");
    coleccionSeries[3] = new Serie("The Mandalorian", 2, "Ciencia Ficción", "Jon Favreau");
    coleccionSeries[4] = new Serie("Breaking Bad", "Vince Gilligan");

    System.out.println(Arrays.toString(coleccionVideojuegos));
    System.out.println(Arrays.toString(coleccionSeries));

    coleccionVideojuegos[0].entregar();
    coleccionVideojuegos[1].entregar();


    coleccionSeries[0].entregar();

    System.out.println(cuentaElementos(coleccionVideojuegos));
    System.out.println(cuentaElementos(coleccionSeries));

    coleccionVideojuegos[0].devolver();
    coleccionVideojuegos[1].devolver();
    coleccionVideojuegos[2].devolver();

    coleccionSeries[0].devolver();

    System.out.println(coleccionSeries[2].compareTo(coleccionSeries[3]));
    System.out.println(coleccionVideojuegos[3].compareTo(coleccionVideojuegos[2]));

    Arrays.sort(coleccionVideojuegos);
    Arrays.sort(coleccionSeries);

    System.out.println(coleccionVideojuegos[4]);
    System.out.println(coleccionSeries[4]);
  }

  /**
   * Cuenta los elementos de un array de objetos.
   * 
   * @param objetos array de objetos
   * @return numero de objetos que hay en el array.
   */
  public static int cuentaElementos(Object[] objetos) {
    int numeroElementos = 0;

    if (objetos != null && objetos.length > 0) {
      for (Object auxiliar : objetos) {
        if (auxiliar != null)
          numeroElementos++;
      }
    }
    return numeroElementos;
  }

}
