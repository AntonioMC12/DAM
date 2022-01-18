#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>

void manejador(int signum)
{
    switch (signum)
    {
    case SIGUSR1:
        printf("He recibido la señal SIGUSR1 \n");
        break;
    case SIGUSR2:
        printf("He recibido la señal SIGUSR2 \n");
        break;
    case SIGTERM:
        printf("Fin de ejecucion \n");
        exit(EXIT_SUCCESS);
    }
}

int main(int argc, char *argv[])
{
    if (signal(SIGUSR1, manejador) == SIG_ERR)
    {
        perror("error en la señal SIGUSR1");
        exit(EXIT_FAILURE);
    }
    if (signal(SIGUSR2, manejador) == SIG_ERR)
    {
        perror("error en la señal SIGUSR2");
        exit(EXIT_FAILURE);
    }
    if (signal(SIGTERM, manejador) == SIG_ERR)
    {
        perror("error en SIGTERM");
        exit(EXIT_FAILURE);
    }
    if (signal(SIGINT, SIG_IGN) == SIG_ERR)
    {
        perror("error en SIGINT");
        exit(EXIT_FAILURE);
    }

    while (1)
        pause();
}