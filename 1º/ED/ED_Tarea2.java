import javax.swing.JOptionPane;

//Aplicacion que convierte un numero en decimal a su correspondiente en binario

public class ED_Tarea2 {

	public static void main(String[] args) {
		
	  String texto = JOptionPane.showInputDialog("Introduce un numero");
	  int numero = Integer.parseInt(texto);
	  String binario = decimalBinario(numero);
	  System.out.println("El numero "+numero+" en binario es "+binario);
	  
	}
	public static String decimalBinario(int numero) {
	  
	  String binario="";
	  String digito;
	  
	  for(int i = numero ; i>0 ; i/=2) {
	    
	    if(i%2==0) {
	      digito="0";
	    }else {
	      digito="1";
	    }
	    
	    binario = digito + binario;
	  }
	  
	  return binario;
	}
}