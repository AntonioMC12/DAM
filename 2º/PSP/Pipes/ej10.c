#include <signal.h>
#include <stdio.h>

// Funcion de tramamiento de la señal
void Tratamiento(int signum)
{
    FILE *fp;
    switch (signum)
    {
    case SIGINT:
        fp = fopen("señales.txt", "a");
        fprintf(fp, " Proceso %d Señal recibida %d \n", getpid(), signum);
        fclose(fp);
        break;
    case SIGSTOP:
        printf("He recibido la señal SIGTSTP, proceso detenido. \n");
        break;
    }
}

int main()
{

    // Asigno el tratamiento a la señal

    signal(SIGINT, Tratamiento);
    signal(SIGSTOP, Tratamiento);
    puts(" Proceso activo esperando señales ");

    // Ciclo infinito de espera por una señal
    while (1)
    {
        pause();
        // Muestra el caracter + despues de cada señal
        putchar('+');
        fflush(stdout);
    }
}