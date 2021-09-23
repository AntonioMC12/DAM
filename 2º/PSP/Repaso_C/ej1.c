#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/**
 * getpid(void) devuelve el pid del proceso un tipo pid_t
 * getppid(void) devuelve el pid del padre un tipo pid_t
 */

int main(int argc, char const *argv[])
{
    pid_t miPid = getpid();
    printf("Soy ej1 y mi PID es: %d\n", miPid);
    system("./ej2");

    return 0;
}
