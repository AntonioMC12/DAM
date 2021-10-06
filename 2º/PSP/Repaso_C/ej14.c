/**
 *  Ejercicio 7:
 *  Desarrolla un programa que cree un solo proceso hijo y un solo proceso nieto (hijo del proceso hijo).
 *  El proceso nieto: pedirá el nombre de un directorio, y lo creará en el directorio HOME de cualquier usuario.
 *  El proceso hijo: mostrará el contenido del HOME (debe mostrar el directorio que creó el hijo)
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>

int main(void)
{
    pid_t pid, childpid;
    int status;

    switch (fork())
    {
    case -1:
        perror("fork error");
        printf("errno value= %d\n", errno);
        exit(EXIT_FAILURE);
        //return (-1);

    case 0: /* proceso hijo */
        printf("Hijo con pid: %d,con padre:%d\n", getpid(), getppid());
        if (fork() == 0)
        {
            //hijo
            childpid = wait(&status);
            char *env = getenv("HOME");
            printf("Mostrando HOME: ");
            execl("/bin/ls","ls",env,(char *)NULL);
        }
        else
        {
            //nieto
            char *file = "/prueba";
            char *env = getenv("HOME");
            /**
            * concateno para obtener el path completo ~/prueba
            */
            char *path = strcat(env, file);
            char *args[] = {
                "/bin/mkdir",
                "mkdir",
            };
            execl(args[0], args[1], env, (char *)NULL);
        }
        exit(EXIT_SUCCESS);

    default: /* proceso padre */
        printf("\n");
    }

    printf("Soy el padre con pid: %d, estoy esperando\n", getpid());
    //Se espera al hijo
    childpid = wait(&status);
    if (childpid > 0)
    {
        if (WIFEXITED(status))
        {
            printf("child %d exited, status=%d\n", childpid, WEXITSTATUS(status));
        }
        else if (WIFSIGNALED(status))
        {
            printf("child %d killed (signal %d)\n", childpid, WTERMSIG(status));
        }
        else if (WIFSTOPPED(status))
        {
            printf("child %d stopped (signal %d)\n", childpid, WSTOPSIG(status));
        }
    }
    else
    {
        printf("Error en la invocacion de wait o la llamada ha sido interrumpida por una señal.\n");
        exit(EXIT_FAILURE);
    }
    exit(EXIT_SUCCESS); //return 0;
}