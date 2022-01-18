/****************************************************************/
/* Programar "ls -l | grep e | wc c"                            */
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

int main(int argc, char *argv[])
{
    int fd1[2], fd2[2];
    int status, child_1, child_2, child_3;

    pipe(fd1);

    child_1 = fork();

    if (child_1 == 0) // hijo 1, ejecuta "ls -l"
    {
        close(fd1[READ_END]);                //cerrar extremo no necesario pq vamos a escribir
        dup2(fd1[WRITE_END], STDOUT_FILENO); //escribo la salida de STDOUT
        close(fd1[WRITE_END]);               //cierro la escritura
        execlp("/bin/ls", "ls", "-l", NULL); //ejecuto ls
    }
    else /* padre */
    {
        close(fd1[WRITE_END]); // extremo no necesario ya, vamos a leer
        pipe(fd2);             //para comunicar grep con wc
        child_2 = fork();

        if (child_2 == 0) // hijo 2, ejecuta "grep e"
        {
            close(fd2[READ_END]);              // cerrar extremo no necesario
            dup2(fd1[READ_END], STDIN_FILENO); //apunto a STDIN a la salida de STDOUT anterior, sería una especia de concat
            close(fd1[READ_END]);              //cierro la lectura
            dup2(fd2[WRITE_END], STDOUT_FILENO);
            close(fd2[WRITE_END]);
            execlp("/usr/bin/grep", "grep", "e", NULL); //ejecuto grep
        }
        else /* padre */
        {
            close(fd1[READ_END]);  // extremo no necesario ya, vamos a leer
            close(fd2[WRITE_END]); // extremo no necesario ya, vamos a leer

            child_3 = fork();

            if (child_3 == 0) // hijo 3, ejecuta "wc -l"
            {
                dup2(fd2[READ_END], STDIN_FILENO);       //apunto a STDIN a la salida de STDOUT anterior, sería una especia de concat
                close(fd2[READ_END]);                    //cierro la lectura
                execlp("/usr/bin/wc", "wc", "-l", NULL); //ejecuto wc
            }

            close(fd1[READ_END]); //cerramos el restante
            close(fd2[READ_END]); //cerramos el restante
            //fclose(fichero);
        }
    }

    //esperamos a los hijos
    waitpid(child_1, &status, 0);
    waitpid(child_2, &status, 0);
    waitpid(child_3, &status, 0);

    return 0;
}