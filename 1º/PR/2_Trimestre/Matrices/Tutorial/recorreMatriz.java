
public class recorreMatriz {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    imprimeFilasNormal(matriz);
    imprimeFilasInverso(matriz);
    imprimeColumnasNormal(matriz);
    imprimeColumnasInverso(matriz);
    imprimeDiagonalNormal(matriz);
    imprimeDiagonalInversa(matriz);
  }

  // 1,2,3,4,5,6,7,8,9
  public static void imprimeFilasNormal(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        System.out.print(m[i][j]+" ");
      }
    }
    System.out.println("");
  }

  // 9,8,7,6,5,4,3,2,1
  public static void imprimeFilasInverso(int[][] m) {
    for(int i = m.length-1 ; i > -1 ; i--) {
      for(int j = m[i].length-1 ; j > -1 ; j--) {
        System.out.print(m[i][j]+" ");
      }
    }
    System.out.println("");
  }

  // 1,4,7,2,5,8,3,6,9
  public static void imprimeColumnasNormal(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        System.out.print(m[j][i]+" ");
      }
    }
    System.out.println("");
  }

  // 9,6,3,8,5,2,7,4,1
  public static void imprimeColumnasInverso(int[][] m) {
    for(int i = m.length-1 ; i > -1 ; i--) {
      for(int j = m[i].length-1 ; j > -1 ; j--) {
        System.out.print(m[j][i]+" ");
      }
    }
    System.out.println("");
  }

  // 1,5,9
  public static void imprimeDiagonalNormal(int[][] m) {
    for(int i = 0 ; i < m.length ; i++) {
        System.out.print(m[i][i]+" ");
    }
    System.out.println("");
  }

  // 7,5,3
  public static void imprimeDiagonalInversa(int[][] m) {
    for(int i = m.length-1, j = 0; i > -1 ; i--,j++) {    
        System.out.print(m[i][j]+" ");
    }
    System.out.println("");
  }
}
