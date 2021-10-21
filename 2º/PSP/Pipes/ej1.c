//incluimos las librerías necesarias
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
//programa principal
int main()
{
    int fd[2];       //array que va a contener a los dos descriptores del pipe
    char buffer[30]; //buffer de 30 caracteres donde los procesos van a escribir y leer
    pid_t pid;       //variable de tipo pid_t para almacenar el pid devuelto por la llamada fork()
    //creamos el pipe enviándole el array de descriptores
    pipe(fd); //en este momento fd[0] será el descriptor de lectura y fd[1] el de escritura
    //creamos el proceso hijo
    pid = fork();
    switch (pid)
    {
    case -1: //Error
        printf("No se ha podido crear el hijo...\n");
        exit(-1);
        break;
    case 0: //estoy en el proceso hijo
        printf("\n Soy el hijo, pulsa una tecla para escribir en el pipe");
        printf("\n Y así enviarle datos a mi padre...");
        getchar();
        //utilizamos la función write para escribir en el pipe
        //para ello indicamos el descriptor de escritura
        //escribrimos una cadena de no más de 30 caracteres (buffer)
        //indicamos el tamaño de lo escrito, parámetro count
        write(fd[1], "Hola papa", 10);
        break;
    default: //estamos en el padre
        //esperamos a que el hijo finalice
        wait(NULL); //podíamos haber utilizado el waitpid
        printf("El padre lee del pipe...\n");
        //utilizamos la función read para leer del fichero pipe
        //indicamos el descriptor de lectura, fd[0]
        //indicamos el buffer donde vamos a guardar la lectura
        //indicamos el tamaño de lo leido
        read(fd[0], buffer, 10);
        //vamos a imprimir por pantalla lo leido
        printf("\n El mensaje que me ha enviado es..%s \n", buffer);
        //Cuando se utiliza la función read, el fichero temporal pipe, queda vacío
        //el fichero pipe se llena con cada escritura y se vacía con cada lectura
        break;
    } //fin del switch
} //fin del programa principal