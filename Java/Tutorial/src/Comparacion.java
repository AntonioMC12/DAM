
public class Comparacion {

	public static void main(Bienvenido[] args) {
		//Ejercicio para comparar valores e indicar si es igual o mayor
		
		byte num1 = 3;
		byte num2 = 6;
		//mostramos los numero que vamos a utilizar 
		
		System.out.println("Vamos a usar los siguientes números: " + num1 + ", " + num2);
		
		//usamos un if para comprobar cual es mayor
		if(num1 == num2) {
			System.out.println("Los números son iguales");
		}
		
		if(num1 > num2) {
			System.out.println(num1 + " es mayor que " + num2);
		}
		else {
			System.out.println(num2 + " es mayor que " + num1);
		}
		
		//cambiamos los números para comprobar que funciona
		num1 = 5;
		num2 = 5;
		
		//Los volvemos a mostrar
		System.out.println("Vamos a usar los siguientes números: " + num1 + ", " + num2);
		
		//usamos un if para comprobar cual es mayor
				if(num1 == num2) {
					System.out.println("Los números son iguales");
				}
					else {
						if(num1 > num2) {
							System.out.println(num1 + " es mayor que " + num2);
						}
						else {
							System.out.println(num2 + " es mayor que " + num1);
						}
					}	
		//cambiamos los números para comprobar que funciona
			num1 = 5;
			num2 = 2;
			
		//Los volvemos a mostrar
			System.out.println("Vamos a usar los siguientes números: " + num1 + ", " + num2);
			
		//usamos un if para comprobar cual es mayor
					if(num1 == num2) {
						System.out.println("Los números son iguales");
					}
					
					if(num1 > num2) {
						System.out.println(num1 + " es mayor que " + num2);
					}
					else {
						System.out.println(num2 + " es mayor que " + num1);
					}
		}

}
