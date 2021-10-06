/**
 * realiza un programa en c que cree un proceso (tendremos 1 proceso padre y 1 hijo)
 * El programa definirá una variable local al programa con valor 6
 * El proceso padré incrementará el valor de la variable en 1.
 * El proceso hijo decrementará el valor de la variable en 1.
 * La salida del programa:
 * Valor inicial = 6
 * Variable en proceso hijo = 5
 * Variable en proceso padre = 7
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     //pid_t
#include <errno.h>      //tratamiento de errores
#include <sys/wait.h>   //waits

int main(void) 
{
    pid_t pid, childpid;
    int status;
    int variable = 6;
    
     
    switch(pid = fork())
    {
        case -1:
            perror("fork error");
            printf("errno value= %d\n", errno);
				exit(EXIT_FAILURE);  
            //return (-1);
            
        case 0: /* proceso hijo */
            printf("Variable en proceso hijo = %d\n", --variable); 
            exit(EXIT_SUCCESS);
            
        default: /* padre */
            printf("El valor inicial de la variable es = %d\n",variable);
            printf("Variable en proceso padre = %d\n", ++variable); 
				/*Averigue quien es el padre del proceso padre*/

				//Se espera al hijo
            childpid=wait(&status);
            if(childpid>0)
            {
             	if (WIFEXITED(status)) 
					{
                    printf("child %d exited, status=%d\n",childpid, WEXITSTATUS(status));
               } 
					else if (WIFSIGNALED(status)) 
					{
                    printf("child %d killed (signal %d)\n", childpid, WTERMSIG(status));
               } 
					else if (WIFSTOPPED(status)) 
					{
                    printf("child %d stopped (signal %d)\n", childpid, WSTOPSIG(status));
               } 
            }
            else 
				{
                printf("Error en la invocacion de wait o la llamada ha sido interrumpida por una señal.\n");
                exit(EXIT_FAILURE);
            } 
            exit(EXIT_SUCCESS); //return 0;
    }
}