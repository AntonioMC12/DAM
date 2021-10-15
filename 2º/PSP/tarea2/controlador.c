#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>
#include <stdbool.h>

//"/mnt/c/Users/Antonio/Desktop/Formacion/2º/PSP/tarea2"

void printMenu()
{
    printf("+----------------------------------------+\n");
    printf("|-----------------MENU-------------------|\n");
    printf("|1- Ejecutar en modo exclusivo           |\n");
    printf("|2- Ejecutar en modo paralelo            |\n");
    printf("|3- Salir del juego                      |\n");
    printf("+----------------------------------------+\n");
}

int chooseOption()
{
    int option;
    bool valid = false;

    while (!valid)
    {
        printf("+----------------------------------------+\n");
        printf("|INTRODUZCA UNA OPCION: ");
        scanf("%d", &option);
        printf("+----------------------------------------+\n");
        if (option > 0 && option < 4)
            valid = true;
    }

    return option;
}

int main(int argc, char const *argv[])
{
    printMenu();
    int option = chooseOption();
    pid_t pid_1, pid_2, pid;

    switch (option)
    {
    case 1:
        printf("¡HAS ELEGIDO LA OPCION 1!\n");
        pid_1 = fork();
        if (pid_1 == 0)
        {
            //child_1
            system("./juego");
        }

        break;
    case 2:
        printf("¡HAS ELEGIDO LA OPCION 2!\n");
        pid_2 = fork();
        if (pid_2 == 0)
        {
            //child_2
            //execute a bash terminal on windows and run ./juego
            system("cmd.exe /c start cmd.exe /c wsl.exe ./juego");
        }
        break;
    case 3:
        printf("¡ADIOS!\n");
        break;
    default:
        printf("¡SE HA PRODUCIDO UN ERROR!\n");
        break;
    }
    pid = wait(NULL);
    while (pid != -1)
    {
        pid = wait(NULL);
    }
}