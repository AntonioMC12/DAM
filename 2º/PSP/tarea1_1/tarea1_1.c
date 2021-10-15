#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>   //pid_t
#include <errno.h>    //tratamiento de errores
#include <sys/wait.h> //waits
#include <string.h>

int main(int argc, char const *argv[])
{
    pid_t status, child_1, child_2, grandson_1, grandson_2;

    printf("Soy el padre con pid: %d y con padre: %d \n", getpid(), getppid());

    child_1 = fork();
    if (child_1 == 0)
    {
        //Child 1 code
        grandson_1 = fork();
        if (grandson_1 == 0)
        {
            //grandson1 code
            system("mkdir ~/NIETO1");
            printf("\nSoy el nieto 1 con pid: %d y con padre: %d \n", getpid(), getppid());
        }
        else if (grandson_1 == -1)
        {
            printf("Error");
        }
        else
        {
            //Child 1 code
            waitpid(grandson_1, &status, 0);
            printf("Soy el hijo 1 con pid: %d y con padre: %d \n", getpid(), getppid());
            printf("Contenido de HOME:\n");
            system("ls ~/");
        }
    }
    else if (child_1 == -1)
    {
        printf("Error");
    }
    else
    {
        waitpid(child_1, &status, 0);
        child_2 = fork();
        if (child_2 == 0)
        {
            //Child 2 code
            grandson_2 = fork();
            if (grandson_2 == 0)
            {
                //grandson 2 code
                system("mkdir ~/NIETO2");
                printf("Soy el nieto 2 con pid: %d y con padre: %d \n", getpid(), getppid());
            }
            else if (grandson_2 == -1)
            {
                printf("Error");
            }
            else
            {
                //child 2 code
                waitpid(grandson_2, &status, 0);
                printf("Soy el hijo 2 con pid: %d y con padre: %d \n", getpid(), getppid());
                printf("Contenido de HOME:\n");
                system("ls ~/");
            }
        }
        else if (child_2 == -1)
        {
            printf("Error");
        }
        else
        {
            //parent code
            waitpid(child_2, &status, 0);
            exit(0);
        }
    }
}