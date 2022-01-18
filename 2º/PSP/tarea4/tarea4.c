/**
* @auhor: Antonio Muñoz Cubero
* El ejercicio debe realizar las siguientes acciones:
*    1. Desde un proceso inicial padre (P1), vamos a generar un hijo (P2) que a su vez generará otro hijo (P3).
*
*    2. En la ejecución del programa, el proceso P1 esperará para continuar a que el proceso P2 le envíe una señal. Mientras esta 
*    acción no se produzca, P1 no ejecutará nada.
*
*    3. P2 esperará para continuar a que el proceso P3 le envié una señal. Mientras esta acción no se produzca, P2 no continuará.
*
*    4. P3 se ejecutará y mostrará un menú con las siguientes opciones:
*        1. Generar un nuevo hijo
*        2. Salir.
*    En caso de que se pulse la opción 1, se generará un nuevo hijo, el cuál mostrará por pantalla “Soy el hijo generado”, finalizando 
*    su ejecución. P3 volverá a mostrar el menú anterior. En caso de que se pulse la opción 2, P3 enviará una señal a P2 y finalizará.
*
*    5. P2 al recibir la señal de P3 mostrará el siguiente menú:
*        1. Generar un nieto
*        2. Salir
*    En caso de pulsar la opción 1, se generará un hijo que a suvez generará otro. Cada uno imprimirá un mensaje indicando quién es y 
*    finalizará. P2 volverá al menú anterior. En el caso de que se pulse salir, P2 enviará una señal a P1 y finalizará.
*
*    6. P1 esperará a que le llegue la señal de P2 y mostrará por pantalla “Soy el padre, he generado un hijo, un nieto, ellos han creado 
*    otros procesos, yo me he esperado hasta el final, se han muerto y aquí sigo yo. Saludos”.
*/

#include <signal.h>
#include <stdio.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <stdlib.h>
#include <string.h>
#include <stdbool.h> //bool

void manejador(int signum)
{
    switch (signum)
    {
    case SIGUSR1:
        printf("He recibido la señal SIGUSR1 desde P2, procedo a ejecutar P1 \n");
        break;
    case SIGUSR2:
        printf("He recibido la señal SIGUSR1 desde P3, procedo a ejecutar P2 \n");
        break;
    }
}

void printMenuP2()
{
    printf("\n");
    printf("+----------------------------------------+\n");
    printf("|-----------------MENU-------------------|\n");
    printf("|1- Generar un nieto                     |\n");
    printf("|2- Salir                                |\n");
    printf("+----------------------------------------+\n");
}

void printMenuP3()
{
    printf("\n");
    printf("+----------------------------------------+\n");
    printf("|-----------------MENU-------------------|\n");
    printf("|1- Generar nuevo hijo                   |\n");
    printf("|2- Salir                                |\n");
    printf("+----------------------------------------+\n");
}

int chooseOption()
{
    int option;
    bool valid = false;

    while (!valid)
    {
        printf("\n");
        printf("+----------------------------------------+\n");
        printf("|INTRODUZCA UNA OPCION: ");
        scanf("%d", &option);
        printf("+----------------------------------------+\n");
        if (option > 0 && option < 3)
            valid = true;
    }

    return option;
}

int main(int argc, char const *argv[])
{
    pid_t p2, p3, status;

    p2 = fork();
    if (p2 == 0)
    {
        p3 = fork();
        if (p3 == 0)
        {
            //P3 code
            bool valid = true;
            int option;
            while (valid)
            {
                printMenuP3();
                option = chooseOption();
                pid_t p3child;
                switch (option)
                {
                case 1:
                    //generar nuevo hijo[p3child]
                    p3child = fork();
                    if (p3child == 0)
                    {
                        //p3child code
                        printf("Soy el hijo generado con pid: %d,con padre:%d\n", getpid(), getppid());
                        exit(EXIT_SUCCESS);
                    }
                    else
                    {
                        waitpid(p3child, &status, 0);
                    }
                    break;

                case 2:
                    valid = false;
                    break;

                default:
                    break;
                }
            }
            //P3 termina y mandamos la señal a P2
            kill(getppid(), SIGUSR2);
            exit(EXIT_SUCCESS);
        }
        else if (p3 == -1)
        {
            printf("Error");
        }
        else
        {
            //P2 code
            //esperamos a que nos llegue la señal de p3
            signal(SIGUSR2, manejador);
            pause();
            //la señal ha llegado
            bool valid = true;
            int option;
            while (valid)
            {
                printMenuP2();
                option = chooseOption();
                pid_t p2child, p2grandson;
                switch (option)
                {
                case 1:
                    //generar nuevo hijo[p2child] y un nieto p2grandson
                    p2child = fork();
                    if (p2child == 0)
                    {
                        p2grandson = fork();
                        if (p2grandson == 0)
                        {
                            //p2grandson code
                            printf("Soy el nieto con pid: %d,con padre:%d\n", getpid(), getppid());
                            exit(EXIT_SUCCESS);
                        }
                        else
                        {
                            //p2child code
                            printf("Soy el hijo generado con pid: %d,con padre:%d\n", getpid(), getppid());
                            waitpid(p2grandson, &status, 0);
                            exit(EXIT_SUCCESS);
                        }
                    }
                    else
                    {
                        waitpid(p2child, &status, 0);
                    }
                    break;

                case 2:
                    valid = false;
                    break;

                default:
                    break;
                }
            }
            //P2 termina y mandamos la señal a P1
            kill(getppid(), SIGUSR1);
            exit(EXIT_SUCCESS);
        }
    }
    else if (p2 == -1)
    {
        printf("Error");
    }
    else
    {
        //P1 code
        
        signal(SIGUSR1, manejador);
        pause();

        printf("\n\nSoy el padre, he generado un hijo, un nieto, ellos han creado otros procesos \nyo me he esprado hasta el final se han muerto y aqui sigo yo \nSALUDOS");
    }
}
