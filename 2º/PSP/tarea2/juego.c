/*
Crea un archivo en C llamado juego.c. Dicho archivo va a albergar un programa en C que
funciona de la siguiente manera:
- Pide al usuario que seleccione entre estas tres operaciones: sumar, restar y multiplicar.
- Para las 3 opciones el programa generará aleatoriamente 2 números entre 1 y 100, y pedirá al
  usuario que acierte el resultado de la operación elegida, terminando la opción cuando el usuario
  acierte o se rinda (introduce -1).
*/

#include <stdio.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>
#include <stdbool.h>
#include <stdlib.h> // rand(), srand()
#include <time.h>   // time()

void printMenu()
{
    printf("\n");
    printf("+----        ELIJA UNA OPCIÓN        ----+\n");
    printf("|-----------------MENU-------------------|\n");
    printf("|1- SUMAR                                |\n");
    printf("|2- RESTAR                               |\n");
    printf("|3- MULTIPLICAR                          |\n");
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
        scanf(" %d", &option);
        printf("+----------------------------------------+\n");
        if (option > 0 && option < 4)
            valid = true;
    }

    return option;
}

int getAnswer()
{
    int option;
    printf("+--------     ADIVINE EL RESULTADO     --------+\n");
    printf("|INTRODUZCA UNA RESPUESTA (-1 PARA RENDIRSE): ");
    scanf(" %d", &option);
    printf("+----------------------------------------------+\n");
    return option;
}

int generateNumbers(int option)
{
    srand(time(NULL)); // Initialization, should only be called once.
    int r1 = rand() % 100;
    int r2 = rand() % 100;
    if (option > 0 && option < 4)
    {
        switch (option)
        {
        case 1:
            //suma
            printf("LOS NÚMERO SON: %d y %d\n", r1, r2);
            return r1 + r2;
            break;

        case 2:
            //resta
            printf("LOS NÚMERO SON: %d y %d\n", r1, r2);
            return r1 - r2;
            break;

        case 3:
            //multiplicación
            printf("LOS NÚMERO SON: %d y %d\n", r1, r2);
            return r1 * r2;
            break;

        default:
            break;
        }
    }
}

char continuePlaying()
{
    bool valid = false;
    char option;
    while (!valid)
    {
        printf("¿Quiere seguir jugando y/n?\n");
        scanf(" %c", &option);
        if (option != 'y' && option != 'n')
        {
            printf("INTRODUZCA UN VALOR CORRECTO (y/n)...\n");
        }
        else
        {
            return option;
        }
    }
}

void play()
{
    printMenu();
    int option = chooseOption();
    int solution, answer;
    bool valid;
    char playAgain;

    switch (option)
    {
    case 1:
        valid = false;
        printf("¡HAS ELEGIDO LA OPCION 1: SUMAR!\n");
        while (!valid)
        {
            solution = generateNumbers(option);
            answer = getAnswer();
            if (solution == answer)
            {
                printf("¡HAS ACERTADO!\n");
                valid = true;
            }
            else if (answer == -1)
            {
                printf("TE HAS RENDIDO\n");
                break;
            }
            else
            {
                printf("¡HAS FALLADO, PRUEBE OTRA VEZ!\n");
            }
        }
        playAgain = continuePlaying();
        if (playAgain == 'y')
        {
            play();
        }
        else
        {
            printf("¡GRACIAS POR JUGAR!\n");
        }

        break;
    case 2:
        valid = false;
        printf("¡HAS ELEGIDO LA OPCION 2: RESTAR!\n");
        while (!valid)
        {
            solution = generateNumbers(option);
            answer = getAnswer();
            if (solution == answer)
            {
                printf("¡HAS ACERTADO!\n");
                valid = true;
            }
            else if (answer == -1)
            {
                printf("TE HAS RENDIDO\n");
                break;
            }
            else
            {
                printf("¡HAS FALLADO, PRUEBE OTRA VEZ!\n");
            }
        }
        playAgain = continuePlaying();
        if (playAgain == 'y')
        {
            play();
        }
        else
        {
            printf("¡GRACIAS POR JUGAR!\n");
        }
        break;
    case 3:
        valid = false;
        printf("¡HAS ELEGIDO LA OPCION 3: MULTIPLICAR!\n");
        while (!valid)
        {
            solution = generateNumbers(option);
            answer = getAnswer();
            if (solution == answer)
            {
                printf("¡HAS ACERTADO!\n");
                valid = true;
            }
            else if (answer == -1)
            {
                printf("TE HAS RENDIDO\n");
                break;
            }
            else
            {
                printf("¡HAS FALLADO, PRUEBE OTRA VEZ!\n");
            }
        }
        playAgain = continuePlaying();
        if (playAgain == 'y')
        {
            play();
        }
        else
        {
            printf("¡GRACIAS POR JUGAR!\n");
        }
        break;
    default:
        printf("¡SE HA PRODUCIDO UN ERROR!\n");
        break;
    }
}

int main(int argc, char const *argv[])
{
    play();

    return 0;
}
