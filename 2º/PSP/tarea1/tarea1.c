#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>

int main(int argc, char const *argv[])
{
    pid_t pid, child_1, child_2, grandson_1;

    child_1 = fork();

    char *env = getenv("HOME");

    if (child_1 == 0)
    {
        /* Child 1 code */
        //system("gnome-terminal -x sh -c \"ls -l ./; bash\"");
        execl("/bin/ls", "ls", "-l", (char *)NULL);
        printf("Hijo 1 con pid: %d,con padre:%d\n", getpid(), getppid());
        exit(0);
    }
    else
    {
        child_2 = fork();

        if (child_2 == 0)
        {
            /* Child 2 code */
            grandson_1 = fork();

            if (grandson_1 == 0)
            {
                /*Grandson 1 code*/
                printf("Nieto 1 con pid: %d,con padre:%d\n", getpid(), getppid());
                int ndir;
                printf("\n Introduce el número de directorios a crear:\n");
                scanf("%d", &ndir);
                for (int i = 0; i < ndir; i++)
                {
                    // creamos los directorios con sus nombres.
                    //concateno para obtener el path completo ~/
                    char *sdir;
                    printf("\n Introduce el nombre del directorio a crear:\n");
                    scanf("%s", sdir);
                    sdir = strcat("/Escritorio",sdir);
                    char *path = strcat(env, sdir);
                    char *args[] = {
                        "/bin/mkdir",
                        "mkdir",
                    };
                    execl(args[0], args[1], path, (char *)NULL);
                }
                exit(0);
            }
            else
            {
                printf("Hijo 2 con pid: %d,con padre:%d\n", getpid(), getppid());
                //creamos el path al escritorio del usuario.
                char *path;
                path = strcat(path, env);
                path = strcat(path, "/Escritorio");
                execl("/bin/cd", "cd", path, (char *)NULL);
                system("ls ~/Escritorio >> ~/Escritorio/directorios.txt");
                //execl("/bin/ls", "ls", ">> directorios.txt", (char *)NULL);
                //system("gnome-terminal -x sh -c \"ls -l ./; bash\"");
                exit(0);
            }
            
        }
        else
        {
            /* Parent Code */
            child_1 = wait(NULL);
            child_2 = wait(NULL);

            execl("/bin/nano", "nano", "~/Escritorio/directorios.txt", (char *)NULL);
            printf("Padre con pid: %d,con padre:%d\n", getpid(), getppid());
            exit(0);
        }
    }
    pid = wait(NULL);
            while (pid != -1)
            {
                pid = wait(NULL);
            }
    return 0;
}