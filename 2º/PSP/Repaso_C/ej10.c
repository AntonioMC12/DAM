#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>     //pid_t
#include <errno.h>      //tratamiento de errores
#include <sys/wait.h>   //waits
#include <malloc.h>

int main(int argc, char const *argv[])
{
    int c;
    pid_t pid;
    int p;
    int *ptr1;
    ptr1 = &p;
    p = 0;

    printf("pico\n");
    for (c = 0; c<3 ; c++)
    {
        pid = fork();
    }
    *ptr1+=1;
    printf("burguir %d\n",p);
    exit(1);
    return 0;
    
}
