/** Desarrolla un programa en C, que cree un proceso hijo y un proceso nieto.
 * El proceso hijo debe escribir al padre el mensaje: "Hola papá,¿Hablamos?".
 * El proceso nieto debe escribir al abuelo el mensaje: "hola abuelo, ¿Cómo estás?".
 *  El proceso padre debe leer los dos mensajes. */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    int fdh[2], fdg[2];
    char buffer[80];
    char buffer1[80];
    pid_t pid, pid1, status;

    pipe(fdh), pipe(fdg);

    char *msnpadre = "Hola papá, ¿Hablamos?";
    char *msnhijo = "Hola abuelo, ¿Cómo estás?";

    pid = fork();
    if (pid == -1)
    {
        printf("ERROR");
    }
    else if (pid == 0)
    {

        pid1 = fork();
        if (pid1 == -1)
        {
            printf("ERROR");
        }
        else if (pid1 == 0)
        {
            close(fdg[0]);
            write(fdg[1], msnhijo, strlen(msnhijo));
        }
        else
        {
            close(fdh[0]);
            write(fdh[1], msnpadre, strlen(msnpadre));
        }
    }
    else
    {
        waitpid(pid, &status, 0);
        close(fdh[1]); // 1 escritura 0 lectura
        close(fdg[1]);
        read(fdh[0], buffer, sizeof(buffer));
        printf("\n El mensaje que me ha enviado mi hijo es..%s \n", buffer);
        read(fdg[0], buffer, sizeof(buffer1));
        printf("\n El mensaje que me ha enviado mi nieto es..%s \n", buffer1);
    }
}