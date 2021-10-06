/**
 *El padre genera 3 hijos y los muestra por pantalla
 */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits

int main(void)
{
    pid_t pid, childpid;
    int status;

    for (int i = 0; i < 3; i++)
    {
        switch (fork())
        {
        case -1:
            perror("fork error");
            printf("errno value= %d\n", errno);
            exit(EXIT_FAILURE);
            //return (-1);

        case 0: /* proceso hijo */
            printf("Hijo %d con pid: %d,con padre:%d\n", i, getpid(), getppid());
            exit(EXIT_SUCCESS);

        default:/* proceso padre */
            printf("\n");
        }
    }
    
    printf("Soy el padre con pid: %d, estoy esperando\n", getpid());
    //Se espera al hijo
    childpid = wait(&status);
    if (childpid > 0)
    {
        if (WIFEXITED(status))
        {
            printf("child %d exited, status=%d\n", childpid, WEXITSTATUS(status));
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