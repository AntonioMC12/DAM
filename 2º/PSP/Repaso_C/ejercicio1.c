#include <stdio.h>
#include <stdlib.h>

/*
El programa muestra por pantalla todos los números pares desde el 0 hasta el número introducido
*/
int main()
{
    //Variable donde almacenado el numero introducido por teclado
    int num;
    printf("Introduce un número entero: ");
    scanf("%d", &num);
    printf("Los números pares del 0 hasta el %d son: \n", num);
    //Comprobamos los numeros pares y lo mostramos por pantalla
    for (int i = 0; i <= num; i++)
    {
        if (i % 2 == 0)
        {
            printf("%d", i);
            if (i < num-1)
            {
                printf(", ");
            }
        }
    }

    printf("\n");
    return 0;
}