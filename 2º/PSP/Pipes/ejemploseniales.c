#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>


//definimos las funciones que vamos a utilizar
//en C, una opción es definirlas antes del main

//manejador de señales para el hijo

void manejador(int segnal)
{

	printf("Hijo recibe una señal y se ejecuta el manejador...%d\n", segnal);
}

int main()
{

	pid_t pid_hijo;
	pid_hijo=fork(); //creamos el hijo

	switch(pid_hijo)
	{
		case -1:
			printf("Error");
			break;
		case 0: //hijo
			//nos ponemos a la escucha por si recibimos la señal
			//pero la ejecución en el hijo continua, para ello
			//usamos la función signal
			signal(SIGUSR1, manejador);
			while(1)
			{
                	   printf ("\n linea 1");
                	   printf ("\n linea 2");
                	   sleep(1);
            		}; //bucle infinito 
			break;
		
		default:
			//Estamos en el padre, vamos a enviar dos señales
			//así comprobamos como el hijo "salta al manejador" cada vez
			//que recibe una
			sleep(5); //esperamos un segundo para no saturar
			//enviamos la señal con kill
			kill(pid_hijo, SIGUSR1);
			sleep(3);
			kill(pid_hijo, SIGUSR1);
			sleep(3);
			
			kill(pid_hijo, SIGTERM);
			
			break;

	}//fin del switch
	return 0;
}//fin del main
