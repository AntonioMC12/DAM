/****************************************************************/
/* Programar "ls -l | wc" >> file.txt                           */
/* TODO: manejo de errores                                      */
/****************************************************************/

#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <sys/stat.h>
#include <fcntl.h>

#define READ_END 0  /* index pipe extremo lectura */
#define WRITE_END 1 /* index pipe extremo escritura */

#define FILE_NAME "file.txt" /* nombre del archivo donde escribir */

int main(int argc, char *argv[])
{
    int fd1[2], file_pointer;
    int status, pid;
    //FILE *fichero;
    //fichero = fopen(FILE_NAME, "wt");

    pipe(fd1); /* comunica ls y wc */

    pid = fork();

    if (pid == 0) /* hijo 1, ejecuta "ls -la" */
    {
        close(fd1[READ_END]);                   //cerrar extremo no necesario pq vamos a escribir
        dup2(fd1[WRITE_END], STDOUT_FILENO);    //escribo la salida de STDOUT
        close(fd1[WRITE_END]);                  //cierro la escritura
        execlp("/bin/ls", "ls", "-la", NULL);   //ejecuto ls
    }
    else /* padre */
    {
        close(fd1[WRITE_END]); // extremo no necesario ya, vamos a leer
        pid = fork();

        if (pid == 0) /* hijo 2, ejecuta "wc" */
        {
            file_pointer = open(FILE_NAME, O_RDWR | O_CREAT, S_IRUSR | S_IWUSR); //apunto al fichero y lo crea si no existe
            dup2(fd1[READ_END], STDIN_FILENO);  //apunto a STDIN a la salida de STDOUT anterior, sería una especia de concat
            close(fd1[READ_END]);               //cierro la lectura
            dup2(file_pointer, STDOUT_FILENO);  //apunto la salida del programa STDOUT al fichero
            execlp("/usr/bin/wc", "wc", NULL);  //ejecuto wc
        }
        else /* padre */
        {
            close(fd1[READ_END]); //cerramos el restante
            //fclose(fichero);
            printf("Proceso completado\n");
        }
    }

    /* wait para cada hijo */
    wait(&status);
    wait(&status);
    return 0;
}