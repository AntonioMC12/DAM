#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[])
{
    
    printf("Soy ej2 y mi PID es: %d\n", getpid());
    printf("El pid de mi padre es: %d\n",getppid());
    sleep(5);
    return 0;
}
