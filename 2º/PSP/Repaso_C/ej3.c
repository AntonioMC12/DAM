#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    printf("Creando fichero con contenido del comando: ls\n");
    system("ls > fsal.txt");
    printf("\nProceso terminado.\n");
    printf("Abriendo fichero...\n");

    int error = system("nano fsal.txt");

    printf("salida: %d\n", error);

    if (error != 0){
        printf("Ha ocurrido un error.");
    }else{
         printf("Proceso terminado con éxito.\n");
    }
    
    
    return 0;
}