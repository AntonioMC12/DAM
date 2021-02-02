public class Ejercicio_for_1{

	public static void main(String[] args){
		/*Realizar un programa que muestre los 100 primero numeros impares en orden inverso*/
		//Realizar un programa que muestro los 100 primeros pares 
		//Muestra la suma
		double add1 = 0;
		double add2 = 0;
		//realizamos la muestra de los 100 primeros pares y guardamos la suma
		for(int i = 2 ; i < 102 ; i+=2){
			
			System.out.print(i + ", ");
			add1 += i;
		}

		System.out.println();

		for(int x = 199 ; x > 0 ; x-=2){
			
			System.out.print(x + ", ");
			add2 += x;
		}

		System.out.println("La suma total de los pares es: "+add1);
		System.out.println("La suma total de los impares es: "+add2);
	}
}
